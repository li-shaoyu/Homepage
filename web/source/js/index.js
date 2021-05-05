
const v1 = new Vue({
    el:"#main",
    data:{
        title:"正在生成主页...",
        result:"",
        edus:new Array(),
        works:new Array(),
        user:{
            id:0,
            name:"",
            age:"",
            city:"",
            address:"",
            email:"",
            phone:"",
            weixin:"",
            qq:"",
            weibo:"",
            sex:"",
            description:""
        },
        edu:{
            id:0,
            start:"",
            end:"",
            school:"",
            study:"",
            description:""
        },
        work:{
            id:0,
            start:"",
            end:"",
            company:"",
            job:"",
            description:""
        },
        skill:{
            id:0,
            keywords:""
        },
        specialty1:{
            id:0,
            name:"",
            description:""
        },
        specialty2:{
            id:0,
            name:"",
            description:""
        },
        count:0
    },
    methods:{
        nan:function(){this.user.sex="nan";},nv:function(){this.user.sex = "nv";},
        userClick:function(){
            //提交用户信息
            //赋值id
            let index = layer.msg("生成用户基本信息中...",{icon:16});
            this.$http.post("v1/user/insert",v1.user,{"emulateJSON":true}).then(function(res){
                console.log(res.body);
                v1.user.id=res.body.data;
                layer.close(index);
                layer.msg("用户生成成功");
            },function(res){
                alert(res.statusText);
                layer.close(index);
                layer.msg("用户生成失败");
            });
        },
        saveWork:function(){
            //录入userid
            v1.work.userid = v1.user.id;
            // 存储工作信息到works
            v1.works.push(Object.assign({}, v1.work));
            v1.work.id=0;
            v1.work.start="";
            v1.work.end="";
            v1.work.company="";
            v1.work.job="";
            v1.work.description="";
        },

        backWork:function(){

            v1.works = new Array();
        },

        saveEdu:function(){
            //录入userid
            v1.edu.userid = v1.user.id;
            //存储学习信息到edus
            v1.edus.push(Object.assign({}, v1.edu));
            v1.edu.description="";
            v1.edu.end="";
            v1.edu.id=0;
            v1.edu.school="";
            v1.edu.start="";
            v1.edu.study="";
        },
        backEdu:function(){
            v1.edus = new Array();
        },

        workClick:function(){
            //录入userid
            v1.work.userid = v1.user.id;
            // 存储工作信息到works
            v1.works.push(Object.assign({}, v1.work));
        },
        eduClick:function(){
            //录入userid
            v1.edu.userid = v1.user.id;
            //存储学习信息到edus
            v1.edus.push(Object.assign({}, v1.edu));
        },
        skillClick:function(){
            //录入userid
            v1.skill.userid=v1.user.id;
        },
        submitClick:function(){
            //录入specialty1和specialty2的userid
            v1.specialty1.userid=v1.user.id;
            v1.specialty2.userid=v1.user.id;
            //依次提交数据
            let x1 = 0;
            for(i=0;i<v1.edus.length;i++){
                v1.result = "提交学习经历中...";
                this.$http.post("v1/edu/insert",v1.edus[i],{"emulateJSON":true}).then(function(res){
                    console.log(res.body);
                    console.log("i="+i);
                    console.log("v1.edus.length="+v1.edus.length);
                    if(x1==0){
                        x1++;
                        v1.result = "提交工作经历中...";
                        //提交工作经历
                        for(i=0;i<v1.works.length;i++){
                            this.$http.post("v1/work/insert",v1.works[i],{"emulateJSON":true}).then(function(res){
                                console.log(res.body);
                                console.log("i="+i);
                                console.log("v1.works.length="+v1.works.length);
                                if(x1 == 1){
                                    x1++;


                                    //提交技能列表
                                    v1.result = "提交技能列表中...";
                                    this.$http.post("v1/skill/insert",v1.skill,{"emulateJSON":true}).then(function(res){
                                        console.log(res.body);
                                        v1.result = "提交特长中...";

                                        this.$http.post("v1/specialty/insert",v1.specialty1,{"emulateJSON":true}).then(function(res){
                                            console.log(res.body);
                                            v1.count++;
                                            if(v1.count == 2){
                                                v1.title = "生成成功：";
                                                v1.result = "访问地址：<a href='u.html?userid="+v1.user.id+"'>点击访问</a>"
                                            }
                                        },function(res){
                                            alert(res.statusText);
                                            v1.result = "提交特长一失败";
                                        });

                                        //提交特长二

                                        this.$http.post("v1/specialty/insert",v1.specialty2,{"emulateJSON":true}).then(function(res){
                                            console.log(res.body);
                                            v1.count++;
                                            if(v1.count == 2){
                                                v1.title = "生成成功：";
                                                v1.result = "访问地址：<a href='u.html?userid="+v1.user.id+"'>点击访问</a>"
                                            }

                                        },function(res){
                                            alert(res.statusText);
                                            layer.close(index);
                                            v1.result = "提交特长二失败";
                                        });
                                    },function(res){
                                        alert(res.statusText);
                                        v1.result = "提交技能列表失败";
                                    });
                                }
                            },function(res){
                                alert(res.statusText);
                                v1.result = "提交工作经历失败";
                            });
                        }
                    }
                },function(res){
                    alert(res.statusText);
                    v1.result = "提交学习经历失败";
                });
            }

        }
    }
});