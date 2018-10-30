<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

    <spring:url value="/resources/js/main.css" var="mainCss" />
    <spring:url value="/resources/js/reso.ico" var="ico" />

    <link href="${mainCss}" rel="stylesheet" />
    <link rel="shortcut icon" href="${ico}" type="image/x-icon" />

</head>
<body>

<div class="wrapper">
    <div id = "inner">
        <h1>RESO TEST</h1>
        <h2>Message: ${msg}</h2>
    </div>


</body>

</html>