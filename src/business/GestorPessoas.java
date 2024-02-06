package business;

import exceptions.NomeInvalidoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;
import persistence.DbWorker;

/**
 *
 * @author efapro01.23
 */
public class GestorPessoas {

    /**
     *
     */
    public GestorPessoas() {
    }

    private DbWorker dbw = new DbWorker();

    // Iniciar HashTable
    private Hashtable<String, Pessoa> pessoas = new Hashtable<>();

    /**
     *
     */
    public void connectionStringCLOSE() {
        dbw.connectionStringCLOSE();
    }

    /**
     *
     * @throws SQLException
     * @throws exceptions.NomeInvalidoException
     */
    public void fillHashTable() throws SQLException, NomeInvalidoException {
        ResultSet rs = dbw.getPessoas();
        while (rs.next()) {
            Pessoa p = new Pessoa();
            p.setCc(rs.getInt("idPessoas"));
            p.setNome(rs.getString("nome"));
            p.setIdade(rs.getInt("idade"));
            pessoas.put(p.getCc().toString(), p);

        }

//        do {
        //String nome = rs.getString("nome");
//            int idade = rs.getInt("idade");
//            int cc = rs.getInt("idPessoas");
//            Pessoa p = new Pessoa(nome, idade);
//            p.setCc(cc);
//            pessoas.put(p.getCc().toString(), p);
//        } while (rs.next());
    }

    /**
     *
     * @return
     */
    public Hashtable<String, Pessoa> getPessoas() {
        return pessoas;
    }

    /**
     *
     * @param cc
     * @return
     */
    public Pessoa getPessoa(String cc) {
        return this.pessoas.get(cc);
    }

    /**
     *
     * @param p
     * @throws java.sql.SQLException
     */
    public void addPessoa(Pessoa p) throws SQLException {
        dbw.savePerson(p);
        this.pessoas.put(p.getCc().toString(), p);
    }

    /**
     *
     * @param cc
     * @throws java.sql.SQLException
     */
    public void removerPessoa(String cc) throws SQLException {
        int result = dbw.removePerson(cc);
        if (result > 0) {
            this.pessoas.remove(cc);
            System.out.println("Pessoa Removida com Sucesso");
        } else {
            System.out.println("Pessoa Não Removida");
        }
    }

    /**
     *
     * @param p
     * @throws java.sql.SQLException
     */
    public void removerPessoa(Pessoa p) throws SQLException {
        int result = dbw.removePerson(p);
        if (result > 0) {
            this.pessoas.remove(p.getCc());
            System.out.println("Pessoa Removida com Sucesso");
        } else {
            System.out.println("Pessoa Não Removida");
        }
    }

    /**
     *
     * @param p
     * @param contactos
     * @throws SQLException
     */
    public void saveContacto(Pessoa p, ArrayList<String> contactos) throws SQLException {
        dbw.SaveContacto(p, contactos);
    }

    /**
     *
     * @param p
     * @return
     * @throws java.sql.SQLException
     */
    public int containsPessoa(Pessoa p) throws SQLException {
        return dbw.containsPerson(p);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.pessoas);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GestorPessoas other = (GestorPessoas) obj;
        return Objects.equals(this.pessoas, other.pessoas);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "GestorPessoas{" + "pessoas=" + pessoas + '}';
    }

}
