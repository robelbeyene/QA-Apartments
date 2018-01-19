var fetch = require('node-fetch')

getApartmentList = () => {

  let url = "http://localhost:8080/qa-apartments3/Rest/apartment/json";
  let fetchData = { 
    method: 'GET',
    mode: 'no-cors'
  };

  fetch(url,fetchData)
  .then(response=>
      //If a 2xx response is received return the response as JSON
       response.ok?response.json():Error(response.statusText)
      //Throw an error otherwise and jump to the catch statement
  )
  .then(response=>{
   
    const ids = JSON.parse(response).reduce((acc,apartment)=>{
        console.log(apartment)
      acc.push(apartment.id);
      return acc;
    },[])
    console.log(ids)

    //  this.setState({stateText:ids});
  })
  .catch(error=>{
    console.log("Request Failed: " + error.message);
  });

}
getApartmentList()