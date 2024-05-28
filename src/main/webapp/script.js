
let hide_btn= document.getElementById('hide_btn');
let hide_btn2= document.getElementById('hide_btn2');

let hidediv = document.getElementById('hidediv');
let hidediv2 = document.getElementById('hidediv2');


hide_btn.addEventListener('click', dropdown);
hide_btn2.addEventListener('click', dropdown2);

function dropdown(){
   hidediv.classList.toggle('show');
}

function dropdown2(){
   hidediv2.classList.toggle('show');
}