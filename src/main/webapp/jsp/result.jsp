<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->



</head>
<body>


<div class="container">
        <h1> R E S U L T </h1>
</div>

<div class="result">
        <h3>Calc ID #1: ${calcid1}</h3>
    <h3>Calc ID  #2: ${calcid2}</h3>
    <h2>RESULT : ${compairresult}</h2>


    <table>
        <!-- here should go some titles...-->
        <tr>
            <th>NAME</th>
            <th>CHECK</th>
        </tr>


    <c:forEach items="${map}" var="entry">
        <tr>
            <td>
                <c:out value="${entry.key}" />
            </td>
            <td>
                <c:out value="${entry.value}" />
            </td>
        </tr>

    </c:forEach>
    </table>



</div>




</body>

</html>