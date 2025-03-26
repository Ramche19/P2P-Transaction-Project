
const password = document.getElementById("Pwd");
const icon = document.getElementById("eye");
const pin = document.getElementById("pin");
const icon1 = document.getElementById("eye1");


icon.addEventListener("click", function () {
    if (password.type === "password") {
        password.type = "text";
        icon.className = "fa-solid fa-eye-slash";
    } else {
        password.type = "password";
        icon.className = "fa-solid fa-eye";
    }
});

icon1.addEventListener("click", function () {
    if (pin.type === "password") {
        pin.type = "text";
        icon1.className = "fa-solid fa-eye-slash";
    } else {
        pin.type = "password";
        icon1.className = "fa-solid fa-eye";
    }
});



function formSubmit(e)
{
    e.preventDefault();
    const passlength = password.value.length;
    const pinlength = pin.value.length;
    console.log(passlength);
    if (passlength < 8) {
        const errormsg = document.getElementById("errorMsg");
        errormsg.textContent = "Password should be min. 8 characters"
        
    }
    else if(pinlength!=6)
    {
		const errormsg1 = document.getElementById("errorMsg1");
        errormsg1.textContent = "MT Pin should be 6 digit number"
	}
    else {
        e.target.submit();
    }


}

 function togglePopup() {
  const popup = document.getElementById('popup');
  popup.style.display = popup.style.display === 'block' ? 'none' : 'block';
}

// Close the popup if clicked outside
window.onclick = function (event) {
  const popup = document.getElementById('popup');
  if (!event.target.matches('.profile-icon')) {
    popup.style.display = 'none';
  }
};
