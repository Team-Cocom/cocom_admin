$(function(){
    $(".event_detail_wrap textarea, input, button").prop("disabled",true);
    $(".modify_detail").prop("disabled",false);
    
    
    $(".modify_detail").click(function(){
        $(".event_detail_wrap textarea, input, button").prop("disabled",false);
    })
    $(".delete_event_info").click(function(){
        if(!confirm("이벤트 정보를 삭제하시겠습니까?")) return;
        let seq = $(this).attr("data-seq");
        $.ajax({
            url:"/api/admin/event/delete?seq="+seq,
            type:"delete",
            success:function(r) {
                alert(r.message);
                location.href="/admin/event/list";
            }
        })
        
    })
    

    $("#deleteDescImg").click(function(){

        if (!confirm("설명 이미지를 삭제 하시겠습니까?")) {
            return;
        }
        let img =  $(this).attr("data-file");

        $.ajax({
            url: "/images/delete/event_desc/" +img,
            type: "delete",
            success: function (result) {
                alert(result.message);
                $(".event_desc_img_area").html("");
            }
        })

        $.ajax({
            url:"/api/admin/event_detail/delete_img?filename="+img,
            type:"patch",
            success:function(r){
            }
        })
    })
    $("#deleteTitleImg").click(function(){
        if(!confirm("타이틀이미지를 삭제 하시겠습니까?")) {
            return;
        }
        let img = $(this).attr("data-file");

        $.ajax({
            url:"/images/delete/event_title/" +img,
            type:"delete",
            success: function(result) {
                alert(result.message);
                $(".event_title_detail_img_area").html("");
            }
        })
        $.ajax({
            url:"/api/admin/event_detail/deletetitle_img?filename="+img,
            type:"patch",
            success:function(r){
                alert(r.message);
            }

        })
    })

    $("#event_title_mod_img").change(function(){
        let form= $("#event_title_img_mod_form");
        let formData = new FormData(form[0]);
        if ($(this).val() == ''|| $(this).val() == null) return;
        
        $.ajax({
            url:"/images/upload/event_title",
            type:"put",
            data:formData,
            contentType:false,
            processData:false,
            success:function(result) {
                alert(result.message);
                if(!result.status) {
                    alert(result.message);
                    return;
                }

                let split = (result.file).split("\\");
                split = split[split.length - 1].split(".");
                let origin_file = split[0] + "." + split[1];
                let tag =
                '<div class="event_title_img_mod" data-name="'+origin_file+'">'+
                    '<img src="/images/event_title/'+origin_file+'" >'+
                    '<button onclick=deleteImg("'+origin_file+'")>&times;</button>'
                '</div>';
                

                $(".event_title_mod_img_area").append(tag);
            }
        })        
    })
    $("#event_desc_mod_img_select").change(function(){
        let form= $("#event_desc_img_mod_form");
        let formData = new FormData(form[0]);
        if ($(this).val() == ''|| $(this).val() == null) return;
        
        $.ajax({
            url:"/images/upload/event_desc",
            type:"put",
            data:formData,
            contentType:false,
            processData:false,
            success:function(result) {
                alert(result.message);
                if(!result.status) {
                    alert(result.message);
                    return;
                }

                let split = (result.file).split("\\");
                split = split[split.length - 1].split(".");
                let origin_file = split[0] + "." + split[1];
                let tag =
                '<div class="event_desc_img_mod" data-name="'+origin_file+'">'+
                    '<img src="/images/event_desc/'+origin_file+'" >'+
                    '<button onclick=deleteImg("'+origin_file+'")>&times;</button>'
                '</div>';

                

                $(".event_desc_mod_img_area").append(tag);
            }
        })
    })
    $("#mod_event").click(function(){
        if (!confirm("이벤트 정보를 수정하시겠습니까?")) return;

        let event_title_img = $(".event_title_img_mod").attr("data-name")
        if($(".event_title_img").attr("data-name") != null){
            event_title_img = $(".event_title_img").attr("data-name")
        }

        let event_desc_img = $(".event_desc_img_mod").attr("data-name")
        if($(".event_desc_img").attr("data-name") != null){
            event_desc_img = $(".event_desc_img").attr("data-name")
        }

        let data = {
            eve_seq:$(this).attr("data-seq"),
            eve_name:$("#event_name_mod").val(),
            eve_ex_text:$("#event_desc_mod").val(),
            eve_img_file:event_desc_img,
            eve_title_img:event_title_img

        }
        console.log(data);
        
        $.ajax({
            url:"/api/admin/event/detail",
            type:"patch",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r){
                alert(r.message);
                $(".event_detail_wrap textarea, input, button").prop("disabled",true);
                $(".modify_detail").prop("disabled",false);
                location.reload;
            }
        })
    })
})

