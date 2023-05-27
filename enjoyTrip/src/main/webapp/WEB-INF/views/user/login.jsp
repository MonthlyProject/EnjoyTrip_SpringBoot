<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="form-login" method="POST" action="">
		<div class="mb-3">
	      <label for="userid" class="form-label">아이디 : </label>
	      <input
	        type="text"
	        class="form-control"
	        id="userid"
	        name="userid"
	        placeholder="아이디..."
	       	value="${saveid}"
	      />
	    </div>
	    <div class="mb-3">
	      <label for="userpwd" class="form-label">비밀번호 : </label>
	      <input
	        type="password"
	        class="form-control"
	        id="userpwd"
	        name="userpwd"
	        placeholder="비밀번호..."
	      />
	    </div>
	    <button type="button" id="btn-login" class="btn btn-outline-primary mb-3">
	                로그인
	    </button>
    </form>
</body>
<script>
     document.querySelector("#btn-login").addEventListener("click", function () {
         let form = document.querySelector("#form-login");
         form.setAttribute("action", "${root}/user/login");
         form.submit();
     });
</script>
</html>