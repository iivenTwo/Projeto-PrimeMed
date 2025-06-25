package dao;

import connect.ConnectFactory;
import examples.model.Usuario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class UsuarioDAO {

    private final Connection con;

    public UsuarioDAO() {
        this.con = new ConnectFactory().getConnection();
    }

    // Busca o nome do usuário pelo CPF
    public String buscarNomePorCpf(String cpf) {
        String sql = "SELECT nome FROM usuario WHERE cpf = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("nome");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cadastra um novo usuário com todos os campos
    public void cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario " +
                "(nome, cpf, nascimento, sexo, estado_civil, rg, cep, endereco, telefone, crm, tipo_usuario, especialidade) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getCpf());

            // Trata nascimento que pode ser null
            LocalDate nascimento = usuario.getNascimento();
            if (nascimento != null) {
                ps.setDate(3, Date.valueOf(nascimento));
            } else {
                ps.setDate(3, null);
            }

            ps.setString(4, usuario.getSexo());
            ps.setString(5, usuario.getEstadoCivil());

            // RG pode ser null
            if (usuario.getRg() != null && !usuario.getRg().isEmpty()) {
                ps.setString(6, usuario.getRg());
            } else {
                ps.setNull(6, java.sql.Types.VARCHAR);
            }

            // CEP pode ser null
            if (usuario.getCep() != null && !usuario.getCep().isEmpty()) {
                ps.setString(7, usuario.getCep());
            } else {
                ps.setNull(7, java.sql.Types.VARCHAR);
            }

            // Endereço pode ser null
            if (usuario.getEndereco() != null && !usuario.getEndereco().isEmpty()) {
                ps.setString(8, usuario.getEndereco());
            } else {
                ps.setNull(8, java.sql.Types.VARCHAR);
            }

            // Telefone pode ser null
            if (usuario.getTelefone() != null && !usuario.getTelefone().isEmpty()) {
                ps.setString(9, usuario.getTelefone());
            } else {
                ps.setNull(9, java.sql.Types.VARCHAR);
            }

            // CRM pode ser null
            if (usuario.getCrm() != null && !usuario.getCrm().isEmpty()) {
                ps.setString(10, usuario.getCrm());
            } else {
                ps.setNull(10, java.sql.Types.VARCHAR);
            }

            ps.setString(11, usuario.getTipoUsuario());

            ps.setString(12, usuario.getEspecialidade());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public boolean crmExiste(String crm) {
    boolean existe = false;
    String sql = "SELECT COUNT(*) FROM usuario WHERE crm = ?";
    
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setString(1, crm);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            existe = rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
       
        
    }
    
    return existe;
}
    
        public boolean cpfExiste(String cpf) {
        String sql = "SELECT COUNT(*) FROM usuario WHERE cpf = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            
        }
        return false;
    }

    
    // Verifica se CPF existe no banco
    public boolean existeCpf(String cpf) {
        String sql = "SELECT COUNT(*) FROM usuario WHERE cpf = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    

    public Integer getUsuarioIdPorId(int usuarioId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
