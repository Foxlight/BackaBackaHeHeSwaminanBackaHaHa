MyCustomerViewModel = function () {
    var self = this;
    self.utilisateur = ko.observableArray();
    $.getJSON("http://localhost:8080/ProjetAmosse/resources/utilisateur/").
            then(function (utilisateurs) {
                $.each(utilisateurs, function () {
                    self.items.push({
                        motDePasse: ko.observable(this.motDePasse),
                        nomUtilisateur: ko.observable(this.nomUtilisateur),
                        prenom: ko.observable(this.prenom),
                        nom: ko.observable(this.nom),
                        info: ko.observable(this.info),
                    });
                });
            }); 
};
ko.applyBindings(new MyCustomerViewModel());