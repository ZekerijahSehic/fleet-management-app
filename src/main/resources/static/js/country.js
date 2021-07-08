$(document).ready(function (){
   $('#editButton').on('click', function (event){
       event.preventDefault();
       $('#editCountryModal').modal();
   });
});