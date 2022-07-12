$(function(){
    
    $("#add_save").click(function(){
        let r_name = $("#rci_name").val();
        // if(isEmpty(r_name)){
        //     alert("올바르게 입력해주세요.")
        //     return;
        // }
        $.ajax({
            url:"/api/release/list?name="+r_name,
            type:"put",
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })

    $(".delete").click(function(){
        if(!confirm("발매사를 삭제하시겠습니까?")) return;
        let seq = $(this).attr("data-seq");
        $.ajax({
            url:"/api/release/list?seq="+seq,
            type:"delete",
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })

})