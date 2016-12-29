(function() {
  var template = Handlebars.template, templates = Handlebars.templates = Handlebars.templates || {};
templates['urlMappingInfoTable'] = template({"1":function(container,depth0,helpers,partials,data) {
    var helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "    <tr id=\"row-"
    + alias4(((helper = (helper = helpers.shortUrl || (depth0 != null ? depth0.shortUrl : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"shortUrl","hash":{},"data":data}) : helper)))
    + "\" data-shorturl=\""
    + alias4(((helper = (helper = helpers.shortUrl || (depth0 != null ? depth0.shortUrl : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"shortUrl","hash":{},"data":data}) : helper)))
    + "\">\n      <td><a href=\"http://localhost:8080/a/"
    + alias4(((helper = (helper = helpers.shortUrl || (depth0 != null ? depth0.shortUrl : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"shortUrl","hash":{},"data":data}) : helper)))
    + "\">"
    + alias4(((helper = (helper = helpers.shortUrl || (depth0 != null ? depth0.shortUrl : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"shortUrl","hash":{},"data":data}) : helper)))
    + "</a></td>\n      <td><a href=\""
    + alias4(((helper = (helper = helpers.redirectUrl || (depth0 != null ? depth0.redirectUrl : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"redirectUrl","hash":{},"data":data}) : helper)))
    + "\">"
    + alias4(((helper = (helper = helpers.redirectUrl || (depth0 != null ? depth0.redirectUrl : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"redirectUrl","hash":{},"data":data}) : helper)))
    + "</a></td>\n      <td>\n        <button type=\"button\" class=\"btn btn-danger\" data-shorturl=\""
    + alias4(((helper = (helper = helpers.shortUrl || (depth0 != null ? depth0.shortUrl : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"shortUrl","hash":{},"data":data}) : helper)))
    + "\" data-toggle=\"modal\" data-target=\"#confirm-delete-modal\" data-title=\"Delete User\" data-message=\"Are you sure you want to delete this user ?\">\n          <span class=\"glyphicon glyphicon-trash\" aria-hidden=\"true\"></span> Delete\n        </button>\n      </td>\n    </tr>\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "<thead>\n  <tr>\n    <th>Short URL</th>\n    <th>Redirect URL</th>\n    <th>Action</th>\n  </tr>\n</thead>\n<tbody>\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},depth0,{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "</tbody>\n";
},"useData":true});
})();