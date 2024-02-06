package tests;

import java.sql.*;

/**
 *
 * @author efapro01.23
 */
public class testBD {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String server = "192.168.64.6";
        String username = "forasteiro";
        String password = "123";
        String dbname = "clinica_V1_1";

        String url = "jdbc:mysql://" + server + ":3306/" + dbname; // = string connection

        Connection conn = null;

        try {

            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Liga��o Estabelecida � BD com Sucesso!");

//            // Prepared Statement permite Wildcards
//            PreparedStatement pt = conn.prepareStatement("SELECT * FROM utente;");
//
//            // RESULT SET = DataSource, recebe os dados da base de dados
//            ResultSet rs = pt.executeQuery();
//
//            // Result Set � como iteration, ent�o pode ser percorrido com o next
//            // next() -> aponta para a linha a ler
//            // getString -> get por N� Coluna OU Nome Coluna
            PreparedStatement pt = conn.prepareStatement("INSERT INTO sala(codigo, dimensao, obs)"
                    + "VALUES(?, ?, ?)");
            // 1� Argumento -> Qual Interroga��o (?) estou a preencher
            // 2� Argumento -> Valor a Preencher
            pt.setInt(1, 7);
            pt.setInt(2, 1200);
            pt.setString(3, "SALA DE DESMANTELAMENTO");

            int result = pt.executeUpdate();

            System.out.println(result > 0 ? "Inser��o Efetuada com Sucesso" : "Erro na Inser��o");

//
//            while (rs.next()) {
//                System.out.println("nome: " + rs.getString("nome"));
//            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (conn != null) {
                try {

                    conn.close();

                } catch (SQLException e) {

                    System.out.println(e.getMessage());

                }
            }
        }

    }
}
