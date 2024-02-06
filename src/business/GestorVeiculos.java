package business;

import business.heranca.Veiculo;
import java.sql.*;
import java.util.Hashtable;
import java.util.Objects;
import persistence.DbWorker;

/**
 *
 * @author efapro01.23
 */
public class GestorVeiculos {

    /**
     *
     */
    public GestorVeiculos() {

    }
    private DbWorker dbw = new DbWorker();

    // Iniciar HashTable
    private Hashtable<String, Veiculo> veiculos = new Hashtable<>();

    /**
     *
     */
    public void connectionStringCLOSE() {
        dbw.connectionStringCLOSE();
    }

    /**
     *
     * @throws SQLException
     */
    public void fillHashTable() throws SQLException {
        ResultSet rs = dbw.getVeiculos();
        while (rs.next()) {
            Veiculo v = new Veiculo();
            v.setMatricula(rs.getString("idVeiculos"));
            v.setMarca(rs.getString("marca"));
            v.setModelo(rs.getString("modelo"));
            v.setCilindrada(rs.getInt("cilindrada"));
            v.setnChassi(rs.getInt("nChassi"));
            v.setnLugares(rs.getInt("nLugares"));
            v.setnPortas(rs.getInt("nPortas"));
            veiculos.put(v.getMatricula(), v);
        }
    }

    /**
     *
     * @return
     */
    public Hashtable<String, Veiculo> getVeiculos() {
        return veiculos;
    }

    /**
     *
     * @param matricula
     * @return
     */
    public Veiculo getVeiculo(String matricula) {
        return this.veiculos.get(matricula);
    }

    /**
     *
     * @param v
     * @param Pessoas_idPessoas
     * @throws java.sql.SQLException
     */
    public void addVeiculo(Veiculo v, int Pessoas_idPessoas) throws SQLException {
        dbw.SaveCar(v, Pessoas_idPessoas);
        this.veiculos.put(v.getMatricula(), v);
    }

    /**
     *
     * @param v
     * @throws java.sql.SQLException
     */
    public void removeCar(Veiculo v) throws SQLException {
        int result = dbw.removeCar(v);
        if (result > 0) {
            this.veiculos.remove(v.getMatricula());
            System.out.println("Removido com Sucesso");
        } else {
            System.out.println("Veiculo não Removido");
        }
    }

    /**
     *
     * @param matricula
     * @throws java.sql.SQLException
     */
    public void removerVeiculo(String matricula) throws SQLException {
        int result = dbw.removeCar(matricula);
        if (result > 0) {
            this.veiculos.remove(matricula);
        } else {
            System.out.println("Veiculo não Removido");
        }
    }

    /**
     *
     * @param v
     * @return
     * @throws java.sql.SQLException
     */
    public int containsVeiculo(Veiculo v) throws SQLException {
        return dbw.containsCar(v);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.veiculos);
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
        final GestorVeiculos other = (GestorVeiculos) obj;
        return Objects.equals(this.veiculos, other.veiculos);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "GestorVeiculos{" + "veiculos=" + veiculos + '}';
    }

}
