
document.getElementById('add-new-transaction-button').addEventListener('click', newTransaction);
document.getElementById('open-new-transaction-form').addEventListener('click', openTransactionForm);

function newTransaction(){
    let inputs = document.getElementsByClassName('front-window-form')[0].children[0].children;
    let form = `{
        "name": "${inputs[1].value}",
        "category": "${inputs[2].value}",
        "unitPrice": "${inputs[3].value}"
    }`;

    let xhttp = new XMLHttpRequest();

    xhttp.onload = function(){alert(this.responseText);}
    xhttp.open("POST", 'index.php');
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send('form=' + form);

    document.getElementsByClassName('blur-background')[0].style.cssText = 'display:none';
}

function openTransactionForm(){
    document.getElementsByClassName('blur-background')[0].style.cssText = 'display:block';
}