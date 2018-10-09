 String.prototype.repeatify = function(number) {
 	  if(!isNaN(number)) {
		  var repeatedString = '';
		  for (var i = 0; i < number; i++) {
			repeatedString += this.toString();
		  }
		  return repeatedString;
      }
     
     else {
		  return "Enter a valid number";
	  }
 };