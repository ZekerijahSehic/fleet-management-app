$('document').ready(function() {

   $('table #editButton').on('click', function (event) {
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (employeeType) {
         $('#idEdit').val(employeeType.id);
         $('#cityEdit').val(employeeType.description);
         $('#addressEdit').val(employeeType.details);
      });
      $('#editLocationModal').modal();
   });

   $('table #detailsButton').on('click', function (event){
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (employeeType, status) {
         $('#idDetails').val(employeeType.id);
         $('#cityDetails').val(employeeType.description);
         $('#addressDetails').val(employeeType.details);
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
