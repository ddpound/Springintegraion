function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
};

function writeBoard() {
	let form = {
		title: $("#title").val(),
		writeuser: $("#writeuser").val(),
		contents: $("#contents").val()
	}

	$.ajax({
		url: 'saveBoard', type: 'POST', dataType: 'json',
		data: JSON.stringify(form),
		contentType: 'application/json',
		success: function(loginResult) {
			if (loginResult.loginResult == true) {
				alert('글쓰기에 성공했습니다')
				location.href = getContextPath()

			}

		}




	})

}