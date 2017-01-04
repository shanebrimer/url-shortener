var Controller = (function() {

  var createUrlMapping = function(urlMappingRequest) {
    ApiClient.addUrlMapping(urlMappingRequest).done(function(urlMapping) {
      $("#error-alert").addClass("hidden");
      UrlTable.addRow(urlMapping);
      $("#result-input").val("http://localhost:8080/a/" + urlMapping.shortUrl);
      $("#result-div").removeClass("hidden");
    }).fail(function() {
      $("#error-alert").removeClass("hidden");
    });
  };

  var deleteUrlMapping = function(buttonElement) {
    var shortUrl = $(buttonElement).data("shorturl");
    var rowElement = $(buttonElement).parents("tr");
    ApiClient.deleteUrlMapping(shortUrl).always(function() {
      UrlTable.deleteRow(rowElement);
    });
  };

  return {
    createUrlMapping: createUrlMapping,
    deleteUrlMapping: deleteUrlMapping
  };

})();