var load = function () {
    init();
}

var init = function () {
	listener_create_article();
    listener_get_listOfArticles();
};


var listener_create_article = function () {
    document.querySelector("#create_article").addEventListener("click", function (evt) {
        var createArticle_form = document.querySelector("#form_CArticle");
        if (createArticle_form.checkValidity()) {
            
            var keywords_input = createArticle_form.elements.namedItem("keywords").value;
            var content_input = createArticle_form.elements.namedItem("content").value;


            //ajax_REST_request("http://localhost:8080/blog_RESTful/resources/article","POST");
            console.log("######" + keywords_input);
            evt.preventDefault();
        }


    });
}

var listener_get_listOfArticles = function () {
    document.querySelector("#getListOfArticles").addEventListener("click", function (evt) {
        ajax_REST_request("http://localhost:8080/blog_RESTful/resources/article", "GET", "content_getListOfArticles");
        
        evt.preventDefault();
    });

}


var ajax_REST_request = function (urlRest, typeMethodHTTP, show_status) {
    $(function () {
        $.ajax({
            url: [urlRest],
            type: typeMethodHTTP,
            headers: {
                Accept: "application/json"
            }
        })
                .success(function (data, status, jq) {
                    document.querySelector("#" + show_status).innerHTML = "Data :" + JSON.stringify(data);
                })
                .error(function (jq, status, error) {
                    $(show_status).text(JSON.stringify(status + " " + error));

                });

    });

}




var listener_hide_form = function (thePressButton, theFormToHide) {
    thePressButton.addEventListener("click", function () {
        if (thePressButton.value === "hideIt") {

            theFormToHide.style.display = 'none';
            thePressButton.setAttribute('value', 'hidded');
        } else {

            theFormToHide.style.display = 'block';
            thePressButton.setAttribute('value', 'hideIt');
        }
    });

}
