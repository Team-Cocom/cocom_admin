$(function(){
    $("#enter_popup_button").click(function(){$(".add_ent_popup").show();})
        $("#add_ent").click(function(){
        let e_name =$("#ent_name").val()
        if(isEmpty(e_name,false)){
            alert("기획사 명을 올바르게 입력해주세요.")
            return;
        }
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
    $("#cancel_ent").click(function(){$(".add_ent_popup").hide();})
    
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