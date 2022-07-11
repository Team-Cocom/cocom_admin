$(function(){
    $("#add_genre").click(function(){
        if(!confirm("추가 하시겠습니까?")) return;
        $.ajax({
            url:"/api/genre/add?name="+$("#gr_name").val(),
            type:"put",
            success:function(r){
                alert(r.message)
            }
        })
    })
})