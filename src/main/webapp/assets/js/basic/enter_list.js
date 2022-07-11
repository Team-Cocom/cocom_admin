$(function(){
    $("#add_ent").click(function(){
        if(!confirm("추가 하시겠습니까?")) return;
        $.ajax({
            url:"/api/enter/add?name="+$("#ent_name").val(),
            type:"put",
            success:function(r){
                alert(r.message)
                location.reload();
            }
        })
    })
    $(".delete_ent").click(function(){
        if(!confirm("삭제하시겠습니까?")) return;
        let seq=$(this).attr("data-seq");
        $.ajax({
            url:"/api/enter/delete?seq="+seq,
            type:"delete",
            success:function(r) {
                alert(r.message);
                location.reload();
            }
        })
    })
})