<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
>
<html>
<head>
	<title>零食购买系统</title>
	<link href="css/bookstore.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<ul class=point02>
		<li>
			<strong>零食分类</strong>
		</li>
		<s:iterator value="#request['catalogs']" var="catalog">
			<li>
				<a href="browseBookPaging.action?currentPage=1&&catalogid=<s:property value="#catalog.catalogid"/>"target=_self>
					<s:property value="#catalog.catalogname"/>
				</a>
			</li>
		</s:iterator>
	</ul>
</body>
</html>