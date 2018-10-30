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
    alternate3('table4Coeff');
    alternate3('table4Bonuses');
    alternate3('table4Drivers');
    alternate3('table4Partners');
    alternate3('table4PCommonLogs');


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

}