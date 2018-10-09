function Node(data) {
	this.data = data;
	this.next = null;
}

function Stack() {
	this.head = null;
}

Stack.prototype.pushElement = function(data) {
	if(data != null) {
		var node = new Node(data);
        
		if(this.head == null) {
			this.head = node;
		}
        else {
			node.next = this.head;
			this.head = node;
		}
	}
    else {
		return "please enter data";
	}
}

Stack.prototype.popElement = function() {
	if (this.isEmpty()) {
        return "Stack Underflow"; 
	}
	var data = this.head.data;
	this.head = this.head.next;
	return data;
}

Stack.prototype.isEmpty = function() {
	if (this.head == null)
        return true;
	return false;
}


Stack.prototype.display = function() {
    var currentNode = this.head;
	var output = "";
	while (currentNode != null) {
		output += currentNode.data + " ";
		currentNode = currentNode.next;
	}
	console.log(output);
}