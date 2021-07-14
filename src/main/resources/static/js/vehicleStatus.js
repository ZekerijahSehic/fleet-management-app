$('document').ready(function() {

   $('table #editButton').on('click', function (event) {
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (vehicleStatus) {
         $('#idEdit').val(vehicleStatus.id);
         $('#cityEdit').val(vehicleStatus.description);
         $('#addressEdit').val(vehicleStatus.details);
      });
      $('#editLocationModal').modal();
   });

   $('table #detailsButton').on('click', function (event){
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (vehicleStatus, status) {
         $('#idDetails').val(vehicleStatus.id);
         $('#cityDetails').val(vehicleStatus.description);
         $('#addressDetails').val(vehicleStatus.details);
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
