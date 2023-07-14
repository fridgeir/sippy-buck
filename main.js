var positionsData = localStorage.getItem("positions");

if(positionsData === null){
    positionsData = {
        positions: []
    }
}
else{
    positionsData = JSON.parse(positionsData);
}
console.log(positionsData);

var transactionsTable = document.getElementsByClassName('transaction-table')[0];

positionsData.positions.forEach(addTransactionRow);

document.getElementById('add-new-transaction-button').addEventListener('click', newTransaction);
document.getElementById('open-new-transaction-form').addEventListener('click', openTransactionForm);

function newTransaction(){
    let inputs = document.getElementsByClassName('front-window-form')[0].children[0].children;
    let newIndex = positionsData.positions.length + 1;
    let form = {
        "id" : newIndex,
        "title": inputs[1].value,
        "unitPrice": inputs[2].value,
        "volume": 1,
        "category": inputs[3].value
    };

    addTransactionRow(form);
    positionsData.positions.push(form);

    localStorage.setItem("positions", JSON.stringify(positionsData));

    document.getElementsByClassName('blur-background')[0].style.cssText = 'display:none';
}

function openTransactionForm(){
    document.getElementsByClassName('blur-background')[0].style.cssText = 'display:block';
}

function addTransactionRow(transaction){
    let newRow = document.createElement('div');

    let rowId = document.createElement('div');
    let rowTitle = document.createElement('div');
    let rowUnitPrice = document.createElement('div');
    let rowVolume = document.createElement('div');
    let rowCategory = document.createElement('div');

    rowId.innerText = transaction.id;
    rowTitle.innerText = transaction.title;
    rowUnitPrice.innerText = transaction.unitPrice;
    rowVolume.innerText = transaction.volume;
    rowCategory.innerText = transaction.category;

    newRow.appendChild(rowId);
    newRow.appendChild(rowTitle);
    newRow.appendChild(rowUnitPrice);
    newRow.appendChild(rowVolume);
    newRow.appendChild(rowCategory);

    transactionsTable.appendChild(newRow);

}