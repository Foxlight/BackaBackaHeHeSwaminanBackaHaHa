var Article = function(article) {  
	this.id = ko.observable(article.id); 
	this.prenom = ko.observable(article.prenom);
	this.nom = ko.observable(article.nom);  
	this.info = ko.observable(article.info);
	this.photo = ko.observable(article.photo);
	this.nomUtilisateur = ko.observable(article.nomUtilisateur);
	this.motDePasse = ko.observable(article.motDePasse);
	this.status = ko.observable(article.status);
	this.derniereConnection = ko.observable(article.derniereConnection);
	this.listeCommentaires = ko.observable(article.listeCommentaires);
	this.role = ko.observable(article.role);

	var ViewModel = function(categories) {  
		var self = this; 
		self.articles = ko.observableArray(ko.utils.arrayMap(articles, function(article) { return new Article(article);}));  
	};  
};