$(function(){
    $("#album_cover_file").change(function(){
        let form = $("#album_cover_form");
        let formData = new FormData(form[0]);
        if($(this).val() == '' || $(this).val() == null) return;
        
        $.ajax({
            url:"/images/upload/album_cover",
            type:"put",
            data:formData,
            contentType:false,
            processData:false,
            success:function(result) {
                if(!result.status) {
                    alert(result.message);
                    return;
                }

                let split = (result.file).split("\\");
                split = split[split.length - 1].split(".");
                let origin_file = split[0] + "." + split[1];
                let tag = 
                '<div class="ab_cover" filename="'+origin_file+'" style="background-image:url(/images/album_cover/'+origin_file+')">'+
                    '<button onclick=deleteImg("'+origin_file+'")>&times;</button>'+
                '</div>';
                $(".ab_covers").append(tag);
            },
            error:function(error) {
                console.log(error);
            }
        })
    })

    $("#ab_add_save").click(function(){
        if(!confirm("앨범 정보를 추가하시겠습니까?")) return;

        let ab_name_du = $("#ab_name").val();

        if(isEmpty(ab_name_du),false){
            alert("올바르게 입력해주세요");
            return;
        }

        let data = {
            ab_name:$("#ab_name").val(),
            ab_ai_seq:1,
            ab_ent_seq:$("#ab_ent_seq option:selected").val(),
            ab_age:$("#ab_age option:selected").val(),
            ab_re_dt:$("#ab_re_dt").val(),
            ab_rci_seq:$("#ab_rci_seq option:selected").val(),
            ab_mv_seq:$("#ab_mv_seq").val(),
            ab_img_file:$(".ab_cover").attr("filename"),
            ab_mu_seq:1,
            ab_is_confirm:1
        }


        console.log(data);

        $.ajax({
            url:"/api/album/add",
            type:"put",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })

    $(".ab_detail_info").click(function(){
        let seq = $(this).attr("data-seq");
        $.ajax({
            url:"/album/detail?seq="+seq,
            type:"get",
            success:function(r){
                location.href="/album/detail?seq="+seq
            }
        })
    })

    $(".album_del_btn").click(function(){
        if(!confirm("앨범 정보를 삭제하시겠습니까?")) return;
        let seq = $(this).attr("data-seq");
        $.ajax({
            url:"/api/album/delete?seq="+seq,
            type:"delete",
            success:function(r){
                alert(r.message);
                location.href="/album/list"
            }
        })
    })
})

