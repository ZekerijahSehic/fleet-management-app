$('document').ready(function() {

   $('table #editButton').on('click', function (event) {
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (contact, status) {
         $('#idEdit').val(contact.id);
         $('#firstnameEdit').val(contact.firstname);
         $('#lastnameEdit').val(contact.lastname);
         $('#emailEdit').val(contact.email);
         $('#mobileEdit').val(contact.mobile);
         $('#phoneEdit').val(contact.phone);
         $('#remarksEdit').val(contact.remarks);
      });
      $('#editContactModal').modal();
   });

   $('table #detailsButton').on('click', function (event){
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (contact, status) {
         $('#idDetails').val(contact.id);
         $('#firstnameDetails').val(contact.firstname);
         $('#lastnameDetails').val(contact.lastname);
         $('#emailDetails').val(contact.email);
         $('#mobileDetails').val(contact.mobile);
         $('#phoneDetails').val(contact.phone);
         $('#remarksDetails').val(contact.remarks);
      });
      $('#detailsContactModal').modal();
   });

   $('.table #deleteButton').on('click',function(event) {
      event.preventDefault();
      var href = $(this).attr('href');
      $('#deleteContactModal #delRef').attr('href', href);
      $('#deleteContactModal').modal();
   });
});
