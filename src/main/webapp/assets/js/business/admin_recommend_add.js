$(function () {
    $("#add_music").change(function () {
        let mu_file = $(this).val();
        let split = mu_file.split("\\");
        split = split[split.length - 1].split(".");
        let origin_file = split[0] + "." + split[1];
        console.log(origin_file);

        $.ajax({
            url: "/api/admin_recommend/music?filename=" + origin_file,
            type: "get",
            success: function (r) {
                alert(r.message);
                if(!r.status)return;
                let seq = r.seq;
                let tag =
                    '<div class="music_file_name" data-seq="'+seq+'">' + origin_file + '</div>';
                $(".add_music_area").append(tag);
            }
        })
    })



    $("#playlist_save").click(function () {
        if (!confirm("재생목록에 추가 하시겠습니까?")) return;

        let data = {
            ard_aa_seq: 1,
            ard_mu_seq:$(".music_file_name").attr("data-seq"),
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
})