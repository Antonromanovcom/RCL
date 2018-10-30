<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->
    <spring:url value="/resources/js/05.jpg" var="m1" />


</head>
<body>


<div class="container">
    <div class="starter-template">
        <h1>RESO CALC ID Compair</h1>
        <h2>Message: ${msg}</h2>
    </div>
</div>

<p>IMG</p>>
<img src="${m1}" />



<form:form method="POST" action="/medchat-1.0-SNAPSHOT/he" modelAttribute="CalcId">
    <table>
        <tr>
            <td><form:label path="calcId">calcId #1: </form:label></td>
            <td><form:input path="calcId"/></td>
        </tr>
        <tr>
            <td><form:label path="calcIdSecond">calcId #2: </form:label></td>
            <td><form:input path="calcIdSecond"/></td>
        </tr>

            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>

</body>

</html>