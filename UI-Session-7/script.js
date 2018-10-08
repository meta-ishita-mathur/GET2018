var errors = new Map();

window.addEventListener('load', stateChange());

function validateFirstName() {
	var regEx = /^[a-zA-Z]{2,}$/;
    	var firstName = document.getElementById("firstName");
    	var valid = false;
    
    	if(firstName.value == "") {
		firstName.style.border = "solid 1px #ff0000";
	    	firstNameError.innerHTML = "This field is required";
	    	errors.set("First Name", "This field is required");
    	}
    
	else if (!regEx.test(firstName.value)) {
		firstName.style.border = "solid 1px #ff0000";
		firstNameError.innerHTML = "Invalid first name";
        	errors.set("First Name", "Invalid first name");
	}
    
	else {
		firstNameError.innerHTML = "";
		firstName.style.borderColor = "";
        
        	if(errors.has("First Name")) {
            		errors.delete("First Name");
        	}
		valid = true;
	}
    	return valid;
}


function validateLastName() {
	var regEx = /^[a-zA-Z]{2,}$/;
	var lastName = document.getElementById("lastName");
    	var valid = false;
    
	if(lastName.value == "") {
        	lastName.style.border = "solid 1px #ff0000";
		lastNameError.innerHTML = "This field is required";
        	errors.set("Last Name", "This field is required");
    	}
    
	else if (!regEx.test(lastName.value)) {
		lastName.style.border = "solid 1px #ff0000";
		lastNameError.innerHTML = "Invalid last name";
        	errors.set("Last Name", "Invalid last name");
	}
    
	else {
		lastNameError.innerHTML = "";
		lastName.style.borderColor = "";
        
        	if(errors.has("Last Name")) {
            		errors.delete("Last Name");
        	}
		valid = true;
	}
    	return valid;
}


function validateEmail() {
	var regEx = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;
	var email = document.getElementById("email");
    	var valid = false;
    
	if(email.value == "") {
        	email.style.border = "solid 1px #ff0000";
		emailError.innerHTML = "This field is required";
        	errors.set("Email", "This field is required");
    	}
    
	else if (!regEx.test(email.value)) {
		email.style.border = "solid 1px #ff0000";
		emailError.innerHTML = "Invalid email";
        	errors.set("Email", "Invalid email");
	}
    
	else {
		emailError.innerHTML = "";
		email.style.borderColor = "";
        
        	if(errors.has("Email")) {
            		errors.delete("Email");
        	}
		valid = true;
	}
    	return valid;
}


function validateContact() {
	var regEx = /^[0-9]{10,12}/;
	var contact = document.getElementById("contact");
    	var valid = false;
    
    	if(contact.value == "") {
        	contact.style.border = "";
		contactError.innerHTML = "";
        
        	if(errors.has("Phone")) {
            		errors.delete("Phone");
        	}
		valid = true;
    	}
    
	else if (!regEx.test(contact.value)) {
		contact.style.border = "solid 1px #ff0000";
		contactError.innerHTML = "Invalid contact number";
        	errors.set("Phone", "Invalid contact number");
	}
    
	else {
		contactError.innerHTML = "";
		contact.style.borderColor = "";
        
        	if(errors.has("Phone")) {
            		errors.delete("Phone");
        	}
		valid = true;
	}
    	return valid;
}


function validateCity() {
	var regEx = /^[a-zA-Z]{3,}$/;
	var city = document.getElementById("city");
    	var valid = false;
    
	if(city.value == "") {
        	city.style.border = "";
		cityError.innerHTML = "";
        
        	if(errors.has("City")) {
            		errors.delete("City");
        	}
		valid = true;
    	}
    
	else if (!regEx.test(city.value)) {
		city.style.border = "solid 1px #ff0000";
		cityError.innerHTML = "Invalid city";
        	errors.set("City", "Invalid City");
	}
    
	else {
		cityError.innerHTML = "";
		city.style.borderColor = "";
        
        	if(errors.has("City")) {
            		errors.delete("City");
        	}
		valid = true;
	}
    	return valid;
}


