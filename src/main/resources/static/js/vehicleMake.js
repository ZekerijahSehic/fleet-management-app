$('document').ready(function() {

   $('table #editButton').on('click', function (event) {
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (vehicleMake) {
         $('#idEdit').val(vehicleMake.id);
         $('#cityEdit').val(vehicleMake.description);
         $('#addressEdit').val(vehicleMake.details);
      });
      $('#editVehicleMakeModal').modal();
   });

   $('table #detailsButton').on('click', function (event){
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (vehicleMake, status) {
         $('#idDetails').val(vehicleMake.id);
         $('#descriptionDetails').val(vehicleMake.description);
         $('#detailsDetails').val(vehicleMake.details);
      });
      $('#detailsVehicleMakeModal').modal();
   });

   $('.table #deleteButton').on('click',function(event) {
      event.preventDefault();
      var href = $(this).attr('href');
      $('#deleteVehicleMakeModal #delRef').attr('href', href);
      $('#deleteVehicleMakeModal').modal();
   });
});
