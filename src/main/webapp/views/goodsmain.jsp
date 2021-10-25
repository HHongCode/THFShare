<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.wlxy.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
    <style type="text/css"> <!--页面样式定义-->
        /* Border styles */
    .title{
        width:100%; height: 40px;
    }

    .sysmenu{
        width:100%; height: 40px;
        border-bottom: #0033FF 1px solid;
        background: #0033FF;
    }
    .sysmenu a{
        color:#fff;
    }

    .sysmenu span{
        color:#fff;
    }
    #table-1{
        width:85%;
        margin-top:10px;
    }
    .s1{
        width:200px;
    }
    .s2{
        font-size: 24px;
        color:#3333CC;
        font-weight: 600;
        width:400px;
    }
    .s3{
        font-size: 14px;
        font-weight: 400;
        color:#575757;
    }
    .s4{
        font-size: 14px;
        font-weight: 400;
        color:#009ACD;
    }
    .s5{
        font-size: 24px;
        font-weight: 400;
        color: #EE7621;
        padding:20px;
    }
    .editbox{
        background: #ffffff;
        border: 1px solid #b7b7b7;
        color: #003366;
        cursor: text;
        font-family: "arial";
        font-size: 11pt;
        width:300px;
        height: 24px;
        padding: 3px;
        border-radius: 5px 5px 5px 5px;
        margin-top:3px;
        margin-bottom:3px;
    }

    .greenbuttoncss {
        font-family: "tahoma", "宋体"; /*www.52css.com*/
        font-size: 11pt; color: #ffffff;
        border: 0px #93bee2 solid;
        background-color:#009393;
        cursor: hand;
        font-style: normal ;
        width:80px;
        height:30px;
        border-radius: 5px 5px 5px 5px;
    }
    </style>
</head>
<body>
<center>
    <div class="title">
        <div style="float:left; margin-left:20px;line-height:30px;">
            <span style="font-size:28px; color:#FF7F00; font-style: italic;font-weight: 800;" >校园物品共享网</span>
        </div>
    </div>
    <div class="sysmenu" style="clear:both">  <!--系统菜单-->
        <div style="float:left; margin-left:20px;margin-top:5px">
            <a style="font-size:24px;text-decoration:none;" href="goodsmain.jsp">首页</a>
        </div>
        <div style="float:right; margin-right:20px; margin-top:10px">
            <span style="margin-left:20px;margin-right:20px; color:#FF8C00" >当前网站访问人数：10人</span>
            <span>|</span>
            <span style="margin-left:20px;color:#FF8C00 ">您好，${loginuser.username}</span>

            <c:if test="${loginuser!=null&&loginuser.utid==1}"> <!--管理员登录-->
                <a style="text-decoration:none; margin-left:20px;" href="hotelmanage.html" title="">我的物品</a>
                <a style="text-decoration:none; margin-left:20px;" href="addnormalmember.html" title="">我的信息</a>
                <a style="text-decoration:none; margin-left:20px;" href="../user/logout" title="">退出登录</a>
            </c:if>
            <c:if test="${loginuser!=null&&loginuser.utid==2}">
                <a style="text-decoration:none; margin-left:20px;" href="userbookinginfo.html" title="">我的订单</a>
                <a style="text-decoration:none; margin-left:20px;" href="addnormalmember.html" title="">我的信息</a>
                <a style="text-decoration:none; margin-left:20px;" href="../user/logout" title="">退出登录</a>
            </c:if>
            <c:if test="${loginuser==null}">
                <a style="text-decoration:none; margin-left:20px;" href="addnormalmember.html" title="">普通会员注册</a>
                <a style="text-decoration:none; margin-left:20px;" href="addhotelmember.html" title="">管理员注册</a>
                <a style="text-decoration:none; margin-left:20px;" href="../views/login.jsp" title="">登录</a>
            </c:if>
        </div>
    </div>
    <!--查询框栏-->
    <div style="width:85%;height:30px;margin:10px auto">
        <form action="index">
            地点：<input class="editbox" type="text" name="position"></input>
            物品名称：<input class="editbox" type="text" name="goodsname"></input>
            <button class="greenbuttoncss" type="submit">查询</button>
        </form>
    </div>
    <!--物品信息-->
    <div style="margin-top:5px;width:85%;border:0.5px solid #CCC"></div>
    <table id="table-1">
        <tbody class="body">
        <c:forEach items="${goodslist}"  var="obj">
        <tr>
            <td class="s1" >
                <a href="hotelinfo.html"><img style="width:280px;height:180px;border-radius:5px"
                                              src="../upload/${obj.photourl}"></a>
            </td>
            <td style="width:600px;">
                <table style="width:100%; height:180px; margin-left:10px">
                    <tr>
                        <td class="s2">
                            <a href="goodsinfo.html" style="text-decoration:none">${obj.goodsname}</a>
                        </td>
                    </tr>
                    <tr>
                        <td class="s3">地点：${obj.detailaddr}</td>
                    </tr>
                    <tr>
                        <td class="s4">描述：${obj.desciption}</td>
                    </tr>
                    <tr>
                        <td class="s4">意向：${obj.intention}</td>
                    </tr>
                </table>
            </td>
<%--            <td valign="top" align="right" class="s5">--%>
<%--                <span style="font-size:12px;">￥</span><span>0</span><span style="font-size:16px;">元起</span>--%>
<%--            </td>--%>
        </tr>
        <tr>
            <td colspan="3"><div style="width:100%;border:0.5px solid #CCC"></div></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

</center>
</body>
</html>
