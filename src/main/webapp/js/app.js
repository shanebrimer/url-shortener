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

$(document).ready(function () {
  client.getUrlMappings().done(function (data) {
    var context = {
      urlMappings: data
    };
    console.log(JSON.stringify(context));
    var templateScript = Handlebars.templates.urlMappingInfoTable(context);
    $("#table-container").append(templateScript);
  });
});

$(document).ready(function() {
  $("#table-container").on("click", "button", function() {
    var shortUrl = $(this).data("shorturl");
    client.deleteUrlMapping(shortUrl).done(function () {
      client.print(shortUrl + " was deleted");
    }).fail(function () {
      client.print(shortUrl + " could not be deleted");
    });

    $(this).parent().parent().remove();
  });
});

