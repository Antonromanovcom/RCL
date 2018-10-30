<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">
<head>


    <spring:url value="/resources/js/yes.png" var="yesimg"/>
    <spring:url value="/resources/js/no.png" var="noimg"/>
    <spring:url value="/resources/js/main.css" var="mainCss"/>
    <spring:url value="/resources/js/mainjs.js" var="mainjs"/>
    <spring:url value="/resources/js/reso.ico" var="ico" />

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="shortcut icon" href="${ico}" type="image/x-icon" />
    <link href="${mainCss}" rel="stylesheet"/>
    <script src="${mainjs}"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>


</head>
<body onload="colorizeAll()">


<div class="container">
    <h1>FULL RESULT TABLE</h1>
</div>

<div class="result">
    <h3>Calc ID #1: ${calcid1}</h3>
    <h3>Calc ID #2: ${calcid2}</h3>

    <hr>

    <div class="controlbtnsdiv">

        <a class="buttons" href='#' onclick="getHtml()"> Подготовить HTML </a>


    </div>
    <div id="fullRezult">
    <hr>
    <h2>WS Calc Logs New</h2>
    <hr>
    <div class="resulttable" id="allresulttable">
    <table id="thetable">
        <!-- here should go some titles...-->
        <tr>
            <th>NAME</th>
            <th>${calcid1}</th>
            <th>${calcid2}</th>
        </tr>

        <c:forEach items="${map}" var="entry">
            <tr>
                <td>
                    <c:out value="${entry.key}"/>
                </td>
                <td align="center">
                    <c:out value="${entry.value.value1}"/>
                </td>
                <td align="center">
                    <c:out value="${entry.value.value2}"/>
                </td>
            </tr>

        </c:forEach>
    </table>
    </div>
    <hr>
    <h2>WS Coeff Calc Logs</h2>
    <hr>
    <div class="resulttable" id="coefResulttTable">
        <table id="table4Coeff">

            <tr>
                <th>NAME</th>
                <th>${calcid1}</th>
                <th>${calcid2}</th>
            </tr>

            <c:forEach items="${coefs}" var="entry">
                <tr>
                    <td>
                        <c:out value="${entry.key}"/>
                    </td>
                    <td align="center" style="padding: 25px">
                        <c:out value="${entry.value.value1}"/>
                    </td>
                    <td align="center">
                        <c:out value="${entry.value.value2}"/>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>

    <!-- ПРЕМИИ (ОНИ ЖЕ - БОНУСЫ) -->
    <hr>
    <h2>WS Premium Logs</h2>
    <hr>
    <div class="resulttable" id="bonusesTable">
        <table id="table4Bonuses">

            <tr>
                <th>NAME</th>
                <th>${calcid1}</th>
                <th>${calcid2}</th>
            </tr>

            <c:forEach items="${bonuses}" var="entry">
                <tr>
                    <td>
                        <c:out value="${entry.key}"/>
                    </td>
                    <td align="center" style="padding: 25px">
                        <c:out value="${entry.value.value1}"/>
                    </td>
                    <td align="center">
                        <c:out value="${entry.value.value2}"/>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>

    <!-- ВОДИЛЫ -->
    <hr>
    <h2>WS Drivers Logs</h2>
    <hr>
    <div class="resulttable" id="driversTable">
        <table id="table4Drivers">

            <tr>
                <th>NAME</th>
                <th>${calcid1}</th>
                <th>${calcid2}</th>
            </tr>

            <c:forEach items="${drivers}" var="entry">
                <tr>
                    <td>
                        <c:out value="${entry.key}"/>
                    </td>
                    <td align="center" style="padding: 25px">
                        <c:out value="${entry.value.value1}"/>
                    </td>
                    <td align="center">
                        <c:out value="${entry.value.value2}"/>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>

    <!-- ПАРТНЕРЫ -->
    <hr>
    <h2>WS Partners Logs</h2>
    <hr>
    <div class="resulttable" id="partnersTable">
        <table id="table4Partners">

            <tr>
                <th>NAME</th>
                <th>${calcid1}</th>
                <th>${calcid2}</th>
            </tr>

            <c:forEach items="${partners}" var="entry">
                <tr>
                    <td>
                        <c:out value="${entry.key}"/>
                    </td>
                    <td align="center" style="padding: 25px">
                        <c:out value="${entry.value.value1}"/>
                    </td>
                    <td align="center">
                        <c:out value="${entry.value.value2}"/>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>

    <!-- COMMONLOGS -->
    <hr>
    <h2>WS Common Logs</h2>
    <hr>
    <div class="resulttable" id="commonLogsTable">
        <table id="table4PCommonLogs">

            <tr>
                <th>NAME</th>
                <th>${calcid1}</th>
                <th>${calcid2}</th>
            </tr>

            <c:forEach items="${commonLogs}" var="entry">
                <tr>
                    <td>
                        <c:out value="${entry.key}"/>
                    </td>
                    <td align="center" style="padding: 25px">
                        <c:out value="${entry.value.value1}"/>
                    </td>
                    <td align="center">
                        <c:out value="${entry.value.value2}"/>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>
    </div>


</div>


<!-- Modal -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">HTML-код таблицы</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="results" id="resultss">
                    <textarea id="paste" class="js-copytextarea" style="width: 100%"></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="copyToClipboard()">Copy & Close</button>
            </div>
        </div>
    </div>
</div>


</body>

</html>