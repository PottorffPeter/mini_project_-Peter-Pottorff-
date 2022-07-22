 // get access to our button that will trigger this 'event' (onClick event)
 let button = document.getElementById("button");

 //note the event listener take in an arrow funtion
 //we can add an 'event' param which would give us the chance
 // to use the event.preventDefault() funtion ;
 //preventing the default behavior can look like stopping a page form refreshing
 //when we submit a form
 button.addEventListener("click", () => {

   //do Ajax! 

   //Step 1: Create out XmlHttpRequest Object
   let xhttp = new XMLHttpRequest();


   //next- Step 1.5 - here we are getting the value from our input form with the id ("field")

   let inputValue = document.getElementById("field").value

   //Step2: Define the behaviors of our response as they comback from the server
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

               // a status of 200 is  OK
               // everything was process successfully

               if(this.readyState == 4 && this.status == 200){


                   let data = JSON.parse(xhttp.responseText);
                   console.log(data);

                   // this method is a helper method to change the view or content in our html

                    renderHTML(data);
               }

       };
               //usng the backticks with the ${} is Template Literal aka string interpolation
       //Step 3: Open the request 
       xhttp.open("GET", `http://sandipbgt.com/theastrologer/api/horoscope/pisces/today${inputValue}`);

       //Step 4: Send the request
       //note remember to add he open and close parenthesis because
       // because that is what calls the method
       xhttp.send();

 });


 // here 'data' is just the param name
 //where as up above the 'data' that we will pass into this funciton
 //will be the actual JSON data we get back from our request in the responseText

 // this is DOM MANIPULATION
   function renderHTML(data){

       //target the p tag that we created in the html file
       // our ptag has an id="input"
       let response = document.getElementById("input");

       //append the response data to our page

       response.append("Name: " + data.name);
       //here we are adding a break behind the name
       response.append(document.createElement('br'));

       response.append("ID: " + data.id)
       response.append(document.createElement('br'));


       //here we are creating an image element and setting the attributes for it
       let image = document.createElement('img');
       image.setAttribute("src", data.sprites.front_default);
       image.setAttribute("height", "300");
       image.setAttribute("width","300");
       response.append(image);
       



   }