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



</body>

</html>