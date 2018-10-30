// Основная функция раскраски/сравнения таблиц
function colorizeAll() {

    alternate3('thetable'); // раскрашиваем основную таблицу Ws Calc Logs

    if (document.getElementById("table4Coeff")) {
        alternate3('table4Coeff'); // раскрашиваем коэфициенты
    }

    if (document.getElementById("table4Bonuses")) {
        alternate3('table4Bonuses'); // Премии
    }
    if (document.getElementById("table4Drivers")) {
        alternate4('table4Drivers', 1, 12); //Водители. Красим
        parseJSONCells(); // Водители - парсим JSON - раскидываем по столбцам
    }

    if (document.getElementById("table4Partners")) {
        alternate4('table4Partners', 1, 13); //Партнеры
        parsePartnersJSONCells(); // Партнеры - парсим JSON - раскидываем по столбцам
    }

    if (document.getElementById("table4PCommonLogs")) {
        alternate3('table4PCommonLogs'); //Common Logs
    }

}

function alternate3(id) { //Основная функция сравнения и раскраски
    if (document.getElementsByTagName) {
        var table = document.getElementById(id); //переменная, ссылающаяся на таблицу
        var rows = table.getElementsByTagName("tr"); //, переменная, ссылающаяся на ряд
        for (i = 1; i < rows.length; i++) { // бегаем по рядам

            // if(i > 1){
            var cell1 = table.rows[i].cells[1]; //ячейка 1
            var cell2 = table.rows[i].cells[2]; //ячейка 2
            var string = cell1.innerHTML; // их содержимое....
            var string2 = cell2.innerHTML;


            if (string.localeCompare(string2) == 0) { //сравнили

                table.rows[i].style.background = "#669966"; // если равны, то красим зеленым
            } else {

                table.rows[i].style.background = "#FF9999"; //если нет - то красным
            }

        }
    }
}

function alternate4(id, cellind1, cellind2) { //функция раскраски для вертикальных таблиц типа Водители
    if (document.getElementsByTagName) {
        var table = document.getElementById(id);
        var rows = table.getElementsByTagName("tr");
        for (i = 2; i < rows.length; i++) {

            var cell1 = table.rows[i].cells[cellind1];
            var cell2 = table.rows[i].cells[cellind2];
            var string = cell1.innerHTML;
            var string2 = cell2.innerHTML;


            if (string.localeCompare(string2) == 0) {
                table.rows[i].style.background = "#669966";
            } else {
                table.rows[i].style.background = "#FF9999";
            }

        }
    }
}

// функция отображения окна копирования результата
function getHtml() {

    var $div = $('#fullRezult'); // обозначили все содеражимое, все таблички
    var y = $div.html(); // пихнули в переменную

    $("#myModal2").modal('show'); // отобразили окно
    $('#paste').val(y);

}

//Выделение и копирование в буфер
function copyToClipboard() {

    console.log('Trying to copy!');

    var copyTextarea = document.querySelector('.js-copytextarea');
    copyTextarea.focus();
    copyTextarea.select();

    try {
        var successful = document.execCommand('copy');
        var msg = successful ? 'successful' : 'unsuccessful';
        console.log('Copying text command was ' + msg);
    } catch (err) {
        console.log('Oops, unable to copy');
    }

    $("#myModal2").modal('hide');

//}


    /*function parseJson() {
      /*  if (document.getElementsByTagName) {


            $(e.currentTarget).find('td').each(function(i,e) {
                console.info($(e).text();
            });

            var table = document.getElementById('table4Drivers');
            var rows = table.getElementsByTagName("tr");
            for (i = 1; i < rows.length; i++) {



                // if(i > 1){
                var cell1 = table.rows[i].cells[1];
                var cell2 = table.rows[i].cells[2];
                var string = cell1.innerHTML;
                var string2 = cell2.innerHTML;

                // console.log(cell1.innerHTML);
                // console.log(cell2.innerHTML);


                if (string.localeCompare(string2) == 0) {

                    table.rows[i].style.background = "#669966";
                } else {

                    table.rows[i].style.background = "#FF9999";
                }

            } */
    // }
}

