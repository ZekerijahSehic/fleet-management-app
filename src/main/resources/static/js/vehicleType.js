$('document').ready(function() {

   $('table #editButton').on('click', function (event) {
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (vehicleStatus) {
         $('#idEdit').val(vehicleStatus.id);
         $('#cityEdit').val(vehicleStatus.description);
         $('#addressEdit').val(vehicleStatus.details);
      });
      $('#editVehicleTypeModal').modal();
   });

   $('table #detailsButton').on('click', function (event){
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (vehicleStatus, status) {
         $('#idDetails').val(vehicleStatus.id);
         $('#descriptionDetails').val(vehicleStatus.description);
         $('#detailsDetails').val(vehicleStatus.details);
      });
      $('#detailsVehicleTypeModal').modal();
   });

   $('.table #deleteButton').on('click',function(event) {
      event.preventDefault();
      var href = $(this).attr('href');
      $('#deleteVehicleTypeModal #delRef').attr('href', href);
      $('#deleteVehicleTypeModal').modal();
   });
});
