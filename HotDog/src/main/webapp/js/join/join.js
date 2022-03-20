// 패스워드 확인 
	const passwordAnswer = $("#password_answer");
	
	$("#password2").focusout(function(){
		const password1 = $("#password1").val();
		const password2 = $("#password2").val();
		const yes = "비밀번호가 일치합니다.";
		const no = "비밀번호가 일치하지 않습니다.";
		
		// 패스워드 1,2가 같은지 확인 후 같으면 다음으로 넘어가기
		passwordAnswer.text(password1 === password2 ? yes : no);

	})

	


