package dao;

import connect.ConnectFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExameDAO {

    private final Connection con;

    public ExameDAO() {
        this.con = new ConnectFactory().getConnection();
    }

    /**
     * Insere um exame no banco.
     * 
     * @param pacienteId pode ser null se paciente não existir
     * @param tipoExame
     * @param resultado
     * @param dataExame java.sql.Date
     * @return true se inserido com sucesso, false caso contrário
     */
    public boolean inserirExame(Integer pacienteId, String tipoExame, String resultado, Date dataExame) {
        String sql = "INSERT INTO exame (paciente_id, usuario_id, tipo_exame, resultado, data_exame) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            if (pacienteId == null) {
                stmt.setNull(1, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(1, pacienteId);
            }

            // ID fixo do médico, pode ser alterado conforme necessário
            stmt.setInt(2, 1);

            stmt.setString(3, tipoExame);
            stmt.setString(4, resultado);
            stmt.setDate(5, dataExame);

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir exame: " + e.getMessage());
            return false;
        }
    }
}
