$(function(){
    $("#prc_img_file").change(function(){
        let form = $("#prc_img_form");
        let formData = new FormData(form[0]);
        if($(this).val() == '' || $(this).val() == null) return;
        
        $.ajax({
            url:"/images/upload/loopy",
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
                '<div class="prc_lopv" filename="'+origin_file+'" style="background-image:url(/images/loopy/'+origin_file+')">'+
                    '<button onclick=deleteImg("'+origin_file+'")>&times;</button>'+
                '</div>';
                $(".prc_v").append(tag);
            },
            error:function(error) {
                console.log(error);
            }
        })
    })
    $("#wk_img_file").change(function(){
        let form = $("#wk_form");
        let formData = new FormData(form[0]);
        if($(this).val() == '' || $(this).val() == null) return;
        
        $.ajax({
            url:"/images/upload/wonky",
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
                '<div class="prc_wk" filename="'+origin_file+'" style="background-image:url(/images/wonky/'+origin_file+')">'+
                    '<button onclick=deleteImg("'+origin_file+'")>&times;</button>'+
                '</div>';
                $(".m_img").append(tag);
            },
            error:function(error) {
                console.log(error);
            }
        })
    })
})
