var client = (function () {

  var getUrlMappings = function () {
    return $.get("/api/urlMappings");
  };

  var deleteUrlMapping = function (shortUrl) {
    return $.ajax({
      url: "/api/urlMappings/" + shortUrl,
      type: "DELETE"
    });
  };

  var print = function (str) {
    alert(str);
  };

  return {
    getUrlMappings: getUrlMappings,
    deleteUrlMapping: deleteUrlMapping,
    print: print
  };

})();

var urlTable = (function () {

  var table;

  var load = function () {
    client.getUrlMappings().done(function (data) {
      var tableTemplate = Handlebars.templates.urlMappingInfoTable(data);
      $("#url-table").append(tableTemplate);
      table = $("#url-table").DataTable();
    });
  };

  var deleteRow = function (rowElement) {
    var shortUrl = $(rowElement).data("shorturl");
    client.deleteUrlMapping(shortUrl).done(function () {
      // client.print(shortUrl + " was deleted...maybe");
    }).fail(function () {
      // client.print(shortUrl + " could not be deleted...probably");
    }).always(function () {
      table.row($(rowElement)).remove().draw();
    });
  };

  return {
    load: load,
    deleteRow: deleteRow
  };

})();

$(document).ready(function () {
  urlTable.load();
});


$(document).ready(function() {
  $("#confirm-delete-modal").on("show.bs.modal", function(e) {
    var rowElement = $(e.relatedTarget).parents("tr");
    $("#confirm-delete-btn").data("rowElement", rowElement);
  });
});

$(document).ready(function() {
  $("#confirm-delete-btn").on("click", function() {
    var rowElement = $(this).data("rowElement");
    urlTable.deleteRow(rowElement);
  });
});

