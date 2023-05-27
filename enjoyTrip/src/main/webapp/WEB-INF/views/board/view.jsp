<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<body>
<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<!-- 이 부분 !! -->
	<main id="main">

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10 col-sm-12">
				<h2 class="my-3 py-3 shadow-sm bg-light text-center">
					글보기
				</h2>
			</div>
			<div class="col-lg-8 col-md-10 col-sm-12">
				<div class="row my-2">
					<h2 class="text-secondary px-5">${article.subject}</h2>
				</div>
				<div class="row">
					<div class="col-md-8">
						<div class="clearfix align-content-center">
							<img class="avatar me-2 float-md-start bg-light p-2"
								src="https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg" />
							<p>
								<span class="fw-bold">${article.userName}</span> <br /> <span
									class="text-secondary fw-light"> ${article.registerTime}
									조회 : ${article.hit} </span>
							</p>
						</div>
					</div>
					<!-- <div class="col-md-4 align-self-center text-end">댓글 : 17</div> -->
					<div class="divider mb-3"></div>
					<div class="text-secondary">${article.content}</div>
					<c:if test="${!empty article.fileInfos}">
						<div class="divider mt-3">
							<ul>
								<c:forEach var="file" items="${article.fileInfos}">
									<li>${file.originalFile} <a href="/file/download/${file.saveFolder}/${file.originalFile}/${file.saveFile}">[다운로드]</a>
								</c:forEach>
							</ul>
						</div>
					</c:if>
					<div class="divider mt-3 mb-3"></div>
					<div class="d-flex justify-content-end">
						<button type="button" id="btn-list"
							class="btn btn-outline-primary mb-3">글목록</button>
						<c:if test="${userInfo.userId eq article.userId}">
							<button type="button" id="btn-mv-modify"
								class="btn btn-outline-success mb-3 ms-1">글수정</button>
							<button type="button" id="btn-delete"
								class="btn btn-outline-danger mb-3 ms-1">글삭제</button>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form id="form-no-param" method="get" action="${root}/board">
		<input type="hidden" id="npgno" name="pgno" value="${pgno}">
		<input type="hidden" id="nkey" name="key" value="${key}">
		<input type="hidden" id="nword" name="word" value="${word}">
		<input type="hidden" id="articleno" name="articleno" value="${article.articleNo}">
	</form>
	<form id="form-param" method="get" action="">
		<input type="hidden" id="npgno" name="pgno" value="${pgno}">
		<input type="hidden" id="nkey" name="key" value="${key}">
		<input type="hidden" id="nword" name="word" value="${word}">
	</form>
	<script>
      document.querySelector("#btn-list").addEventListener("click", function () {
	    	let form = document.querySelector("#form-param");
	   		form.setAttribute("action", "/article/list");
	    	form.submit();
      });
      document.querySelector("#btn-mv-modify").addEventListener("click", function () {
	    	let form = document.querySelector("#form-no-param");
	   		form.setAttribute("action", "/article/modify");
	    	form.submit();
      });
      document.querySelector("#btn-delete").addEventListener("click", function () {
	    	let form = document.querySelector("#form-no-param");
	   		form.setAttribute("action", "/article/delete");
	    	form.submit();
      });
    </script>
	</div>

	</main>
	<!-- End #main -->

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

	<a href="#"
		class="scroll-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<div id="preloader"></div>

	<%@ include file="/WEB-INF/views/include/modals.jsp" %>
	<%@ include file="/WEB-INF/views/include/jsinclude.jsp"%>


</body>

</html>