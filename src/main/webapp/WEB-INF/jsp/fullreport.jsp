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
    <spring:url value="/resources/js/reso.ico" var="ico"/>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="shortcut icon" href="${ico}" type="image/x-icon"/>
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

    </div>
    <div class="wrapper2">

        <div style="width:100%; height:1px; clear:both;"></div> <!-- выравниваем без обтекания -->
        <div class="wrapper3">
            <div id="line_block"><a class="buttons" href='#' onclick="getHtml()"> Подготовить HTML </a></div>
            <div id="line_block_center"></div>
            <div id="line_block_right"><a class="buttons" href='${pageContext.request.contextPath}/ho'> Назад </a></div>
        </div>
        <div style="width:100%; height:1px; clear:both;"></div> <!-- выравниваем без обтекания -->
    </div>


    <div id="fullRezult">
        <hr>
        <h2>WS Calc Logs New</h2>
        <hr>
        <div class="resulttable" id="allresulttable">
            <table id="thetable">
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

        <!-- Coeffs  -->

        <c:if test="${not empty coefs}">
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
        </c:if>

        <!-- ПРЕМИИ (ОНИ ЖЕ - БОНУСЫ) -->

        <c:if test="${not empty bonuses}">
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
        </c:if>

        <!-- ВОДИЛЫ -->
        <c:if test="${not empty drivers}">
            <hr>
            <h2>WS Drivers Logs</h2>
            <hr>
            <div class="resulttable2" id="driversTable">
                <table id="table4Drivers" border="1">

                    <tr>
                        <th rowspan="2">NAME</th>
                        <th colspan="11">${calcid1}</th>
                        <th colspan="11">${calcid2}</th>
                    </tr>
                    <tr class="driverparams">

                        <th>1</th>
                        <th>2</th>
                        <th>3</th>
                        <th>4</th>
                        <th>5</th>
                        <th>6</th>
                        <th>7</th>
                        <th>8</th>
                        <th>9</th>
                        <th>10</th>
                        <th>11</th>
                        <th>12</th>
                        <th>13</th>
                        <th>14</th>
                        <th>15</th>
                        <th>16</th>
                        <th>17</th>
                        <th>18</th>
                        <th>19</th>
                        <th>20</th>
                        <th>21</th>
                        <th>21</th>

                    </tr>

                    <c:forEach items="${drivers}" var="entry">
                        <tr>
                            <td>
                                <c:out value="${entry.key}"/>
                            </td>
                            <td align="center" style="padding: 25px">
                                <c:out value="${entry.value.value1}"/>
                            </td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center">
                                <c:out value="${entry.value.value2}"/>
                            </td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                            <td align="center" style="padding: 25px"></td>
                        </tr>

                    </c:forEach>
                </table>
            </div>
        </c:if>

        <!-- ПАРТНЕРЫ -->
        <c:if test="${not empty partners}">
            <hr>
            <h2>WS Partners Logs</h2>
            <hr>
            <div class="resulttable" id="partnersTable">
                <table id="table4Partners" border="1">

                    <tr>
                        <th rowspan="2">CALCID</th>
                        <th colspan="12">${calcid1}</th>
                        <th colspan="12">${calcid2}</th>
                    </tr>
                    <tr>
                        <th>v1</th>
                        <th>v2</th>
                        <th>v3</th>
                        <th>v4</th>
                        <th>v5</th>
                        <th>v6</th>
                        <th>v7</th>
                        <th>v8</th>
                        <th>v9</th>
                        <th>v10</th>
                        <th>v11</th>
                        <th>v12</th>
                        <th>b1</th>
                        <th>b2</th>
                        <th>b3</th>
                        <th>b4</th>
                        <th>b5</th>
                        <th>b6</th>
                        <th>b7</th>
                        <th>b8</th>
                        <th>b9</th>
                        <th>b10</th>
                        <th>b11</th>
                        <th>b12</th>

                    </tr>

                    <c:forEach items="${partners}" var="entry">
                        <tr>
                            <td>
                                <c:out value="${entry.key}"/>
                            </td>
                            <td align="center" style="padding: 25px">
                                <c:out value="${entry.value.value1}"/>
                            </td>
                            <td align="center"></td>

                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center">
                                <c:out value="${entry.value.value2}"/>
                            </td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>

                        </tr>

                    </c:forEach>
                </table>
            </div>
        </c:if>

        <!-- COMMONLOGS -->
        <c:if test="${not empty commonLogs}">
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
        </c:if>
    </div>


</div>


<!-- Modal -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
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