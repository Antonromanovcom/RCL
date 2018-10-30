<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->

    <spring:url value="/resources/js/yes.png" var="yesimg" />
    <spring:url value="/resources/js/no.png" var="noimg" />
    <spring:url value="/resources/js/main.css" var="mainCss" />
    <spring:url value="/resources/js/mainjs.js" var="mainjs" />
    <spring:url value="/resources/js/reso.ico" var="ico" />

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="shortcut icon" href="${ico}" type="image/x-icon" />



    <link href="${mainCss}" rel="stylesheet" />
    <script src="${mainjs}"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


</head>
<body onload="alternate2('thetable')">


<div class="container">
        <h1> R E S U L T </h1>
</div>

<div class="result">
        <h3>Calc ID #1: ${calcid1}</h3>
    <h3>Calc ID  #2: ${calcid2}</h3>

<hr>

    <table id="thetable">
        <!-- here should go some titles...-->
        <tr>
            <th>NAME</th>
            <th>CHECK</th>
        </tr>


    <c:forEach items="${map}" var="entry">
        <tr>
            <td>


                <c:set var="keyy" scope="session" value="${entry.key}"/>


                <a href="#"  onclick="linkFunction('${entry.key}');" class="bt lnk-inform">
                    <c:out value="${entry.key}"/>
                </a>

            </td>
            <td align="center">
                <c:set var="alter" scope="session" value="${entry.value}"/>

                <c:if test="${alter == 1}">
                    <img src="${yesimg}" width="35px" height="35px"/>
                </c:if>
                <c:if test="${alter == 0}">
                    <img src="${noimg}" width="35px" height="35px"/>
                </c:if>

            </td>
        </tr>

    </c:forEach>
    </table>


</div>




<!-- Скрипт, привязывающий событие click, открывающее модальное окно, к элементам, имеющим класс .btn -->
<script>
    $(document).ready(function(){
        //при нажатию на любую кнопку, имеющую класс .btn
        $(".btn").click(function() {


            if(document.getElementsByTagName) {
                var table = document.getElementById('thetable');
                var rows = table.getElementsByTagName("tr");
                var cells = table.rows[1].cells[0];
                var dataForServerFromClientPageByClick = cells.innerHTML;
                var clikedOptionWitoutNSymbols = dataForServerFromClientPageByClick.replace(/\r|\n/g, '');
                found = clikedOptionWitoutNSymbols.match(/<a.*?>(.*?)<\/a>/);


                console.log(cells.innerHTML);
                console.log(found[1]);




                var dataForServer = { id: found[1]};

                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/medchat-1.0-SNAPSHOT/greeting",
                    data: dataForServer,
                    dataType: 'json',
                    success: function(data) {
                        console.log(data);

                        //$("#paste").val(data);

                        $.each(data, function(index, element) {


                            $('#paste').val($('#paste').val()+ index + ' - ' + element+'\n');

                        });



                    }
                });
            }


            //открыть модальное окно с id="myModal"

            $("#myModal").modal('show');
        });



    });



</script>



<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Подробная информация о сверке по полю</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="results" id="resultss">
                    <textarea id="paste" style="width: 100%"></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>


</body>

</html>