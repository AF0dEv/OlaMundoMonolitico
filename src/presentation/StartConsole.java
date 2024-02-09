package presentation;

import business.Pessoa;
import business.heranca.VeiculoCombustao;
import business.heranca.VeiculoEletrico;
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
     * @throws exceptions.NomeInvalidoException
     */
    public static void main(String[] args) throws SQLException, NomeInvalidoException {
        // Estancianmento de Objeto
        ProgramController pc = new ProgramController();
        Scanner sc = new Scanner(System.in);

        int var = 0;
        Integer cc;
        pc.fillHashTablePessoas();
        pc.fillArrayListVeiculos();
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

            // Pedir Operação
            try {
                System.out.println("\nIndique a Operação a Efetuar: ");
                var = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
            }

            switch (var) {
                case 1:
                    Pessoa p = new Pessoa();
                    System.out.println("CRIAR PESSOA ");

                    // Estanciar variáveis
                    String nome;
                    Integer idade;
                    String contactos;

                    // Scan KEY HashTable
                    System.out.println("\nIntroduza Nº Cartão Cidadão: ");
                    cc = sc.nextInt();
                    sc.nextLine();
                    p.setCc(cc);

                    // Scan nome e Validação
                    System.out.println("\nIntroduza o Nome: ");
                    nome = sc.nextLine();

                    p.setNome(nome);

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

                    // Saber Nº CC
                    System.out.println("\nIntroduza o Nº Cartão Cidadão da Pessoa a Eliminar\n");
                    cc = sc.nextInt();
                    sc.nextLine();
                    p = pc.getPessoa(cc);

                    // Verificar se Existe a Pessoa
                    if (!pc.getPessoas().contains(p)) {
                        System.out.println("\nNº Cartão Cidadão Inexistente\n");

                        // Se existir Remover
                    } else {

                        pc.removerPessoa(cc);

                        // Apresentar Pessoas
                        System.out.println(pc.getPessoas());
                    }

                    break;

                // Adicionar Veiculo
                case 3:
                    System.out.println("ADICIONAR VEICULO");

                    // Pedir Pessoa onde guardar
                    System.out.println("\nIndique o Nº do Cartão de Cidadão da Pessoa a Guardar o seu Veiculo?\n");

                    // Mostrar Lista de Pessoas
                    System.out.println(pc.getPessoas());
                    cc = sc.nextInt();
                    sc.nextLine();
                    p = pc.getPessoa(cc);

                    // Verificar se Existe a Pessoa
                    if (!pc.getPessoas().contains(p)) {
                        System.out.println("\nNº Cartão Cidadão Inexistente\n");

                    } else {

                        // Guardar Pessoa
                        p = pc.getPessoa(cc);
                        Integer tipo = null;
                        do {
                            // Verificar o Tipo de Veiculo
                            System.out.println("\nIndique o Tipo do Veiculo:\n");
                            System.out.println("1: ELÉTRICO\n");
                            System.out.println("2: COMBUSTÃO\n");
                            System.out.println("0: CANCELAR\n\n");
                            tipo = sc.nextInt();
                            sc.nextLine();

                            if (tipo == 1) {
                                VeiculoEletrico ve = new VeiculoEletrico();
                                // Verificar se a Pessoa excede os 3 Veiculos
                                try {

                                    // MATRICULA
                                    System.out.println("Indique a Matricula do Veiculo: ");
                                    ve.setMatricula(sc.nextLine());

                                    // MARCA
                                    System.out.println("Indique a Marca do Veiculo: ");
                                    ve.setMarca(sc.nextLine());

                                    // MODELO
                                    System.out.println("Indique o Modelo do Veiculo: ");
                                    ve.setModelo(sc.nextLine());

                                    // Nº CHASSI
                                    System.out.println("Indique o Nº de Chassi do Veiculo: ");
                                    ve.setnChassi(sc.nextInt());
                                    sc.nextLine();

                                    // Nº LUGARES
                                    System.out.println("Indique o Nº de Lugares do Veiculo: ");
                                    ve.setnLugares(sc.nextInt());
                                    sc.nextLine();

                                    // Nº PORTAS
                                    System.out.println("Indique o Nº de Portas do Veiculo");
                                    ve.setnPortas(sc.nextInt());
                                    sc.nextLine();

                                    // Guardar Veiculo na Pessoa
                                    p.setVeiculo(null, ve);

                                    pc.addVeiculo(null, ve, p.getCc());

                                } catch (MaximoVeiculosException ex) {
                                    Logger.getLogger(StartConsole.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else if (tipo == 2) {
                                VeiculoCombustao vc = new VeiculoCombustao(0);
                                // Verificar se a Pessoa excede os 3 Veiculos
                                try {

                                    // MATRICULA
                                    System.out.println("Indique a Matricula do Veiculo: ");
                                    vc.setMatricula(sc.nextLine());

                                    // MARCA
                                    System.out.println("Indique a Marca do Veiculo: ");
                                    vc.setMarca(sc.nextLine());

                                    // MODELO
                                    System.out.println("Indique o Modelo do Veiculo: ");
                                    vc.setModelo(sc.nextLine());

                                    // CILINDRADA
                                    System.out.println("Indique a Cilindrada do Veiculo: ");
                                    vc.setCilindrada(sc.nextInt());
                                    sc.nextLine();

                                    // Nº CHASSI
                                    System.out.println("Indique o Nº de Chassi do Veiculo: ");
                                    vc.setnChassi(sc.nextInt());
                                    sc.nextLine();

                                    // Nº LUGARES
                                    System.out.println("Indique o Nº de Lugares do Veiculo: ");
                                    vc.setnLugares(sc.nextInt());
                                    sc.nextLine();

                                    // Nº PORTAS
                                    System.out.println("Indique o Nº de Portas do Veiculo");
                                    vc.setnPortas(sc.nextInt());
                                    sc.nextLine();

                                    // Guardar Veiculo na Pessoa
                                    p.setVeiculo(vc, null);

                                    pc.addVeiculo(vc, null, p.getCc());

                                } catch (MaximoVeiculosException ex) {
                                    Logger.getLogger(StartConsole.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else {
                                System.out.println("Indique Opção válida");
                            }
                        } while (tipo != 0);
                    }
                    break;

                // Remover Veiculo
                case 4:
                    System.out.println("REMOVER VEICULO");

                    // Pedir Pessoa a Listar
                    System.out.println("\nIndique o Nº do Cartão de Cidadão da Pessoa a Remover o seu Veiculo?\n");

                    // Mostrar Lista de Pessoas
                    System.out.println(pc.getPessoas());
                    cc = sc.nextInt();
                    sc.nextLine();
                    p = pc.getPessoa(cc);
                    if (!pc.getPessoas().contains(p)) {
                        System.out.println("\nNº Cartão Cidadão Inexistente\n");

                        // Se existir Remover
                    } else {

                        // Guardar Pessoa
                        p = pc.getPessoa(cc);

                        // Verificar se a Pessoa tem Automoveis
                        if (p.getVeiculos().isEmpty()) {
                            System.out.println("Esta Pessoa não tem Veiculos!");
                        } else {

                            // Saber Automóvel a Eliminar
                            System.out.println("Indique a Matricula do Automóvel a Eliminar: ");
                            String mat = sc.nextLine();

                            // Verificar se Automóvel Existe
                            for (int i = 0; i < p.getVeiculos().size(); i++) {
                                if (!p.getVeiculos().get(i).getMatricula().equals(mat)) {
                                    System.out.println("Veiculo com essa Matricula não Existe!");
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
                    System.out.println("\nIndique o Nº do Cartão de Cidadão da Pessoa a Listar os Veiculo?\n");

                    // Mostrar Lista de Pessoas
                    System.out.println(pc.getPessoas());
                    cc = sc.nextInt();
                    sc.nextLine();
                    p = pc.getPessoa(cc);

                    if (!pc.getPessoas().contains(p)) {
                        System.out.println("\nNº Cartão Cidadão Inexistente\n");

                        // Se existir Remover
                    } else {
                        p = pc.getPessoa(cc);
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
