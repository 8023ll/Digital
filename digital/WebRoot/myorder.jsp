<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>电子商城——我的订单页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/Layout.css" rel="stylesheet" type="text/css" />
	<SCRIPT type=text/javascript src="js/scrolltop.js"></SCRIPT>
	<SCRIPT type=text/javascript src="js/qq.js"></SCRIPT >

  </head>
  
  <body>
<!--顶部注册开始-->
	<div class="itop">
		<div class="itop_body">
			<div class="itop_left fl">欢迎光临好东东买卖网！</div>
			<div class="itop_right fl">
			 	
			 <s:if test="#session.CURRENT_USER==null">
		     	<span class="blue"><a href="login.jsp">[登录]</a></span>
		 	 	<span class="blue"><a href="reg.jsp">[注册]</a></span>		
		     </s:if>
		     <s:else>
		     	欢迎您：
		     	<span class="red">${sessionScope.CURRENT_USER.userName}</span>
		     	<span class="blue"><a href="logOut">[退出]</a></span>
		     	<span class="blue"><a href="toMyOrderInfo">[我的订单]</a></span>
		     </s:else> 	 
		 	 
		 	 <a href="cart.jsp">
		 	 	<span><img src="images/d002.jpg"/></span>&nbsp;
				<span>购物车 </span>
				<!-- <span class="red">5</span> 件  -->	
			 </a>
			</div>
		</div>
	</div>
	<div class="clearall"></div>
<!--顶部注册结束-->
<!--头部搜索开始-->
	<div class="header">
		<div class="logo fl"><img src="images/d001.jpg"/></div>
		<div class="search fl">
			<div class="search_from">
				<div><input name="" type="text" class="s_input fl"/></div>
				<div class="s_botton fl"><input type="image" src="images/002.jpg"/></div>
			</div>
			<div class="s_hot hui">热门搜索：笔记本 台式机 一体机 平板电脑 手机 打印机 </div>
		</div>
	</div>
<!--头部搜索结束-->
<!--菜单开始-->
	<div class="menu">
		<div class="menu_left fl">全部商品分类</div>
		<div class="menu_center fl">
			<div class="dh_topd"><A href="list">网站首页</A></div>
			<div class="dh_topd"><A href="index.jsp">购物流程</A></div>
			<div class="dh_topd"><A href="index.jsp">联系我们</A></div>
		</div>
	</div>
	<div class="clearall"></div>
<!--菜单结束-->

<!--主体开始-->
	<div class="main mt10">
		<div class="mleft fl ah">
		<!--订单开始-->
			<div class="car_a jiacu">您的订单有以下内容</div>
			<div class="car_b fl mt10">
				<p class="bh fl">订单编号</p>
				<p class="spmc fl">订单时间</p>
				<p class="dj fl">订单状态</p>
				<p class="sl fl">总额</p>
				<p class="je fl">明细</p>
				<p class="del fl">删除</p>
			</div>
			
			<s:set var="total" value="0"/>
			<s:iterator id="myOrder" value="#request.myOrderInfoList">
				<div class="car_c fl">
					<p class="bh fl"><s:property value="id"/></p>
					<p class="spmc fl"><s:property value="ordertime"/></p>
					<p class="dj fl"><s:property value="status"/></p>
					<p class="sl fl"><s:property value="orderprice"/></p>
					<p class="je fl"><a href="toOrderDetail?id=${id }">查看</a></p>
					<p class="del fl">
						<s:if test="#myOrder.status=='未处理'">
							<a href="deleteOrderInfo?id=${id }">删除</a>
						</s:if>
					</p>
				</div>
				<s:set var="total" value="#total+orderprice"></s:set>
			</s:iterator>	
			<div class="car_c fl">
					<p class="bh fl">1</p>
					<p class="spmc fl">2016-08-20 21:28:19.0</p>
					<p class="dj fl">未处理</p>
					<p class="sl fl">9084.0</p>
					<p class="je fl"><a href="myorderdetail.jsp">查看</a></p>
					<p class="del fl">
						
							<a href="deleteOrderInfo?id=1">删除</a>
						
					</p>
				</div>
			
			<div class="car_c fl" style="background-color:#ccccee;">
				<p class="bh fl">-</p>
				<p class="spmc fl">合计</p>
				<p class="dj fl">-</p>
				<p class="sl fl">￥9084.<s:property value="#total"/> </p>
				<p class="je fl">-</p>
				<p class="del fl">-</p>
			</div>
			

				
			
		<!-- 
			<div class="car_d fl">
				<p class="cz fl"><a href="clearCart"><img src="images/d014.jpg"/></a></p>
				<p class="cz fl"><a href="list"><img src="images/d015.jpg"/></a></p>
				<p class="cz fl"><a href="addOrderInfo"><img src="images/d016.jpg"/></a></p>
			</div>
		 -->
		<!-- 订单结束-->
		</div>
		<div class="mright fl">
			<!-- 浏览排行榜开始 -->
			<div class="mright_b mt10">
				<p class="tit">浏览排行榜</p>
				<div class="con">
				  	<s:iterator id="browsePiItem" value="#session.browsePiList" status="status">
					  <s:if test="#status.index==1">
						<div class="conshow">
							<p class="img fl">
							<img height='50px' width='65px' src="product_images/${browsePiItem.pic }"/></p>
							<p class="content fl">${browsePiItem.name }</p>
						</div>
				      </s:if>
					  <s:if test="#status.index>1 && #status.index<13 ">
						<p class="paihang">${browsePiItem.name }</p>		
					  </s:if>		
	
					</s:iterator>			  
				</div>
			</div>
			<!-- 浏览排行榜结束 -->
			<!-- 销量排行榜开始 -->
			<div class="mright_a">
				<p class="tit">销量排行榜</p>
				<div class="con"> 
					<div class="conshow">
						<p class="img fl"><img src="images/d007.jpg"/></p>
						<p class="content fl">笔记本电脑/联想S200</p>
					</div>
					<p class="paihang">笔记本电脑/联想S200</p>
					<p class="paihang">笔记本电脑/联想S230</p>
					<p class="paihang">笔记本电脑/联想S400</p>
	
				</div>
			</div>
			<!-- 销量排行榜结束 -->
		</div>
	</div>

<!--主体结束-->


<!--尾部开始-->
	<div class="end">地址：江苏省盐城市亭湖区大庆中路100号电话：0515-88888888邮箱：dongdi@yaohoo.com.cn邮编：224000<br />
		版权所有：苏州同凯信息有限公司　技术支持：0515-99999999</div>
	<!--尾部结束-->
	<DIV style="DISPLAY: none;POSITION: fixed; TEXT-ALIGN: center; LINE-HEIGHT: 30px; WIDTH: 30px; BOTTOM: 100px; HEIGHT: 33px; FONT-SIZE: 12px; CURSOR: pointer; RIGHT: 0px; _position: absolute; _right: auto" id=goTopBtn><IMG border=0 src="images/lanren_top.jpg"></DIV>
	<SCRIPT type=text/javascript>goTopEx();</SCRIPT>

  </body>
</html>
