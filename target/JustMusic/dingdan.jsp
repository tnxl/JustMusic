<%--
  Created by IntelliJ IDEA.
  User: Lsy
  Date: 2019/6/24
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>订单</title>
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
        <s:set var="items" value="#session.cart.items"/>
        <s:if test="#items.size != 0">
            <font color="#7fffd4">订单</font>
            <form action="updateCart.action" method="post">
                <table id="tb" cellSpacing="2" cellPadding="5" width="95%" align="center" border="0">
                    <tr>
                        <td bgcolor="#666666" align="center" width="50%" height="12">零食名</td>
                        <td bgcolor="#666666" align="center" width="15%">定 价</td>
                        <td bgcolor="#666666" align="center" width="15%">数 量</td>
                            <%--                <td bgcolor="#666666" align="center" width="20%">--%>
                            <%--                    <font color="gray">操 作</font>--%>
                            <%--                </td>--%>
                    </tr>
                    <s:iterator value="#items">
                        <tr>
                            <td>
                                <s:property value="value.book.bookname"/>
                            </td>
                            <td>
                                <s:property value="value.book.price"/>
                            </td>
                            <td>
                                <input disabled type="text" name="quantity" value="<s:property value="value.quantity"/>"
                                       size="4"/>
                                <input type="hidden" name="bookid" value="<s:property value="value.book.bookid"/>"/>
                            </td>
                                <%--                <td>--%>
                                <%--                    <input type="submit" value="更新"/>--%>
                                <%--                </td>--%>
                        </tr>
                    </s:iterator>
                </table>
            </form>
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

            消费金额:<s:property value="#session.cart.totalPrice"/>元&nbsp;&nbsp;&nbsp;
        </s:if>
        <s:else>
            对不起，您还没有选购零食！
        </s:else>
    </div>
</div>

<jsp:include page="foot.jsp"/>
</body>
</html>
