$(function(){
    $(".notice_mod_area").hide();

    $("#modify_notice").click(function(){
        $(".notice_detail_area").hide();
        $(".notice_mod_area").show();
    })

    $("#cancel_mod").click(function(){
    $(".notice_detail_area").show();
    $(".notice_mod_area").hide();
    })

    $(".delete_img").click(function(){
        if(!confirm("이미지를 삭제하시겠습니까?")) return;

        $.ajax({
            url:"/api/post/delete_img?seq="+$(this).attr("data-seq"),
            type:"patch",
            success:function(r){
                alert(r.message);
                $(".img_area").html("");
            }
        })
    })

    $("#ni_mod_file").change(function(){
        let form = $("#ni_img_form");
        let formData = new FormData(form[0]);
        if($(this).val() == '' || $(this).val() == null) return;
        
        $.ajax({
            url:"/images/upload/notice_img",
            type:"put",
            data:formData,
            contentType:false,
            processData:false,
            success:function(result) {
                if(!result.status) {
                    alert(result.message);
                    return;
                }
    
                let split = (result.file).split("\\");
                split = split[split.length - 1].split(".");
                let origin_file = split[0] + "." + split[1];
                let tag = 
                '<div class="ni_mod_detail_img" filename="'+origin_file+'" style="background-image:url(/images/notice_img/'+origin_file+')">'+
                    '<button onclick=deleteImg("'+origin_file+'")>&times;</button>'+
                '</div>';
                $(".ni_mod_img_area").append(tag);
            }
        })
    })

    $("#mod_save").click(function(){

        let data = {
            ni_seq:$(this).attr("data-seq"),
            ni_import:$("#ni_mod_import  option:selected").val(),
            ni_img_file:$(".ni_mod_detail_img").attr("filename"),
            ni_ex_text:$("#ni_ex_text_mod").val()
        }

        $.ajax({
            url:"/api/post/detail",
            type:"patch",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })

})

