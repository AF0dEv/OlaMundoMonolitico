package tests;

import business.Pessoa;
import java.util.Hashtable;

/**
 *
 * @author efapro01.23
 */
public class TestHashTable {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        Hashtable<Integer, Pessoa> pessoas = new Hashtable<>();

        Pessoa p = new Pessoa("", 0);

        p.setNome("Afonso");

        pessoas.put(1, p);

        for (Integer id : pessoas.keySet()) {
            System.out.println(pessoas.get(id));
        }

    }
}
