function validateForgotPasswordForm() {
	var emailid = document.forms["ForgotPasswordForm"]["emailid"].value;
	var newpass = document.forms["ForgotPasswordForm"]["newpass"].value;
	var confirm = document.forms["ForgotPasswordForm"]["confirm"].value;
	var pattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
	if (emailid == "") {
		alert("EmailId Must Be Failed Out.");
		return false;
	} else if (!emailid.match(pattern)) {
		alert("EmailId Should Be Correct Format.");
		return false;
	} else if (newpass == "") {
		alert("Password Must Be Failed Out.");
		return false;
	} else if (confirm == "") {
		alert("Password Must Be Failed Out");
		return false;
	} else if (newpass != confirm) {
		alert("Password did not match: Please Check Password..");
		return false;
	}
}