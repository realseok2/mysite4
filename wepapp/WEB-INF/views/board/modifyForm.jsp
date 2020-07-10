<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyForm</title>
<link href="/ms2/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/ms2/assets/css/board.css" rel="stylesheet" type="text/css">

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
				<div id="modifyForm">
					<form action="/ms2/board" method="get">
					<input type = "hidden" name = "action" value = "modify">
					<input type = "hidden" name = "no" value = ${requestScope.boardVo.no }>
					<input type = "hidden" name = "userNo" value = ${requestScope.boardVo.userNo }>
						<!-- 작성자 -->
						<div class="form-group">
							<span class="form-text">Writer</span>
							<span class="form-value">${authUser.name }</span>
						</div>
						
						<!-- 조회수 -->
						<div class="form-group">
							<span class="form-text">Views</span>
							<span class="form-value">${boardVo.hit }</span>
						</div>
						
						<!-- 작성일 -->
						<div class="form-group">
							<span class="form-text">WritedDate</span>
							<span class="form-value">${boardVo.date }</span>
						</div>
						
						<!-- 제목 -->
						<div class="form-group">
							<label class="form-text" for="txt-title">Title</label>
							<input type="text" id="txt-title" name="title" value="${boardVo.title }">
						</div>
					
						
					
						<!-- 내용 -->
						<div class="form-group">
							<textarea id="txt-content" name = "content" value = "${boardVo.content }">${boardVo.content}</textarea>
						</div>
						
						<a id="btn_cancel" href="/ms2/board?action=list">Cancel</a>
						<button id="btn_modify" type="submit" >Modification</button>
						
					</form>
	                <!-- //form -->
				</div>
				<!-- //modifyForm -->
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