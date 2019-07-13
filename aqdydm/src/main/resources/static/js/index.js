$(function () {
    var type = $("#iType").val();
    load(parseInt(type), 0);

    $("#btnLoadAll").click(function () {
        $("#iType").val(2);
        $("#iPageIndex").val(0);
        $("#posts").html("");
        //console.log("load2");
        load(2, 0);
    });
    $("#btnLoadLunli").click(function () {
        $("#iType").val(0);
        $("#iPageIndex").val(0);
        $("#posts").html("");
        //console.log("load0");
        load(0, 0);
    });
    $("#btnLoadLusi").click(function () {
        $("#iType").val(1);
        $("#iPageIndex").val(0);
        $("#posts").html("");
        //console.log("load1");
        load(1, 0);
    });
    $("#btnLoadShebao").click(function () {
        $("#iType").val(2);
        $("#iPageIndex").val(0);
        $("#posts").html("");
        //console.log("load2");
        load(2, 0);
    });
    $("#btnLoadLldm").click(function () {
        $("#iType").val(3);
        $("#iPageIndex").val(0);
        $("#posts").html("");
        //console.log("load3");
        load(3, 0);
    });
    $("#btnLoadMore").click(function () {
        var type = $("#iType").val();
        var pageIndex = $("#iPageIndex").val();
        load(parseInt(type), parseInt(pageIndex));
    });
});

function load(type, pageIndex) {
    $.ajax({
        url: "/film/page/" + type + "/" + pageIndex,
        type: "GET",
        success: function (result, status) {
            if (200 == result.code) {
                //console.log(result.message);
                //console.log(result.data["films"]);
                $.each(result.data["films"], function (index, film) {
                    if (film.type == "伦理片") {
                        var content = $.ajax({url: "/static/files/filmLunliTemplate.txt", async: false});
                        var html = content.responseText;
                        html = html.replace(RegExp("filmid", "g"), film.id);
                        html = html.replace(RegExp("filmimg", "g"), film.img);
                        html = html.replace(RegExp("filmalt", "g"), film.alt);
                        html = html.replace(RegExp("filmplot", "g"), film.plot);
                        html = html.replace(RegExp("filmactor", "g"), film.actor);
                        html = html.replace(RegExp("filmtype", "g"), film.type);
                        html = html.replace(RegExp("filmdetail", "g"), "/film/detail/0/" + film.id);
                        //console.log(html);
                        $("#posts").append(html);
                    }
                    if (film.type == "撸丝片") {
                        var content = $.ajax({url: "/static/files/filmLusiTemplate.txt", async: false});
                        var html = content.responseText;
                        html = html.replace(RegExp("filmid", "g"), film.id);
                        html = html.replace(RegExp("filmimg", "g"), film.img);
                        html = html.replace(RegExp("filmalt", "g"), film.alt);
                        html = html.replace(RegExp("filmplot", "g"), film.plot);
                        html = html.replace(RegExp("filmactor", "g"), film.actor);
                        html = html.replace(RegExp("filmtype", "g"), film.type);
                        html = html.replace(RegExp("filmdetail", "g"), "/film/detail/1/" + film.id);
                        //console.log(html);
                        $("#posts").append(html);
                    }
                    if (film.type == "社保片") {
                        var content = $.ajax({url: "/static/files/filmShebaoTemplate.txt", async: false});
                        var html = content.responseText;
                        html = html.replace(RegExp("filmid", "g"), film.id);
                        html = html.replace(RegExp("filmimg", "g"), film.img);
                        html = html.replace(RegExp("filmalt", "g"), film.alt);
                        html = html.replace(RegExp("filmplot", "g"), film.plot);
                        html = html.replace(RegExp("filmactor", "g"), film.actor);
                        html = html.replace(RegExp("filmtype", "g"), film.type);
                        html = html.replace(RegExp("filmdetail", "g"), "/film/detail/2/" + film.id);
                        //console.log(html);
                        $("#posts").append(html);
                    }
                    if (film.type == "伦理动漫") {
                        var content = $.ajax({url: "/static/files/filmLldmTemplate.txt", async: false});
                        var html = content.responseText;
                        html = html.replace(RegExp("filmid", "g"), film.id);
                        html = html.replace(RegExp("filmimg", "g"), film.img);
                        html = html.replace(RegExp("filmalt", "g"), film.alt);
                        html = html.replace(RegExp("filmplot", "g"), film.plot);
                        html = html.replace(RegExp("filmactor", "g"), film.actor);
                        html = html.replace(RegExp("filmtype", "g"), film.type);
                        html = html.replace(RegExp("filmdetail", "g"), "/film/detail/3/" + film.id);
                        //console.log(html);
                        $("#posts").append(html);
                    }
                });
                //console.log("load complete...");
                $("#iPageIndex").val(pageIndex + 1);
            } else {
                $("#iPageIndex").val(pageIndex);
                alert(result.message);
            }
            //console.log(status);
        }
    });
}