function doAjax() {

    var inputText = $("#input_str").val();

    $.ajax({
        url : 'getCharNum',
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        data : ({
            text: inputText
        }),
        success: function (data) {

            var result = '"'+data.text+'", '+data.count+' characters';
            $("#result_text").text(result);
        }
    });
}