var ApiClient = (function () {

  var _url = "/api/urlMappings";

  var getUrlMappings = function() {
    return $.get(_url);
  };

  var addUrlMapping = function(urlMappingRequest) {
    return $.ajax({
      headers: {
        "Accept": "application/json",
        "Content-Type": "application/json" 
      },
      "type": "POST",
      "url": _url,
      "data": JSON.stringify(urlMappingRequest),
      "dataType": "json"
    });
  };

  var deleteUrlMapping = function(shortUrl) {
    return $.ajax({
      url: _url + '/' + shortUrl,
      type: "DELETE"
    });
  };

  return {
    getUrlMappings: getUrlMappings,
    addUrlMapping: addUrlMapping,
    deleteUrlMapping: deleteUrlMapping
  };

})();