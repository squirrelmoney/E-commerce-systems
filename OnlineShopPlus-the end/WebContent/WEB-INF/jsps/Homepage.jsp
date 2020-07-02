<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
 <c:set var="picPath" value="http://localhost:8083/Filesevice"></c:set>         
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>taobao jquery js lephy</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>

<body style="height:1000px;">
<c:set var="user" value="${sessionScope.user}"></c:set>
    <!--scroll-head-->
    <div class="scroll-head"></div>
    <!--top-->
    <div class="top-wrapper">
        <div class="top-info">
            <div class="top-left">
                <div data-toggle="arrowdown" id="arrow1" class="user-name">
                    <a href="#">402专场</a>
                    <span class="down-icon"></span>
                </div>
                <div data-toggle="arrowdown" id="arrow2" class="msg-info">
                    <i class="fa fa-envelope fa-gray"></i>
                    <a href="#">消息</a>
                    <span class="down-icon"></span>
                </div>
                <a class="a-float-left" href="#">岭南超市</a>              
            </div>
            <!--top-right-->
            <div class="top-right">
                <div data-toggle="arrowdown" id="arrow3" class="user-name">
                    <a href="${pageContext.request.contextPath}/rest/CustomerController/Customerdetails">我的信息</a>
                    <span class="down-icon"></span>
                </div>
                <div data-toggle="arrowdown" id="arrow4" class="user-name">
                    <i class="fa fa-shopping-cart fa-orange"></i>
                    <a href="${pageContext.request.contextPath}/CartController/Mycart.do">购物车</a>
                    <span class="down-icon"></span>
                </div>
                <div data-toggle="arrowdown" id="arrow5" class="user-name">
                    <i class="fa fa-star fa-gray"></i>
                    <a href="#">收藏夹</a>
                    <span class="down-icon"></span>
                </div>
                <a class="a-float-left" href="#">商品分类</a>
                <span class="vertical-line">|</span>
                <div data-toggle="arrowdown" id="arrow6" class="user-name">
                    <a href="#">卖家中心</a>
                    <span class="down-icon"></span>
                </div>
                <a class="a-float-left" href="#">联系客户</a>
                <div data-toggle="arrowdown" id="arrow7" class="user-name">
                    <i class="fa fa-list-ul fa-orange"></i>
                    <a href="#">网站导航</a>
                    <span class="down-icon"></span>
                </div>
                
            </div>
        </div>
    </div>

    <!--top-main-->
    <div class="top-main">

        <div class="search-wrapper">
            <div class="search-box">
                <div data-toggle="arrowdown" id="arrow8" class="search-toggle">
                    宝贝<span class="down-icon"></span>
                </div>
                <input class="search-in" type="text" placeholder=" 搜‘402专场’试试，典型糕副美">
                <input type="button" class="search-but" value="搜索">
                <div data-toggle="hidden-box" id="nav-box8" class="search-toggle-box">店铺</div>
            </div>
            <a class="a-float-left hight-search" href="#">高级<br/>搜索</a>
            <!--other-search-->
            <div class="other-search">
                <a href="#">女士凉鞋</a>
                <a href="#">男士T恤</a>
                <a href="#">连衣裙</a>
                <a href="#">时尚女包</a>
                <a href="#">女士T恤</a>
                <a href="#">雪纺衫</a>
                <a href="#">中老年女装</a>
                <a href="#">风衣</a>
                <a href="#">童装</a>
                <a href="#">孕妇装</a>
                <a href="#">运动套装</a>
                <a href="#">打底裤</a>
                <a href="#">蚊帐</a>
                <a href="#" class="more-other">更多<i class="fa fa-angle-right"></i></a>
            </div>
        </div>
    </div>
    <!--content-top-->
    <div class="content-top">
        <!--sidebar-->
        <div class="sidebar">
            <h3>商品服务分类</h3>
            <!--sidebar-info-->
            <div class="sidebar-info">
                <ul class="side-li">
                    <li class="s_1"><h3>服装内衣<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_2"><h3>鞋包配饰<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_3"><h3>运动户外<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_4"><h3>珠宝手表<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_5"><h3>手机数码<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_6"><h3>家电办公<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_7"><h3>护肤彩妆<span class="fa fa-angle-right fa-loc"></span></h3>v</li>
                    <li class="s_8"><h3>母婴用品<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_9"><h3>家纺居家<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_10"><h3>家具建材<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_11"><h3>美食特产<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_12"><h3>日用百货<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_13"><h3>汽车摩托<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_14"><h3>文化娱乐<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_15"><h3>本地生活<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_16"><h3>虚拟服务<span class="fa fa-angle-right fa-loc"></span></h3></li>
                </ul>

            </div>
        </div>
        <!--right-con-->
        <div class="right-con">
            <div class="nav">
                <a id="spe-a1" href="#">天狗</a>
                <a id="spe-a2" href="#">聚划算</a>
                <a id="spe-a3" href="#">二手</a>
                <span class="line-a">|</span>
                <a href="#">拍卖</a>
                <a href="#">岭南</a>
                <a href="#">电器城</a>
                <a href="#">Hitao粉妆</a>
                <a href="#">旅行</a>
                <a href="#">云手机</a>
                <a href="#">特色中国</a>
                <span class="keep-a" href="#"><a href="#">消费者保障</a></span>
            </div>
            <!--show-box-->
            <div class="show-box">
                <!--content-->
                <div class="content">
                    <ul class="imgBox">
                        <li><a href="#"><img src="${pageContext.request.contextPath}/img/111.jpg" height="400" width="600"></a></li>                      
                    </ul>

                    <div class="control to-left"><i class="fa fa-angle-left"></i></div>
                    <div class="control to-right"><i class="fa fa-angle-right"></i></div>
                </div>
               <a style="float: left" href="#"><img src="${pageContext.request.contextPath}/img/666.jpg" /></a>
                <!--content-down-->
                <div class="content-down">
                    <ul class="imgBox1">
                   
                        <li>
                            <a href="#"><img src="${pageContext.request.contextPath}/img/01.png" /></a>
                            <a href="#"><img src="${pageContext.request.contextPath}/img/02.jpg" /></a>
                            <a href="#"><img src="${pageContext.request.contextPath}/img/03.png" /></a>
                            <a href="#"><img src="${pageContext.request.contextPath}/img/04.png" /></a>
                        </li>
                      
                    </ul>

                   
                </div>
                <a style="float: left" href="#"><img src="${pageContext.request.contextPath}/img/15.jpg" /></a>
            </div>
            <div class="tlinks">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>
            <!--right-sidbar-->
            <div class="right-sidebar">
                <div class="info-box">
                    <ul class="tab-nav">
                        <li id="li-1" class="li-nav li-nav-hover li-border">公告</li>
                        <li id="li-2" class="li-nav">规则</li>
                        <li id="li-3" class="li-nav">论坛</li>
                        <li id="li-4" class="li-nav">安全</li>
                        <li style="border-right: none" id="li-5" class="li-nav">公益</li>
                    </ul>
                    <div id="box-1" style="display: block" class="hiddenBox">

                        <a href="#">岭南超市2014:开放多样性</a>
                        <a href="#">舌尖中国二季首尝</a>
                        <a href="#">402自建计费系统</a>
                        <a href="#">来往首届419宇宙节</a>
                    </div>
                    
                 
                </div>
                <!--user-info-->
                <div class="user-info">
                    <div class="gold-top">
                        <img width="62px" height="62px" src="${pageContext.request.contextPath}/img/user-head.jpg" />
                        <div class="inner-user">
                            <h3>Hi ${user.username }</h3>
                            <a class="get-gold" href="#"><span class="glods"></span><span class="get-money">领淘金币抵钱</span></a>
                            <a class="vip-home" href="#">会员俱乐部</a>
                        </div>
                    </div>
                    <!--login-->
                    <div class="login">
                  <%--   <c:set var="user" value="${sessionScope.user}"></c:set> --%>
                   <c:if test=""></c:if>
					<c:if test="${user.username!=null}">
					 <a class="login-btn" href="${pageContext.request.contextPath}/rest/LoginController/exit"><i class="fa fa-user fa-user-loc"></i>注销</a>
					</c:if>
                       <c:if test="${user.username==null}">
					<a class="login-btn" href="${pageContext.request.contextPath}/rest/LoginController/Loginuser"><i class="fa fa-user fa-user-loc"></i>登陆</a>
						<a class="login-btn free" href="${pageContext.request.contextPath}/rest/RegisterController/Register">免费注册</a>
						</c:if>
                        
                        
                        <a class="login-btn free" href="#">免费开店</a>
                    </div>
                </div>
                <!--service-->
                <div class="service">
                    <h3>便民服务</h3>
                    <div id="service-1" class="service-cell service-z">
                        <h5 class="service-i"><img src="${pageContext.request.contextPath}/img/phone.png" /></h5>
                        <h6>话费</h6>
                        <i class="fa fa-angle-down"></i>
                    </div>
                    <div id="service-2" class="service-cell service-z">
                        <h5 class="service-i"><img src="${pageContext.request.contextPath}/img/game.png" /></h5>
                        <h6>游戏</h6>
                        <i class="fa fa-angle-down"></i>
                    </div>
                    <div id="service-3" class="service-cell service-z">
                        <h5 class="service-i"><img src="${pageContext.request.contextPath}/img/plane.png" /></h5>
                        <h6>旅行</h6>
                        <i class="fa fa-angle-down"></i>
                    </div>
                    <div id="service-4" class="service-cell service-z">
                        <h5 class="service-i"><img src="${pageContext.request.contextPath}/img/save.png" /></h5>
                        <h6>保险</h6>
                        <i class="fa fa-angle-down"></i>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="${pageContext.request.contextPath}/img/18.png" /></h5>
                        <h6>彩票</h6>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="${pageContext.request.contextPath}/img/move.png" /></h5>
                        <h6>电影</h6>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="${pageContext.request.contextPath}/img/eat.png" /></h5>
                        <h6>点外卖</h6>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="${pageContext.request.contextPath}/img/money.png" /></h5>
                        <h6>理财</h6>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="${pageContext.request.contextPath}/img/book.png" /></h5>
                        <h6>电子书</h6>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="${pageContext.request.contextPath}/img/miusc.png" /></h5>
                        <h6>音乐</h6>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="${pageContext.request.contextPath}/img/bag.png" /></h5>
                        <h6>水电煤</h6>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="${pageContext.request.contextPath}/img/....png" /></h5>
                        <h6>请期待</h6>
                    </div>
                </div>
       


            </div>
        </div>
    </div>
    <!--main-->
    <div class="sub-nav">
        <input type="button" class="more-btn" value="更多"/>
        <!--sub-nav-cell-->
        <div class="sub-nav-cell">
            <h3 class="orange">主题市场</h3>
            <ul class="sub-nav-box">
                <li><a href="#">爱美女人</a></li>
                <li><a href="#">品质男人</a></li>              
                <li><a href="#">全球购</a></li>
                <li><a href="#">品牌街</a></li>
                <li><a href="#">汽车生活</a></li>
                <li><a href="#">花嫁新娘</a></li>
                <li><a href="#">孕婴童</a></li>
                <li><a href="#">同城便民</a></li>
                <li><a href="#">爱么装</a></li>
                <li><a href="#">运动户外</a></li>
                <li><a href="#">家用电器</a></li>
                <li><a href="#">狠爱</a></li>
                <li><a href="#">网络游戏</a></li>
                <li><a href="#">潮流设计</a></li>
              
            </ul>
        </div>
        <div class="sub-nav-cell">
            <h3 class="green-sp">特色购物</h3>
            <ul class="sub-nav-box sp">
                <li><a href="#">爱美女人</a></li>
                <li><a href="#">品质男人</a></li>
                
                <li><a href="#">全球购</a></li>
                <li><a href="#">品牌街</a></li>
                <li><a href="#">汽车生活</a></li>
                <li><a href="#">花嫁新娘</a></li>
                <li><a href="#">孕婴童</a></li>
                <li><a href="#">同城便民</a></li>
                <li><a href="#">爱么装</a></li>
                <li><a href="#">运动户外</a></li>
                <li><a href="#">家用电器</a></li>
                <li><a href="#">狠爱</a></li>
                <li><a href="#">网络游戏</a></li>
                <li><a href="#">潮流设计</a></li>
                

            </ul>
        </div>
        <div class="sub-nav-cell">
            <h3 class="red-now">当前热点</h3>
            <ul class="sub-nav-box now">
                <li><a href="#">爱美女人</a></li>
                <li><a href="#">品质男人</a></li>
                
                <li><a href="#">全球购</a></li>
                <li><a href="#">品牌街</a></li>
                <li><a href="#">汽车生活</a></li>
                <li><a href="#">花嫁新娘</a></li>
                <li><a href="#">孕婴童</a></li>
                <li><a href="#">同城便民</a></li>
                <li><a href="#">爱么装</a></li>
                <li><a href="#">运动户外</a></li>
                <li><a href="#">家用电器</a></li>
                <li><a href="#">狠爱</a></li>
                <li><a href="#">网络游戏</a></li>
                <li><a href="#">潮流设计</a></li>
                

            </ul>
        </div>
        <div class="sub-nav-cell">
            <h3 class="blue-more">更多精彩</h3>
            <ul class="sub-nav-box more">
                <li><a href="#">爱美女人</a></li>
                <li><a href="#">品质男人</a></li>
                
                <li><a href="#">全球购</a></li>
                <li><a href="#">品牌街</a></li>
                <li><a href="#">汽车生活</a></li>
                <li><a href="#">花嫁新娘</a></li>
                <li><a href="#">孕婴童</a></li>
                <li><a href="#">同城便民</a></li>
                <li><a href="#">爱么装</a></li>
                <li><a href="#">运动户外</a></li>
                <li><a href="#">家用电器</a></li>
                <li><a href="#">狠爱</a></li>
                <li><a href="#">网络游戏</a></li>
                <li><a href="#">潮流设计</a></li>
                
            </ul>
        </div>
    </div>
    <!--main-->
 <div class="main">
    
            <div class="main-title">
                <h1>万能的超市<span class="show-title">下面有更多个特色商品等你来逛哦！</span></h1>
            </div>
            
