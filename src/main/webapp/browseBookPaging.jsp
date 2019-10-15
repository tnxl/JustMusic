<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
>
<html>
<head>
    <title>网上零食店</title>
    <link href="css/bookstore.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="content">
    <div class="left">
        <div class="list_box">
            <div class="list_bk">
                <s:action name="browseCatalog" executeResult="true"/>
            </div>
        </div>
    </div>
    <div class="right">
        <ul>
            <s:iterator value="#request['books']" var="book">
                <li style="float: left;line-height:25px; padding: 15px">
                    <form action="addToCart.action" method="post">
						<input type="hidden" name="bookid" value="<s:property value="#book.bookid"/>">
                        <img src="picture/<s:property value="#book.picture"/>" width="200" height="200"style="padding-bottom: 15px"/><br>
						数量:<input type="text" name="quantity" value="1" size="4"/><br>
                        零食名:<s:property value="#book.bookname"/><br>
                        价格:<s:property value="#book.price"/>元 <br>
                            <%--						<img src="picture/buy.gif"/>--%>
                        <input type="image" name="submit" src="picture/buy.gif"style="padding-top: 10px"/>
                    </form>
                </li>
            </s:iterator>
        </ul>
        <div style="clear: both;"></div>
        <center>
            <s:set value="#request.pager" var="pager"/>
            <s:if test="#pager.hasFirst">
                <a href="browseBookPaging.action?currentPage=1">首页</a>
            </s:if>
            <s:if test="#pager.hasPrevious">
                <a href="browseBookPaging.action?currentPage=<s:property value="#pager.currentPage-1"/>">
                    上一页
                </a>
            </s:if>
            <s:if test="#pager.hasNext">
                <a href="browseBookPaging.action?currentPage=<s:property value="#pager.currentPage+1"/>">
                    下一页
                </a>
            </s:if>
            <s:if test="#pager.hasLast">
                <a href="browseBookPaging.action?currentPage=<s:property value="#pager.totalPage"/>">
                    尾页
                </a>
            </s:if>
            <br>当前第<s:property value="#pager.currentPage"/>页，总共<s:property value="#pager.totalPage"/>页
        </center>

    </div>
</div>
</div>
<jsp:include page="foot.jsp"/>
</body>
</html>