// Берем JSON из ячейки и раскидываем по ячейкам справа. Только для таблички Drivers (скорее всего под удаление)
function parseJSONCells() {

    $('#table4Drivers tr td').each(function () {

        var columnIndex = $(this).parent().children().index($(this));
        var rowIndex = $(this).parent().parent().children().index($(this).parent());


        var strJSON3 = getTableCellValue('table4Drivers', rowIndex, columnIndex);
        console.log('Value is is ' + strJSON3);
        if (testJSON(strJSON3)) {
            console.log('THIS - ' + columnIndex + " : " + strJSON3);
            var data = JSON.parse(strJSON3);
            console.log('PARSED - ' + data.KBMCOEFFDRIVEROSAGO);
            setRowPrice('table4Drivers', rowIndex, columnIndex, 1, data.KBMCOEFFDRIVEROSAGO);
            setTH('table4Drivers', 1, columnIndex, 0, 'KBMCOEFFDRIVEROSAGO'); //th
            setRowPrice('table4Drivers', rowIndex, columnIndex, 2, data.KBMCLASSDRIVEROSAGO);
            setTH('table4Drivers', 1, columnIndex, 1, 'KBMCLASSDRIVEROSAGO'); //th
            setRowPrice('table4Drivers', rowIndex, columnIndex, 3, data.STAGE);
            setTH('table4Drivers', 1, columnIndex, 2, 'STAGE'); //th
            setRowPrice('table4Drivers', rowIndex, columnIndex, 4, data.LICENCEDATE);
            setTH('table4Drivers', 1, columnIndex, 3, 'LICENCEDATE'); //th
            setRowPrice('table4Drivers', rowIndex, columnIndex, 5, data.KVS);
            setTH('table4Drivers', 1, columnIndex, 4, 'KVS'); //th
            setRowPrice('table4Drivers', rowIndex, columnIndex, 6, data.LICENCESERIA);
            setTH('table4Drivers', 1, columnIndex, 5, 'LICENCESERIA'); //th
            setRowPrice('table4Drivers', rowIndex, columnIndex, 7, data.LICENCENUMBER);
            setTH('table4Drivers', 1, columnIndex, 6, 'LICENCENUMBER'); //th
            setRowPrice('table4Drivers', rowIndex, columnIndex, 8, data.KBMCOEFFDRIVERCASCO);
            setTH('table4Drivers', 1, columnIndex, 7, 'KBMCOEFFDRIVERCASCO'); //th
            setRowPrice('table4Drivers', rowIndex, columnIndex, 9, data.KVSOSAGO);
            setTH('table4Drivers', 1, columnIndex, 8, 'KVSOSAGO'); //th
            setRowPrice('table4Drivers', rowIndex, columnIndex, 10, data.KBMIDREQUESTRSADRIVEROSAGO);
            setTH('table4Drivers', 1, columnIndex, 9, 'KBMIDREQUESTRSADRIVEROSAGO'); //th
            setRowPrice('table4Drivers', rowIndex, columnIndex, 0, data.RELATE_TO_RISK);
            setTH('table4Drivers', 1, columnIndex, -1, 'RELATE_TO_RISK'); //th


        }
    });

}

// возвращает значение ячейки по id таблицы, номеру столца и ряда
function getTableCellValue(tableId, rowIndex, columnIndex) {
    var cell = $('#' + tableId + ' tr').eq(rowIndex).find('td').eq(columnIndex)
    return cell.text();
}

// Функция проверяющая - это вообще Json или нет
function testJSON(text) {
    if (typeof text !== "string") {
        return false;
    }

    if (text.indexOf("{") <= 0) {
        return false;
    }

    try {
        JSON.parse(text);
        return true;
    }
    catch (error) {
        return false;
    }
}

// устанавливает заданное в параметрах значение ячейки (для копирования туда значения)
function setRowPrice(tableId, rowIndex, columnIndex, offset, newvalue) {
    columnIndex = columnIndex + offset;
    $('#' + tableId + ' tr').eq(rowIndex).find('td').eq(columnIndex).html(newvalue);
};

// меняет заголовок. Имя ключа JSON надо пихнуть в заголовок
function setTH(tableId, rowIndex, columnIndex, offset, newvalue) {
    columnIndex = columnIndex + offset;
    var thv = $('#' + tableId + ' tr').eq(rowIndex).find('th').eq(columnIndex).text();
    console.log('TH Value is - ' + thv);
    $('#' + tableId + ' tr').eq(rowIndex).find('th').eq(columnIndex).html('<span>' + newvalue + '</span>');
};

