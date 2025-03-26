const password = document.getElementById("Pwd");


const from_acc = document.getElementById("AccNumber");
const to_acc = document.getElementById("RAccNumber");
const amount = document.getElementById("amount");


/* const icon1 = document.getElementById("eye1");
icon1.addEventListener("click", function () {
    if (password.type === "password") {
        password.type = "text";
        icon1.className = "fa-solid fa-eye-slash";
    } else {
        password.type = "password";
        icon1.className = "fa-solid fa-eye";
    }
});
*/

function validAccount() {
    const errorMsg2 = document.getElementById("errorMsg2");
    if (from_acc.value === to_acc.value) {
        errorMsg2.textContent = "Cannot Send Money to the Same Account!";
        return false;
    } else {
        errorMsg2.innerHTML = "<br>";
        return true;
    }
}


function validAmount() {
    const errorMsg1 = document.getElementById("errorMsg1");
    if (amount.value < 100) {
        errorMsg1.textContent = "Minimum Amount should be Rs.100";
        return false;
    } else {
        errorMsg1.innerHTML = "<br>";
        return true;
    }
}





const pin = document.getElementById("Pin"); 
const icon = document.getElementById("eye");
icon.addEventListener("click", ()=>{
	if (pin.type === "password") {
        pin.type = "number";
        icon.className = "fa-solid fa-eye-slash";
    } else {
        pin.type = "password";
        icon.className = "fa-solid fa-eye";
    }
	
})



function validPin()
{
	const pinvalue =(parseInt(pin.value.length))
	const errorMsg =document.getElementById('errorMsg');
	if(pinvalue !== 6)
	{
		errorMsg.textContent = "Transaction-Pin should be 6 digit number";
        return false;
		
	}
	 else {
        errorMsg.textContent = " ";
        return true;
    }
}

pin.addEventListener("input",validPin);
to_acc.addEventListener("input", validAccount);
amount.addEventListener("input", validAmount);


function check(event) {
    const isAccountValid = validAccount();
    const isAmountValid = validAmount();

    if (!isAccountValid || !isAmountValid) {
        event.preventDefault();
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
   