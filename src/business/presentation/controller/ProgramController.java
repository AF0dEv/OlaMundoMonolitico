package business.presentation.controller;

import business.GestorPessoas;
import business.GestorVeiculos;
import business.Pessoa;
import business.heranca.Veiculo;
import exceptions.NomeInvalidoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

/**
 *
 * @author efapro01.23
 */
public class ProgramController {

    /**
     *
     */
    public ProgramController() {
    }

    GestorPessoas gp = new GestorPessoas();
    GestorVeiculos gv = new GestorVeiculos();

    /**
     *
     * @throws SQLException
     * @throws exceptions.NomeInvalidoException
     */
    public void fillHashTablePessoas() throws SQLException, NomeInvalidoException {
        gp.fillHashTable();
    }

    /**
     *
     * @throws SQLException
     */
    public void fillHashTableVeiculos() throws SQLException {
        gv.fillHashTable();
    }

    /**
     *
     * @return
     */
    public Hashtable<String, Pessoa> getPessoas() {
        return gp.getPessoas();
    }

    /**
     *
     * @param cc
     * @return
     */
    public Pessoa getPessoa(String cc) {
        return gp.getPessoa(cc);
    }

    /**
     *
     * @param p
     * @throws java.sql.SQLException
     */
    public void addPessoa(Pessoa p) throws SQLException {
        gp.addPessoa(p);
    }

    /**
     *
     * @param cc
     * @throws java.sql.SQLException
     */
    public void removerPessoa(String cc) throws SQLException {
        gp.removerPessoa(cc);
    }

    /**
     *
     * @param p
     * @throws java.sql.SQLException
     */
    public void removerPessoa(Pessoa p) throws SQLException {
        gp.removerPessoa(p);
    }

    /**
     *
     * @param p
     * @return
     * @throws java.sql.SQLException
     */
    public int containsPessoa(Pessoa p) throws SQLException {
        return gp.containsPessoa(p);
    }

    /**
     *
     * @return
     */
    public Hashtable<String, Veiculo> getVeiculos() {
        return gv.getVeiculos();
    }

    /**
     *
     * @param matricula
     * @return
     */
    public Veiculo getVeiculo(String matricula) {
        return gv.getVeiculo(matricula);
    }

    /**
     *
     * @param v
     * @param Pessoas_idPessoas
     * @throws java.sql.SQLException
     */
    public void addVeiculo(Veiculo v, int Pessoas_idPessoas) throws SQLException {
        gv.addVeiculo(v, Pessoas_idPessoas);
    }

    /**
     *
     * @param v
     * @throws java.sql.SQLException
     */
    public void removerVeiculo(Veiculo v) throws SQLException {
        gv.removeCar(v);
    }

    /**
     *
     * @param matricula
     * @throws java.sql.SQLException
     * @par @throws java.sql.SQLExceptionam matricula
     */
    public void removerVeiculo(String matricula) throws SQLException {
        gv.removerVeiculo(matricula);
    }

    /**
     *
     * @param p
     * @param contactos
     * @throws SQLException
     */
    public void saveContacto(Pessoa p, ArrayList<String> contactos) throws SQLException {
        gp.saveContacto(p, contactos);
    }

    /**
     *
     */
    public void connectionStringCLOSE() {
        gp.connectionStringCLOSE();
        gv.connectionStringCLOSE();
    }

    /**
     *
     * @param v
     * @return
     * @throws java.sql.SQLException
     */
    public int containsVeiculo(Veiculo v) throws SQLException {
        return gv.containsVeiculo(v);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.gp);
        hash = 79 * hash + Objects.hashCode(this.gv);
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
        final ProgramController other = (ProgramController) obj;
        if (!Objects.equals(this.gp, other.gp)) {
            return false;
        }
        return Objects.equals(this.gv, other.gv);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "ProgramController{" + "gp=" + gp + ", gv=" + gv + '}';
    }

}
