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

var getData = function () { 
	var myHeaders = new Headers();
	myHeaders.set('Accept', 'application/json');
	fetch("http://localhost:8080/ProjetAmosse/resources/article", {
		method: 'GET',
		headers: myHeaders }).then(function (response) { return response.json(); }).then(function (j) {
		ko.applyBindings(new ViewModel(j)); }).catch(function (jq, status, error) { $(".error").text(JSON.stringify(status + " " + error)); });
};