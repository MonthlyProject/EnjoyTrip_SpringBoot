		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
		    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		    level: 6 // 지도의 확대 레벨
		};
			// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption);
		var markers = [];
		var markersId =[];
		var markerscontent = [];
	
		// 즐겨찾기 목록 가져오기
		window.onload = function () {
	
		    for (var i = 0; i < markers.length; i++) {
		        markers[i].setMap(null);
		    }
		    markers = [];//마크 초기화
		    markersId = [];//마크 초기화
		    markerscontent = [];//마크 내용 초기화
		    fetch("/EnjoyTrip2_BackEnd/article?action=getMarker")//db에서 검색 조건에 맞는 데이터 가져와서
		        .then((response) => response.json())
		        .then((data) => {
		        makeTripDot(data)
		        });
		}
	
		function makeTripDot(data) {//마크 정보 세팅하기
		    if (data !== 0) {//데이터가 존재하면
		        let trips = data.marker;
		        var moveLatLon;
		        trips.forEach(function (trip) {
					//지도 좌표
		            moveLatLon = new kakao.maps.LatLng(`${trip.latitude}`, `${trip.longitude}`);
					//태그에 넣을 이미지 크기
		            var markerimgsize = new kakao.maps.Size(32, 36),
		                imageOption = {
		                    offset: new kakao.maps.Point(13, 34)
		                };
					//마크 위치와 이미지 세팅
		            var marker = new kakao.maps.Marker({
		                position: moveLatLon,
		                image: new kakao.maps.MarkerImage(getmarkerimage(trip.contentTypeId), markerimgsize, imageOption),
		            });
		            
		            if (trip.firstimage === "") {//사진이 없을 때 대체할 사진 넣기
		                trip.firstimage = "/EnjoyTrip2_BackEnd/assets/img/noimg.png"
		            }
		            
		            var infowindow = new kakao.maps.InfoWindow({//태그를 건드렸을 때 생성할 창
		                position: moveLatLon,
		                content: `<div style="width:400px;">
					                <form id="form-register" method="POST" action="">
						                <input type="hidden" name="action" value="addStar">
						                <input type="hidden" name="contentId" value="${trip.contentTypeId}">
				                        <a style="display: block; padding: 6px;background-color: deepskyblue; font-size: 20px; font-weight: bold; color: white;display: block; text-align: center;" name="title" value="${trip.title}">${trip.title}</a>
				                        <div style="display: flex; justify-content: center; align-items: center;">
				                            <img src="${trip.firstImage}" style="width:200px;" name="image" value="${trip.firstInage}">
				                            <a style="margin: 20px;" name="addr" value="${trip.addr1} ${trip.addr2}">${trip.addr1} ${trip.addr2}</a>
				                        </div>
			                        </form>
		                    	</div>`
		            })
		            markersId.push(trip.contentId);
		            markers.push(marker);//배열에 마크 넣기
		            markerscontent.push(infowindow);
		            setmarker(moveLatLon);//배열에 든 마크 찍기
		        });
		    }
		}
	
		//마크 이미지
		function getmarkerimage(contentTypeId) {
		    if (contentTypeId == '12') {
		        return '/EnjoyTrip2_BackEnd/assets/img/marker/marker12.png';
		    } else if (contentTypeId === '14') {
		        return '/EnjoyTrip2_BackEnd/assets/img/marker/marker14.png';
		    } else if (contentTypeId === '15') {
		        return '/EnjoyTrip2_BackEnd/assets/img/marker/marker15.png';
		    } else if (contentTypeId === '25') {
		        return '/EnjoyTrip2_BackEnd/assets/img/marker/marker25.png';
		    } else if (contentTypeId === '28') {
		        return '/EnjoyTrip2_BackEnd/assets/img/marker/marker28.png';
		    } else if (contentTypeId === '32') {
		        return '/EnjoyTrip2_BackEnd/assets/img/marker/marker32.png';
		    } else if (contentTypeId === '38') {
		        return '/EnjoyTrip2_BackEnd/assets/img/marker/marker38.png';
		    } else if (contentTypeId == '39') {
		        return '/EnjoyTrip2_BackEnd/assets/img/marker/marker39.png';
		    }
		}
	
		function setmarker(location) {
		    for (let i = 0; i < markers.length; i++) {
		        markers[i].setMap(map);
		        kakao.maps.event.addListener(markers[i], 'mouseover', makeOverListener(map, markers[i], markerscontent[i]));
		        kakao.maps.event.addListener(markers[i], 'mouseout', makeOutListener(markerscontent[i]));
		    }
		    map.setCenter(location);//걍 이동
		    //map.panTo(location);
		}
	
		function makeOverListener(map, marker, infowindow) {
		    return function () {
		        infowindow.open(map, marker);
		    };
		}
	
		// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		function makeOutListener(infowindow) {
		    return function () {
		        infowindow.close();
		    };
		}
		
		//최단경로 구하기
		document.getElementById("btn-root").addEventListener("click", function () {
	    	fetch("/EnjoyTrip2_BackEnd/article?action=getroot"+areaCode)//db에서 구군 데이터 가져와서
	   		.then(response => response.json())
	   		.then(data => makeAreaArea(data, areaCode));
		});