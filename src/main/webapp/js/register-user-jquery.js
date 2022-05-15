function validateRegister() {
	$(document).ready(function(){
		var firstNameElement = $('#firstName');
	 	var lastNameElement = $('#lastName');
	 	var emailElement = $('#email');
	 	var userNameElement = $('#userName');
	 	var passwordElement = $('#password');
	 	var confirmPasswordElement = $('#confirmPassword');

	 	var status = false;
	 	var message = "Please fill all mandatory fields";
	 	
	 	setBoderColor(firstNameElement);
	 	setBoderColor(lastNameElement);
	 	setBoderColor(emailElement);
	 	setBoderColor(userNameElement);
	 	setBoderColor(passwordElement);
	 	setBoderColor(confirmPasswordElement);
	 	
	 	var email = emailElement.val();
	 	
	 	if(email != "" && !validateEmail(email)){
	 		message = "Email is incorrect format";
	 		emailElement.css("border-color","rgb(255,0,0)");	
	 	}else if(passwordElement.val() != confirmPasswordElement.val()){
	 		message = "confirm Password is not match with password ";
	 		emailElement.css("border-color","rgb(255,0,0)");
	 	}
	 	
	 	var numberOfInput = $("input").length;
	 	var countNumberValidInput = 0;
	 	
	 	$("input").each(function(i){
	 		if($(this).css("border-color") == "rgb(0,128,0)"){
	 			countNumberValidInput++;
	 		}
	 	});
	 	
	 	if (countNumberValidInput == numberOfInput) {
	 		message = "";
	 		status = true;
	 	}
	 	
	 	$("#error").html(message);
	 	
	 	if(status){
	 		var rowCount = $("#tbl-result > tbody > tr").length;
	 		if(rowCount == 0){
	 			$("#tbl-result thead").append("<tr>" + "<th>No</th>" + "<th>Last name</th>" + "<th>Email</th>" + "<th>User Name</th>" + "</tr>");
	 		}
	 		$("#tbl-result thead").append("<tr>" 
	 		+ "<td>" + (++rowCount) + "</td>"
	 		+ "<td>" + firstNameElement.val() + "</td>"
	 		+ "<td>" + lastNameElement.val() + "</td>"
	 		+ "<td>" + emailElement.val() + "</td>"
	 		+ "<td>" + userNameElement.val() + "</td>"
	 		+ "<td>" + passwordElement.val() + "</td>"
	 		+ "</tr>");
	 	}
	});
}

function validateEmail(email){
	var re= /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}

function setBoderColor(element){
	if(element.val() == ""){
		element.css("border-color","rgb(255,0,0)");		
	}else{
		element.css("border-color","rgb(0,128,0)");			
	}
}