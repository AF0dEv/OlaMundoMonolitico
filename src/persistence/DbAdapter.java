package persistence;

import business.Pessoa;
import business.heranca.VeiculoCombustao;
import business.heranca.VeiculoEletrico;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.PropertyResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author efapro01.23
 */
public class DbAdapter {

    FileInputStream input;
    PropertyResourceBundle prop;

    private Connection conn = null;

    // Construtor com Conexão a Base
    /**
     *
     */
    public DbAdapter() {
        try {
            this.input = new FileInputStream("./src/resources/config.properties");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DbAdapter.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        try {
            this.prop = new PropertyResourceBundle(input);
        } catch (IOException ex) {
            Logger.getLogger(DbAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection(prop.getString("db.url"), prop.getString("db.user"), prop.getString("db.password"));
            System.out.println("Ligação Estabelecida à BD com Sucesso!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
        int result = 0;
        // Guardar Contactos
        for (String contacto : p.getContactos()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Contactos(contacto, Pessoas_idPessoas)"
                    + "VALUES (?, ?)");
            ps.setString(1, contacto);
            ps.setInt(2, p.getCc());

            result = ps.executeUpdate();
            // Verificar se Guardou

        }
        System.out.println(result > 0 ? "Inserção Efetuada com Sucesso" : "Erro na Inserção");
    }

    /**
     *
     * @param vc
     * @param Pessoas_idPessoas
     * @param ve
     * @return
     * @throws java.sql.SQLException
     */
    public int saveCar(VeiculoCombustao vc, VeiculoEletrico ve, int Pessoas_idPessoas) throws SQLException {
        // Tentar Guardar Dados
        if (vc != null) {
            PreparedStatement pt = conn.prepareStatement("INSERT INTO Veiculos(idVeiculos, marca, modelo, cilindrada, nChassi, nLugares, nPortas, Tipos_idTipos, Pessoas_idPessoas) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE "
                    + "marca = ?, "
                    + "modelo = ?, "
                    + "cilindrada = ? "
                    + "nChassi = ?, "
                    + "nLugares = ?, "
                    + "nPortas = ?;");

            // Set WildCards
            pt.setString(1, vc.getMatricula()); // Matricula
            pt.setString(2, vc.getMarca()); // Marca
            pt.setString(3, vc.getModelo()); // Modelo
            pt.setInt(4, vc.getCilindrada()); // Cilindrada
            pt.setInt(5, vc.getnChassi()); //  Chassi
            pt.setInt(6, vc.getnLugares()); // Lugares
            pt.setInt(7, vc.getnPortas()); // Portas
            pt.setInt(8, Pessoas_idPessoas); // Pessoa
            pt.setInt(9, 2);                 // Tipo
            pt.setString(10, vc.getMarca()); // Marca
            pt.setString(11, vc.getModelo()); // Modelo
            pt.setInt(12, vc.getCilindrada()); // Cilindrada
            pt.setInt(13, vc.getnChassi()); //  Chassi
            pt.setInt(14, vc.getnLugares()); // Lugares
            pt.setInt(15, vc.getnPortas()); // Portas

            // Executar
            return pt.executeUpdate();
        } else if (ve != null) {
            PreparedStatement pt = conn.prepareStatement("INSERT INTO Veiculos(idVeiculos, marca, modelo, nChassi, nLugares, nPortas, Pessoas_idPessoas, Tipos_idTipos) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE "
                    + "marca = ?, "
                    + "modelo = ?, "
                    + "nChassi = ?, "
                    + "nLugares = ?, "
                    + "nPortas = ?;");

            // Set WildCards
            pt.setString(1, ve.getMatricula()); // Matricula
            pt.setString(2, ve.getMarca()); // Marca
            pt.setString(3, ve.getModelo()); // Modelo
            pt.setInt(4, ve.getnChassi()); //  Chassi
            pt.setInt(5, ve.getnLugares()); // Lugares
            pt.setInt(6, ve.getnPortas()); // Portas
            pt.setInt(7, Pessoas_idPessoas); // Pessoa
            pt.setInt(8, 1);                 // Tipo
            pt.setString(9, ve.getMarca()); // Marca
            pt.setString(10, ve.getModelo()); // Modelo
            pt.setInt(11, ve.getnChassi()); //  Chassi
            pt.setInt(12, ve.getnLugares()); // Lugares
            pt.setInt(13, ve.getnPortas()); // Portas

            // Executar
            return pt.executeUpdate();
        }
        return 0;
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
    public int removePerson(Integer cc) throws SQLException {
        PreparedStatement pt = conn.prepareStatement("DELETE FROM Pessoas WHERE idPessoas = ?;");
        pt.setInt(1, cc);
        return pt.executeUpdate();
    }

    /**
     *
     * @param vc
     * @param ve
     * @return
     * @throws SQLException
     */
    public int removeCar(VeiculoCombustao vc, VeiculoEletrico ve) throws SQLException {
        if (vc != null) {
            PreparedStatement pt = conn.prepareStatement("DELETE FROM Veiculos"
                    + "WHERE idVeiculos = ?");
            pt.setString(1, vc.getMatricula());
            return pt.executeUpdate();
        } else if (ve != null) {
            PreparedStatement pt = conn.prepareStatement("DELETE FROM Veiculos"
                    + "WHERE idVeiculos = ?");
            pt.setString(1, ve.getMatricula());
            return pt.executeUpdate();
        }
        return 0;
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
     * @param vc
     * @param ve
     * @return
     * @throws SQLException
     */
    public int containsCar(VeiculoCombustao vc, VeiculoEletrico ve) throws SQLException {

        if (vc != null) {
            PreparedStatement pt = conn.prepareStatement("SELECT * "
                    + "FROM Veiculos"
                    + "WHERE 'idVeiculos' = ? ");
            pt.setString(1, vc.getMatricula());
            return pt.executeUpdate();
        } else if (ve != null) {
            PreparedStatement pt = conn.prepareStatement("SELECT * "
                    + "FROM Veiculos"
                    + "WHERE 'idVeiculos' = ? ");
            pt.setString(1, ve.getMatricula());
            return pt.executeUpdate();
        }
        return 0;
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
