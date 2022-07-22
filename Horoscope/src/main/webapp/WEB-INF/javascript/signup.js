
 let submitButton = document.getElementById("submit-button");

submitButton.addEventListener("click", (event) => {
event.preventDefault();

    //do AJAX
    //1. Create the XMLHttpRequest obj

    let xhttp = new XMLHttpRequest();

    // //next were going to get the values from the form

    let first_name = document.getElementById("first_name").value;
    let last_name = document.getElementById("last_name").value;
    let user_name = document.getElementById("user_name").value;
    let email = document.getElementById("email").value;
    let pass_word = document.getElementById("pass_word").value;
    let zodiac_sign = document.getElementById("zodiac_sign").value;


    let signupInfo = {
        first_name:first_name,
        last_name: last_name,
        user_name: user_name,
        email: email,
        pass_word:pass_word,
        zodiac_sign:zodiac_sign
    };

    console.log(signupInfo);

    //STEP 2: Define the behaviors of our responses as they come back from the server
    /*
        A readyState is a property which signifies that state that the request is currently in.
        There are several states:
        0: UNSENT - opening of the request has yet to be called
        1: OPENED - open() has been called
        2: HEADERS_RECEIVED: send() has been called[aka the request has been sent], and the headers of the response as well as the status are now available.
        3: LOADING: downloading the response. Therefore, the responseText (which is a xhr property) is holding partial data.
        4: DONE: the entire operation is now complete
        Why need readyStates?
        Ofter you can implement other transitions or animations to your webpages by triggering them at given readyStates.
        ex. loading screens
    */

        xhttp.onreadystatechange = function(){

            //200 status code is a OK response
       //which means that everything was processed correctly
       if(this.readyState == 4 && xhttp.status == 200){

        console.log(xhttp.responseText);
        let data = JSON.parse(xhttp.responseText);
         console.log(data);

         //global caching funciton

         localStorage.setItem('currentUser', JSON.stringify(data));

        //window.location.replace("welcome.html")
        } else if(this.readyState == 4 && xhttp.status ===204) {
            console.log(xhttp.responseText)
            console.log()
                alert("Failed. Status Code: " + xhttp.status)

        }

    };

    //STEP 3: OPEN THE REQUEST
    xhttp.open("POST",`http://localhost:8080/Horoscope/signup`)

    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.setRequestHeader("Access-Control-Allow-Origin", "*");

     console.log(xhttp);
    //STEP 4- send the request
    xhttp.send(JSON.stringify(signupInfo));

    
});

    





// function renderHTML(data){
//     // let resp = document.getElementById("input");

//     // //append all response data to my webpage
//     // resp.append("Name: " + data.name);
//     // resp.append(document.createElement('br'));

//     // resp.append("ID: " + data.id);
//     // resp.append(document.createElement('br'));
//     console.log(data.email);
//     console.log(data.last_name);

//     // window.location.replace("tickets.html")

//     }