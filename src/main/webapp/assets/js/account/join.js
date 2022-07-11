$(function(){
    $("#add").click(function(){
        let id = $("#aa_id").val();
        let pwd = $("#aa_pwd").val();
        let name = $("#aa_name").val();
        let role = $("#aa_role").val();

        
        if(isEmpty(id)) {
            alert("아이디를 올바르게 입력하세요");
            return;
        }
        if(isEmpty(pwd)) {
            alert("비밀번호를 올바르게 입력하세요");
            return;
        }
        if(isEmpty(name, false)) {
            alert("이름을 올바르게 입력하세요");
            return;
        }
        let data={
            aa_id:id,
            aa_pwd:pwd,
            aa_name:name,
            aa_role:role
        }
        $.ajax({
            url:"/api/account/join",
            type:"put",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(a) {
                alert(a.message);
                location.reload();
            },
            error:function(err) {
                alert(err.responseJSON.message);
            }
        })
        
        $(".delete").click(function(){
            if(!confirm("관리자 정보를 삭제하시겠습니까?")) return;
            let seq = $(this).attr("data-seq");
            $.ajax({
                url:"/api/account/delete?seq="+seq,
                type:"delete",
                success:function(r) {
                    alert(r.message);
                    location.reload();
                }
            })
        });
    })
})