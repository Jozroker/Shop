$(document).ready(function () {

    $('#create').click(function () {
        if ($('#name').val() === '') {
            $('#name').change(function () {
                this.style.borderColor = 'red';
            }).trigger('change')
        } else {
            $('#name').change(function () {
                this.style.borderColor = '';
            }).trigger('change')
        }
        if ($('#description').val() === '') {
            $('#description').change(function () {
                this.style.borderColor = 'red';
            }).trigger('change')
        } else {
            $('#description').change(function () {
                this.style.borderColor = '';
            }).trigger('change')
        }
        if ($('#price').val() === '' || isNaN(parseFloat($('#price').val()))) {
            $('#price').change(function () {
                this.style.borderColor = 'red';
            }).trigger('change')
        } else {
            $('#price').change(function () {
                this.style.borderColor = '';
            }).trigger('change')
        }
        if ($('#count').val() === '' || isNaN(parseInt($('#count').val()))) {
            $('#count').change(function () {
                this.style.borderColor = 'red';
            }).trigger('change')
        } else {
            $('#count').change(function () {
                this.style.borderColor = '';
            }).trigger('change')
        }
        if ($('#name').val() !== '' && $('#description').val() !== '' && $('#price').val() !== '' && $('#count').val() !== '') {
            if (!isNaN(parseFloat($('#price').val())) && !isNaN(parseInt($('#count').val()))) {
                $('#create_product').submit();
            }
        }
        $('#create').blur();
        return false;
    });
});
