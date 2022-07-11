$(function(){
    $("#country_popup_button").click(function(){$(".add_country_popup").show();})
    $("#add_country").click(function(){
        let c_name = $("#cr_name").val();
        if(isEmpty(c_name,false)){
            alert("장르 명을 올바르게 입력해주세요.")
            return;
        }

        if(!confirm("추가 하시겠습니까?")) return;
        $.ajax({
            url:"/api/country/add?name="+c_name,
            type:"put",
            success:function(r){
                if(!r.status){
                    alert(r.message);
                    return;
                }
                alert(r.message);
                location.reload();
            }
        })
    });

    $("#cancel_country").click(function(){$(".add_country_popup").hide();})

    $(".delete_country").click(function(){
        let cr_name = $(this).attr("data-name");
        if(!confirm(cr_name+"을 삭제하시겠습니까?")) return;

        $.ajax({
            url:"/api/country/delete?seq="+$(this).attr("data-seq"),
            type:"delete",
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })
})