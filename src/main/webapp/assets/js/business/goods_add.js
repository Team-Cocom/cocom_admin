
$(function(){
    $("#goods_img_file").change(function(){
        let form = $("#goods_img_form");
        let formData = new FormData(form[0]);
        if($(this).val() == '' || $(this).val() == null) return;
        $.ajax({
            url:"/images/upload/goods_img",
            type:"put",
            data:formData,
            contentType:false,
            processData:false,
            success:function(result) {
                if(!result.status) {
                    alert(result.message);
                    return;
                }
                let tag = 
                '<div class="goods_imgs" filename="'+result.file+'" style="background-image:url(/images/goods_img/'+result.file+')">'+
                    '<button onclick=deleteImg("'+result.file+'")>&times;</button>'+
                '</div>';
                $(".img_list").append(tag);
            },
            error:function(error) {
                console.log(error);
            }
        })
    });
    $("#gz_add_save").click(function(){

        let data = {
            gz_name:$("#gz_name").val(),
            gz_price: $("#gz_price").val(),
            gz_stock: $("#gz_stock").val(),
            gz_count: $("#gz_count").val(),
            gz_notice: $("#gz_notice").val(),
            gz_img_file:$(".goods_imgs").attr("filename"),
            gz_ex_text: $("#gz_ex_text").val(),
            gz_ent_seq:$("#gz_ent_seq option:selected").val()
        }
        console.log(data);

        $.ajax({
            url:"/api/goods/add",
            type:"put",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r){
                alert(r.message);
            }
        })
    })

})