package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO extends DAO {
    public UsuarioDAO() { super(); conectar(); }

    public boolean insert(Usuario usuario) {
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO usuario (codigo, login, senha, sexo) VALUES (" +
                usuario.getCodigo() + ", '" + usuario.getLogin() + "', '" +
                usuario.getSenha() + "', '" + usuario.getSexo() + "');");
            return true;
        } catch (SQLException e) { return false; }
    }

    public List<Usuario> get() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            ResultSet rs = conexao.createStatement().executeQuery("SELECT * FROM usuario");
            while(rs.next()) {
                usuarios.add(new Usuario(rs.getInt("codigo"), rs.getString("login"),
                                       rs.getString("senha"), rs.getString("sexo").charAt(0)));
            }
        } catch (Exception e) { System.err.println(e.getMessage()); }
        return usuarios;
    }
    
    public boolean delete(int codigo) {
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate("DELETE FROM usuario WHERE codigo = " + codigo);
            return true;
        } catch (SQLException e) { return false; }
    }

    public boolean update(Usuario usuario) {
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate("UPDATE usuario SET login = '" + usuario.getLogin() + "', senha = '" + 
                usuario.getSenha() + "', sexo = '" + usuario.getSexo() + "' WHERE codigo = " + usuario.getCodigo());
            return true;
        } catch (SQLException e) { return false; }
    }
}