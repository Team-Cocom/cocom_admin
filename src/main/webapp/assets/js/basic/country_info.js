$(function (){
    // $(".genre_add").click(function () {

    // })
    $(".country_add_btn").click(function(){ 
        let name = $("#country_name").val();
        if(isEmpty(name)) {
            alert("나라 이름을 올바르게 입력해주세요.");
            return;
        }
        if(!confirm("나라 정보를 추가하시겠습니까?")) return;

        $.ajax({
            url:"/api/country/add?name="+name,
            type:"put",
            success:function(r) {
                alert(r.message);
                location.reload();
            }
        })
    })
    $(".country_del_btn").click(function(){
        if(!confirm("나라 정보를 삭제하시겠습니까?")) return;
        let seq = $(this).attr("data-seq");
        $.ajax({
            url:"/api/country/delete?seq="+seq,
            type:"delete",
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })
})