<c:forEach items="${list}" var="list"> 
    <div class="product-box">
                <div class="inner-info">                    
                    <div class="inner-left">
                    <img id='imgSize1ImgSrc' src='${picPath}${list.picture}'  height="100" width="100" />
                        
                        <h1></h1>
                        <td>${list.name}</td>
                    </div>
                    <div class="inner-right">                        
                           <td>价格：  ${list.price}</td>                  
                       <table class="tab-inner">                        
                            <tr><td>积分：${list.points}</td>                                                  
                       </table>
                         <div>
                            <h1>		 
                            <a href="${pageContext.request.contextPath}/CartController/insertMycart.do?cid=${list.cid}">增加到购物车</a> 
		                    <a href="${pageContext.request.contextPath}/MyOrderController/Myorder.do?cid=${list.cid}">购买</a>
                          </h1>
                        </div>
                 </div>
              </div>
     
</div>  
 </c:forEach> 


  
    <!--footer-->
    <div class="footer">
        <div class="footer-right">
            <div class="footer-nav">
                <a href="#">402集团</a>|
                <a href="#">402国际站</a>|
                <a href="#">402中国站</a>|
                <a href="#">全球速卖通</a>|
                <a href="#">岭南网</a>|
                <a href="#">天狗</a>|
                <a href="#">聚划算</a>|
        
            </div>
            <div class="about-tao">
                <a href="#">关于超市</a>
                <a href="#">合作伙伴</a>
                <a href="#">营销中心</a>
                <a href="#">廉正举报</a>
                <a href="#">联系客服</a>
                <a href="#">开放平台</a>
                <a href="#">诚征英才</a>
                <a href="#">联系我们</a>
                <a href="#">网站地图</a>
                <a href="#">法律声明</a>
                <span class="gary-text">&copy; 2020 lncs.com 版权所有</span>
            </div>
            <p class="gary-text"><span>网络文化经营许可证：文网文[2020]402号</span>|<span>增值电信业务经营许可证：湛江402402402</span>|<span>信息网络传播视听节目许可证：2020402号</span></p>
            <div class="some-info">
                <img src="${pageContext.request.contextPath}/img/some.png" />
            </div>
        </div>
        <div class="tao-man">
            <img src="${pageContext.request.contextPath}/img/tao-man.png" />
        </div>
    </div>
    <script src="js/jquery_1.9.js"></script>
    <script src="js/main.js"></script>
    <script src="js/img-show.js"></script>
</body>
</html>