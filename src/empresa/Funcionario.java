package empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexao;

public class Funcionario extends Pessoa {
	// Variáveis
	private String matricula;
	private String departamento;

	public Funcionario() {
	}

	public Funcionario(int id, String nome, String email, String matricula, String departamento) {
		super(id, nome, email);
		this.matricula = matricula;
		this.departamento = departamento;
	}

	// Método para incluir funcionário
	public boolean incluirFuncionario() throws ClassNotFoundException {
		String sqlPessoa = "INSERT INTO pessoa (id, nome, email) VALUES (?, ?, ?)";
		String sqlFuncionario = "INSERT INTO funcionario (id, matricula, departamento) VALUES (?, ?, ?)";
		Connection con = Conexao.conectar();
		try {
			// Inserir Pessoa
			PreparedStatement stm = con.prepareStatement(sqlPessoa);
			stm.setInt(1, super.getId());
			stm.setString(2, super.getNome());
			stm.setString(3, super.getEmail());
			stm.execute();

			// Inserir Funcionario
			stm = con.prepareStatement(sqlFuncionario);
			stm.setInt(1, super.getId());
			stm.setString(2, this.matricula);
			stm.setString(3, this.departamento);
			stm.execute();
			return true;
		} catch (SQLException erro) {
			System.out.println("");
			System.err.println("Ocorreu um erro na inserção do funcionário - " + erro.getMessage());
			return false;
		}
	}

	// Método para alterar funcionário
	public boolean alterarFuncionario() throws ClassNotFoundException {
		Connection con = null;
		PreparedStatement stm = null;
		con = Conexao.conectar();
		try {
			// Alterar Pessoa
			String sqlPessoa = "UPDATE pessoa SET nome = ?, email = ? WHERE id = ?";
			stm = con.prepareStatement(sqlPessoa);
			stm.setString(1, super.getNome());
			stm.setString(2, super.getEmail());
			stm.setInt(3, super.getId());
			stm.execute();

			// Alterar Funcionario
			String sqlFuncionario = "UPDATE funcionario SET matricula = ?, departamento = ? WHERE id = ?";
			stm = con.prepareStatement(sqlFuncionario);
			stm.setString(1, this.matricula);
			stm.setString(2, this.departamento);
			stm.setInt(3, super.getId());
			stm.execute();
		} catch (SQLException erro) {
			System.out.println("");
			System.err.println("Ocorreu um erro na atualização - " + erro.getMessage());
			return false;
		} finally {
			try {
				if (stm != null)
					stm.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.err.println("Erro ao fechar recursos: " + e.getMessage());
			}
		}

		return true;
	}

	// Método para Excluir Funcionário
	public boolean excluirFuncionario() throws ClassNotFoundException {
		String sqlFuncionario = "DELETE FROM funcionario WHERE id = ?;";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sqlFuncionario);
			stm.setInt(1, super.getId());
			stm.execute();
		} catch (SQLException erro) {
			System.out.println("Erro na exclusao do funcionário - " + erro);
			return false;
		}
		String sqlPessoa = "DELETE FROM pessoa WHERE id = ?;";
		try {
			PreparedStatement stm = con.prepareStatement(sqlPessoa);
			stm.setInt(1, super.getId());
			stm.execute();
		} catch (SQLException erro) {
			System.out.println("Erro na exclusao de pessoa - " + erro);
			return false;
		}

		return true;
	}

	public List<Funcionario> listarFuncionario() throws ClassNotFoundException {
		List<Funcionario> listFunc = new ArrayList<>();
		Connection con = Conexao.conectar();

		String sql = "SELECT ";
		sql += "p.id, ";
		sql += "p.nome, ";
		sql += "p.email, ";
		sql += "f.matricula, ";
		sql += "f.departamento ";
		sql += "FROM pessoa p ";
		sql += "INNER JOIN funcionario f ";
		sql += "ON p.id = f.id";

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Matrícula: " + rs.getString("matricula"));
                System.out.println("Departamento: " + rs.getString("departamento"));
                System.out.println("-------------------------");
			}
		} catch (SQLException erro) {
			System.out.println("Problemas ao listar os Funcionários - " + erro);
		}
		return listFunc;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}
