package tests;

import business.Pessoa;
import business.heranca.Veiculo;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author efapro01.23
 */
public class TestePessoa {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        // Estancianmento de Objeto
        Pessoa pessoa = new Pessoa("", 0);
        Scanner sc = new Scanner(System.in);

        // Iniciar HashTable
        Hashtable<Integer, Pessoa> pessoas = new Hashtable<>();

//        Pessoa p = new Pessoa();
//        try {
//            p.setNome("Afonso");
//        } catch (NomeInvalidoException e) {
//        }
//        pessoas.put(1, p);
//        for (Integer id : pessoas.keySet()) {
//            System.out.println(pessoas.get(id));
//        }
        // Definir nome da Pessoa
        System.out.print("Introduza um nome: ");
        String nome = sc.nextLine();

        pessoa.setNome(nome);

        // Definir idade
        System.out.print("Introduza uma idade: ");
        int idade = sc.nextInt();
        pessoa.setIdade(idade);
        sc.nextLine();

        String contacto;
        do {
            System.out.println("\n Introduza um Contacto (vazio para terminar)");
            contacto = sc.nextLine();

            try {
                if (!pessoa.setContacto(contacto)) {
                    System.out.println("Erro ao Guardar Contacto!\n");
                }
            } catch (NullPointerException ex) {
                System.out.println("ERRO TERRIVEL " + ex.getMessage());
            }

        } while (!contacto.equals(""));

        Veiculo veiculo = new Veiculo();

        // Saida de Dados
        System.out.println(" ---------- Dados da Pessoa ---------- ");
        System.out.println(pessoa.toString());
//        System.out.println("Introduza o Contacto a remover:");
//        String contactoRemover = sc.nextLine();
//        if (pessoa.removerContacto(contactoRemover)) {
//            System.out.println("Contacto Removido com Sucesso");
//        } else {
//            System.out.println("Erro ao Remover Contacto");
//        }

//        ArrayList<Integer> numeros = new ArrayList<>();
//        numeros.add(12);
//        numeros.add(32);
//        numeros.add(2312);
//        numeros.add(1342);
//        numeros.add(1112);
//        numeros.add(15652);
//        numeros.add(34512);
//        numeros.add(12352);
//        System.out.println("Array Original: " + numeros);
//
//        numeros.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (o1 < o2) {
//                    return -1;
//                } else if (o1 > o2) {
//                    return 1;
//                }
//                return 0;
//            }
//        });
//        numeros.remove(new Integer(34512));
//        System.out.println("ArrayOrdenado: " + numeros);
    }
}