/* Парсим JSON для партнеров и копируем в соседние ячейки.
-------------------------------------------------------------

Суть там такая, кто не понял. Надо как-то передать вертикальную структуру таблицы, не ломая сложившуюся систему интерфейсов на сервере. Решил, что группу
 полей на сервере проще пихнуть как одно значение, сформировав из него JSON. А что тогда будет ключом? В табличке Drivers нет вообще id. То есть 10 значений,
 грубо говоря, имеют 10 одинаковых calc id. Мапа не поддерживает одинаковые ключи (они перезаписываются). Что делать? Вводить в табличку поле? Я решил, что я не админ,
 чтобы лезть в табличку.  При этом группу полей, представляющих водителя с добавлением некого ручного итератор можно выразить как ключ. Что-то типа i-name-birthday-somefield
 , которое потом тоже при желании можно распарсить. То есть это ключ. А в значение... одно единственное.... чтобы делать сравнение с другим таким же значением по другому calc id,
 ... мы формируем в JSON'е из группы других полей. А здесь - на клиенте мы это распарсиваем и распихиваем по полям.

 -------------------------------------------------------------

 */
function parsePartnersJSONCells() {

    $('#table4Partners tr td').each(function () { //бегаем по табличке

        var columnIndex = $(this).parent().children().index($(this)); //берем индекс столбца
        var rowIndex = $(this).parent().parent().children().index($(this).parent()); // берем индекс строки
        var strJSON3 = getTableCellValue('table4Partners', rowIndex, columnIndex);

        if (testJSON(strJSON3)) { // ... Если это JSON

            var data = JSON.parse(strJSON3); // парсим его...

            setRowPrice('table4Partners', rowIndex, columnIndex, 1, data.DOCISSUEDATE); // устанавливаем значение ячейки в следующем столбце
            setTH('table4Partners', 1, columnIndex, 0, 'DOCISSUEDATE'); //и ставим ему заголовок
            setRowPrice('table4Partners', rowIndex, columnIndex, 2, data.DOCSERIA); // ......... ну и так далее.............
              setTH('table4Partners', 1, columnIndex, 1, 'DOCSERIA'); //th
            setRowPrice('table4Partners', rowIndex, columnIndex, 3, data.VIPCLIENT);
              setTH('table4Partners', 1, columnIndex, 2, 'VIPCLIENT'); //th
            setRowPrice('table4Partners', rowIndex, columnIndex, 4, data.ADDRKLADR);
              setTH('table4Partners', 1, columnIndex, 3, 'ADDRKLADR'); //th
            setRowPrice('table4Partners', rowIndex, columnIndex, 5, data.DOCNUMBER);
            setTH('table4Partners', 1, columnIndex, 4, 'DOCNUMBER'); //th
            setRowPrice('table4Partners', rowIndex, columnIndex, 6, data.ID);
               setTH('table4Partners', 1, columnIndex, 5, 'ID'); //th
            setRowPrice('table4Partners', rowIndex, columnIndex, 7, data.BIRTHDATE);
               setTH('table4Partners', 1, columnIndex, 6, 'BIRTHDATE'); //th
            setRowPrice('table4Partners', rowIndex, columnIndex, 8, data.LICENCESERIA);
               setTH('table4Partners', 1, columnIndex, 7, 'LICENCESERIA'); //th
            setRowPrice('table4Partners', rowIndex, columnIndex, 9, data.ISRESIDENT);
              setTH('table4Partners', 1, columnIndex, 8, 'ISRESIDENT'); //th
            setRowPrice('table4Partners', rowIndex, columnIndex, 10, data.DOCTYPE);
               setTH('table4Partners', 1, columnIndex, 9, 'DOCTYPE'); //th
            setRowPrice('table4Partners', rowIndex, columnIndex, 11, data.TYPE);
               setTH('table4Partners', 1, columnIndex, 10, 'TYPE'); //th
            setRowPrice('table4Partners', rowIndex, columnIndex, 0, data.NAME);
              setTH('table4Partners', 1, columnIndex, -1, 'NAME'); //th


        }
    });

}






