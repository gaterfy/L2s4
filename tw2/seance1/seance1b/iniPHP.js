function init() {
    var els = document.querySelectorAll('td');
    for (var i=0; i<els.length; i++) {
      els[i].addEventListener('click', changeState);
    }
}

function changeState() {
  if (this.className == 'blanc') {
    this.innerHTML = 'N';
    this.className = 'noir';
  }
  else if (this.className == 'noir') {
    this.innerHTML = '';
    this.className = '';
  }
  else {
    this.innerHTML = 'B';
    this.className = 'blanc';
  }
}

window.addEventListener('load',init);
