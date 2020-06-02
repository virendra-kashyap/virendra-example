function masterCheckbox(e) {
	var checkBox = document.getElementsByName("ids");
	console.log("checkBox " + checkBox)

	if (e.checked) {
		for (var i = 0; i < checkBox.length; i++) {
			checkBox[i].checked = true;
		}
	} else {
		for (var i = 0; i < checkBox.length; i++) {
			checkBox[i].checked = false;
		}
	}
}