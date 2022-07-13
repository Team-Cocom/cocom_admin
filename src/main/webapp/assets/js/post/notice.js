$(function(){
    $("#notice_popup_button").click(function(){$(".notice_add_popup").show()})
    $("#notice_cancel").click(function(){$(".notice_add_popup").hide()})
    $("#notice_img").change(function(){
        let form = $("#notice_form");
        let formData = new FormData(form[0]);
        if ($(this).val() == '' || $(this).val() == null) return;

        $.ajax({
            url: "/images/upload/notice_img",
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
                    '<div class="notice_image" data-name="' + origin_file + '">' +
                    '<img src="/images/notice_img/' + origin_file + '" >' +
                    '<button onclick=deleteImg("' + origin_file + '")>&times;</button>'
                '</div>';
                $(".notice_img_area").append(tag);
            }
        })
    })


    $("#notice_add").click(function(){
        
        let data = {
            ni_title:$("#ni_title").val(),
            ni_ex_text:$("#ni_ex_text").val(),
            ni_import:$("#ni_import option:selected").val(),
            ni_img_file:$(".notice_image").attr("data-name")
        }

        $.ajax({
            url:"/api/post/add",
            type:"put",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r){
                alert(r.message);
                location.reload();
            }

        })
    })
})


function deleteImg(filename) {
    if (!confirm("커버 이미지를 삭제 하시겠습니까?")) {
        return;
    }
    $.ajax({
        url: "/images/delete/notice_img/" + filename,
        type: "delete",
        success: function (result) {
            alert(result.message);
            $(".notice_img_area").html("");
        }
    })
}