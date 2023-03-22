'use strict';  /* 엄격모드를 사용, 보다 엄격한 parsing 및 error handling을 자발적으로 시행하도록 적용 */
// 에이작스는 경로 이동이 아니라 요청한 곳으로 다시 돌아오고 페이지 리로딩 없이 비동기 처리된다는 특성때문에 댓글 = 에이작스는 거의 공식이다
let commentIndex = {
	init: function () {
		$("#comment_save").on("click", () => {
			this.commentSave();
		});
	},
	
	commentSave: function (){
		let data = {
			content: $("#comment-content").val(),
		}
		let boardId = $("#boardNo").val();
		console.log(data);
		console.log(boardId);
		$.ajax({
			type: "POST",                  // `` = 템플릿 문자열, 자바의 "문자열만들기" 처럼 `백쿼트로 문자열을 감싸면 ${}형태로 변수를 문자열로 삽입이 가능하다
			url: `/board/${boardNo}/comment`, // 에이작스는 자신이 호출 한 곳으로 돌아온다, 그래서 /comment가 없이 글상세페이지와 url이 동일하게 설정해버리면 글상세페이지인지 댓글쓰기페이지인지 구분을 못한다.
			data: json.stringify(data), // 자바스크립트 객체를 JSON 문자열로 변환할땐 stringify 메서드를 사용
			contentType: "application/json; charset=utf-8",
			dataType: "text"
		}).done(function (res) { // done의 장점은 $.ajax의 반환 값이 애플리케이션의 다른 곳과 연결될 수 있는 지연된promise라는 것, 그래서 ajax를 몇 군데 다른 곳에서 걸려고 한다면 이 ajax호출을 만드는 함수의 옵션으로 성공함수를 전달하는 대신 함수 자체에서 $.ajax를 반환하고 콜백을 done,fail,then등으로 바인딩가능, done는 성공할때만 트리거됨
			alert("댓글을 작성하였습니다.");
			locatin.href = `/board/${boardNo}`;
		}).fail(function (err) {
			alert(JSON.stringify(err));
		});
	},
}
commentIndex.init();