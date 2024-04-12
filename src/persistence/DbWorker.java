package persistence;

import business.Pessoa;
import business.heranca.VeiculoCombustao;
import business.heranca.VeiculoEletrico;
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
     * @param vc
     * @param ve
     * @param Pessoas_idPessoas
     * @throws SQLException
     */
    public void SaveCar(VeiculoCombustao vc, VeiculoEletrico ve, int Pessoas_idPessoas) throws SQLException {
        dba.saveCar(vc, ve, Pessoas_idPessoas);
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
     * @param vc
     * @param ve
     * @return
     * @throws SQLException
     */
    public int removeCar(VeiculoCombustao vc, VeiculoEletrico ve) throws SQLException {
        return dba.removeCar(vc, ve);
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
    public int removePerson(Integer cc) throws SQLException {
        return dba.removePerson(cc);
    }

    /**
     *
     * @param vc
     * @param ve
     * @return
     * @throws SQLException
     */
    public int containsCar(VeiculoCombustao vc, VeiculoEletrico ve) throws SQLException {
        return dba.containsCar(vc, ve);
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
