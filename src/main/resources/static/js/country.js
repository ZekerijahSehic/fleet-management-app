$('document').ready(function() {

   $('table #editButton').on('click', function (event) {
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (country) {
         $('#idEdit').val(country.id);
         $('#descriptionEdit').val(country.description);
         $('#capitalEdit').val(country.capital);
         $('#codeEdit').val(country.code);
         $('#continentEdit').val(country.continent);
         $('#nationalityEdit').val(country.nationality);
      });
      $('#editCountryModal').modal();
   });

   $('table #detailsButton').on('click', function (event){
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (country, status) {
         $('#idDetails').val(country.id);
         $('#codeDetails').val(country.code);
         $('#capitalDetails').val(country.capital);
         $('#nationalityDetails').val(country.nationality);
         $('#continentDetails').val(country.continent);
         $('#descriptionDetails').val(country.description);
      });
      $('#detailsCountryModal').modal();
   });

   $('.table #deleteButton').on('click',function(event) {
      event.preventDefault();
      var href = $(this).attr('href');
      $('#deleteCountryModal #delRef').attr('href', href);
      $('#deleteCountryModal').modal();
   });
});
