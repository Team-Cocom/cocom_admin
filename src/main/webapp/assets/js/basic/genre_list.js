$(function(){
    $("#genre_popup_button").click(function(){$(".add_genre_popup").show();})
    $("#add_genre").click(function(){
        let g_name = $("#gr_name").val()
        if(isEmpty(g_name,false)){
            alert("장르 명을 올바르게 입력해주세요.")
            return;
        }

        if(!confirm("추가 하시겠습니까?")) return;
        $.ajax({
            url:"/api/genre/add?name="+g_name,
            type:"put",
            success:function(r){
                alert(r.message);
            }
        })
    });

    $("#cancel_genre").click(function(){$(".add_genre_popup").hide();})

    $(".delete_genre").click(function(){
        let gr_name = $(this).attr("data-name");
        if(!confirm(gr_name+"을 삭제하시겠습니까?")) return;

        $.ajax({
            url:"/api/genre/delete?seq="+$(this).attr("data-seq"),
            type:"delete",
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })
})