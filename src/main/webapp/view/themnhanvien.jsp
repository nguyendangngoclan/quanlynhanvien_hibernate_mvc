<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Thêm nhân viên</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
	<div class="mx-auto col-8">
		<div align="center">
			<h1>THÊM NHÂN VIÊN</h1>
		</div>
		<form:form action="${contextPath}/insertNhanVien" method="POST" modelAttribute="nhanvien">
		  <div class="form-group">
		    <label for="txtHoTen">Họ tên</label>
		    <!-- <input type="text" class="form-control" id="txtHoTen"> --> 
		    <form:input path="hoTen" class="form-control" id="hoTen"/>
		  </div>
		  <div class="form-group">
		    <label for="txtNamSinh">Năm sinh</label>
		    <!-- <input type="text" class="form-control" id="txtNamSinh"> -->
		    <form:input path="namSinh" class="form-control" id="namSinh"/>
		  </div>
		  <div class="form-group">
		    <label for="txtQueQuan">Quê quán</label>
		    <!-- <input type="text" class="form-control" id="txtQueQuan"> -->  
		    <form:input path="queQuan" class="form-control" id="queQuan"/>
		  </div>
		  <div class="form-group">
		    <label for="txtEmail">Email</label>
		    <!-- <input type="email" class="form-control" id="txtEmail"> -->
		    <form:input path="email" class="form-control" id="email"/>
		  </div>
		  <div class="form-group">
		    <label for="txtBangCap1">Bằng cấp thứ nhất</label>
		    <!-- <input type="email" class="form-control" id="txtEmail"> -->
		    <form:input path="listBangCap" class="form-control" id="bangCap1"/>
		  </div>
		  <div class="form-group">
		    <label for="txtBangCap2">Bằng cấp thứ hai</label>
		    <!-- <input type="email" class="form-control" id="txtEmail"> -->
		    <form:input path="listBangCap" class="form-control" id="bangCap2"/>
		  </div>
		  <div class="form-group">
		    <label for="txtBangCap3">Bằng cấp thứ ba</label>
		    <!-- <input type="email" class="form-control" id="txtEmail"> -->
		    <form:input path="listBangCap" class="form-control" id="bangCap3"/>
		  </div>
		  <div class="form-group">
		    <label for="txtLoaiNhanVien">Loại nhân viên</label>
		    <!-- <input type="text" class="form-control" id="txtLoaiNhanVien"> -->
		    <form:select class="form-control" path="loaiNhanVien">
			   <form:option value="NONE" label="--- Select ---"/>
			   <c:forEach items="${loaiNV}" var="objLoaiNV">
			   	<form:option value="${objLoaiNV.id}" label="${objLoaiNV.loaiNhanVien}"/>
			   </c:forEach>
			   <%-- <form:options items="${loaiNV}" /> --%>
			</form:select>
		  </div>
		  <form:button class="btn btn-primary" id="thong_bao">Thêm</form:button>
		  <!-- <button type="submit" class="btn btn-primary">Thêm</button> -->
		  <button type="button" class="btn btn-secondary" id="back">Thoát</button>
		</form:form>	
	</div>
</body>
<script type="text/javascript">

$(document).ready(function(){

	$('#namSinh').val('');

 });
$( "#back" ).click(function() {
	location.assign("http://localhost:8080/QuanLyNhanVien");
});
$( "#thong_bao" ).click(function() {
	alert("thêm thành công");
});
</script>
</html>