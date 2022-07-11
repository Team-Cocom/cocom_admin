$(function(){
    $("#join").click(function(){
<<<<<<< HEAD
=======
        if(!confirm("추가 하시겠습니까?")) return;


>>>>>>> 3c8b99a45df8bdde4de2cf8bbd0ce28ef74b2873
        let data = {
            aa_id:$("#aa_id").val(),
            aa_pwd:$("#aa_pwd").val(),
            aa_role:$("#aa_role").val()
        }
<<<<<<< HEAD
=======


>>>>>>> 3c8b99a45df8bdde4de2cf8bbd0ce28ef74b2873
        $.ajax({
            url:"/api/account/join",
            type:"put",
            contentType:"application/json",
            data:JSON.stringify(data),
<<<<<<< HEAD
            success:function(r){
                alert(r.message);
            }
        })
    })
=======
            success:function(a) {
                console.log(a);
                alert(a.message);
            }

        })
    })

>>>>>>> 3c8b99a45df8bdde4de2cf8bbd0ce28ef74b2873
})