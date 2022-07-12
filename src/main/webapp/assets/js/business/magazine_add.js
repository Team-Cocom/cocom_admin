$(function(){
    $("#mz_poster_img").change(function(){
        let form = $("#magazine_poster_img");
        let formData = new FormData(form[0]);
        if($(this).val()==''||$(this).val() == null) return;

        $.ajax({
                url:"/images/upload/magazine_img",
                type:"put",
                data:formData,
                contentType:false,
                processData:false,
                success:function(result){
                    alert(result.message);
                    if(!result.status) {
                    alert(result.message);
                    return;
                }
                let split = (result.file).split("\\");
                split = split[split.length-1].split(".");
                let origin_file = split[0]+"."+split[1];
                let tag = 
                '<div class="magazine_img" data-name="'+origin_file+'">'+
                '<img src="/images/magazine_img/'+origin_file+'">'+
                '<button onclick=deleteImg("'+origin_file+'")>&times;</button>'+
                '</div>';

                $(".magazine_img_area").append(tag);
            }
        })
    })
    


    $(".add_magazine").click(function(){
        if(!confirm("매거진 정보를 추가하시겠습니까?")) return;
        
        
        let data = {
            mz_name:$("#mz_name").val(),
            mz_poster_img:$(".magazine_img").attr("data-name")
        }
        console.log(data);

        $.ajax({
            url:"/api/magazine/add",
            type:"put",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })

    })

})
