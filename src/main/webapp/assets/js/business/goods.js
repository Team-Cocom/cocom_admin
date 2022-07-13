$(function(){
    $(".del_btn").click(function(){
        if(!confirm("해당 굿즈 정보를 삭제하시겠습니까?")) return;
        let seq = $(this).attr("data-seq");
        $.ajax({
            url:"/api/goods/list?seq="+seq,
            type:"delete",
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })
})