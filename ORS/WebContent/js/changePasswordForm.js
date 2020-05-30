function validateChangePasswordForm() {
	var emailId = document.forms["changePasswordForm"]["emailId"].value;
	var currentPassword = document.forms["changePasswordForm"]["currentPassword"].value;
	var newPassword = document.forms["changePasswordForm"]["newPassword"].value;
	var confirmPassword = document.forms["changePasswordForm"]["confirmPassword"].value;
	var pattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
	if (emailId == "") {
		alert("EmailId must be filled out");
		return false;
	} else if (!emailId.match(pattern)) {
		alert("EmailId Should be correct format.")
		return false;
	} else if (currentPassword == "") {
		alert("Password must be filled out");
		return false;
	} else if (newPassword == "") {
		alert("Password must be filled out");
		return false;
	} else if (confirmPassword == "") {
		alert("Password must be filled out");
		return false;
	} else if (newPassword != confirmPassword) {
		alert("Password did not match: Please Check Password..");
		return false;
	}
}