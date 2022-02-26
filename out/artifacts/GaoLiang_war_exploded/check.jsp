<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>专利辅助工具</title>
    <style>
        *{
            margin: 0px;
            padding: 0px;
        }

        body
        {
            height:3000px;
        }

        #zzjs_net_1{
            width:150px;
            height:150px;
            /*background-color:#eee;*/
            /*border:1px solid #ddd;*/
        }

        .div_master{
            /*border: 1px ;*/
        }

        .div_master_2{
            width: 60%;
            height: 90%;
            margin: 0 auto;
            margin-top: 20px;
            padding-left: 20%;
            /*border: 1px solid;*/
            /*text-align:center;*/
        }

    </style>
</head>
<head>
    <style type="text/css">
        *{font-family:"微软雅黑";font-size:16px;margin:0;padding:0;letter-spacing:3px;line-height:22px;}
        #wrap{width:500px;height:300px;margin:20px auto;position:relative;}
        #text{width:500px;height:300px;border:1px solid green;}
        #result{width:500px;position:absolute;left:0px;top:0px;display:none;}
        input{width:100px;height:40px;margin-top:5px;}
        span{background-color:yellow;}
        span2{background-color:deepskyblue;}
    </style>
</head>
<body>

<%--如果check变量是空的,代表 刚进入--%>
<c:if test="${empty wait_check_1 && empty wait_check_2}">
    <div style="margin:0 auto;height: 90%;width: 90%">
        <form action="/check" method="post">
            <div id="result" style=""></div>
            <textarea id="text" placeholder="检测文本" name="check_img"></textarea>
            &nbsp;&nbsp;&nbsp;
            <input type="submit" id="btnFind" value="辅助检测"/>&nbsp;&nbsp;&nbsp;
        </form>
    </div>
</c:if>

<%--第一次检查的结果显示--%>
<c:if test="${not empty wait_check_1}">
    <div class="div_master">
        <div class="div_master_2">
                ${wait_check_1}
        </div>
    </div>
    <script language="javascript" type="text/javascript">
        lastScrollY=0;
        function heartBeat(){
            var diffY;
            if (document.documentElement && document.documentElement.scrollTop)
                diffY = document.documentElement.scrollTop;
            else if (document.body)
                diffY = document.body.scrollTop
            else
            {/*Netscape stuff*/}
//alert(diffY);
            percent=.1*(diffY-lastScrollY);
            if(percent>0)percent=Math.ceil(percent);
            else percent=Math.floor(percent);
            document.getElementById("zzjs_net_1").style.top=parseInt(document.getElementById
            ("zzjs_net_1").style.top)+percent+"px";
            lastScrollY=lastScrollY+percent;
//alert(lastScrollY);
        }


        j1="<div id=\"zzjs_net_1\" style='left:2px;position:absolute;top:120px;'>"+
            "<div style='font-size:1px;color: blueviolet'></div>"+"<form action=\"/check_ing\" method=\"Post\">\n" +
            "<input type=\"submit\" id=\"btnFind\" value=\"下一步检测\"/>";

        document.write(j1);
        window.setInterval("heartBeat()",1);
    </script>
    <input type="hidden" name="ExPws" value="${wait_check}" />
    </form>

    <br>
    <script type="text/javascript">
        //判断是否为IE浏览器,这一步可以不要
        function isIe(){
            return ("ActiveXObject" in window);
        }
        //全局变量
        var words="检查连接关系是否颠倒!!如固定写成转动，转动写成固定";
        var  n=0;
        var flashing;
        var temp=[];


        document.write('<B><font size="12px" color="red">');    //输出html元素标签等内容
        //依次改变words的格式
        for(index=0;index<words.length;index++){  //将字符串拆分成字符单位处理

            document.write('<span2 id="neonLight" style="font-family:Verdana,Arial;font-size:20px;">'+words.charAt(index)+' </span2>');
        }

        document.write("</font></B>");   //输出html元素标签内容
        temp=document.getElementsByTagName("span2");

        //逐渐变色
        function neon(){
            //起始为红色
            if(n==0){
                for(i=0;i<temp.length;i++){
                    temp[i].style.color="black";
                }
            }

            //依次变为蓝色
            if(n<temp.length){
                temp[n].style.color="blue";
                n++;
            }else{  //变完回到初始状态
                n=0;
            }
        }

        //启动函数
        function beginNeon(){
            flashing=setInterval("neon()",100 ); //每隔1.5秒启动
        }
        beginNeon();
    </script>

</c:if>

<%--第二次检查的结果显示--%>
<c:if test="${not empty wait_check_2 }">
    <div class="div_master">
        <div class="div_master_2">
                ${wait_check_2}
        </div>
    </div>
    <script language="javascript" type="text/javascript">
        lastScrollY=0;
        function heartBeat(){
            var diffY;
            if (document.documentElement && document.documentElement.scrollTop)
                diffY = document.documentElement.scrollTop;
            else if (document.body)
                diffY = document.body.scrollTop
            else
            {/*Netscape stuff*/}
//alert(diffY);
            percent=.1*(diffY-lastScrollY);
            if(percent>0)percent=Math.ceil(percent);
            else percent=Math.floor(percent);
            document.getElementById("zzjs_net_1").style.top=parseInt(document.getElementById
            ("zzjs_net_1").style.top)+percent+"px";
            lastScrollY=lastScrollY+percent;
//alert(lastScrollY);
        }
        j1="<div id=\"zzjs_net_1\" style='left:2px;position:absolute;top:120px;'>"+
            "<div style='font-size:1px;color: blueviolet'></div>"+"<form action=\"/check.jsp\" method=\"post\">\n" +
            "<input type=\"submit\" id=\"btnFind\" value=\"重置\"/>" +
            "</form>"
        document.write(j1);
        window.setInterval("heartBeat()",1);
    </script>
    <br>
    <script type="text/javascript">
        //判断是否为IE浏览器,这一步可以不要
        function isIe(){
            return ("ActiveXObject" in window);
        }
        //全局变量
        var words="控制器、传感器是否写了型号，一些不常见的装置，是否写了型号，或者进一步描述了其结构";
        var  n=0;
        var flashing;
        var temp=[];


        document.write('<B><font size="12px" color="red">');    //输出html元素标签等内容
        //依次改变words的格式
        for(index=0;index<words.length;index++){  //将字符串拆分成字符单位处理

            document.write('<span2 id="neonLight" style="font-family:Verdana,Arial;font-size:20px;">'+words.charAt(index)+' </span2>');
        }

        document.write("</font></B>");   //输出html元素标签内容
        temp=document.getElementsByTagName("span2");

        //逐渐变色
        function neon(){
            //起始为红色
            if(n==0){
                for(i=0;i<temp.length;i++){
                    temp[i].style.color="black";
                }
            }

            //依次变为蓝色
            if(n<temp.length){
                temp[n].style.color="blue";
                n++;
            }else{  //变完回到初始状态
                n=0;
            }
        }

        //启动函数
        function beginNeon(){
            flashing=setInterval("neon()",100 ); //每隔1.5秒启动
        }
        beginNeon();
    </script>
</c:if>




</body>
</html>