MyCustomerViewModel = function () {
    var self = this;
    self.items = ko.observableArray();
    $.getJSON("http://localhost:8080/ProjetAmosse/resources/roles/").
            then(function (roless) {
                $.each(roless, function () {
                    self.items.push({
                        description: ko.observable(this.description),
                        nom: ko.observable(this.nom),
                    });
                });
            }); 
};
ko.applyBindings(new MyCustomerViewModel());