package empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.Conexao;

public class Projeto {
    private int id;
    private String nome;
    private String descricao;
    private int idFuncionario;

    public Projeto() {}

    public Projeto(int id, String nome, String descricao, int idFuncionario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.idFuncionario = idFuncionario;
    }

    // Incluir Projeto
    public boolean incluirProjeto() throws ClassNotFoundException {
        String sql = "INSERT INTO projeto (nome, descricao, id_funcionario) VALUES (?, ?, ?)";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, getNome());
            stmt.setString(2, getDescricao());
            stmt.setInt(3, getIdFuncionario());

            stmt.executeUpdate();
            return true;

        } catch (SQLException erro) {
            System.err.println("Erro ao incluir projeto: " + erro.getMessage());
            return false;
        }
    }

    // Listar projetos
    public void listarProjetos() throws ClassNotFoundException {
        String sql = "SELECT * FROM projeto";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("NOME: " + rs.getString("nome"));
                System.out.println("DESCRIÇÃO: " + rs.getString("descricao"));
                System.out.println("ID Funcionário: " + rs.getInt("id_funcionario"));
                System.out.println("---------------------------");
            }

        } catch (SQLException erro) {
            System.err.println("Erro ao listar projetos: " + erro.getMessage());
        }
    }

    // Alterar Projeto
    public boolean alterarProjeto() throws ClassNotFoundException {
        String sql = "UPDATE projeto SET nome = ?, descricao = ?, id_funcionario = ? WHERE id = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, getNome());
            stmt.setString(2, getDescricao());
            stmt.setInt(3, getIdFuncionario());
            stmt.setInt(4, getId());

            stmt.executeUpdate();
            return true;

        } catch (SQLException erro) {
            System.err.println("Erro ao alterar projeto: " + erro.getMessage());
            return false;
        }
    }

    // Excluir Projeto
    public boolean excluirProjeto() throws ClassNotFoundException {
        String sql = "DELETE FROM projeto WHERE id = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, getId());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao excluir projeto: " + e.getMessage());
            return false;
        }
    }

    // Getters e setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
