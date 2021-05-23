function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
};

function writeBoard() {
	let form = {
		title: $("#title").val(),
		writeuser: $("#writeuser").val(),
		contents: $("#summernote").val()
	}
	$.ajax({
		url: 'saveBoard', type: 'POST', dataType: 'json',
		data: JSON.stringify(form),
		contentType: 'application/json',
		success: function(Result) {
			if (Result.saveResult == true) {
				alert('글쓰기에 성공했습니다')
				location.href = getContextPath()
			}else if(Result.saveResult == 'noContents'){
				alert('제목이나 내용을 입력해주세요')
			}
		},
		error: function(){
			alert('글쓰기에 실패했습니다')
		}
	})

}

function deleteBoard() {
	let id = $("#boardId").text()


	$.ajax({
		url: 'deleteBoard?boardId='+id, type: 'DELETE',
		dataType: "json",
		
		success: function() {
			alert('삭제에 성공했습니다')
			location.href = getContextPath()
		},
		error: function() {
			alert('삭제에 실패했습니다' + id)
		}
	})


}

