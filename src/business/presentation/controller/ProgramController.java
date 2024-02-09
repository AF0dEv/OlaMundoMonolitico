package business.presentation.controller;

import business.GestorPessoas;
import business.GestorVeiculos;
import business.Pessoa;
import business.heranca.Veiculo;
import business.heranca.VeiculoCombustao;
import business.heranca.VeiculoEletrico;
import exceptions.NomeInvalidoException;
import java.sql.SQLException;
import java.util.ArrayList;
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
        gp.fillArrayList();
    }

    /**
     *
     * @throws SQLException
     */
    public void fillArrayListVeiculos() throws SQLException {
        gv.fillArrayList();
    }

    /**
     *
     * @return
     */
    public ArrayList<Pessoa> getPessoas() {
        return gp.getPessoas();
    }

    /**
     *
     * @param cc
     * @return
     */
    public Pessoa getPessoa(int cc) {
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
    public void removerPessoa(Integer cc) throws SQLException {
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
    public ArrayList<Veiculo> getVeiculos() {
        return gv.getVeiculos();
    }

    /**
     *
     * @param matricula
     * @return
     * @throws java.sql.SQLException
     */
    public Veiculo getVeiculo(String matricula) throws SQLException {
        return gv.getVeiculo(matricula);
    }

    /**
     *
     * @param vc
     * @param ve
     * @param Pessoas_idPessoas
     * @throws java.sql.SQLException
     */
    public void addVeiculo(VeiculoCombustao vc, VeiculoEletrico ve, int Pessoas_idPessoas) throws SQLException {
        gv.addVeiculo(vc, ve, Pessoas_idPessoas);
    }

    /**
     *
     * @param vc
     * @param ve
     * @throws java.sql.SQLException
     */
    public void removerVeiculo(VeiculoCombustao vc, VeiculoEletrico ve) throws SQLException {
        gv.removeCar(vc, ve);
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
     * @param vc
     * @param ve
     * @return
     * @throws java.sql.SQLException
     */
    public int containsVeiculo(VeiculoCombustao vc, VeiculoEletrico ve) throws SQLException {
        return gv.containsVeiculo(vc, ve);
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
