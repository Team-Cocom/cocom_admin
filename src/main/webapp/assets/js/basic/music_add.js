$(function(){
    $("#music_cover_img").change(function(){
        let form = $("#cover_img_form");
        let formData = new FormData(form[0]);
        if($(this).val()==''||$(this).val() == null) return;

        $.ajax({
                url:"/images/upload/music_cover",
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
                '<div class="music_img" data-name="'+origin_file+'">'+
                '<img src="/images/music_cover/'+origin_file+'">'+
                '<button onclick=deleteImg("'+origin_file+'")>&times;</button>'
                '</div>';

                $(".cover_img_area").append(tag);
            }
        })
    })
    $("#music_file").change(function(){
        let form = $("#music_file_form");
        let formData = new FormData(form[0]);
        if($(this).val()==''||$(this).val() == null) return;

        $.ajax({
                url:"/music/upload/music",
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
                '<audio controls class="music_file" data-name="'+origin_file+'">'+
                    '<source src="/images/music/'+origin_file+'" type="audio/mp3">'+
                '</audio>'+
                '<button onclick=deleteImg("'+origin_file+'")>&times;</button>';

                $(".music_file_area").append(tag);
            }
        })
    })
    


    $("#add_music").click(function(){
        if(!confirm("노래 정보를 추가하시겠습니까?")) return;
        let data = {
            mu_name:$("#mu_name").val(),
            mu_ai_seq:1,
            mu_img_file:$(".music_img").attr("data-name"),
            mu_ab_seq:$('#ab_seq option:selected').val(),
            mu_music_file:$(".music_file").attr("data-name"),
            mu_age:$("#mu_age option:selected").val(),
            mu_lyrics:$("#mu_lylic").val(),
            mu_explain_txt:$("#mu_explain").val(),
            mu_playtime:$("#mu_playtime").val()
        }
        console.log(data);

        $.ajax({
            url:"/api/music/add",
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
