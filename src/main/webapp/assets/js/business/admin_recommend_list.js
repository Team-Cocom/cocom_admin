$(function () {
    $("#playlist_popup_open").click(function(){
        $(".admin_playlist_popup_wrap").show();
    })
    $("#cancel_playlist").click(function(){
        $(".admin_playlist_popup_wrap").hide();
        $("#add_music").val("");
    })

    $("#playlist_save").click(function () {
        if (!confirm("재생목록에 추가 하시겠습니까?")) return;
        let data = {
            ard_aa_seq: 1,
            ard_mu_seq:$("#add_music").attr("data-seq"),
            ard_title: $("#ard_title").val(),
            ard_ab_seq: 1
        }

        $.ajax({
            url: "/api/admin_recommend/add",
            type: "put",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (r) {
                alert(r.message);
                location.reload();
            }
        })
    })
    $("#add_music").click(function(){
        $(".music_search_popup").show();
        getMusicList('','');
    })
    $("#music_search_button").click(function(){
        let music_keyword = $("#music_search_keyword").val();
        getMusicList(music_keyword,1);
    })
})

function getMusicList(keyword, page){
    $.ajax({
        url:"/api/admin_recommend/music_list?keyword="+keyword+"&page="+page,
        type:"get",
        success:function(r){
            $(".music_search_list tbody").html("");
            for(let i=0; i<r.list.length; i++) {
                let tag = 
                '<tr>'+
                    '<td>'+
                        '<img width="60" src="/images/music_cover/'+r.list[i].mu_img_file+'">'+
                    '</td>'+
                    '<td>'+r.list[i].mu_name+'</td>'+
                    '<td>'+r.list[i].gr_name+'</td>'+
                    '<td hidden>'+r.list[i].mu_music_file+'</td>'+
                    '<td>'+
                        '<button class="music_select" data-seq="'+r.list[i].mu_seq+'" data-name="'+r.list[i].mu_name+'">선택</button>'+
                    '</td>'+
                '</tr>';
                $(".music_search_list tbody").append(tag);
            }
            $(".music_search_pager_area").html("");
            for(let i=0; i<r.pageCount; i++) {
                let tag = '<button class="music_pager">'+(i+1)+'</button>'
                $(".music_search_pager_area").append(tag);
            }
            $(".music_pager").click(function(){
                let page = $(this).html();
                getMusicList(music_keyword,page);
            })

            $(".music_select").click(function(){
                let name = $(this).attr("data-name");
                let seq = $(this).attr("data-seq");
                $("#add_music").val(name);
                $("#add_music").attr("data-seq", seq);
                $(".music_search_popup").hide();

                music_keyword="";
                $("#music_search_keyword").val("");

                $(".music_search_popup").hide();
            })
        }
    })
}