<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


		<div id="header">
			<h1><a href="${pageContext.request.contextPath }/main">TS_Site</a></h1>

			<c:choose>
				<c:when test="${empty authUser }">
				<!-- 로그인 실패시, 로그인 전  -->
				<ul>
					<li><a href="${pageContext.request.contextPath }/user/loginForm">Join</a></li>
					<li><a href="${pageContext.request.contextPath }/user/joinForm">Join Us</a></li>
				</ul>
				</c:when>
				
				<c:otherwise>
					<!-- 로그인 성공시 -->
					<ul>
						<li>WELCOME ${authUser.name}</li>
						<li><a href="${pageContext.request.contextPath }/user/logout">Leave</a></li>
						<li><a href="${pageContext.request.contextPath }/user/modifyForm">Modification</a></li>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>