(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
})(jQuery);

$(function(){
    const userid = $.getUrlParam("userid");
    if(userid!=null){
        $.getJSON("v1/info",{userid:userid},function(data){

            if(data.data == null){
                alert("用户编号不存在，生成主页失败");
                return;
            }
            let user = data.data.user;
            let skill = data.data.skill;
            let edus = new Array();
            edus.push(data.data.edu);
            let tempEdu = data.data.edu;
            while(tempEdu.next != null){
                edus.push(tempEdu.next);
                tempEdu.next = tempEdu.next.next;
            }

            let works = new Array();
            works.push(data.data.work);
            let tempWork = data.data.work;
            while(tempWork.next != null){
                works.push(tempWork.next);
                tempWork.next = tempWork.next.next;
            }

            let specialtys = new Array();
            specialtys.push(data.data.specialty);
            let tempSpecialty = data.data.specialty;
            while(tempSpecialty.next != null){
                specialtys.push(tempSpecialty.next);
                tempSpecialty = tempSpecialty.next;
            }
            console.log(edus);
            console.log(works);
            console.log(specialtys);
            changeUserText(user);
            changeUserAddr(user);
            changeSkill(skill);
            changeEdu(edus);
            changeWork(works);
            changeSpecialtys(specialtys);
        });
    }else{
        layer.msg("参数错误，请检查网址"+userid);
    }
});

function changeUserText(user){
    $(".user-name").text(user.name);
    $(".user-age").text(user.age);
    $(".user-city").text(user.city);
    $(".user-phone").text(user.phone);
    $(".user-email").text(user.email);
    $(".user-niuke").text(user.niuke);
    $(".user-address").text(user.address);
    $(".user-description").text(user.description);
}

function changeUserAddr(user){
    $(".user-name,.user-name-alt").attr("title",user.name);
    $(".user-CSDN-href").attr("href","https://blog.csdn.net/"+user.CSDN);
    $(".user-CSDN-href").attr("title",user.CSDN);
    $(".user-niuke-href").attr("href","https://www.nowcoder.com/profile/"+user.niuke);
    $(".user-niuke-href").attr("title",user.niuke);
    $(".user-github-href").attr("href","https://github.com/"+user.github);
    $(".user-github-href").attr("title",user.github);
    $("a.user-email").attr("href","mailto:"+user.email);
    $(".user-phone-href").attr("href","tel:"+user.phone);
    if(user.sex == null || user.sex == "nan"){
        $(".user-sex").attr("src","./source/u_files/img/main_photo.jpg");
    }else{
        $(".user-sex").attr("src","./source/u_files/img/main_photo2.jpg");
    }
}
function changeSpecialtys(specialtys){
    $(".specialty1-name").text(specialtys[0].name);
    $(".specialty1-description").text(specialtys[0].description);
    $(".specialty2-name").text(specialtys[1].name);
    $(".specialty2-description").text(specialtys[1].description);
    //src="./source/u_files/img/main_photo.jpg"

}
function changeSkill(skill){
    let skills = skill.keyWords.split(" ");
    for (let i=0;i<skills.length;i++) {
        let $li = $("<li>"+skills[i]+"</li>");
        $(".data-skill").append($li);
    }
}
function changeEdu(edus){
    for (let i=0;i<edus.length;i++){
        let $div = $("" +
            "                                        <div class=\"timeline-item clearfix\">\n" +
            "                                            <div class=\"left-part\"><h5 class=\"item-period\">"+edus[i].start+" <br>至<br> "+edus[i].end+"</h5><span\n" +
            "                                                    class=\"item-company\">"+edus[i].school+"</span></div>\n" +
            "                                            <div class=\"divider\"></div>\n" +
            "                                            <div class=\"right-part\"><h4 class=\"item-title\">"+edus[i].study+"</h4>\n" +
            "                                                <p>"+edus[i].description+"</p></div>\n" +
            "                                        </div>" +
            "");
        $(".data-edu").prepend($div);
    }
}
function changeWork(works){
    for(let i=0;i<works.length;i++){
        let $div = $("" +
            "                                        <div class=\"timeline-item clearfix\">\n" +
            "                                            <div class=\"left-part\"><h5 class=\"item-period\">"+works[i].start+" <br>至<br> "+works[i].end+"</h5><span\n" +
            "                                                    class=\"item-company\">"+works[i].company+"</span></div>\n" +
            "                                            <div class=\"divider\"></div>\n" +
            "                                            <div class=\"right-part\"><h4 class=\"item-title\">"+works[i].job+"</h4>\n" +
            "                                                <p>"+works[i].description+"</p></div>\n" +
            "                                        </div>" +
            "");
        $(".data-work").prepend($div);
    }
}