function validateState() {
	var state = document.getElementById("state");
    	var valid = false;
    
    	if (state.value == "") {
        	state.style.border = "solid 1px #ff0000";
		stateError.innerHTML = "This field is required";
        	errors.set("State", "This field is required");
    	}
    
    	else {
        	stateError.innerHTML = "";
        	state.style.borderColor = "";
        
        	if(errors.has("State")) {
            		errors.delete("State");
        	}
        	valid = true;
    	}
    	return valid;
}


function validateZip() {
	var regEx = /^[0-9]{6,6}$/;
    	var zip = document.getElementById("zip");
    	var valid = false;
    
    	if (zip.value == "") {
        	zip.style.border = "solid 1px #ff0000";
		zipError.innerHTML = "This field is required";
        	errors.set("Zip Code", "This field is required");
    	}
    
    	else if(!regEx.test(zip.value)) {
		zip.style.border = "solid 1px #ff0000";
		zipError.innerHTML = "Invalid zipcode";
        	errors.set("Zip Code", "Invalid Zip Code");
	}
    
    	else {
        	zipError.innerHTML = "";
        	zip.style.borderColor = "";
        
        	if(errors.has("Zip Code")) {
            		errors.delete("Zip Code");
        	}
        	valid = true;
    	}
    	return valid;
}


function validateProject() {
	var project = document.getElementById("project");
    	var valid = false;
    
    	if (project.value == "") {
        	project.style.border = "solid 1px #ff0000";
		projectError.innerHTML = "This field is required";
        	errors.set("Project Description", "This field is required");
    	}
    
    	else {
        	projectError.innerHTML = "";
        	project.style.borderColor = "";
        
        	if(errors.has("Project Description")) {
            		errors.delete("Project Description");
        	}
        	valid = true;
    	}
    	return valid;
}


