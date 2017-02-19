MyCustomerViewModel = function () {
    var self = this;
    self.commentaire = ko.observableArray();
    $.getJSON("http://localhost:8080/ProjetAmosse/resources/commentaire/").
            then(function (commentaires) {
                $.each(commentaires, function () {
                    self.items.push({
                        commentaire: ko.observable(this.commentaire),
                    });
                });
            }); 
};
ko.applyBindings(new MyCustomerViewModel());