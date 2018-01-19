import React from 'react';

const baseURL = "http://localhost:8080/qa-apartments3/Rest/apartment/json"

function create(apartmentObject){
    const request = new Request(baseURL, {
        method: "POST",
        headers : {
            'contentType' : 'application/json'
        },
        body : apartmentObject
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
        const stateToSend = {...this.state.apartment}
        create(JSON.stringify(stateToSend))
    }
    
   
      render(){
        return (
          <div className='pageheader'>
            <h2>Lets get adding son</h2>
            <form id='form'>
                <i>* indicates required fields</i><br/>
                Building Name
                <input type='text' id='buildingName' onChange={this.onChange} placeholder='building name'/>*<br/>
                Apartment Number
                <input type='text' id='apartmentNo' onChange={this.onChange} placeholder='apartment number'/>*<br/>
                Agency
                <input type='text' id='agency' onChange={this.onChange} placeholder='agency'/>*<br/>
                Landlord
                <input type='text' id='landlord' onChange={this.onChange} placeholder='landlord'/><br/>
                Tenant
                <input type='text' id='tenant' onChange={this.onChange} placeholder='tenant'/>*<br/>
                Lease Start
                <input type='text' id='leaseStart' onChange={this.onChange} placeholder='format: yyyy-mm-dd'/>*<br/>
                Lease End
                <input type='text' id='leaseEnd' onChange={this.onChange} placeholder='format: yyyy-mm-dd'/>*<br/>
                Break Clause
                <input type='text' id='breakClause' onChange={this.onChange} placeholder='format: yyyy-mm-dd'/>*<br/>
                Agency Phone Number
                <input type='text' id='agencyPhoneNo' onChange={this.onChange} placeholder='agency Telephone Number'/>*<br/>
                Number of Rooms
                <input type='text' id='noRooms' onChange={this.onChange} placeholder='number of rooms'/><br/>
                Rent
                <input type='text' id='rent' onChange={this.onChange} placeholder='rent format 00.00'/>*<br/>
                Notes
                <input type='text' id='notes' onChange={this.onChange} placeholder='notes here...'/><br/>
                Address
                <input type='textblock' id='address' onChange={this.onChange} placeholder='address line 1'/>*<br/>
                {/* 
                <input type='textblock' id='address2' onChange={this.onChange} placeholder='address line 2'/><br/>
                <input type='textblock' id='address3' onChange={this.onChange} placeholder='address line 3'/><br/>
                <input type='textblock' id='postCode' onChange={this.onChange} placeholder='Post Code'/><br/>
                */}
                Deposit
                <input type='text' id='deposit' onChange={this.onChange} placeholder='deposit'/>*<br/>
                <input type='button' value='MYsubmit' onClick={()=>this.addApartment()}/>
            </form>
          </div>
        );
      }
    };


export default AddApartment;