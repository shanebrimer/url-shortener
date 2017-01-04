var UrlTable = (function() {

  var table;

  var load = function() {
    ApiClient.getUrlMappings().done(function(data) {
      var tableTemplate = Handlebars.templates.urlMappingInfoTable(data);
      $("#url-table").append(tableTemplate);
      table = $("#url-table").DataTable();
    });
  };

  var addRow = function(urlMapping) {
    var row = [
      '<a href="http://localhost:8080/a/' + urlMapping.shortUrl + '">' + urlMapping.shortUrl + '</a>', 
      '<a href="' + urlMapping.redirectUrl + '">' + urlMapping.redirectUrl + '</a>', 
      '<button type="button" class="btn btn-danger" data-shorturl="' + urlMapping.shortUrl + '" data-toggle="modal" data-target="#confirm-delete-modal">' + 
        '<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete' + 
      '</button>'
    ];
    table.row.add(row).draw();
  };

  var deleteRow = function(rowElement) {
    table.row($(rowElement)).remove().draw();
  };

  return {
    load: load,
    addRow: addRow,
    deleteRow: deleteRow
  };

})();