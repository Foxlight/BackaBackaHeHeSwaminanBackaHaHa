MyCustomerViewModel = function () {
    var self = this;
    self.items = ko.observableArray();
    $.getJSON("http://localhost:8080/ProjetAmosse/resources/article/").
            then(function (articles) {
                $.each(articles, function () {
                    self.items.push({
                        positionLatitude: ko.observable(this.positionLatitude),
                        titre: ko.observable(this.titre),
                        positionLongitude: ko.observable(this.positionLongitude),
                        motCles: ko.observable(this.motCles),
                        publier_actif: ko.observable(this.publier_actif),
                        contenu: ko.observable(this.contenu),
                        positionNom: ko.observable(this.positionNom),
                    });
                });
            }); 
	self.remove = function(items){  
                   self.items.remove(item);
                    $.ajax({  
                        url: [URI],  
                        type: "DELETE",  
                        contentType: "application/json",  
                        headers: {  
                        Accept : "application/json"  
                    }  
                    })  
                            .success(function(data, status, jq) {  
                        // alert(status);  
                        self.items.remove(item);  
                    })  
                            .error(function(jq, status, error) {  
                        $(".error").text(JSON.stringify(status + " " + error));  
  
                    });  
                };  
};
ko.applyBindings(new MyCustomerViewModel());