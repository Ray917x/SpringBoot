<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 訂義jstl為"c" -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 給c 根目錄的值 並設定名字為contextroot -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">                       <!-- 使用此方法後面要加/ -->
				<li class="nav-item active"><a class="nav-link" href="${contextRoot}/">Home
						<span class="sr-only">(current)</span>
				</a></li>									  <!-- MessagesController mapping地址 -->
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/messages/add">Link</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-expanded="false"> Dropdown </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div></li>
				<li class="nav-item"><a class="nav-link disabled">Disabled</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>



	<script type="text/javascript"
		src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
	<!-- jquery一定要放前面 -->
	<script type="text/javascript"
		src="${contextRoot}/js/bootstrap.bundle.js"></script>
</body>
</html>