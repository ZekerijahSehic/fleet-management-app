$('document').ready(function() {

   $('table #editButton').on('click', function (event) {
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (location) {
         $('#idEdit').val(location.id);
         $('#cityEdit').val(location.city);
         $('#addressEdit').val(location.address);
         $('#ddlCountryEdit').val(location.countryid);
         $('#ddlStateEdit').val(location.stateid);
      });
      $('#editLocationModal').modal();
   });

   $('table #detailsButton').on('click', function (event){
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (location, status) {
         $('#idDetails').val(location.id);
         $('#cityDetails').val(location.city);
         $('#addressDetails').val(location.address);
         $('#ddlCountryDetails').val(location.countryid);
         $('#ddlStateDetails').val(location.stateid);
      });
      $('#detailsLocationModal').modal();
   });

   $('.table #deleteButton').on('click',function(event) {
      event.preventDefault();
      var href = $(this).attr('href');
      $('#deleteLocationModal #delRef').attr('href', href);
      $('#deleteLocationModal').modal();
   });
});
