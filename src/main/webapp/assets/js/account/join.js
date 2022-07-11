$(function(){
    $("#join").click(function(){
        let data = {
            aa_id:$("#aa_id").val(),
            aa_pwd:$("#aa_pwd").val(),
            aa_role:$("#aa_role").val()
        }
        $.ajax({
            url:"/api/account/join",
            type:"put",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(a) {
                console.log(a);
                alert(a.message);
            }

        })
    })

})