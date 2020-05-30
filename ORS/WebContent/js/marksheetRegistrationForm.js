function validateMarksheetRegistrationForm() {
	var rollNumber = document.forms["MarksheetRegistrationForm"]["rollNumber"].value;
	var name = document.forms["MarksheetRegistrationForm"]["name"].value;

	if (rollNumber == "") {
		alert("RollNumber Must Be Failed Out");
		return false;
	} else if (name == "") {
		alert("Name Must Be Failed Out");
		return false;
	}
}