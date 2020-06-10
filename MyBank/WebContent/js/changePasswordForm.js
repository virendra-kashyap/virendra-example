function validateChangePasswordForm() {
	var current = document.forms["ChangePasswordForm"]["current"].value;
	var newpass = document.forms["ChangePasswordForm"]["newpass"].value;
	var confirm = document.forms["ChangePasswordForm"]["confirm"].value;
	if (current == "") {
		alert("Password Must Be Failed Out.");
		return false;
	} else if (newpass == "") {
		alert("Password Must Be Failed Out.");
		return false
	} else if (confirm == "") {
		alert("Password Must Be Failed Out.");
		return false;
	} else if (newpass != confirm) {
		alert("Password did not match: Please Check Password..");
		return false;
	}
}