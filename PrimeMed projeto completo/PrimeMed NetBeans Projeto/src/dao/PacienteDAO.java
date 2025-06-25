package dao;

import connect.ConnectFactory;
import examples.model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteDAO {
    private final Connection con;

    public PacienteDAO() {
        this.con = new ConnectFactory().getConnection();
    }

    public boolean inserirPaciente(Paciente paciente) {
        String sql = "INSERT INTO paciente (nome, nascimento, sexo, cpf, rg, cep, endereco, estado_civil, numero_convenio, telefone, email, convenio) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNome());
            stmt.setDate(2, java.sql.Date.valueOf(paciente.getNascimento()));  // Convertendo LocalDate para java.sql.Date
            stmt.setString(3, paciente.getSexo());
            stmt.setString(4, paciente.getCpf());
            stmt.setString(5, paciente.getRg());
            stmt.setString(6, paciente.getCep());
            stmt.setString(7, paciente.getEndereco());
            stmt.setString(8, paciente.getEstadoCivil());
            stmt.setString(9, paciente.getNumeroConvenio());
            stmt.setString(10, paciente.getTelefone());
            stmt.setString(11, paciente.getEmail());
            stmt.setString(12, paciente.getConvenio());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir paciente: " + e.getMessage());
            return false;
        }
    }

    // Método para verificar se CPF já existe
    public boolean existeCpf(String cpf) {
        String sql = "SELECT COUNT(*) FROM paciente WHERE cpf = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar CPF: " + e.getMessage());
        }
        return false;
    }
    
    // Busca o ID do usuário pelo nome (busca exata)
    public Integer buscarIdPorNome(String nome) {
        String sql = "SELECT id FROM usuario WHERE nome = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Não encontrado
    }

    // Método para verificar se RG já existe
    public boolean existeRg(String rg) {
        String sql = "SELECT COUNT(*) FROM paciente WHERE rg = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, rg);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar RG: " + e.getMessage());
        }
        return false;
    }
}
