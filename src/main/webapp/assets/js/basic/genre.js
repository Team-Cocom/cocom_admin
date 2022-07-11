$(function(){
    $("#gr_save").click(function(){
        if(isEmpty($("#name").val())){
            alert("장르명을 다시 입력해주세요.");
            return;
        }
        $.ajax({
            url:"/genre/add?name="+$("#name").val(),
            type:"put",
            success:function(a){
                alert(a.message);
                location.reload();
            }
        })
    })
    $(".delte").click(function(){
        if(!confirm("삭제 하시겠습니까?")) return;

        $.ajax({
            url:"api/"
        })
    })
})