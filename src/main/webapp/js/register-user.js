function validateRegister() {
 	var firstNameElement = document.getElementById("firstName");
 	var lastNameElement = document.getElementById("lastName");
 	var emailElement = document.getElementById("email");
 	var userNameElement = document.getElementById("userName");
 	var passwordElement = document.getElementById("password");
 	var confirmPasswordElement = document.getElementById("confirmPassword");

 	var status = false;
 	var message = "Please fill all mandatory fields";

 	setBoderColor(firstNameElement);
 	setBoderColor(lastNameElement);
 	setBoderColor(emailElement);
 	setBoderColor(userNameElement);
 	setBoderColor(passwordElement);
 	setBoderColor(confirmPasswordElement);

 	var email = emailElement.value;

 	if (email != "" && !validateEmail(email)) {
 		message = "Email is incorrect format";
 		emailElement.style.boderColor = "red";
 	}else if(passwordElement.value != confirmPasswordElement.value){
 		message = "confirm Password is not match with password ";
 		confirmPasswordElement.style.boderColor = "red";
 	}

 	var numberOfInput = document.getElementsByTagName("input").length;
 	var countNumberValidInput = 0;

 	for (var j = 0; j < numberOfInput; j++) {
 		if (document.getElementsByTagName("input")[j].style.borderColor == "green") {
 			countNumberValidInput++;
 		}
 	}

 	if (countNumberValidInput == numberOfInput) {
 		message = "";
 		status = true;
 	}

 	document.getElementById("error").innerHTML = message;
 	if (status) {
 		showUserRegisted();
 		return true;
 	}
 	
 	return false;
 }

function validateEmail(email){
	var re= /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}

function showUserRegisted(){
	var table = document.getElementById("tbl-result").getElementsByTagName("tbody")[0];
	var index = table.rows.length;

	if (table.rows.length == 0) {
		var thead = document.getElementById("tbl-result").getElementsByTagName("thead")[0];
		var row = thead.insertRow(0);
		row.insertCell(0).outerHTML = "<th>No</th>";
		row.insertCell(1).outerHTML = "<th>First Name</th>";
		row.insertCell(2).outerHTML = "<th>Last name</th>";
		row.insertCell(3).outerHTML = "<th>Email</th>";
		row.insertCell(4).outerHTML = "<th>User Name</th>";
	}

	var row = table.insertRow(table.rows.length);
	row.insertCell(0).outerHTML = "<td>" + ++index + "</td>";
	row.insertCell(1).outerHTML = "<td>" + document.getElementById("firstName").value + "</td>";
	row.insertCell(2).outerHTML = "<td>" + document.getElementsByClassName("lastName")[0].value + "</td>";
	row.insertCell(3).outerHTML = "<td>" + document.getElementsByTagName("input")[2].value + "</td>";
	row.insertCell(4).outerHTML = "<td>" + document.getElementById("userName").value + "</td>";
	
}

function setBoderColor(element){
	if(element.value == ""){
		element.style.borderColor = "red";		
	}else{
		element.style.borderColor = "green";		
	}
}