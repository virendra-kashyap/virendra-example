function validateLoginForm() {
	var emailId = document.forms["LoginForm"]["emailId"].value
	var password = document.forms["LoginForm"]["password"].value;
	var pattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
	if (emailId == "") {
		alert("EmailId Must Be Failed Out");
		return false;
	} else if (!emailId.match(pattern)) {
		alert("EmailId Should be correct format.");
		return false;
	} else if (password == "") {
		alert("Password Must be Failed Out");
		return false;
	} else if (password.type === "password") {
		password.type = "text";
	} else {
		password.type = "password";
	}
}