document.addEventListener("DOMContentLoaded", function () {

    let display = document.getElementById("display");
    let buttons = document.querySelectorAll(".button");

    for (let i = 0; i < buttons.length; i = i + 1) {

        buttons[i].addEventListener("click", function () {

            let value = this.innerText;

            if (value === "C") {

                display.innerText = "";

            }
            else if (value === "Clr") {

                let currentText = display.innerText;
                let newText = currentText.slice(0, currentText.length - 1);
                display.innerText = newText;

            }
            else if (value === "=") {

                try {

                    let expression = display.innerText;
                    expression = expression.replace(/\^/g, "**");

                    let result = eval(expression);

                    display.innerText = result;

                }
                catch (error) {

                    display.innerText = "Error";

                }

            }
            else {

                let currentValue = display.innerText;
                let updatedValue = currentValue + value;
                display.innerText = updatedValue;

            }

        });

    }

});