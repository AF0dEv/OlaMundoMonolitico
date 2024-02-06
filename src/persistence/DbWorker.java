package persistence;

import business.Pessoa;
import business.heranca.Veiculo;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author efapro01.23
 */
public class DbWorker {

    private DbAdapter dba = new DbAdapter();

    /**
     *
     */
    public DbWorker() {
        DbAdapter dba = new DbAdapter();
    }

    /**
     *
     * @param p
     * @throws SQLException
     */
    public void savePerson(Pessoa p) throws SQLException {
        // Executar save
        int result = dba.savePerson(p);

    }

    /**
     *
     * @param p
     * @param contactos
     * @throws SQLException
     */
    public void SaveContacto(Pessoa p, ArrayList<String> contactos) throws SQLException {
        // Executar save
        dba.saveContacto(p, contactos);

    }

    /**
     *
     * @param v
     * @param Pessoas_idPessoas
     * @throws SQLException
     */
    public void SaveCar(Veiculo v, int Pessoas_idPessoas) throws SQLException {
        dba.saveCar(v, Pessoas_idPessoas);
    }

    /**
     *
     * @return @throws SQLException
     * @throws java.sql.SQLException
     */
    public ResultSet getPessoas() throws SQLException {
        return dba.getPessoas();
    }

    /**
     *
     * @return @throws SQLException
     * @throws java.sql.SQLException
     */
    public ResultSet getVeiculos() throws SQLException {
        return dba.getVeiculos();
    }

    /**
     *
     * @return @throws SQLException
     * @throws java.sql.SQLException
     */
    public ResultSet getContactos() throws SQLException {
        return dba.getContactos();
    }

    /**
     *
     * @param v
     * @return
     * @throws SQLException
     */
    public int removeCar(Veiculo v) throws SQLException {
        return dba.removeCar(v);
    }

    /**
     *
     * @param matricula
     * @return
     * @throws SQLException
     */
    public int removeCar(String matricula) throws SQLException {
        return dba.removeCar(matricula);
    }

    /**
     *
     * @param p
     * @return
     * @throws SQLException
     */
    public int removePerson(Pessoa p) throws SQLException {
        return dba.removePerson(p);
    }

    /**
     *
     * @param cc
     * @return
     * @throws SQLException
     */
    public int removePerson(String cc) throws SQLException {
        return dba.removePerson(cc);
    }

    /**
     *
     * @param v
     * @return
     * @throws SQLException
     */
    public int containsCar(Veiculo v) throws SQLException {
        return dba.containsCar(v);
    }

    /**
     *
     * @param p
     * @return
     * @throws SQLException
     */
    public int containsPerson(Pessoa p) throws SQLException {
        return dba.containsPerson(p);
    }

    /**
     *
     */
    public void connectionStringCLOSE() {
        dba.connectionStringCLOSE();
    }
}
