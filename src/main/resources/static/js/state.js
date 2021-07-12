$('document').ready(function() {

    $('.table #editButton').on('click',function(event){
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(state, status){
            $('#idEdit').val(state.id);
            $('#ddlCountryEdit').val(state.countryid);
            $('#capitalEdit').val(state.capital);
            $('#codeEdit').val(state.code);
            $('#nameEdit').val(state.name);
            $('#detailsEdit').val(state.details);
        });
        $('#editStateModal').modal();
    });

    $('.table #detailsButton').on('click',function(event) {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(state, status){
            $('#idDetails').val(state.id);
            $('#codeDetails').val(state.code);
            $('#capitalDetails').val(state.capital);
            $('#ddlCountryDetails').val(state.countryid);
            $('#nameDetails').val(state.name);
            $('#detailsDetails').val(state.details);
        });
        $('#detailsStateModal').modal();
    });

    $('.table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteStateModal #delRef').attr('href', href);
        $('#deleteStateModal').modal();
    });
});
