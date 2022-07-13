$(function(){
    $("#pass_popup").click(function(){$(".pass_add_popup_wrap").show();})
    $("#cancel_pass").click(function(){$(".pass_add_popup_wrap").hide();})
    
    $("#ps_img_file").change(function(){
        let form = $("#pass_img_form");
        let formData = new FormData(form[0]);
        if ($(this).val() =='' || $(this).val() == null) return;

        $.ajax({
            url:"/images/upload/pass_img",
            type:"put",
            data:formData,
            contentType:false,
            processData:false,
            success:function(result){
                alert(result.message);
                if (!result.status){
                    alert(result.message);
                    return;
                }
                let split = (result.file).split("\\");
                split = split[split.length - 1].split(".");
                let origin_file = split[0] + "." + split[1];
                let tag =
                    '<div class="pass_img" data-name="'+origin_file+'">' +
                    '<img src="/images/pass_img/'+origin_file+'" >' +
                    '<button onclick=deleteImg("'+origin_file+'")>&times;</button>'
                '</div>';

                $(".img_file").append(tag);
            }
        })
    })

    $("#add_pass").click(function(){
        if(!confirm("이용권을 등록하시겠습니까?")) return;
        
        let data = {
            ps_name:$("#ps_name").val(),
            ps_period:$("#ps_period").val(),
            ps_img_file:$(".pass_img").attr("data-name"),
            ps_price:$("#ps_price").val(),
            ps_type:$("#ps_type option:selected").val()
        }

        $.ajax({
            url:"/api/pass/add",
            type:"put",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r) {
                alert(r.message);
                location.reload();
            }
        })

    })
})

function deleteImg(filename) {
    if (!confirm("이용권 이미지를 삭제 하시겠습니까?")) {
        return;
    }
    $.ajax({
        url: "/images/delete/pass_img/" + filename,
        type: "delete",
        success: function (result) {
            alert(result.message);
            $(".img_file").html("");
        }
    })
}