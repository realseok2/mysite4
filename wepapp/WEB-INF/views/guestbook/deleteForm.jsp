<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteForm</title>
<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/guestbook.css" rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">

	<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		
		<!-- //header -->

		<c:import url="/WEB-INF/views/include/nav.jsp"></c:import>	
		
		<!-- //nav -->

		<c:import url="/WEB-INF/views/include/asideUser.jsp"></c:import>	
		
		<!-- //aside -->

		<div id="content">
		
		<c:import url="/WEB-INF/views/include/contentHead.jsp"></c:import>
            <!-- //content-head -->

			<div id="guestbook">
				<form action="${pageContext.request.contextPath }/guestbook/delete" method="get">
					<input type = "hidden" name = "no" value = ${no }>
					<table id="guestDelete">
						<colgroup>
							<col style="width: 10%;">
							<col style="width: 40%;">
							<col style="width: 25%;">
							<col style="width: 25%;">
						</colgroup>
						<tr>
							<td>Password</td>
							<td><input type="password" name="password"></td>
							<td class="text-left"><button type="submit">Delete</button></td>
							<td><a href="${pageContext.request.contextPath }/guestbook/addList">[ Main ]</a></td>
						</tr>
					</table>
				</form>
				
			</div>
			<!-- //guestbook -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>
