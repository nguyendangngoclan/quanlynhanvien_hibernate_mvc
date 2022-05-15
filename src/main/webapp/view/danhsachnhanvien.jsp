<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách nhân viên</title>
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
	<div class="mx-auto col-8">
		<div align="center">
			<h1>DANH SÁCH NHÂN VIÊN</h1>
		</div>
		<table class="table">
		  <thead class="thead-light">
		    <tr>
		      <th scope="col">Họ tên</th>
		      <th scope="col">Năm sinh</th>
		      <th scope="col">Quê quán</th>
		      <th scope="col">Email</th>
		      <th scope="col">Loại nhân viên</th>
		      <th scope="col">Bằng cấp</th>
		      <th scope="col"></th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${listNhanVien}" var="objNhanVien">
		  	<tr>
		      <td>${objNhanVien.hoTen}</td>
		      <td>${objNhanVien.namSinh}</td>
		      <td>${objNhanVien.queQuan}</td>
		      <td>${objNhanVien.email}</td>
		      <td>${objNhanVien.loaiNV.loaiNhanVien}</td>
		      <td>
		      	<c:forEach items="${objNhanVien.bangCaps}" var="objBangCap">
		      		${objBangCap.xepLoai} /
		      	</c:forEach>
		      </td>
		      <td><a class="btn btn-success" style="height: 35px;" href="${contextPath}/showUpdateNhanVien/${objNhanVien.idNhanvien}">Sửa</a>
		      <a class="btn btn-danger" style="height: 35px;" href="${contextPath}/deleteNhanVien/${objNhanVien.idNhanvien}">Xóa</a></td>
		    </tr>
		  </c:forEach>
		  </tbody>
		</table>
		<button type="button" class="btn btn-secondary" id="back">Thoát</button>
	</div>
</body>
<script type="text/javascript">

$(document).ready(function(){

 });
/* $( "#back" ).click(function() {
	window.history.back();
}); */
$( "#back" ).click(function() {
	location.assign("http://localhost:8080/QuanLyNhanVien");
});
</script>
</html>