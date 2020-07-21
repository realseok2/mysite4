<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddList</title>
<link href="${pageContext.request.contextPath }/assets/css/mysite.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath }/assets/css/guestbook.css"
	rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<!-- //header -->

		<c:import url="/WEB-INF/views/include/nav.jsp"></c:import>

		<!-- //nav -->

		<c:import url="/WEB-INF/views/include/guestbookAside.jsp"></c:import>

		<!-- //aside -->

		<div id="content">

			<div id="content-head">
				<h3>Normal</h3>
				<div id="location">
					<ul>
						<li>Main</li>
						<li>Guestbook</li>
						<li class="last">Normal</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>

			<!-- //content-head -->

			<div id="guestbook">
				<form action="${pageContext.request.contextPath }/guestbook/add"
					method="get">
					<table id="guestAdd">
						<colgroup>
							<col style="width: 70px;">
							<col>
							<col style="width: 70px;">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th><label class="form-text" for="input-uname">Name</label></th>
								<td><input id="input-uname" type="text" name="name"></td>
								<th><label class="form-text" for="input-pass">Password</label></th>
								<td><input id="input-pass" type="password" name="password"></td>
							</tr>
							<tr>
								<td colspan="4"><textarea name="content" cols="72" rows="5"></textarea></td>
							</tr>
							<tr class="button-area">
								<td colspan="4"><button type="submit">Submit</button></td>
							</tr>
						</tbody>

					</table>
					<!-- //guestWrite -->
					<input type="hidden" name="action" value="add">

				</form>

				<c:forEach items="${gList}" var="guestbookVo">

					<table class="guestRead">
						<colgroup>
							<col style="width: 10%;">
							<col style="width: 35%;">
							<col style="width: 35%;">
							<col style="width: 10%;">
							<col style="width: 10%;">
						</colgroup>
						<tr>
							<td>${guestbookVo.no }</td>
							<td>${guestbookVo.name }</td>
							<td>${guestbookVo.date }</td>
							<td><a
								href="${pageContext.request.contextPath }/guestbook/updateForm/${guestbookVo.no }">[
									Update ]</a></td>
							<td><a
								href="${pageContext.request.contextPath }/guestbook/deleteForm/${guestbookVo.no }">[
									Delete ]</a></td>
						</tr>
						<tr>
							<td colspan=5 class="text-left">${guestbookVo.content }</td>
						</tr>
					</table>

				</c:forEach>
				<!-- //guestRead -->

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