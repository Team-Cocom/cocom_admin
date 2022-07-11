$(function(){
    $("#login").click(function(){

        let data = {
            aa_id:$("#aa_id").val(),
            aa_pwd:$("#aa_pwd").val(),
        }

        $.ajax({
            url:"/api/account/login",
            type:"post",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r){
                alert(r.message);
                location.href = "/";
            }
        })
    })
})