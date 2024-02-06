package presentation;

import business.Pessoa;
import business.heranca.Veiculo;
import business.presentation.controller.ProgramController;
import exceptions.MaximoVeiculosException;
import exceptions.NomeInvalidoException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//
/**
 *
 * @author efapro01.23
 */
public class StartConsole {

    /**
     *
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException, NomeInvalidoException {
        // Estancianmento de Objeto
        ProgramController pc = new ProgramController();
        Scanner sc = new Scanner(System.in);

        int var = 0;
        String key;
        pc.fillHashTablePessoas();
        pc.fillHashTableVeiculos();
        // SWITCHCASE
        do {

            // MENU
            System.out.println("======================================");
            System.out.println("\t\tMENU");
            System.out.println("""
                           1. Criar Pessoa
                           2. Remover Pessoa
                           3. Adicionar Veiculo
                           4. Remover Veiculo
                           5. Listar Veiculos de 1 Pessoa
                           6. Listar  Todas as Propriedades
                           """);
            System.out.println("======================================");

            // Pedir Opera��o
            try {
                System.out.println("\nIndique a Opera��o a Efetuar: ");
                var = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
            }

            switch (var) {
                case 1:
                    Pessoa p = new Pessoa();
                    System.out.println("CRIAR PESSOA ");

                    // Estanciar vari�veis
                    String nome;
                    Integer idade;
                    String contactos;

                    // Scan KEY HashTable
                    System.out.println("\nIntroduza N� Cart�o Cidad�o: ");
                    Integer cc = sc.nextInt();
                    sc.nextLine();
                    p.setCc(cc);

                    // Scan nome e Valida��o
                    System.out.println("\nIntroduza o Nome: ");
                    nome = sc.nextLine();
                    try {
                        p.setNome(nome);
                    } catch (NomeInvalidoException e) {
                    }

                    // Scan idade
                    System.out.print("\nIntroduza uma idade: ");
                    idade = sc.nextInt();
                    p.setIdade(idade);
                    sc.nextLine();

                    // Scan contactos
                    String contacto;
                    do {
                        System.out.println("\n Introduza um Contacto (vazio para terminar): ");
                        contacto = sc.nextLine();

                        try {
                            if (!p.setContacto(contacto)) {
                                System.out.println("\nErro ao Guardar Contacto!\n");
                            }
                        } catch (NullPointerException ex) {
                            System.out.println("\nERRO TERRIVEL " + ex.getMessage());
                        }

                    } while (!contacto.equals(""));
                    System.out.println(p.getNome());
                    // Adicionar Pessoa
                    pc.addPessoa(p);
                    // Guardar Contactos
                    pc.saveContacto(p, p.getContactos());

                    // Apresentar Pessoa Adicionada
                    System.out.println(pc.getPessoas());
                    break;

                //  Remover Pessoa
                case 2:

                    System.out.println("REMOVER PESSOA");
                    System.out.println(pc.getPessoas());

                    // Saber N� CC
                    System.out.println("\nIntroduza o N� Cart�o Cidad�o da Pessoa a Eliminar\n");
                    key = sc.nextLine();

                    // Verificar se Existe a Pessoa
                    if (!pc.getPessoas().containsKey(key)) {
                        System.out.println("\nN� Cart�o Cidad�o Inexistente\n");

                        // Se existir Remover
                    } else {

                        pc.removerPessoa(key);

                        // Apresentar Pessoas
                        System.out.println(pc.getPessoas());
                    }

                    break;

                // Adicionar Veiculo
                case 3:
                    System.out.println("ADICIONAR VEICULO");

                    // Pedir Pessoa onde guardar
                    System.out.println("\nIndique o N� do Cart�o de Cidad�o da Pessoa a Guardar o seu Veiculo?\n");

                    // Mostrar Lista de Pessoas
                    System.out.println(pc.getPessoas());
                    key = sc.nextLine();

                    if (!pc.getPessoas().containsKey(key)) {
                        System.out.println("\nN� Cart�o Cidad�o Inexistente\n");

                    } else {

                        // Guardar Pessoa
                        p = pc.getPessoa(key);
                        Veiculo v = new Veiculo();
                        // Verificar se a Pessoa excede os 3 Veiculos
                        try {

                            // MATRICULA
                            System.out.println("Indique a Matricula do Veiculo: ");
                            v.setMatricula(sc.nextLine());

                            // MARCA
                            System.out.println("Indique a Marca do Veiculo: ");
                            v.setMarca(sc.nextLine());

                            // MODELO
                            System.out.println("Indique o Modelo do Veiculo: ");
                            v.setModelo(sc.nextLine());

                            // CILINDRADA
                            System.out.println("Indique a Cilindrada do Veiculo: ");
                            v.setCilindrada(sc.nextInt());
                            sc.nextLine();

                            // N� CHASSI
                            System.out.println("Indique o N� de Chassi do Veiculo: ");
                            v.setnChassi(sc.nextInt());
                            sc.nextLine();

                            // N� LUGARES
                            System.out.println("Indique o N� de Lugares do Veiculo: ");
                            v.setnLugares(sc.nextInt());
                            sc.nextLine();

                            // N� PORTAS
                            System.out.println("Indique o N� de Portas do Veiculo");
                            v.setnPortas(sc.nextInt());
                            sc.nextLine();

                            // Guardar Veiculo na Pessoa
                            p.setVeiculo(v);

                            pc.addVeiculo(v, p.getCc());

                        } catch (MaximoVeiculosException ex) {
                            Logger.getLogger(StartConsole.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    break;

                // Remover Veiculo
                case 4:
                    System.out.println("REMOVER VEICULO");

                    // Pedir Pessoa a Listar
                    System.out.println("\nIndique o N� do Cart�o de Cidad�o da Pessoa a Remover o seu Veiculo?\n");

                    // Mostrar Lista de Pessoas
                    System.out.println(pc.getPessoas());
                    key = sc.nextLine();

                    if (!pc.getPessoas().containsKey(key)) {
                        System.out.println("\nN� Cart�o Cidad�o Inexistente\n");

                        // Se existir Remover
                    } else {

                        // Guardar Pessoa
                        p = pc.getPessoa(key);

                        // Verificar se a Pessoa tem Automoveis
                        if (p.getVeiculos().isEmpty()) {
                            System.out.println("Esta Pessoa n�o tem Veiculos!");
                        } else {

                            // Saber Autom�vel a Eliminar
                            System.out.println("Indique a Matricula do Autom�vel a Eliminar: ");
                            String mat = sc.nextLine();

                            // Verificar se Autom�vel Existe
                            for (int i = 0; i < p.getVeiculos().size(); i++) {
                                if (!p.getVeiculos().get(i).getMatricula().equals(mat)) {
                                    System.out.println("Veiculo com essa Matricula n�o Existe!");
                                } else {

                                    p.removerVeiculo(p.getVeiculos().get(i));
                                    System.out.println("Veiculo Removido com Sucesso!");

                                }
                                // Atualizar HashTable
                                pc.addPessoa(p);
                            }

                        }
                    }
                    break;
                // Listar Veiculos de uma Pessoa
                case 5:
                    System.out.println("LISTAR VEICULOS 1 PESSOA");
                    // Inicializar Objetos

                    // Pedir Pessoa a Listar
                    System.out.println("\nIndique o N� do Cart�o de Cidad�o da Pessoa a Listar os Veiculo?\n");

                    // Mostrar Lista de Pessoas
                    System.out.println(pc.getPessoas());
                    key = sc.nextLine();

                    if (!pc.getPessoas().containsKey(key)) {
                        System.out.println("\nN� Cart�o Cidad�o Inexistente\n");

                        // Se existir Remover
                    } else {
                        p = pc.getPessoa(key);
                        System.out.println(p.getVeiculos().toString());
                    }

                    break;

                // Listar Todas as Propriedades
                case 6:
                    System.out.println("LISTAR TODAS AS PROPRIEDADES");
                    System.out.println(pc.getPessoas());
                default:

            }

        } while (var != 0);
        if (var == 0) {
            pc.connectionStringCLOSE();
        }
    }
}