package persistence;

import business.Pessoa;
import business.heranca.Veiculo;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author efapro01.23
 */
public class DbAdapter {

    Properties props = new Properties();
    InputStream input = getClass().getResourceAsStream("/config.properties");

    private Connection conn = null;

    // Construtor com Conexão a Base
    /**
     *
     */
    public DbAdapter() {
        try {
            props.load(input);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        try {

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Ligação Estabelecida à BD com Sucesso!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
    }

    /**
     *
     */
    public void connectionStringCLOSE() {

        if (conn != null) {
            try {

                conn.close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }
        }
    }

    /**
     *
     * @param p
     * @return
     * @throws java.sql.SQLException
     */
    public int savePerson(Pessoa p) throws SQLException {
        // Tentar Guardar Dados
        PreparedStatement pt = conn.prepareStatement("INSERT INTO Pessoas(idPessoas, nome, idade) "
                + "VALUES (?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE "
                + "nome = ?, "
                + "idade = ?");

        // Set aos  WildCards
        pt.setInt(1, p.getCc());
        pt.setString(2, p.getNome());
        pt.setInt(3, p.getIdade());
        pt.setString(4, p.getNome());
        pt.setInt(5, p.getIdade());

        return pt.executeUpdate();
    }

    /**
     *
     * @param p
     * @param contactos
     * @throws java.sql.SQLException
     */
    public void saveContacto(Pessoa p, ArrayList<String> contactos) throws SQLException {
        // Guardar Contactos
        for (String contacto : p.getContactos()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Contactos(contacto, Pessoas_idPessoas)"
                    + "VALUES (?, ?)");
            ps.setString(1, contacto);
            ps.setInt(2, p.getCc());

            int result = ps.executeUpdate();
            // Verificar se Guardou
            System.out.println(result > 0 ? "Inserção Efetuada com Sucesso" : "Erro na Inserção");
        }

    }

    /**
     *
     * @param v
     * @param Pessoas_idPessoas
     * @return
     * @throws java.sql.SQLException
     */
    public int saveCar(Veiculo v, int Pessoas_idPessoas) throws SQLException {
        // Tentar Guardar Dados
        PreparedStatement pt = conn.prepareStatement("INSERT INTO Veiculos(idVeiculos, marca, modelo, cilindrada, nChassi, nLugares, nPortas, Pessoas_idPessoas) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE "
                + "marca = ?, "
                + "modelo = ?, "
                + "nChassi = ?, "
                + "nLugares = ?, "
                + "nPortas = ?;");

        // Set WildCards
        pt.setString(1, v.getMatricula()); // Matricula
        pt.setString(2, v.getMarca()); // Marca
        pt.setString(3, v.getModelo()); // Modelo
        pt.setInt(5, v.getnChassi()); //  Chassi
        pt.setInt(6, v.getnLugares()); // Lugares
        pt.setInt(7, v.getnPortas()); // Portas
        pt.setInt(8, Pessoas_idPessoas);
        pt.setString(9, v.getMarca()); // Marca
        pt.setString(10, v.getModelo()); // Modelo
        pt.setInt(12, v.getnChassi()); //  Chassi
        pt.setInt(13, v.getnLugares()); // Lugares
        pt.setInt(14, v.getnPortas()); // Portas

        // Executar
        return pt.executeUpdate();

    }

    /**
     *
     * @return @throws java.sql.SQLException
     * @throws java.sql.SQLException
     */
    public ResultSet getPessoas() throws SQLException {
        PreparedStatement pt = conn.prepareStatement("SELECT * FROM Pessoas;");
        return pt.executeQuery();

    }

    /**
     *
     * @return @throws java.sql.SQLException
     * @throws java.sql.SQLException
     */
    public ResultSet getVeiculos() throws SQLException {
        PreparedStatement pt = conn.prepareStatement("SELECT * FROM Veiculos;");
        return pt.executeQuery();
    }

    /**
     *
     * @return @throws java.sql.SQLException
     * @throws java.sql.SQLException
     */
    public ResultSet getContactos() throws SQLException {

        PreparedStatement pt = conn.prepareStatement("SELECT * FROM Contactos;");
        return pt.executeQuery();
    }

    /**
     *
     * @param p
     * @return
     * @throws SQLException
     */
    public int removePerson(Pessoa p) throws SQLException {
        PreparedStatement pt = conn.prepareStatement("DELETE FROM Pessoas"
                + "WHERE idPessoas = ?");
        pt.setInt(1, p.getCc());
        return pt.executeUpdate();
    }

    /**
     *
     * @param cc
     * @return
     * @throws SQLException
     */
    public int removePerson(String cc) throws SQLException {
        PreparedStatement pt = conn.prepareStatement("DELETE FROM Pessoas WHERE idPessoas = ?;");
        pt.setString(1, cc);
        return pt.executeUpdate();
    }

    /**
     *
     * @param v
     * @return
     * @throws SQLException
     */
    public int removeCar(Veiculo v) throws SQLException {
        PreparedStatement pt = conn.prepareStatement("DELETE FROM Veiculos"
                + "WHERE idVeiculos = ?");
        pt.setString(1, v.getMatricula());
        return pt.executeUpdate();
    }

    /**
     *
     * @param matricula
     * @return
     * @throws SQLException
     */
    public int removeCar(String matricula) throws SQLException {
        PreparedStatement pt = conn.prepareStatement("DELETE FROM Veiculos"
                + "WHERE idVeiculos = ?");
        pt.setString(1, matricula);
        return pt.executeUpdate();
    }

    /**
     *
     * @param v
     * @return
     * @throws SQLException
     */
    public int containsCar(Veiculo v) throws SQLException {
        PreparedStatement pt = conn.prepareStatement("SELECT * "
                + "FROM Veiculos"
                + "WHERE 'idVeiculos' = ? ");
        pt.setString(1, v.getMatricula());
        return pt.executeUpdate();
    }

    /**
     *
     * @param p
     * @return
     * @throws SQLException
     */
    public int containsPerson(Pessoa p) throws SQLException {
        PreparedStatement pt = conn.prepareStatement("SELECT * "
                + "FROM Pessoas"
                + "WHERE 'idPessoas' = ? ");
        pt.setInt(1, p.getCc());
        return pt.executeUpdate();
    }
}
