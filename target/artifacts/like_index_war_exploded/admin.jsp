<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%String path=request.getContextPath(); %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>查询</title>
    <style type="text/css">
        html,body{
            text-align: center;
            height: 100%;
            width: 100%;margin: 0;
            padding:0;
            overflow: hidden;
        }
        .sec-input-box{
            position: relative;
            top:30%;
            margin-top:-20px;
        }
        .sec-input{
            width: 531px !important;
            padding: 10px 40px 10px 10px;
            height: 22px;
            border: 1px solid rgba(0,0,0,.25);
            border: 1px solid #ddd\9;
            font-size: 16px;
            color: #333;
            border-top-left-radius: 2px;
            border-top-right-radius: 0;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 2px;
            border-right: 0;
            vertical-align: top;
            outline: 0;
            box-shadow: none;
            position: relative;
            z-index: 3;
            -webkit-appearance: none;
            position: relative;
        }
        .sec-input:hover {
            border: 1px solid rgba(0,0,0,.4);
            border-right:0;
        }
        .sec-input:focus {
            border-color:#fd6853;
        }
        .sec-input-box .enter-input input {
            width: 74px;
            height: 45px;
            border: 0;
            outline: 0;
            position: relative;
            top:-1px;
            box-shadow: none;
            background: #fd6853;
            vertical-align: top;
            cursor: pointer;
            border-top-left-radius: 0;
            border-top-right-radius: 2px;
            border-bottom-right-radius: 2px;
            border-bottom-left-radius: 0;
            line-height: 44px;
            text-align: center;
            font-size: 33px;
            color: #fff;
            background: #fd6853 url('<%=path%>/ico_spy.png') 29px -9px no-repeat;
            -webkit-transition: all .25s;
            -moz-transition: all .25s;
            transition: all .25s;
        }
        .suggestion {
            padding-top: 5px;
            top: 43px;
            left: 0px;
            display: block;
            position: absolute;
            width: 654px;
            border: 1px solid #e8e8e8;
            -moz-box-shadow: 0px 1px 8px rgba(0,0,0,0.1);
            -webkit-box-shadow: 0px 1px 8px rgba(0,0,0,0.1);
            box-shadow: 0px 1px 8px rgba(0,0,0,0.1);
            border-top-left-radius: 0px;
            border-top-right-radius: 0px;
            border-bottom-right-radius: 2px;
            border-bottom-left-radius: 2px;
            display: none;
        }
        .suglist {
            display: block;
            margin:0;
            padding: 0;
            width: 100%;
            list-style: none;
            font-size: 14px;
            line-height: 28px;
            float: left;
            overflow: hidden;
        }
        .suglist li {
            text-align: left;
            padding: 0 9px;
            cursor: pointer;
            zoom: 1;
            position: relative;
            white-space: nowrap;
            overflow: hidden;
            -ms-text-overflow: ellipsis;
            text-overflow: ellipsis;
            word-wrap: normal;
            -ms-word-break: normal;
            word-break: normal;
            line-height: 28px;
        }
        .suglist li:hover{
            background: #f3f3f3;
        }
        .sug-history {
            width: 100%;
            background: #fff;
            text-align: right;
            height: 28px;
            float: left;
            line-height: 28px;
            border-top: 1px solid #f3f3f3;
            color: #e4e4e4;
        }
        .sug-history a{
            color: #777;
            margin-right: 10px
        }
        .sug-history a:hover {
            text-decoration: underline;
        }
        suggestion.min.v.2.css:1
        .suggestion a:visited {
            color: #741274;
        }
        suggestion.min.v.2.css:1
        .sug-history a {
            color: #777;
            text-decoration: none;
        }
        suggestion.min.v.2.css:1
        .suggestion a {
            outline: 0;
        }
        suggestion.min.v.2.css:1
        .suggestion * {
            zoom: 1;
        }
    </style>
</head>
<body>

  <h1>搜索提示</h1>  <span class="sec-input-box">
            <input type="text" class="sec-input" name="query" id="query" maxlength="100" autocomplete="off">
			<span class="enter-input"><input type="submit" value="" id="stb"></span>
	            <div class="suggestion nobg" id="vl">
                    <div class="suginner">
                        <ul id="suglist" class="suglist">

                        </ul>
                        <div class="sugc" id="sugc" style="display: none;"></div>
                    </div>
                    <div class="sug-history" style="display: block;"><a href="javascript:void(0)" id="clear-history">清空历史</a></div>
                </div>
        </span>

<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
    var $vl = $("#vl");
    var $suglist = $("#suglist");
    $("#query").on("keyup",function(){
        if(!this.value){
            $vl.hide();
        }else{
            $.getJSON("like?limit=20&word="+$("#query").val(),function(data){
                $suglist.empty();
                if(data){
                    for (var i = 0; i < data.length; i++) {
                        $suglist.append('<li>'+data[i]+'</li>')
//                        $suglist.append('<li>'+data[i].name+'</li>')
                    }
                    $vl.show();
                }else{
                    $vl.hide();
                }
            });
        }
    });
    $suglist.on("click","li",function(){
        $("#query").val($(this).text())
        $vl.hide();
    })
</script>
</body>
</html>