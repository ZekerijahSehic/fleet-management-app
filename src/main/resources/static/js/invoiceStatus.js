$('document').ready(function() {

   $('table #editButton').on('click', function (event) {
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (invoiceStatus) {
         $('#idEdit').val(invoiceStatus.id);
         $('#cityEdit').val(invoiceStatus.description);
         $('#addressEdit').val(invoiceStatus.details);
      });
      $('#editLocationModal').modal();
   });

   $('table #detailsButton').on('click', function (event){
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (invoiceStatus, status) {
         $('#idDetails').val(invoiceStatus.id);
         $('#cityDetails').val(invoiceStatus.description);
         $('#addressDetails').val(invoiceStatus.details);
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
