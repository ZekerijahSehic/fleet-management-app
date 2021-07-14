$('document').ready(function() {

   $('table #editButton').on('click', function (event) {
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (vehicleMake) {
         $('#idEdit').val(vehicleMake.id);
         $('#cityEdit').val(vehicleMake.description);
         $('#addressEdit').val(vehicleMake.details);
      });
      $('#editLocationModal').modal();
   });

   $('table #detailsButton').on('click', function (event){
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (vehicleMake, status) {
         $('#idDetails').val(vehicleMake.id);
         $('#cityDetails').val(vehicleMake.description);
         $('#addressDetails').val(vehicleMake.details);
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
