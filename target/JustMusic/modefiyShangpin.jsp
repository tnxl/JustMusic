<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Lsy
  Date: 2019/6/24
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加修改零食页面</title>
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
        <div class="right_box">
            零食
            <s:set var="item" value="#session.gequ['book']"/>
<%--            <s:iterator value="item">--%>
                <%--            <s:if test="#mod != null">--%>
                <form action="update.action">
                    <img src="picture/<s:property value='#item.picture'/>" alt=""><br>
                    <input type="hidden" value="<s:property value='#item.bookid'/>" name="bookid">
                    零食名：<input type="text" value="<s:property value='#item.bookname'/>" name="bookname"><br>
                    价格：&nbsp<input type="text" value="<s:property value='#item.price'/>" name="price"><br>
                    <input type="submit" value="提交修改">
                </form>
<%--            </s:iterator>--%>
            <%--            </s:if>--%>

            <%--            <s:set var="items" value="#session.items"/>--%>
            <%--            <s:if test="#items.size != 0">--%>
            <%--                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
            <%--                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
            <%--                <font color="blue"><h3>专辑列表</h3></font><br/>--%>
            <%--                <form action="updateCart.action" method="post">--%>
            <%--                    <table id="tb" cellSpacing="2" cellPadding="5" width="100%" align="center" border="0">--%>
            <%--                        <tr>--%>
            <%--                            <td bgcolor="#666666" align="center" width="50%" height="12">专辑名</td>--%>
            <%--                            <td bgcolor="#666666" align="center" width="15%" >定 价</td>--%>
            <%--                                &lt;%&ndash;                            <td bgcolor="#666666" align="center" width="15%">数 量</td>&ndash;%&gt;--%>
            <%--                            <td bgcolor="#666666" align="center" width="35%">--%>
            <%--                                <font color="gray">操 作</font>--%>
            <%--                            </td>--%>
            <%--                        </tr>--%>

            <%--                        <s:iterator value="#items">--%>
            <%--                            <tr>--%>
            <%--                                <td>--%>
            <%--                                    <s:property value="value.book.bookname"/>--%>
            <%--                                </td>--%>
            <%--                                <td>--%>
            <%--                                    <s:property value="value.book.price"/>--%>
            <%--                                </td>--%>
            <%--                                    &lt;%&ndash;                                <td>&ndash;%&gt;--%>
            <%--                                    &lt;%&ndash;                                    <input type="text" name="quantity" value="<s:property value="value.quantity"/>" size="4"/>&ndash;%&gt;--%>
            <%--                                    &lt;%&ndash;                                    <input type="hidden" name="bookid" value="<s:property value="value.book.bookid"/>"/>&ndash;%&gt;--%>
            <%--                                    &lt;%&ndash;                                </td>&ndash;%&gt;--%>
            <%--                                <td>--%>
            <%--                                    <input type="submit" value="更新"/>--%>
            <%--                                    <span><a href="delToCart.action?bookid=<s:property value='value.book.bookid'/>">删除</a></span>--%>
            <%--                                </td>--%>
            <%--                            </tr>--%>
            <%--                        </s:iterator>--%>

            <%--                    </table>--%>
            <%--                </form>--%>
            <%--                <hr/>--%>
            <%--                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
            <%--                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
            <%--                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
            <%--                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
            <%--                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
            <%--                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
            <%--                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
            <%--                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
            <%--                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
            <%--                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
            <%--                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
            <%--                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>

            <%--                &lt;%&ndash;    消费金额:<s:property value="#session.cart.totalPrice"/>元&nbsp;&nbsp;&nbsp;&ndash;%&gt;--%>
            <%--                &lt;%&ndash;    <a href="checkout.action"><img src="picture/count.gif"/></a>&ndash;%&gt;--%>
            <%--            </s:if>--%>
            <%--            <s:else>--%>
            <%--                对不起，暂时没有商品--%>
            <%--            </s:else>--%>
        </div>
    </div>
</div>
<jsp:include page="foot.jsp"/>

</body>
</html>
