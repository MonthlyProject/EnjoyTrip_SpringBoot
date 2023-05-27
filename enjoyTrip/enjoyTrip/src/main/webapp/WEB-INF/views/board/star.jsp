<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>


<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<main id="main"> <!-- 메인 컨텐츠 시작 -->
	<div class="container">
		<!-- 관광지 조회 섹션 -->
		<section id="search" class="search">
			<!-- 관광지 조회 타이틀 -->
			<div class="row d-flex justify-content-center">
				<div class="col-lg-6 text-center">
					<h2 class="fw-bold">즐겨찾기</h2>
					<button id="btn-root" class="btn btn-outline-success" type="button">최단경로 찾기</button>
				</div>
			</div>
			<!-- 타이틀 종료 -->
			<!-- kakao map start -->
			<div id="map" class="mt-3" style="width: 100%; height: 550px">
				<script type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=54bc1b9c7746df1f03acaf0a07564944"></script>
			</div>
			<!-- kakao map end -->

		</section>
		<!-- End 관광지 조회 섹션 -->
	</div>
	<!-- 메인 컨텐츠 --> </main>
	<!-- End #main -->


	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

	<a href="#"
		class="scroll-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<div id="preloader"></div>

	<%@ include file="/WEB-INF/views/include/modals.jsp" %>
	<%@ include file="/WEB-INF/views/include/jsinclude.jsp"%>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=54963ba8b27648e7471f4438db6499e7&libraries=services,clusterer,drawing"></script>
	<script type="module" src="${root}/assets/js/star.js"></script>

</body>

</html>