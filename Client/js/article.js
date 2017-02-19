var Article = function(article) {
	this.id = ko.observable(article.id);
	this.titre = ko.observable(article.titre);
	this.motCles= ko.observable(article.motCles);
	this.publierActif = ko.observable(article.publierActif);
	this.contenu = ko.observable(article.contenu);
	this.photo = ko.observable(article.photo);
	this.positionLongitude = ko.observable(article.positionLongitude);
	this.positionLatitude = ko.observable(article.positionLatitude);
	this.positionNom = ko.observable(article.positionNom);
	this.status = ko.observable(article.status);
	this.utilisateur = ko.observable(article.utilisateur);
	this.commentaires = ko.observable(article.commentaire);
};


var ViewModel = function(articles) {
	var self = this;
	self.articles = ko.observableArray(ko.utils.arrayMap(articles, function(article) {
		return new Article(article);
	}));
};

var getData = function() {  
	$.ajax({  
		url: "http://localhost:8080/bibliotheque_ntdp/webresources/category",  
		type: "GET",  
		headers: {  
			Accept: "application/json"  
		}  
	}).success(function(data, status, jq) {   
		ko.applyBindings(new ViewModel(data));  
	}).error(function(jq, status, error) {  
		$(".error").text(JSON.stringify(status + " " + error));  

	});  
}; 