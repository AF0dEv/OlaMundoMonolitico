/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import java.util.ArrayList;

/**
 *
 * @author efapro01.23
 */
public class TestArray {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(43);
        numeros.add(23);
        numeros.add(44);

        try {
            System.out.println("Valor da Posição 10: " + numeros.get(10));
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Acesso a uma Posição Inválida");
            ex.printStackTrace();
        }
    }
}
