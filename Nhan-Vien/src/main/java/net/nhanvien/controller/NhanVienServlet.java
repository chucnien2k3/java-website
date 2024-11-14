package net.nhanvien.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.nhanvien.dao.NhanVienDao;
import net.nhanvien.model.NhanVien;

/**
 * Servlet implementation class nhanvienServlet
 */
@WebServlet("/dang-ky")
public class NhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NhanVienDao nhanVienDao = new NhanVienDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NhanVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/views/dangkynhanvien.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ho = request.getParameter("ho");
		String ten = request.getParameter("ten");
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		String diaChi = request.getParameter("diaChi");
		Integer sdtI = Integer.parseInt(request.getParameter("sdt"));
		String sdtS = String.valueOf(sdtI);
		
		NhanVien nhanvien = new NhanVien();
		nhanvien.setHo(ho);
		nhanvien.setTen(ten);
		nhanvien.setTenDangNhap(tenDangNhap);
		nhanvien.setMatKhau(matKhau);
		nhanvien.setDiaChi(diaChi);
		nhanvien.setSdt(sdtI);
		
		try {
			nhanVienDao.dangkynhanVien(nhanvien);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/views/detaildangkynhanvien.jsp");
		dispatcher.forward(request, response);
	}

}
