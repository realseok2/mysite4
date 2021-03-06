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
					<form action="${pageContext.request.contextPath }/board/search" method="get">
					
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
							<c:forEach items="${pMap.bList}" var="boardVo">
								<tr>
									<td>${boardVo.no}</td>
									<td class="text-left"><a href="${pageContext.request.contextPath }/board/read/${boardVo.no}">${boardVo.title}</a></td>
									<td>${boardVo.userName}</td>
									<td>${boardVo.hit}</td>
									<td>${boardVo.date}</td>
									
									<td>
										<c:if test="${authUser.no == boardVo.userNo }">
											<a href="${pageContext.request.contextPath }/board/modifyForm/${boardVo.no}">[Modification]</a>
										</c:if>	
									</td>
									
									<td>
										<c:if test="${authUser.no == boardVo.userNo }">
											<a href="${pageContext.request.contextPath }/board/delete/${boardVo.no}">[Delete] </a>
										</c:if>	
									</td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
		
					<div id="paging">
						<ul>
							<c:if test="${pMap.prev == true}">
								<li><a href="${pageContext.request.contextPath }/board/list2?crtPage=${pMap.startPageBtnNo-1}">◀</a></li>
							</c:if>
							
							<c:forEach begin="${pMap.startPageBtnNo }" end="${pMap.endPageBtnNo }" step="1" var="page">
								<c:choose>
									<c:when test="${param.crtPage == page }">
										<li class="active">
											<a href="${pageContext.request.contextPath }/board/list2?crtPage=${page}">${page}</a>
										</li>									
									</c:when>
									<c:otherwise>
										<li class="">
											<a href="${pageContext.request.contextPath }/board/list2?crtPage=${page}">${page}</a>
										</li>
									</c:otherwise>
								</c:choose>
								

							</c:forEach>
								
							<c:if test="${pMap.next == true}">
								<li><a href="${pageContext.request.contextPath }/board/list2?crtPage=${pMap.endPageBtnNo+1}">▶</a></li>
							</c:if>			

						</ul>
						
						
						
						<div class="clear"></div>
					</div>
					
					<c:if test="${authUser != null }">
						<a id="btn_write" href="${pageContext.request.contextPath }/board/writeForm/${authUser.no }">[Write]</a>
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
