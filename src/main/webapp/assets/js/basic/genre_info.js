$(function (){
    $(".genre_add_form").hide();

    $(".genre_add").click(function () {
        $(".genre_add_form").show();
    })
    $(".genre_add_btn").click(function(){ 
        let name = $("#genre_name").val();
        if(isEmpty(name)) {
            alert("장르 이름을 올바르게 입력해주세요.");
            return;
        }
        if(!confirm("장르 정보를 추가하시겠습니까?")) return;

        $.ajax({
            url:"/api/genre/add?name="+name,
            type:"put",
            success:function(r) {
                alert(r.message);
                location.reload();
            }
        })
    })
    $(".genre_del_btn").click(function(){
        if(!confirm("장르 정보를 삭제하시겠습니까?")) return;
        let seq = $(this).attr("data-seq");
        $.ajax({
            url:"/api/genre/delete?seq="+seq,
            type:"delete",
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })

})