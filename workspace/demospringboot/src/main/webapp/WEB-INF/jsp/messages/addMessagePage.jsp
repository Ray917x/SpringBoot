<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <!-- 訂義jstl為"c" -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 給c 根目錄的值 並設定名字為contextroot -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>

<div class="container">

<br/>

<div class="card">
  <div class="card-header">
   新增訊息
  </div>
  <div class="card-body">
   
   <!-- form form表單要加入 %@ taglib-->
    <form:form action="${contextRoot}/messages/post" method="post" modelAttribute="messages">
    
   <div class="input-group">
      <form:textarea class="form-control" path="text"/>
   </div>
   <br />
    <button type="submit" class="btn btn-primary mb-2" >送出</button>
<!--      <input type="submit" name="submit" value="送出" /> -->
   </form:form>
   
  </div>
  <div class="card">
  <div class="card-header">
  最新訊息 時間: ${lastestMsg.added}
  <span> </span>
  </div>
  <div class="card-body">
   
   ${lastestMsg.text}
   
  </div>
</div>

</div>


</body>
</html>