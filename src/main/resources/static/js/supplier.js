$('document').ready(function() {

   $('table #editButton').on('click', function (event) {
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (supplier, status) {
         $('#idEdit').val(supplier.id);
         $('#nameEdit').val(supplier.name);
         $('#detailsEdit').val(supplier.details);
         $('#websiteEdit').val(supplier.website);
         $('#addressEdit').val(supplier.address);
         $('#cityEdit').val(supplier.city);
         $('#phoneEdit').val(supplier.phone);
      });
      $('#editSupplierModal').modal();
   });

   $('table #detailsButton').on('click', function (event){
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (supplier, status) {
         $('#idDetails').val(supplier.id);
         $('#nameDetails').val(supplier.name);
         $('#detailsDetails').val(supplier.details);
         $('#websiteDetails').val(supplier.website);
         $('#addressDetails').val(supplier.address);
         $('#cityDetails').val(supplier.city);
         $('#phoneDetails').val(supplier.phone);
      });
      $('#detailsSupplierModal').modal();
   });

   $('.table #deleteButton').on('click',function(event) {
      event.preventDefault();
      var href = $(this).attr('href');
      $('#deleteClientModal #delRef').attr('href', href);
      $('#deleteClientModal').modal();
   });
});
