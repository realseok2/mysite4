<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">

</head>


<body>
	<div id="wrap">

	<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
	
		<!-- //header -->
		
		<c:import url="/WEB-INF/views/include/nav.jsp"></c:import>	
		<!-- //nav -->

				<c:import url="/WEB-INF/views/include/boardAsideUser.jsp"></c:import>
		<!-- //aside -->

		<div id="content">

			<div id="content-head">
				<h3>Board</h3>
				<div id="location">
					<ul>
						<li>Main</li>
						<li>Board</li>
						<li class="last">Normal</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->

			<div id="board">
				<div id="list">
					<form action="${pageContext.request.contextPath }/reply/search" method="get">
					
						<div class="form-group text-right">
						
						
						
						
							<input type = "text" name = "keyword" value = "">
							<button type="submit" id=btn_search>Search</button>
						
						
						
						
							
						</div>
					</form>
					<table >
						<thead>
							<tr>
								<th>No</th>
								<th>Title</th>
								<th>Writer</th>
								<th>Views</th>
								<th>Writed Date</th>
								<th colspan = "2" >Administer</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach items="${rList}" var="replyVo">
								<tr>
									<td>${replyVo.no}</td>
									<td class="text-left"><a href="${pageContext.request.contextPath }/reply/read/${replyVo.no}">${replyVo.title}</a></td>
									<td>${replyVo.userName}</td>
									<td>${replyVo.hit}</td>
									<td>${replyVo.date}</td>
									
									<td>
										<c:if test="${authUser.no == replyVo.userNo }">
											<a href="${pageContext.request.contextPath }/reply/modifyForm/${replyVo.no}">[Modification]</a>
										</c:if>	
									</td>
									
									<td>
										<c:if test="${authUser.no == replyVo.userNo }">
											<a href="${pageContext.request.contextPath }/reply/delete/${replyVo.no}">[Delete] </a>
										</c:if>	
									</td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
		
					<div id="paging">
						<ul>
							<li><a href="">◀</a></li>
							<li><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">4</a></li>
							<li class="active"><a href="">5</a></li>
							<li><a href="">6</a></li>
							<li><a href="">7</a></li>
							<li><a href="">8</a></li>
							<li><a href="">9</a></li>
							<li><a href="">10</a></li>
							<li><a href="">▶</a></li>
						</ul>
						
						
						<div class="clear"></div>
					</div>
					
					<c:if test="${authUser != null }">
						<a id="btn_write" href="${pageContext.request.contextPath }/reply/writeForm/${authUser.no }">[Write]</a>
					</c:if>
				</div>
				
				<!-- //list -->
			</div>
			<!-- //board -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>
