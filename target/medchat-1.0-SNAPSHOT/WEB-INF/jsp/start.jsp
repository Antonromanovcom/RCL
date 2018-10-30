<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->
    <spring:url value="/resources/js/yes.png" var="m1" />
    <spring:url value="/resources/js/reso.ico" var="ico" />
    <spring:url value="/resources/js/main.css" var="mainCss" />

    <link href="${mainCss}" rel="stylesheet" />
    <link rel="shortcut icon" href="${ico}" type="image/x-icon" />

</head>
<body>




<div class="wrapper">
    <div id = "inner">
        <h1>RESO CALC ID Compair</h1>
    </div>
</div>

<div class= "wrapper2">
    <a class="buttons" href='${pageContext.request.contextPath}/ho' >Начать</a>
</div>





</body>

</html>