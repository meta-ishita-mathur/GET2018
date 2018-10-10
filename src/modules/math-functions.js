const sum = (a, b) => {
	var addB = (b) => {
		return a + b;
	}
    
	if(typeof b == 'undefined') {
		return addB;
	}
    
    else {
		return addB(b);
	}
}
export {sum};