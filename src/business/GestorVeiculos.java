package business;

import business.heranca.Veiculo;
import business.heranca.VeiculoCombustao;
import business.heranca.VeiculoEletrico;
import java.sql.*;
import java.util.ArrayList;
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
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

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
    public void fillArrayList() throws SQLException {
        ResultSet rs = dbw.getVeiculos();
//        while (rs.next()) {
//            Veiculo v = new Veiculo();
//            v.setMatricula(rs.getString("idVeiculos"));
//            v.setMarca(rs.getString("marca"));
//            v.setModelo(rs.getString("modelo"));
//            if (rs.getString("Tipos_idTipos") == "2") {
//
//            }
//            v.setnChassi(rs.getInt("nChassi"));
//            v.setnLugares(rs.getInt("nLugares"));
//            v.setnPortas(rs.getInt("nPortas"));
//            veiculos.put(v.getMatricula(), v);
//        }
        while (rs.next()) {
            if ("2".equals(rs.getString("Tipos_idTipos"))) {
                veiculos.add(new VeiculoCombustao(rs.getInt("cilindrada"), rs.getString("matricula"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("nChassi"), rs.getInt("nLugares"), rs.getInt("nPortas")));
            } else {
                veiculos.add(new VeiculoEletrico(rs.getString("matricula"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("nChassi"), rs.getInt("nLugares"), rs.getInt("nPortas")));
            }

        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    /**
     *
     * @param matricula
     * @return
     */
    public Veiculo getVeiculo(String matricula) throws SQLException {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getMatricula() == matricula) {
                return veiculo;
            }
            // ==================================================== \\
            // FUTURALLY IMPLEMENT SYSTEM WHERE ARRAYLIST WILL DELETE THE LAST OBJ AND UPDATE WITH CURRENT USED ONES \\
            // OBJECTIVE: INCREASE PERFORMANCE BY NOT USING DATABASE TOO MUCH DUE TO CONSTANT UPDATE OF ARRAYLIST \\

            // ==================================================== \\
//                int result = dbw.containsCar(veiculo);
//                if (result > 0){
//                    ResultSet rs = dbw.getVeiculos();
        }
        System.out.println("ERRO: VEICULO INEXISTENTE!");
        return null;
    }

    /**
     *
     * @param v
     * @param Pessoas_idPessoas
     * @throws java.sql.SQLException
     */
    public void addVeiculo(Veiculo v, int Pessoas_idPessoas) throws SQLException {
        dbw.SaveCar(v, Pessoas_idPessoas);
        this.veiculos.add(v);
    }

    /**
     *
     * @param v
     * @throws java.sql.SQLException
     */
    public void removeCar(Veiculo v) throws SQLException {
        int result = dbw.removeCar(v);
        if (result > 0) {
            this.veiculos.remove(v);
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