function validateWebsite() {
	var website = document.getElementById("website");
	var regEx = /((([A-Za-z]{3,9}:(?:\/\/)?)(?:[-;:&=\+\$,\w]+@)?[A-Za-z0-9.-]+|(?:www.|[-;:&=\+\$,\w]+@)[A-Za-z0-9.-]+)((?:\/[\+~%\/.\w-_]*)?\??(?:[-\+=&;%@.\w_]*)#?(?:[\w]*))?)/;
    	var valid = false;
    
    	if(website.value == "") {
        	website.style.border = "";
		websiteError.innerHTML = "";
        
        	if(errors.has("Website or domain name")) {
            		errors.delete("Website or domain name");
        	}
		valid = true;
    	}
    
	else if (!regEx.test(website.value)){
		website.style.border = "solid 1px #ff0000";
		websiteError.innerHTML = "Invalid website or domain name";
        	errors.set("Website or domain name", "Invalid Website or domain name");
	}
    
	else {
		websiteError.innerHTML = "";
		website.style.borderColor = "";
        
        	if(errors.has("Website or domain name")) {
            		errors.delete("Website or domain name");
        	}
		valid = true;
	}
    	return valid;
}


function stateChange() {
	var state = document.getElementById("state");
    	var referenceNode = state.parentNode.parentNode.parentNode;
    	var optionalElement = document.getElementsByClassName("optionalElement");
    
    	while (optionalElement.length > 0) {
        	optionalElement[0].parentNode.removeChild(optionalElement[0]);
    	}
                    
    	if(state.value == "Rajasthan") {
        	referenceNode.parentNode.insertBefore(getProject(), referenceNode.nextSibling);    
        	referenceNode.parentNode.insertBefore(getWebsite(), referenceNode.nextSibling);
		
		if(localStorage.getItem("Project Description").length > 0)
                	document.getElementById("project").value = localStorage.getItem("Project Description");
            
            	if(localStorage.getItem("Website or domain name").length > 0)
                	document.getElementById("website").value = localStorage.getItem("Website or domain name");
    	}
    
    	else if(state.value == "Haryana") {
        	referenceNode.parentNode.insertBefore(getHosting(), referenceNode.nextSibling);
        	referenceNode.parentNode.insertBefore(getZipCode(), referenceNode.nextSibling);
		
		if(localStorage.getItem("Zip Code").length > 0)
                	document.getElementById("zip").value = localStorage.getItem("Zip Code");
    	}
    
    	else if(state.value == "Maharashtra") {
        	referenceNode.parentNode.insertBefore(getProject(), referenceNode.nextSibling);
        	referenceNode.parentNode.insertBefore(getZipCode(), referenceNode.nextSibling);
		
		if(localStorage.getItem("Zip Code").length > 0)
                	document.getElementById("zip").value = localStorage.getItem("Zip Code");
            
            	if(localStorage.getItem("Project Description").length > 0)
                	document.getElementById("project").value = localStorage.getItem("Project Description");
    	}
	
	else {
            localStorage.clear();
        }
}


function getWebsite() {
	var website = document.createElement('div');
        
    	website.className = "form-element optionalElement";
    	website.innerHTML = "<div class='row'><div>Website or Domain Name</div><div class='input-field'><div><i class='fas fa-globe-asia'></i></div><div><input type='text' id='website' placeholder='Website or domain name' onblur='validateWebsite()' /><p id='websiteError'></p></div></div></div>";
    
    	return website;
}


function getHosting() {
	var hosting = document.createElement('div');
    
    	hosting.className = "form-element optionalElement";
   	hosting.innerHTML = "<div class='row'><div>Do you have a hosting?</div><div class='input-radio-field'><p><input type='radio' id='yesHosting' value='Yes' /> Yes</p><p><input type='radio' id='noHosting' value='No' /> No</p></div></div>";
    
    	return hosting;
}


function getZipCode() {
    	var zipcode = document.createElement('div');
        
    	zipcode.className = "form-element optionalElement";
    	zipcode.innerHTML = "<div class='row'><div>Zip Code</div><div class='input-field'><div><i class='fas fa-home'></i></div><div><input type='text' id='zip' placeholder='Zip Code' onblur='validateZip()' /><p id='zipError'></p></div></div></div>";
    
    	return zipcode;
}


function getProject() {
    	var project = document.createElement('div');
        
    	project.className = "form-element optionalElement";
    	project.innerHTML = "<div class='row'><div>Project Description</div><div class='input-field pen'><div><i class='fas fa-pen'></i></div><div><textarea rows='3' cols='25' id='project' placeholder='Project Description' onblur='validateProject()'></textarea><p id='projectError'></p></div></div></div>";
    
    	return project;
}


function validateForm() {
    	errors.clear();
    	var state = document.getElementById("state");
    	var flag = false;
    	var valid = false;
    
    	if(state.value == "Rajasthan" && (validateProject() && validateWebsite())) {
        	flag = true;
    	}
    
    	else if(state.value == "Haryana" && validateZip()) {
        	flag = true;
    	}
    
    	else if(state.value == "Maharashtra" && (validateZip() && validateProject())) {
        	flag = true;
    	}
    
	if(validateFirstName() & validateLastName() & validateEmail() & validateContact() & validateCity() & validateState() & flag) {
        	var contact = document.getElementById("contact");
        	var address = document.getElementById("address");
        	var city = document.getElementById("city");
        	var project = document.getElementById("project");
        	var website = document.getElementById("website");
        	var zip = document.getElementById("zip");
        	var yesHosting = document.getElementById("yesHosting");
        	var noHosting = document.getElementById("noHosting");
        
        	localStorage.clear();
		localStorage.setItem("First Name", document.getElementById("firstName").value);
		localStorage.setItem("Last Name", document.getElementById("lastName").value);
		localStorage.setItem("Email", document.getElementById("email").value);
		localStorage.setItem("State", document.getElementById("state").value);

		if(contact.value != "") {
		    localStorage.setItem("Phone #", contact.value);
		}

		if(address.value != "") {
		    localStorage.setItem("Address", address.value);
		}

		if(city.value != "") {
		    localStorage.setItem("City", city.value);
		}

		if(project != null) {
		    localStorage.setItem("Project Description", project.value);
		}

		if(website != null && website.value != "") {
		    localStorage.setItem("Website or domain name", website.value);
		}

		if(zip != null) {
		    localStorage.setItem("Zip Code", zip.value);
		}

		if(yesHosting != null && yesHosting.checked) {
		    localStorage.setItem("Has Hosting", yesHosting.value);
		}

		else if(noHosting != null && noHosting.checked) {
		    localStorage.setItem("Has Hosting", noHosting.value);
		}
		valid = true;
		}
    
    else {    
		var errorKeys = errors.keys();
		var message = "";

		for(var key of errorKeys) {
		    message = message + key + "-" + errors.get(key) + "\n";
		}
		alert(message);
    }
    return valid;
}
