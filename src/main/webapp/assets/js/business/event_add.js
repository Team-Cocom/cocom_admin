$(function (){
    $("#event_title_img").change(function(){
        let form= $("#event_title_form");
        let formData = new FormData(form[0]);
        if ($(this).val() == ''|| $(this).val() == null) return;

        $.ajax({
            url:"/images/upload/event_title",
            type:"put",
            data:formData,
            contentType:false,
            processData:false,
            success:function(result){
                alert(result.message);
                if(!result.status) {
                    alert(result.message);
                    return;
                }
                let split = (result.file).split("\\");
                split = split[split.length - 1].split(".");
                let origin_file = split[0] + "." + split[1];
                let tag =
                '<div class="event_title_img_file" data-name="'+origin_file+'">'+
                    '<img src="/images/event_title/'+origin_file+'" >'+
                    '<button onclick=deleteImg("'+origin_file+'")>&times;</button>'
                '</div>';

                $(".event_title_img_area").append(tag);

            }
        })
    })
    $("#event_desc_img").change(function(){
        let form= $("#event_desc_form");
        let formData = new FormData(form[0]);
        if ($(this).val() == ''|| $(this).val() == null) return;

        $.ajax({
            url:"/images/upload/event_desc",
            type:"put",
            data:formData,
            contentType:false,
            processData:false,
            success:function(result){
                alert(result.message);
                if(!result.status) {
                    alert(result.message);
                    return;
                }
                let split = (result.file).split("\\");
                split = split[split.length - 1].split(".");
                let origin_file = split[0] + "." + split[1];
                let tag =
                '<div class="event_desc_img_file" data-name="'+origin_file+'">'+
                    '<img src="/images/event_desc/'+origin_file+'" >'+
                    '<button onclick=deleteImg("'+origin_file+'")>&times;</button>'
                '</div>';

                $(".event_desc_img_area").append(tag);

            }
        })
    })

    $(".event_add_btn").click(function(){
        let name = $("#event_name").val();
        if(isEmpty(name),false){
            alert("타이틀을 올바르게 입력해주세요.");
            return;
        }
        if(!confirm("이벤트 정보를 추가하시겠습니까?")) return;
        let data = {
            eve_name: $("#event_name").val(),
            eve_ex_text: $("#event_detail_desc").val(),
            eve_title_img:$(".event_title_img_file").attr("data-name"),
            eve_img_file:$(".event_desc_img_file").attr("data-name")
        }
        console.log(data);
        
        $.ajax({
            url:"/api/admin/event/add",
            type:"put",
            data: JSON.stringify(data),
            contentType: "application/json",
            success: function(r) {
                alert(r.message);
                location.href="/admin/event/list"
            }
            
        })
    })
    
})
function deleteImg(filename) {
    if (!confirm("이미지를 삭제 하시겠습니까?")) {
        return;
    }
    $.ajax({
        url: "/images/delete/event_title/" + filename,
        type: "delete",
        success: function (result) {
            alert(result.message);
            $(".event_title_img_area").html("");
        }
    })
    
}
function deleteImg(filename) {
    if (!confirm("이미지를 삭제 하시겠습니까?")) {
        return;
    }
    $.ajax({
        url: "/images/delete/event_desc/" + filename,
        type: "delete",
        success: function (result) {
            alert(result.message);
            $(".event_desc_img_area").html("");
        }
    })
}

