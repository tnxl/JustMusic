<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Lsy
  Date: 2019/6/24
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理零食</title>
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
            <s:set var="items" value="#session.items"/>
            <s:if test="#items.size != 0">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <font color="blue"><h3>零食列表</h3></font><br/>
                    <table id="tb" cellSpacing="2" cellPadding="5" width="100%" align="center" border="0">
                        <tr>
                            <td bgcolor="#666666" align="center" width="50%" height="12">零食名</td>
                            <td bgcolor="#666666" align="center" width="15%" >定 价</td>
<%--                            <td bgcolor="#666666" align="center" width="15%">数 量</td>--%>
                            <td bgcolor="#666666" align="center" width="35%">
                                <font color="gray">操 作</font>
                            </td>
                        </tr>

                        <s:iterator value="#items">
                            <tr>
                                <td>
                                    <s:property value="value.book.bookname"/>
                                </td>
                                <td>
                                    <s:property value="value.book.price"/>
                                </td>
<%--                                <td>--%>
<%--                                    <input type="text" name="quantity" value="<s:property value="value.quantity"/>" size="4"/>--%>
<%--                                    <input type="hidden" name="bookid" value="<s:property value="value.book.bookid"/>"/>--%>
<%--                                </td>--%>
                                <td>
                                    <span><a href="modify.action?bookid=<s:property value='value.book.bookid'/>">修改</a></span>
                                    <span><a href="mod.action?bookid=<s:property value='value.book.bookid'/>">删除</a></span>
                                </td>
                            </tr>
                        </s:iterator>

    </table>
    <hr/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<%--    消费金额:<s:property value="#session.cart.totalPrice"/>元&nbsp;&nbsp;&nbsp;--%>
<%--    <a href="checkout.action"><img src="picture/count.gif"/></a>--%>
    </s:if>
    <s:else>
        对不起，暂时没有商品
    </s:else>
</div>
</div>
</div>
<jsp:include page="foot.jsp"/>

</body>
</html>
