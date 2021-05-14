function getContextPath() {
	var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
};
function login(){
	let form = {
		id : $("#uId").val(),
		pw : $("#uPw").val()
	};
	console.log($("#uId").val())
	console.log($("#uPw").val())
	console.log(form)
	
	$.ajax({
		url : 'loginProc' ,type: 'POST', dataType: 'json',
		data : JSON.stringify(form),
		contentType: 'application/json',
		success: function(result){
			
			if(result.loginResult == true){
				window.location.href = getContextPath()+'/';
				alert('로그인성공')
			}else if(result.loginResult == "pwFalse"){
				alert('비밀번호가 틀림')
			}else{
				alert('해당아이디가 없습니다')
			}
		},
		error : function(){
			alert('로그인 에러 발생')
		}
		
	})
	
	
}