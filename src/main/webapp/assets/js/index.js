$(function(){
    $("#login_btn").click(function(){
        if(isEmpty($("#aa_id").val())) {
            $("#aa_id+.error").css("display", "block");
        }
        else {
            $("#aa_id+.error").css("display", "");
        }
        if(isEmpty($("#aa_pwd").val())) {
            $("#aa_pwd+.error").css("display", "block");
        }
        else {
            $("#aa_pwd+.error").css("display", "");
        }

        let data = {
            aa_id:$("#aa_id").val(),
            aa_pwd:$("#aa_pwd").val(),
        }

        $.ajax({
            url:"/api/account/login",
            type:"post",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r) {
                alert(r.message);
                if(r.status) {
                    location.href = "/admin/recommend";
                }
            }
        })
    })
})