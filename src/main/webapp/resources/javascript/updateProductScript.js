$(document).ready(function () {

    $('#update').click(function () {
        if ($('#id').val() === '' || parseInt($('#id').val()) <= 0) {
            $('#id').change(function () {
                this.style.borderColor = 'red';
            }).trigger('change')
        } else {
            $('#id').change(function () {
                this.style.borderColor = '';
            }).trigger('change')
        }
        if ($('#id').val() !== '') {
            if (!isNaN(parseInt($('#id').val()))) {
                $('#update_product').submit();
            }
        }
        $('#update').blur();
        return false;
    });
});
