
$(function () {
    $("#music_file_save_btn").click(function(){
        $("#music_file_save_btn").hide();
        
    })
    $("#cover_img_save_btn").click(function(){
        $("#cover_img_save_btn").hide();
    })

    if($(".music_img_mod").attr("data-name") == null){$("#cover_img_mod_save").show();}
    if($(".music_file_mod").attr("data-name") == null){$("#music_file_save_mod").show();}


    $("#music_cover_img").change(function () {
        let form = $("#cover_img_form");
        let formData = new FormData(form[0]);
        if ($(this).val() == '' || $(this).val() == null) return;

        $.ajax({
            url: "/images/upload/music_cover",
            type: "put",
            data: formData,
            contentType: false,
            processData: false,
            success: function (result) {
                alert(result.message);
                if (!result.status) {
                    alert(result.message);
                    return;
                }
                let split = (result.file).split("\\");
                split = split[split.length - 1].split(".");
                let origin_file = split[0] + "." + split[1];
                let tag =
                    '<div class="music_img" data-name="' + origin_file + '">' +
                    '<img src="/images/music_cover/' + origin_file + '" >' +
                    '<button onclick=deleteImg("' + origin_file + '")>&times;</button>'
                '</div>';

                $(".cover_img_area").append(tag);
                $("#cover_img_save").hide();
            }
        })
    })

    $("#music_cover_mod_img").change(function () {
        let form = $("#cover_img_mod_form");
        let formData = new FormData(form[0]);
        if ($(this).val() == '' || $(this).val() == null) return;

        $.ajax({
            url: "/images/upload/music_cover",
            type: "put",
            data: formData,
            contentType: false,
            processData: false,
            success: function (result) {
                alert(result.message);
                if (!result.status) {
                    alert(result.message);
                    return;
                }
                let split = (result.file).split("\\");
                split = split[split.length - 1].split(".");
                let origin_file = split[0] + "." + split[1];
                let tag =
                '<div class="music_img_mod" data-name="'+origin_file+'"'+
                'style="background-image: url( /images/music_cover/'+origin_file+');">'+
                '<button onclick="deleteModImg('+origin_file+')">&times;</button>'+
                '</div>';

                $(".img_file").append(tag);
                $("#cover_img_mod_save").hide();
            }
        })
    })



    $("#music_file").change(function () {
        let form = $("#music_file_form");
        let formData = new FormData(form[0]);
        if ($(this).val() == '' || $(this).val() == null) return;

        $.ajax({
            url: "/music/upload/music",
            type: "put",
            data: formData,
            contentType: false,
            processData: false,
            success: function (result) {
                alert(result.message);
                if (!result.status) {
                    alert(result.message);
                    return;
                }

                let split = (result.file).split("\\");
                split = split[split.length - 1].split(".");
                let origin_file = split[0] + "." + split[1];
                let tag =
                    '<audio controls class="music_file" data-name="' + origin_file + '">' +
                    '<source src="/images/music/' + origin_file + '" type="audio/mp3">' +
                    '</audio>' +
                    '<button onclick=delete_music_file("' + origin_file + '")>&times;</button>';

                $(".music_file_area").append(tag);
                $("#music_file_save").hide();
            }
        })
    })
    $("#music_file_mod").change(function () {
        let form = $("#music_file_mod_form");
        let formData = new FormData(form[0]);
        if ($(this).val() == '' || $(this).val() == null) return;

        $.ajax({
            url: "/music/upload/music",
            type: "put",
            data: formData,
            contentType: false,
            processData: false,
            success: function (result) {
                alert(result.message);
                if (!result.status) {
                    alert(result.message);
                    return;
                }

                let split = (result.file).split("\\");
                split = split[split.length - 1].split(".");
                let origin_file = split[0] + "." + split[1];
                let tag =
                    '<audio controls class="music_file_mod" data-name="' + origin_file + '">' +
                    '<source src="/images/music/' + origin_file + '" type="audio/mp3">' +
                    '</audio>' +
                    '<button onclick=delete_music_file_mod("' + origin_file + '")>&times;</button>';

                $(".music_file_area_mod").append(tag);
                $("#music_file_save_mod").hide();
            }
        })
    })



    $("#add_music").click(function () {
        if (!confirm("노래 정보를 추가하시겠습니까?")) return;

        let name = $("#mu_name").val();
        let img_file = $(".music_img").attr("data-name");
        let music_file = $(".music_file").attr("data-name");
        let mu_time = $("#mu_playtime").val();

        if (isEmpty(name, false)) {
            alert("노래 제목을 올바르게 입력해 주세요.");
            return;
        }
        if (isEmpty(mu_time)) {
            alert("재생시간은 필수 항목입니다.");
            return;
        }


        let data = {
            mu_name: name,
            mu_ai_seq: 1,
            mu_img_file: img_file,
            mu_ab_seq: $('#ab_seq option:selected').val(),
            mu_music_file: music_file,
            mu_age: $("#mu_age option:selected").val(),
            mu_lyrics: $("#mu_lylic").val(),
            mu_explain_txt: $("#mu_explain").val(),
            mu_playtime: mu_time,
            mu_gr_seq:$("#mu_gr_seq option:selected").val(),
            mu_cr_seq:$("#mu_cr_seq option:selected").val()
        }

        $.ajax({
            url: "/api/music/add",
            type: "put",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (r) {
                alert(r.message);
                location.reload();
            }
        })

    })
    $("#mod_music").click(function () {
        if (!confirm("노래 정보를 수정하시겠습니까?")) return;

        let name = $("#mu_mod_name").val();
        let img_file = $(".music_img_mod").attr("data-name");
        let music_file = $(".music_file_mod").attr("data-name");
        let mu_time = $("#mu_playtime_mod").val();
        let ai_seq = $("#ai_seq option:selected").val();

        if (isEmpty(name, false)) {
            alert("노래 제목을 올바르게 입력해 주세요.");
            return;
        }
        if (isEmpty(mu_time)) {
            alert("재생시간은 필수 항목입니다.");
            return;
        }

        let data = {
            mu_seq:$(this).attr("data-seq"),
            mu_name:name,
            mu_ai_seq:ai_seq,
            mu_img_file:img_file,
            mu_ab_seq:$('#mod_ab_seq option:selected').val(),
            mu_music_file:music_file,
            mu_age:$("#mu_age_mod option:selected").val(),
            mu_lyrics:$("#mu_lylic_mod").val(),
            mu_explain_txt:$("#mu_explain_mod").val(),
            mu_playtime:mu_time,
            mu_gr_seq:$("#mu_gr_seq_mod option:selected").val(),
            mu_cr_seq:$("#mu_cr_seq_mod option:selected").val()
        }
        console.log(data);

        $.ajax({
            url:"/api/music/modify",
            type:"patch",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r) {
                alert(r.message);
                location.href="/music/list";
            }
        })

    })

})


