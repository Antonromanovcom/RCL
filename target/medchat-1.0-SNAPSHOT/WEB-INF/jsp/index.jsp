<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

    <spring:url value="/resources/css/main.css" var="mainCss" />
    <spring:url value="/resources/images/reso.ico" var="ico" />

    <link href="${mainCss}" rel="stylesheet" />
    <link rel="shortcut icon" href="${ico}" type="image/x-icon" />

</head>
<body>

<div class="wrapper">
    <div id = "inner">
        <h1>RESO CALC ID Compair Input Form</h1>
    </div>

<div class="container">
    <div class="starter-template">
    </div>
</div>


<form:form method="POST" action="${pageContext.request.contextPath}/he" class="contact_form" modelAttribute="CalcId">


    <table style="width: 100%">
        <tr>
            <td><form:label path="calcId">calcId #1: </form:label></td>
            <td><form:input path="calcId" class="Input-text"/></td>
            <td></td>
        </tr>
        <tr>
            <td><form:label path="calcIdSecond">calcId #2: </form:label></td>
            <td><form:input path="calcIdSecond"/></td>
            <td></td>
        </tr>
        <tr>
            <td>Тип проверки</td>
            <td style="text-align: left; padding-left: 170px">
                <form:radiobutton path="type" value="1" /> Полная проверка <br>
                <form:radiobutton path="type" value="2" /> Только различия</td>
            <td></td>
        </tr>
        <tr>
            <td colspan="3" style="text-align: center"><hr></td>

        </tr>
        <tr>

            <td colspan="3" style="text-align: center"><input class="submit" type="submit" value="Submit"/></td>
        </tr>



    </table>

</form:form>

</div>

</body>

</html>