
var bookedSeats = new Array;

function  Asientos(asientoOcupados) {
    bookedSeats = asientoOcupados;
    document.getElementById("frmAsientos:select").value = null;
    $(function () {
        var settings = {
            rows: 4,
            cols: 10,
            rowCssPrefix: 'row-',
            colCssPrefix: 'col-',
            seatWidth: 65,
            seatHeight: 50,
            seatCss: 'seat',
            selectedSeatCss: 'selectedSeat',
            selectingSeatCss: 'selectingSeat'
        };

        var init = function (reservedSeat) {
            var str = [], seatNo, className;
            for (i = 0; i < settings.rows; i++) {
                for (j = 0; j < settings.cols; j++) {

                    if (i == 2 && j == 0) {
                        settings.seatWidth = 65;
                        settings.seatHeight = 70;
                    }

                    if (i == 3 && j == 0) {
                        settings.seatWidth = 65;
                        settings.seatHeight = 63;

                    }
                    seatNo = (i + j * settings.rows + 1);

                    className = settings.seatCss + ' ' + settings.rowCssPrefix + i.toString() + '' + settings.colCssPrefix + j.toString() + '';

                    if ($.isArray(reservedSeat) && $.inArray(seatNo, reservedSeat) != -1) {
                        className += ' ' + settings.selectedSeatCss;
                    }

                    str.push('<li class="' + className + '"' +
                            'style="top:' + (i * settings.seatHeight).toString() + 'px;left:' + (j * settings.seatWidth).toString() + 'px">' +
                            '<a title="' + seatNo + '">' + seatNo + '</a>' +
                            '</li>');

                }
            }
            $('#place').html(str.join(''));


        };
        var asiento = new Array();
        init(bookedSeats);

        $('.' + settings.seatCss).click(function () {
            var str = [], item;
            document.getElementById("frmAsientos:select").value = null;
            if ($(this).hasClass(settings.selectedSeatCss)) {

                alert('ASIENTO YA RESERVADO');
            }
            else {
                $(this).toggleClass(settings.selectingSeatCss);
                $.each($('#place li.' + settings.selectingSeatCss + ' a'), function (index, value) {
                    item = $(this).attr('title');
                    str.push(item);
                    asiento = str;
                    document.getElementById("frmAsientos:select").value = asiento;

                });
            }
        });


        $('#btnShow').click(function () {
            var str = [];
            $.each($('#place li.' + settings.selectedSeatCss + ' a, #place li.' + settings.selectingSeatCss + ' a'), function (index, value) {
                str.push($(this).attr('title'));
            });
            alert(str.join(','));
        });

    });

}
