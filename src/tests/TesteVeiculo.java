package tests;

import business.heranca.Veiculo;
import java.util.Scanner;

/**
 *
 * @author efapro01.23
 */
public class TesteVeiculo {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        // Estancianmento de Objeto
        Veiculo veiculo1 = new Veiculo();
        Scanner sc = new Scanner(System.in);

        // Definir MATRICULA do Veiculo
        System.out.print("Introduza a Matricula do veiculo: ");
        String matricula = sc.nextLine();
        veiculo1.setMatricula(matricula);

        // Definir MARCA do Veiculo
        System.out.print("Introduza a Marca do Veiculo: ");
        String marca = sc.nextLine();
        veiculo1.setMarca(marca);

        // Definir MODELO do Veiculo
        System.out.print("Introduza o Modelo do Veiculo: ");
        String modelo = sc.nextLine();
        veiculo1.setModelo(modelo);

        // Definir CILINDRADA do Veiculo
//        System.out.println("Introduza a Cilindrada do Veiculo: ");
//        Integer cilindrada = sc.nextInt();
//        veiculo1.setCilindrada(cilindrada);
//        sc.nextLine();
        // Definir Nº CHASSI do Veiculo
        System.out.println("Introduza o Nº de Chassi do Veiculo: ");
        Integer nChassi = sc.nextInt();
        veiculo1.setnChassi(nChassi);
        sc.nextLine();

        // Definir Nº LUGARES do Veiculo
        System.out.println("Introduza o Nº de Lugares do Veiculo: ");
        Integer nLugares = sc.nextInt();
        veiculo1.setnLugares(nLugares);
        sc.nextLine();

        // Definir Nº PORTAS do veiculo
        System.out.println("Introduza o Nº de Portas do Veiculo: ");
        Integer nPortas = sc.nextInt();
        veiculo1.setnPortas(nPortas);
        sc.nextLine();

        // Saida de Dados
        System.out.println(veiculo1.toString());
    }
}
