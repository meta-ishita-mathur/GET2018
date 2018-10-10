import {sayHello} from './modules/greeting';
import {sum} from './modules/math-functions';

const resultGreeting = document.getElementById('resultGreeting');

const result = document.getElementById("result");

resultGreeting.textContent = sayHello('Nice to see you!');

result.addEventListener("click", function() {
	const resultSum = document.getElementById('resultSum');
	const resultProduct = document.getElementById('resultProduct');
	const firstNumber = parseInt(document.getElementById("firstNumber").value, 10);
	const secondNumber = parseInt(document.getElementById("secondNumber").value, 10);
	
	resultSum.innerHTML = `The sum of ${firstNumber} and ${secondNumber} is ${sum(firstNumber)(secondNumber)}.`;
	resultProduct.innerHTML = `The sum using function sum(a,b) is ${sum(firstNumber, secondNumber)}.`;
});