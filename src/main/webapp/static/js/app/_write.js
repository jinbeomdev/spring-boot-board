$("#writeForm").submit(function(event) {
    event.preventDefault();

    var obj = new Object();

    var $form = $(this),
    url = $form.attr("action");

    obj.author = $form.find("input[name='author']").val(),
    obj.title = $form.find("input[name='title']").val(),
    obj.content = $form.find("textarea[name='content']").val();

    var json_data = JSON.stringify(obj);

    var request = $.ajax({
        url:url,
        type:"POST",
        data:json_data,
        dataType:"json",
        contentType: "application/json"
    });

    window.location.replace("/board");
});