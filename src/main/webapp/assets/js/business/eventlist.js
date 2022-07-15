$(function(){
    
    
    $(".event_detail").click(function(){
        location.href="/admin/event_detail?seq="+$(this).attr("data-seq");
    })
   
    $(".event_detail_area").click(function(){
        $(".event_name_mod").prop("disabled", false);   
    })


})