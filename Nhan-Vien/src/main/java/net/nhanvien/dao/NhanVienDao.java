package net.nhanvien.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.nhanvien.model.NhanVien;

public class NhanVienDao {
	
	public int dangkynhanVien(NhanVien nhanvien) throws ClassNotFoundException {
		String them_nhanvien_sql = "insert into nhanvien " + 
				" (ho,ten,tendangnhap,matkhau,diachi,sdt) values " + " (?,?,?,?,?,?);";
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/jsp_nhanvien", "root", "");
				PreparedStatement preparedStatement = connection.prepareStatement(them_nhanvien_sql)){
			
			preparedStatement.setString(1, nhanvien.getHo());
			preparedStatement.setString(2, nhanvien.getTen());
			preparedStatement.setString(3, nhanvien.getTenDangNhap());
			preparedStatement.setString(4, nhanvien.getMatKhau());
			preparedStatement.setString(5, nhanvien.getDiaChi());
			preparedStatement.setInt(6, nhanvien.getSdt());
			
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
