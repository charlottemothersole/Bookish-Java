import './style.css'
import javascriptLogo from './javascript.svg'
import viteLogo from '/vite.svg'
//import { setupCounter } from './counter.js'

let dbData;

let getBooks = () => {
    fetch("http://localhost:8080/books", {
            method: "GET",
            mode: "cors",
            headers: {
                "Access-Control-Allow-Origin": "*"
            }
        })
        .then(response => response.json())
        .then(data => {
            renderBooks(data);
        }
    );
}

let getBookById = () => {
    let idInput = document.getElementById('idInput');
    fetch("http://localhost:8080/books/" + idInput.value, {
            method: "GET",
            mode: "cors",
            headers: {
                "Access-Control-Allow-Origin": "*"
            }
        })
        .then(response => response.json())
        .then(data => {
            renderBooks(data);
        }
    );
}

function renderBooks(data) {
//create page header
    let bookHeader = document.createElement('h2');
//    create empty html variable
    let html = '';
//    find container div
    let container = document.querySelector('.container');
//append to the html variable
    if(Array.isArray(data)) {
        bookHeader.innerText = 'All Books';
        container.appendChild(bookHeader);
        //    create empty list element
        let bookList = document.createElement('ul');
        bookList.style.padding = '0';
        bookList.style.listStyle = 'none';
        //    loop through data and for each object create list element containing object title
        data.forEach(book => {
            let listItem = `<li class="book"> ${book.title} </li>`;
            html += listItem;
        });
        //    set list elements inner html to ul of li elements
        bookList.innerHTML = html;
        container.appendChild(bookList);
    } else {
        bookHeader.innerText = 'Search Results';
        container.appendChild(bookHeader);
        let result = `<p>${data.title}</p>`
        html += result;
        container.innerHTML += html;
    }
}

let allBooksButton = document.getElementById('allBooks');
allBooksButton.addEventListener("click", getBooks);
let getBookByIdButton = document.getElementById('idButton');
getBookByIdButton.addEventListener("click", getBookById);
