function loadContent() {
    var details = document.getElementById("data");

    for(var i = 0; i < localStorage.length; i++) {
        var key = localStorage.key(i);
        var parentDiv = document.createElement("div");
        var newLabel = document.createElement("div");
        var newValue = document.createElement("div");
        
        parentDiv.className = "detail";
        details.appendChild(parentDiv);
        
        newLabel.className = "label";
        newLabel.innerHTML = key;
        parentDiv.appendChild(newLabel);

        newValue.className = "value";
        newValue.innerHTML = localStorage.getItem(key);
        parentDiv.appendChild(newValue);
    }
}