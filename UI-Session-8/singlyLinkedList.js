function Node(data) {
	this.data = data;
	this.next = null;
}

function LinkedList() {
	this.head = null;
	this.size = 0;

    this.add = function(data) {
    	var node = new Node(data);
    	var current;
        
    	if (this.head == null) 
            this.head = node; 
        
        else { 
            current = this.head; 
            while (current.next) { 
                current = current.next; 
            }  
            current.next = node; 
        } 
        this.size++; 
    }
	
    this.removeElement = function(data) { 
        var current = this.head; 
        var prev = null;
        
        while (current != null) {  
            if (current.data === data) { 
                if (prev == null)
                    this.head = current.next;
                
                else
                    prev.next = current.next;
                
                this.size--; 
                return current.element; 
            }
            prev = current; 
            current = current.next; 
        } 
    } 
	
	this.remove = function() { 
        var current = this.head;
        var prev = null;
        
		while(current.next) {
			prev = current;
			current = current.next;
		}
		prev.next = null;	
    }
    
    this.display = function() {
        var currentNode = this.head;
		var output = "";
        
        while (currentNode != null) {
            output += currentNode.data + " ";
            currentNode = currentNode.next;
        }
		console.log(output);
    }
}