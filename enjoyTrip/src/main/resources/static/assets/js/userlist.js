	    // 회원 목록.
	    fetch(`/admin/user`)
	      .then((response) => response.json())
	      .then((data) => { console.log(data); makeList(data);});
	    
		// 회원 목록 tbody
		function makeList(data) {
			let tbody = ``;
			data.forEach(function (user) {
				tbody += `
					<tr class="text-center" data-id="${user.userId }">
		                <td>${user.userName}</td>
		                <td>${user.userId}</td>
		                <td>${user.emailId}@${user.emailDomain }</td>
		                <td><button type="button" class="btn btn-outline-primary" onclick="userDelete(this);">삭제</button></td>
					</tr>
				`;
			});
			document.querySelector("#userlist").innerHTML = tbody;
		}
	    
		//회원 삭제
	    function userDelete(el) {
	        if (confirm("정말 삭제?")) {
	        	fetch(`/admin/delete/${id}`)
		            .then((response) => response.json())
		            .then((data) => makeList(data));
	        }
	    }
	    
	    //검색
	    document.querySelector("#btn-user-search").addEventListener("click", function () {
            let searchcase = document.getElementById("search-case").value;
            let word = document.querySelector("#search-word").value;
            let searchinfo = {
              type: searchcase,
              content: word,
            };
            let config = {
              method: "POST",
              headers: {
                "Content-Type": "application/json",
              },
              body: JSON.stringify(searchinfo),
            };
            fetch(`/admin/search`, config)
              .then((response) => response.json())
              .then((data) => makeList(data));
	    });