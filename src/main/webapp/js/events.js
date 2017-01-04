$(document).ready(function() {

  UrlTable.load();

  $("#home-anchor").on("click", function(e) {
    e.preventDefault();
    $("#table-container").addClass("hidden");
    $("#form-container").removeClass("hidden");
    $("#links-anchor").parents("li").removeClass("active");
    $("#home-anchor").parents("li").addClass("active");
  });

  $("#links-anchor").on("click", function(e) {
    e.preventDefault();
    $("#form-container").addClass("hidden");
    $("#table-container").removeClass("hidden");
    $("#home-anchor").parents("li").removeClass("active");
    $("#links-anchor").parents("li").addClass("active");
  });

  $("#customLinkCheckbox").change(function() {
    if ($(this).is(":checked")) {
      $("#customLinkInputDiv").removeClass("hidden");
    } else {
      $("#customLinkInputDiv").addClass("hidden");
      $("#inputCustomLink").val("");
    }
  });

  $("#form-submit-btn").on("click", function() {
    $("#url-form").validator();
    var valid = $("#url-form").data("valid");
    var redirectUrl = $("#inputRedirectLink").val();
    if (valid === true && redirectUrl) {
      var urlMappingRequest = {};
      urlMappingRequest["redirectUrl"] = redirectUrl;
      var customUrl = $("#inputCustomLink").val();
      if (customUrl) {
        urlMappingRequest["shortUrl"] = customUrl;
      }
      Controller.createUrlMapping(urlMappingRequest);
    }
  });

  $("#result-input").on("click", function() {
    $(this).select();
    document.execCommand("copy");
  });

  $("#url-form").on("valid.bs.validator", function() {
    $("#url-form").data("valid", true);
  });

  $("#url-form").on("invalid.bs.validator", function() {
    $("#url-form").data("valid", false);
  });

  $("#confirm-delete-modal").on("show.bs.modal", function(e) {
    var buttonElement = $(e.relatedTarget);
    $("#confirm-delete-btn").data("buttonElement", buttonElement);
  });

  $("#confirm-delete-btn").on("click", function() {
    var buttonElement = $(this).data("buttonElement");
    Controller.deleteUrlMapping(buttonElement);
  });

});