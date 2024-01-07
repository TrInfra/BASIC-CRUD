package DAO;

import DTO.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UserDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<UserDTO> list = new ArrayList<>();

    public void RegisterUser(UserDTO ObjecteUserDto) {
        String sql = "INSERT INTO usuario (username,cpf_cnpj,email) values (?,?,?)";
        conn = new ConnectionDB().ConnetionDataBase();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, ObjecteUserDto.getName_user());
            pstm.setString(2, ObjecteUserDto.getCpf_user());
            pstm.setString(3, ObjecteUserDto.getEmail_user());

            pstm.execute();
            pstm.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "UserDAO Register" + erro);
        }

    }

    public ArrayList<UserDTO> SearchUser() {
        String sql = "SELECT * FROM usuario ";
        conn = new ConnectionDB().ConnetionDataBase();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                UserDTO objecteUserDTO = new UserDTO();
                objecteUserDTO.setId_user(rs.getInt("id"));
                objecteUserDTO.setName_user(rs.getString("username"));
                objecteUserDTO.setEmail_user(rs.getString("email"));
                objecteUserDTO.setCpf_user(rs.getString("cpf_cnpj"));
                list.add(objecteUserDTO);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UserDAO Search" + erro);
        }
        return list;
    }

    public void UpdateUser(UserDTO ObjecteUserDto) {
        String sql = "UPDATE usuario set username = ?, cpf_cnpj = ?,email = ? where id = ?";
        conn = new ConnectionDB().ConnetionDataBase();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, ObjecteUserDto.getName_user());
            pstm.setString(2, ObjecteUserDto.getCpf_user());
            pstm.setString(3, ObjecteUserDto.getEmail_user());
            pstm.setInt(4, ObjecteUserDto.getId_user());

            pstm.execute();
            pstm.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "UserDAO update" + erro);
        }
    }

    public void DeleteUser(UserDTO ObjecteUserDto) {
        String sql = "DELETE from usuario where id = ?";
        conn = new ConnectionDB().ConnetionDataBase();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ObjecteUserDto.getId_user());
            pstm.execute();
            pstm.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "UserDAO Delete" + erro);
        }
    }
}
