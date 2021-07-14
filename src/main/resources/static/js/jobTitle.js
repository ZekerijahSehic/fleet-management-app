$('document').ready(function() {

   $('table #editButton').on('click', function (event) {
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (jobTitle) {
         $('#idEdit').val(jobTitle.id);
         $('#cityEdit').val(jobTitle.description);
         $('#addressEdit').val(jobTitle.details);
      });
      $('#editLocationModal').modal();
   });

   $('table #detailsButton').on('click', function (event){
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (jobTitle, status) {
         $('#idDetails').val(jobTitle.id);
         $('#cityDetails').val(jobTitle.description);
         $('#addressDetails').val(jobTitle.details);
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
