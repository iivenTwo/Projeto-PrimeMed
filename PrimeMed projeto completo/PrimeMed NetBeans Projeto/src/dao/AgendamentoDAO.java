package dao;

import connect.ConnectFactory;

import java.sql.*;
import java.time.LocalDateTime;

public class AgendamentoDAO {

    private final Connection con;

    public AgendamentoDAO() {
        this.con = new ConnectFactory().getConnection();
    }

    // Busca paciente pelo CPF para obter o ID
    public Integer getPacienteIdPorCpf(String cpf) throws SQLException {
        String sql = "SELECT id FROM paciente WHERE cpf = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return null; // paciente não encontrado
    }

    // Insere agendamento na tabela
    public boolean inserirAgendamento(int pacienteId, int usuarioId, LocalDateTime dataHora, String descricao) {
        String sql = "INSERT INTO agendamento (paciente_id, usuario_id, data_hora, descricao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, pacienteId);
            stmt.setInt(2, usuarioId);
            stmt.setTimestamp(3, Timestamp.valueOf(dataHora));
            stmt.setString(4, descricao);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir agendamento: " + e.getMessage());
            return false;
        }
    }
}
