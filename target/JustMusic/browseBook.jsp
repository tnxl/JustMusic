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
        <div class="right_box">
            <table width="600" border="0">
                <s:iterator value="#request['books']" var="book">
                    <tr>
                        <td width="200" align="center">
                            <img src="picture/<s:property value="#book.picture"/>" width="150"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top" width="450">
                    <tr>
                        <td>
                            零食名:<s:property value="#book.bookname"/><br>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            价格:<s:property value="#book.price"/>元
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <img src="picture/buy.gif"/>
                        </td>
                    </tr>
                </s:iterator>
            </table>

        </div>
    </div>
</div>
<jsp:include page="foot.jsp"/>
</body>
</html>
