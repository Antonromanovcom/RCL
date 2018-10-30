function linkFunction(key) {

    console.log(key);
    document.getElementById('paste').value = "";

    if (document.getElementsByTagName) {

        var dataForServer = {id: key};

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/medchat-1.0-SNAPSHOT/greeting",
            data: dataForServer,
            dataType: 'json',
            success: function (data) {
                console.log(data);

                //$("#paste").val(data);

                $.each(data, function (index, element) {


                    $('#paste').val($('#paste').val() + index + ' - ' + element + '\n');

                });


            }
        });
    }


    //открыть модальное окно с id="myModal"

    $("#myModal").modal('show');


}

function alternate2(id) {
    if (document.getElementsByTagName) {
        var table = document.getElementById(id);
        var rows = table.getElementsByTagName("tr");
        for (i = 0; i < rows.length; i++) {

            // if(i > 1){
            var cells = table.rows[i].cells[1];
            console.log(cells.innerHTML);

            var string = cells.innerHTML;
            var searchNo = "no.png";
            var searchYes = "yes.png";


            if (string.includes(searchNo)) {
                table.rows[i].style.background = "#FF9999";

            }
            if (string.includes(searchYes)) {
                table.rows[i].style.background = "#669966";

            }
            //   }

        }
    }
}

function colorizeAll() {

    alternate3('thetable');

    if (document.getElementById("table4Coeff")) {
        alternate3('table4Coeff');
    }

    if (document.getElementById("table4Bonuses")) {
        alternate3('table4Bonuses');
    }
    if (document.getElementById("table4Drivers")) {
        alternate4('table4Drivers', 1, 12);
        parseJSONCells();
    }

    if (document.getElementById("table4Partners")) {
        alternate4('table4Partners', 1, 13);
        parsePartnersJSONCells();
    }

    if (document.getElementById("table4PCommonLogs")) {
        alternate3('table4PCommonLogs');
    }

}

function alternate3(id) {
    if (document.getElementsByTagName) {
        var table = document.getElementById(id);
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

        }
    }
}

function alternate4(id, cellind1, cellind2) {
    if (document.getElementsByTagName) {
        var table = document.getElementById(id);
        var rows = table.getElementsByTagName("tr");
        for (i = 2; i < rows.length; i++) {

            // if(i > 1){
            var cell1 = table.rows[i].cells[cellind1];
            var cell2 = table.rows[i].cells[cellind2];
            var string = cell1.innerHTML;
            var string2 = cell2.innerHTML;

            console.log(cell1.innerHTML);
            console.log(cell2.innerHTML);

            if (string.localeCompare(string2) == 0) {

                table.rows[i].style.background = "#669966";
            } else {

                table.rows[i].style.background = "#FF9999";
            }

        }
    }
}

function getHtml() {

    console.log('ITS WORK!');

    //var $div = $('#allresulttable');
    var $div = $('#fullRezult');

    var y = $div.html();


    $("#myModal2").modal('show');
    $('#paste').val(y);

}

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

function parseJSONCells() {

    // console.log('Мы в ПарсДжсон');

    $('#table4Drivers tr td').each(function () {
        //    console.log('Мы в ич');
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

function getTableCellValue(tableId, rowIndex, columnIndex) {
    var cell = $('#' + tableId + ' tr').eq(rowIndex).find('td').eq(columnIndex)
    return cell.text();
}

function testJSON(text) {
    if (typeof text !== "string") {
        return false;
    }
    /*if (text.charAt(0) !== '{') {
        return false;
    }*/

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

function setRowPrice(tableId, rowIndex, columnIndex, offset, newvalue) {
    columnIndex = columnIndex + offset;
    $('#' + tableId + ' tr').eq(rowIndex).find('td').eq(columnIndex).html(newvalue);
};

function setTH(tableId, rowIndex, columnIndex, offset, newvalue) {
    columnIndex = columnIndex + offset;
    var thv = $('#' + tableId + ' tr').eq(rowIndex).find('th').eq(columnIndex).text();
    console.log('TH Value is - ' + thv);
    $('#' + tableId + ' tr').eq(rowIndex).find('th').eq(columnIndex).html('<span>' + newvalue + '</span>');
};

function parsePartnersJSONCells() {

    console.log('Мы в ПарсДжсон для ПАРТНЕРОВ');

    $('#table4Partners tr td').each(function () {
        console.log('Мы в ич');
        var columnIndex = $(this).parent().children().index($(this));
        var rowIndex = $(this).parent().parent().children().index($(this).parent());


        var strJSON3 = getTableCellValue('table4Partners', rowIndex, columnIndex);
        console.log('Value is ' + strJSON3);
        if (testJSON(strJSON3)) {
            console.log('THIS - ' + columnIndex + " : " + strJSON3);
            var data = JSON.parse(strJSON3);

            setRowPrice('table4Partners', rowIndex, columnIndex, 1, data.DOCISSUEDATE);
            setTH('table4Partners', 1, columnIndex, 0, 'DOCISSUEDATE'); //th
            setRowPrice('table4Partners', rowIndex, columnIndex, 2, data.DOCSERIA);
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

function getOnlyDifferences() {

    console.log('Get Only Differences');
    alert('Get Only Differences');

     //   $(this).parents('tr').remove();
    findRow4Delete('thetable');


}

function deleteRow(table, row) {
    document.getElementById(table).deleteRow(row);
}

function findRow4Delete(table) {

    var table = document.getElementById(table);
    var rows = table.getElementsByTagName("tr");
    for (i = 1; i < rows.length; i++) {

        /*if (table.rows[i].style.background = "#FF9999"){

*/
            var cell1 = table.rows[i].cells[1];
            var cell2 = table.rows[i].cells[2];
            var string = cell1.innerHTML;
            var string2 = cell2.innerHTML;


        if (string.localeCompare(string2) == 0) {

            table.deleteRow(i);

        } else {

            console.log(cell1.innerHTML);
            console.log(cell2.innerHTML);


        }



    }

}



