import React from 'react';

const baseURL = "http://localhost:8080/rest/apartment/json"

function create(apartmentObject){
    const request = new Request(baseURL, {
        method: "POST",
        headers : {
            'Content-Type' : 'application/json'
        },
        body : JSON.stringify(apartmentObject)
    });
    return fetch(request).then(()=>'worked', ()=>'failed');
}

class AddApartment extends React.Component {
        constructor(){
      super();
      this.state={
        apartment:{}
      }
    }

    onChange=e=>{
        // console.log(e.target.value)
        this.setState({apartment:{...this.state.apartment,[e.target.id]: e.target.value}})
        console.log(this.state)
    }

    addApartment=()=>{
        create(this.state.apartment)
    }
    
   
      render(){
        return (
          <div className='pageheader'>
            <h2>Lets get adding son</h2>
            <form id='form' action="http://localhost:8080/rest/apartment/json" method="post">
                {/* id
                <input type='text' id='id' placeholder='id'/><br/> */}
                buildingName
                <input type='text' id='buildingName' onChange={this.onChange} placeholder='building name'/><br/>
                apartmentNo
                <input type='text' id='apartmentNumber' onChange={this.onChange} placeholder='apartment number'/><br/>
                agency
                <input type='text' id='agency' onChange={this.onChange} placeholder='agency'/><br/>
                landlord
                <input type='text' id='landlord' onChange={this.onChange} placeholder='landlord'/><br/>
                tenant
                <input type='text' id='tenant' onChange={this.onChange} placeholder='tenant'/><br/>
                leaseStart
                <input type='text' id='leaseStart' onChange={this.onChange} placeholder='lease start date format yyyy-mm-dd'/><br/>
                leaseEnd
                <input type='text' id='leaseEnd' onChange={this.onChange} placeholder='lease end date format yyyy-mm-dd'/><br/>
                breakCluase
                <input type='text' id='breakClause' onChange={this.onChange} placeholder='break clause date format yyyy-mm-dd'/><br/>
                agencyPhoneNo
                <input type='text' id='agencyPhoneNumber' onChange={this.onChange} placeholder='agency Telephone Number'/><br/>
                noRooms
                <input type='text' id='numberOfRooms' onChange={this.onChange} placeholder='number of rooms'/><br/>
                rent
                <input type='text' id='rent' onChange={this.onChange} placeholder='rent format 00.00'/><br/>
                notes
                <input type='text' id='notes' onChange={this.onChange} placeholder='notes here...'/><br/>
                address<br/>
                <input type='textblock' id='address1' onChange={this.onChange} placeholder='address line 1'/><br/>
                <input type='textblock' id='address2' onChange={this.onChange} placeholder='address line 2'/><br/>
                <input type='textblock' id='address3' onChange={this.onChange} placeholder='address line 3'/><br/>
                <input type='textblock' id='postCode' onChange={this.onChange} placeholder='Post Code'/><br/>
                deposit
                <input type='text' id='deposit' onChange={this.onChange} placeholder='deposit'/><br/>
                <input type = 'submit'/>
                <input type='button' value='MYsubmit' onClick={()=>this.addApartment()}/>
            </form>
          </div>
        );
      }
    };


export default AddApartment;