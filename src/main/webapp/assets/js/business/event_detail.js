$(function(){
    $(".event_detail_wrap textarea, input, button").prop("disabled",true);
    $(".modify_detail").prop("disabled",false);
    
    
    $(".modify_detail").click(function(){
        $(".event_detail_wrap textarea, input, button").prop("disabled",false);
    })
    $(".delete_event_info").click(function(){
        if(!confirm("장르 정보를 삭제하시겠습니까?")) return;
        let seq = $(this).attr("data-seq");
        $.ajax({
            url:"/api/admin/event/delete?seq="+seq,
            type:"delete",
            success:function(r) {
                alert(r.message);
                location.reload();
            }
        })
        
    })
})