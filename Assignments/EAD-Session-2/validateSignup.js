function validation()
{	
	if(validateName(document.getElementsByName("firstName")[0], document.getElementById("errorFirstName"))
		& validateName(document.getElementsByName("lastName")[0], document.getElementById("errorLastName"))
		& validateContact()
		& validatePassword()
		& validateConfirmPassword()
		& validateEmail())
	{
		return true;
	}
	else
	{
		return false;
	}
}

function validateName(name, error)
{
	var regularExpression = /^[A-Za-z]{2,30}$/;
	if(!regularExpression.test(name.value))
	{
		error.innerHTML = "Name must have alphabets only.";
		name.style.border = "red solid 1px";
		return false;
	}
	else
	{
		error.innerHTML = "";
		name.style.border = "";
		return true;
	}
}

function validateContact()
{
	var regularExpression = /^[0-9]{8,10}$/;
	if(!regularExpression.test(document.getElementsByName("contact")[0].value))
	{
		document.getElementById("errorContact").innerHTML = "Contact must have numbers only and length is minimum 8";
		document.getElementsByName("contact")[0].style.border = "red solid 1px";
		return false;
	}
	else
	{
		document.getElementById("errorContact").innerHTML = "";
		document.getElementsByName("contact")[0].style.border = "";
		return true;
	}
}

function validateEmail()
{
	var regularExpression = /^[a-zA-Z0-9]+([\.-_]?[a-zA-Z0-9]*)*@[a-zA-Z]+\.([a-zA-Z]{2,3})$/;
	if(!regularExpression.test(document.getElementsByName("email")[0].value))
	{
		document.getElementById("errorEmail").innerHTML = "Enter valid email";
		document.getElementsByName("email")[0].style.border = "red solid 1px";
		return false;
	}
	else
	{
		document.getElementById("errorEmail").innerHTML = "";
		document.getElementsByName("email")[0].style.border = "";
		return true;
	}
}

function validatePassword()
{
	var regularExpression = /^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$/;
	if(!regularExpression.test(document.getElementsByName("password")[0].value))
	{
		document.getElementById("errorPassword").innerHTML = "Password should contain Uppercase, Lowercase, Numeric, Alphanumeric, and length minimum 8";
		document.getElementsByName("password")[0].style.border = "red solid 1px";
		return false;
	}
	else
	{
		document.getElementById("errorPassword").innerHTML = "";
		document.getElementsByName("password")[0].style.border = "";
		return true;
	}
}

function validateConfirmPassword()
{
	if(document.getElementsByName("password")[0].value != document.getElementsByName("confirmPassword")[0].value)
	{
		document.getElementById("errorConfirmPassword").innerHTML = "Enter valid password";
		document.getElementsByName("confirmPassword")[0].style.border = "red solid 1px";
		return false;
	}
	else
	{
		document.getElementById("errorConfirmPassword").innerHTML = "";
		document.getElementsByName("confirmPassword")[0].style.border = "";
		return true;
	}
}