function deleteImg(filename) {
    if (!confirm("커버 이미지를 삭제 하시겠습니까?")) {
        return;
    }
    $.ajax({
        url: "/images/delete/music_cover/" + filename,
        type: "delete",
        success: function (result) {
            alert(result.message);
            $(".img_file").html("");
            $("#cover_img_save").show();
        }
    })
}

function deleteModImg(filename) {
    if (!confirm("커버 이미지를 삭제 하시겠습니까?")) {
        return;
    }
    $.ajax({
        url:"/api/music/img/delete?filename="+filename,
        type:"patch",
        success: function (r){
        }
    })
    $.ajax({
        url: "/images/delete/music_cover/" + filename,
        type: "delete",
        success: function (result) {
            alert(result.message);
            $(".img_file").html("");
        }
    })
}

function delete_music_file(filename) {
    if (!confirm("노래 파일을 삭제 하시겠습니까?")) {
        return;
    }
    $.ajax({
        url: "/images/delete/music/"+filename,
        type: "delete",
        success: function (result) {
            alert(result.message);
            $(".music_file_area").html("");
            $("#music_file_save").show();
        }
    })
}

function delete_music_file_mod(filename) {
    if (!confirm("노래 파일을 삭제 하시겠습니까?")) {
        return;
    }

    $.ajax({
        url:"/api/music/file/delete?filename="+filename,
        type:"patch",
        success: function (r){
        }
    })
    $.ajax({
        url: "/images/delete/music/"+filename,
        type: "delete",
        success: function (result) {
            alert(result.message);
            $(".music_file_area_mod").html("");
            $("#music_file_save_mod").show();
        }
    })
}
