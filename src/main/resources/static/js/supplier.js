$('document').ready(function() {

   $('table #editButton').on('click', function (event) {
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (supplier, status) {
         $('#addressEdit').val(supplier.address);
         $('#cityEdit').val(supplier.city);
         $('#ddlCountryEdit').val(supplier.countryid);
         $('#detailsEdit').val(supplier.details);
         $('#emailEdit').val(supplier.email);
         $('#idEdit').val(supplier.id);
         $('#mobileEdit').val(supplier.mobile);
         $('#nameEdit').val(supplier.name);
         $('#phoneEdit').val(supplier.phone);
         $('#ddlStateEdit').val(supplier.stateid);
         $('#websiteEdit').val(supplier.website);
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
         $('#nationalityDetails').val(supplier.nationality);
         $('#ddlStateDetails').val(supplier.stateid);
         $('#ddlCountryDetails').val(supplier.countryid);
         $('#cityDetails').val(supplier.city);
         $('#phoneDetails').val(supplier.phone);
         $('#mobileDetails').val(supplier.mobile);
         $('#emailDetails').val(supplier.email);
      });
      $('#detailsSupplierModal').modal();
   });

   $('.table #deleteButton').on('click',function(event) {
      event.preventDefault();
      var href = $(this).attr('href');
      $('#deleteSupplierModal #delRef').attr('href', href);
      $('#deleteSupplierModal').modal();
   });
});
