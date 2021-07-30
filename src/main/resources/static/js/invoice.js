$('document').ready(function() {

   $('table #editButton').on('click', function (event) {
      event.preventDefault();

      var href = $(this).attr('href');

      $.get(href, function (invoice) {
         $('#idEdit').val(invoice.id);
         $('#ddlClientEdit').val(invoice.clientid);

         var invoiceDate = invoice.invoiceDate.substr(0,10);
         $('#invoiceDateEdit').val(invoiceDate);

         $('#ddlInvoiceStatusEdit').val(invoice.invoicestatusid);
         $('#remarksEdit').val(invoice.remarks);
      });
      $('#editInvoiceModal').modal();
   });


});
