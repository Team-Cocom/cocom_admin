$(function(){
    $("#release_popup_button").click(function(){$(".add_rci_popup").show();})
        $("#add_rci").click(function(){
        let r_name =$("#rci_name").val()
        if(isEmpty(r_name,false)){
            alert("기획사 명을 올바르게 입력해주세요.")
            return;
        }
        if(!confirm("추가 하시겠습니까?")) return;
        $.ajax({
            url:"/api/release/add?name="+$("#rci_name").val(),
            type:"put",
            success:function(r){
                alert(r.message)
                location.reload();
            }
        })
    })
    $("#cancel_rci").click(function(){$(".add_rci_popup").hide();})
    
    $(".delete_rci").click(function(){
        if(!confirm("삭제하시겠습니까?")) return;
        let seq=$(this).attr("data-seq");
        $.ajax({
            url:"/api/release/delete?seq="+seq,
            type:"delete",
            success:function(r) {
                alert(r.message);
                location.reload();
            }
        })
    })
})