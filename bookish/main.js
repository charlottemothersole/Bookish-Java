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
//            console.log(data);
//            dbData = data;
            renderBooks(data);
        }
    );
}

function renderBooks(data) {
    console.log(data);
    let html = '';
    data.forEach(book => {
        let htmlSegment = `<div class="user"> ${book}
                        </div>`;

        html += htmlSegment;
    });

    let container = document.querySelector('.container');
    container.innerHTML = html;
}
getBooks();
//renderBooks();

//
//let displayBooks = (data) => {
//    let booksContainer = document.createElement("div");
//    booksContainer.innerHTML = tab;
//    let tab =
//        `<tr>
//          <th>Name</th>
//          <th>Office</th>
//          <th>Position</th>
//          <th>Salary</th>
//         </tr>`;
//
//    // Loop to access all rows
//    for (let r of data.list) {
//        tab += `<tr>
//        <td>${r.name} </td>
//        <td>${r.office}</td>
//        <td>${r.position}</td>
//        <td>${r.salary}</td>
//    </tr>`;
//    }
//    // Setting innerHTML as tab variable
//    document.getElementById("app").appendChild(booksContainer);
//}


//document.querySelector('#app').innerHTML = `
//  <div> this is where data will go ${dbData}
//  </div>
