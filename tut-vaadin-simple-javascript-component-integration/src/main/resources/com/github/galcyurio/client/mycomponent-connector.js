window.com_github_galcyurio_client_MyComponent = function () {
  // Create the component
  var myComponent = new mylibrary.MyComponent(this.getElement());
  var self = this;
  
  // Handle changes from the server-side
  this.onStateChange = function () {
    myComponent.setValue(this.getState().value);
  };

  // Pass user interaction to the server-side
  myComponent.click = function () {
    self.onClick(myComponent.getValue());
  };
};