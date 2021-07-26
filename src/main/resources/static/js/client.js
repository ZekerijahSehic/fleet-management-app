$('document').ready(function() {

   $('table #editButton').on('click', function (event) {
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (client, status) {
         $('#idEdit').val(client.id);
         $('#nameEdit').val(client.name);
         $('#detailsEdit').val(client.details);
         $('#websiteEdit').val(client.website);
         $('#addressEdit').val(client.address);
         $('#nationalityEdit').val(client.nationality);
         $('#ddlStateEdit').val(client.stateid);
         $('#ddlCountryEdit').val(client.countryid);
         $('#cityEdit').val(client.city);
         $('#phoneEdit').val(client.phone);
         $('#mobileEdit').val(client.mobile);
         $('#emailEdit').val(client.email);
      });
      $('#editClientModal').modal();
   });

   $('table #detailsButton').on('click', function (event){
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (client, status) {
         $('#idDetails').val(client.id);
         $('#nameDetails').val(client.name);
         $('#detailsDetails').val(client.details);
         $('#websiteDetails').val(client.website);
         $('#addressDetails').val(client.address);
         $('#nationalityDetails').val(client.nationality);
         $('#ddlStateDetails').val(client.stateid);
         $('#ddlCountryDetails').val(client.countryid);
         $('#cityDetails').val(client.city);
         $('#phoneDetails').val(client.phone);
         $('#mobileDetails').val(client.mobile);
         $('#emailDetails').val(client.email);
      });
      $('#detailsClientModal').modal();
   });

   $('.table #deleteButton').on('click',function(event) {
      event.preventDefault();
      var href = $(this).attr('href');
      $('#deleteClientModal #delRef').attr('href', href);
      $('#deleteClientModal').modal();
   });
});
