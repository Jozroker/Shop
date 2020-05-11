$(document).ready(function () {

    $('#name').on('keyup', function() {
        this.style.borderColor = '';
    });
    // $('#exampleInputPassword1').on('keyup', function() {
    //     let thisEmpty = false;
    //     let otherEmpty = $("#exampleInputEmail1").val().length === 0;
    //
    //     $('#exampleInputPassword1').each(function() {
    //         thisEmpty = $(this).val().length === 0;
    //
    //     });
    //
    //     if (thisEmpty || otherEmpty)
    //         $('#btn').attr('disabled', 'disabled');
    //     else
    //         $('#btn').attr('disabled', false);
    // });
    //
    // $('#exampleInputEmail1').blur(function () {
    //     if (!checkFields) {
    //         $('#btn').attr('disabled', 'disabled');
    //     }
    // });
    //
    // $('#exampleInputPassword1').blur(function () {
    //     if (!checkFields) {
    //         $('#btn').attr('disabled', 'disabled');
    //     }
    // });

    function checkFields() {
        let thisEmpty = $('#exampleInputEmail1').val().length !== 0;
        let otherEmpty = $('#exampleInputPassword1').val().length !== 0;
        return thisEmpty & otherEmpty;
    }
    // $("#exampleInputEmail2").on('input keyup', function () {
    //     if ($("#exampleInputEmail2").val() !== "") {
    //         if ($("#exampleInputEmail1").val() !== "") {
    //             $("#btn").removeAttr("disabled");
    //         }
    //     }
    // });

    $('#create').click(function () {
        if ($('#name').val() === '') {
            $('#name').change(function () {
                this.style.borderColor = 'red';
            }).trigger('change')
        }
        if ($('#description').val() === '') {
            $('#description').change(function () {
                this.style.borderColor = 'red';
            }).trigger('change')
        }
        if ($('#price').val() === '' || isNaN(parseFloat($('#price').val()))) {
            $('#price').change(function () {
                this.style.borderColor = 'red';
            }).trigger('change')
        }
        if ($('#name').val() !== '' && $('#description').val() !== '' && $('#price').val() !== '') {
            if (!isNaN(parseFloat($('#price').val()))) {
                $('#create_product').submit();
            }
        }
        return false;
    });
});
// function action() {
//     if ($('#name').val() === '') {
//         $('#name').change(function () {
//             this.style.borderColor = 'red';
//         }).trigger('change')
//     }
//     if ($('#description').val() === '') {
//         $('#description').change(function () {
//             this.style.borderColor = 'red';
//         }).trigger('change')
//     }
//     if ($('#price').val() === '' || isNaN(parseFloat($('#price').val()))) {
//         $('#price').change(function () {
//             this.style.borderColor = 'red';
//         }).trigger('change')
//     }
//     if ($('#name').val() !== '' && $('#description').val() !== '' && $('#price').val() !== '') {
//         if (!isNaN(parseFloat($('#price').val()))) {
//             $('#create_product').submit();
//         }
//     }
//     return false;
// }