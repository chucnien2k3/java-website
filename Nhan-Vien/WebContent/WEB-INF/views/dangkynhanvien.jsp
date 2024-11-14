<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Lưu ý name="ho" là khai báo của NhanVien -->
 <div align="center">
  <h1>Biểu Mẫu Đăng Ký Nhân Viên</h1>
  <form action="<%= request.getContextPath() %>/dang-ky" method="post">
   <table style="with: 80%">
    <tr>
     <td>Họ</td>
     <td><input type="text" name="ho" /></td>
    </tr>
    <tr>
     <td>Tên</td>
     <td><input type="text" name="ten" /></td>
    </tr>
    <tr>
     <td>Tên Đăng Nhập</td>
     <td><input type="text" name="tenDangNhap" /></td>
    </tr>
    <tr>
     <td>Mật Khẩu</td>
     <td><input type="password" name="matKhau" /></td>
    </tr>
    <tr>
     <td>Địa Chi</td>
     <td><input type="text" name="diaChi" /></td>
    </tr>
    <tr>
     <td>Số Điện Thoại</td>
     <td><input type="text" name="sdt" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>