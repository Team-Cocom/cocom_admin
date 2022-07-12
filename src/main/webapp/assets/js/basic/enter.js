$(function(){
    $("#add_save").click(function(){
        let e_name = $("#ent_name").val();
        if(isEmpty(e_name)) {
            alert("올바르게 입력 해주세요.");
            return;
        }
        $.ajax({
            url:"/api/enter/list?name="+e_name,
            type:"put",
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })

    $(".delete").click(function(){
        if(!confirm("엔터를 삭제하시곘습니까?")) return;
        let seq = $(this).attr("data-seq");
        $.ajax({
            url:"/api/enter/list?seq="+seq,
            type:"delete",
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })
})