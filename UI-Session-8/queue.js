function Node(data) {
	this.data = data;
	this.next = null;
}

function Queue() {
	this.front = null;
	this.rear = null;
}

Queue.prototype.enqueue = function(data) {
	if(data != null) {
		var node = new Node(data);
		if(this.front == null) {
			this.front = node;
			this.rear = node;
		}
        else {
			this.rear.next = node;
			this.rear = node;
		}
	}
    else {
		return "please enter data";
	}
}

Queue.prototype.dequeue = function() {
	if (this.isEmpty()) {
        return "Queue Underflow"; 
	}
	var removedElement = this.front.data;
    if(this.rear == this.front) {
		this.front = null;
		this.rear = null;
	}
    else {
		this.front = this.front.next;
	}
	return removedElement;
}

Queue.prototype.isEmpty = function() {
	if (this.rear == null)
        return true;
	return false;
}

Queue.prototype.display = function() {
	var currentNode = this.front;
	var output = "";
	while (currentNode != null) {
		output += currentNode.data + " ";
		currentNode = currentNode.next;
	}
	console.log(output);
}