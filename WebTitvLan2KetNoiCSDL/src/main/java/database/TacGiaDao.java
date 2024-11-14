package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TacGia;

public class TacGiaDao implements DaoInterface<TacGia> {
	@Override
	public ArrayList<TacGia> selectAll() {
		ArrayList<TacGia> ketQua = new ArrayList<TacGia>();
		
		try {
			// bước 1
			Connection con = JDBCUtil.getConnection();
			// bước 2
			String sql = "select * from tacgia";
			PreparedStatement st = con.prepareStatement(sql);
			// bước 3
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// bước 4
			while(rs.next()) {
				String maTacGia = rs.getString("matacgia");
				String hocVaTen = rs.getString("hovaten");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getString("tieusu");
				TacGia tg = new TacGia(maTacGia, hocVaTen, ngaySinh, tieuSu);
				ketQua.add(tg);
				
			}
			// bước 5
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public TacGia selectById(TacGia t) {
		TacGia ketQua = null;
		
		try {
			// bước 1
			Connection con = JDBCUtil.getConnection();
			// bước 2
			String sql = "select * from tacgia where matacgia=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());
			// bước 3
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// bước 4
			while(rs.next()) {
				String maTacGia = rs.getString("matacgia");
				String hoVaTen = rs.getString("hovaten");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getString("tieusu");
				ketQua = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
				break;
				
			}
			// bước 5
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int insert(TacGia t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO tacgia (matacgia, hovaten, ngaysinh, tieusu) "+
						" VALUES (?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());
			st.setString(2, t.getHoVaTen());
			st.setDate(3, t.getNgaySinh());
			st.setString(4, t.getTieuSu());

			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<TacGia> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(TacGia t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from tacgia "+
						 " WHERE matacgia=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());
			
			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<TacGia> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(TacGia t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE tacgia "+
					 " SET " +
					 " hovaten=?"+
					 ", ngaysinh=?"+
					 ", tieusu=?"+
					 " WHERE matacgia=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getHoVaTen());
			st.setDate(2, t.getNgaySinh());
			st.setString(3, t.getTieuSu());
			st.setString(4, t.getMaTacGia());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	public static void main(String[] args) {
		TacGiaDao tgd = new TacGiaDao();
//		ArrayList<TacGia> kq = tgd.selectAll();
//		for (TacGia tacGia : kq) {
//			System.out.println(tacGia.toString());
//		}
//		
//		TacGia tg = tgd.selectById(new TacGia("TG1", "", null, ""));
//		System.out.println(tg);
		
		// test insert
//		TacGia tg_new = new TacGia("TG9", "Niên", new Date(2003-1900, 06-1, 13), null);
//		tgd.insert(tg_new);
		
		// test delete
//		TacGia tg_delete = new TacGia("TG9", "Niên", new Date(2003-1900, 06-1, 13), null);
//		tgd.delete(tg_delete);
		
		// test update
//		TacGia tg_update = new TacGia("TG9", "Niên", new Date(2003-1900, 06-1, 13), "đi tù mới về");
//		tgd.update(tg_update);
		
		TacGia tg = tgd.selectById(new TacGia("TG9", "", null, ""));
		System.out.println(tg);
		tg.setTieuSu("Đi Tù Một Gông");
		
		tgd.update(tg);
		
	}
	
}
