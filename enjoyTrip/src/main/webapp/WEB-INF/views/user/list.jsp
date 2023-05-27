<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="pt-4 container">
		<div class="mb-4 text-center">
			<h2 class="fw-bold">회원 관리</h2>
			<div class="mt-4 container">
				<div class="row mb-2 justify-content-between">
					<div class="mr-2 col-auto">
						<form id="form-user-search" class="row row-cols-lg-auto g-3 align-items-center">
							<div class="col-auto">
								<label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
								<select class="form-select" id="search-case">
									<option name="key" id="key" selected>검색조건</option>
									<option value="userId">아이디</option>
									<option value="userName">이름</option>
									<option value="userEmail">이메일</option>
								</select>
							</div>

							<div class="col-auto">
								<input type="text" name="word" id="search-word"
									class="mr-1 form-control" placeholder="검색어 입력" />
							</div>

							<div class="col-auto">
								<button type="button" id="btn-user-search"
									class="btn btn-outline-primary">검색</button>
							</div>
						</form>
					</div>
				</div>
				<div class="row">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">이름</th>
								<th scope="col">아이디</th>
								<th scope="col">이메일</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody id="userlist"></tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<main id="main"></main>
	<!-- End #main -->

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

	<a href="#"
		class="scroll-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<div id="preloader"></div>


	<%@ include file="/WEB-INF/views/include/modals.jsp" %>
	<%@ include file="/WEB-INF/views/include/jsinclude.jsp"%>
	<script type="module" src="/assets/js/userlist.js"></script>
</body>

</html>