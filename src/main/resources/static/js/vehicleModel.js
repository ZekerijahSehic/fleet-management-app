$('document').ready(function() {

   $('table #editButton').on('click', function (event) {
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (vehicleStatus) {
         $('#idEdit').val(vehicleStatus.id);
         $('#descriptionEdit').val(vehicleStatus.description);
         $('#detailsEdit').val(vehicleStatus.details);
      });
      $('#editVehicleModelModal').modal();
   });

   $('table #detailsButton').on('click', function (event){
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (vehicleStatus, status) {
         $('#idDetails').val(vehicleStatus.id);
         $('#descriptionDetails').val(vehicleStatus.description);
         $('#detailsDetails').val(vehicleStatus.details);
      });
      $('#detailsVehicleModelModal').modal();
   });

   $('.table #deleteButton').on('click',function(event) {
      event.preventDefault();
      var href = $(this).attr('href');
      $('#deleteVehicleModelModal #delRef').attr('href', href);
      $('#deleteVehicleModelModal').modal();
   });
});
