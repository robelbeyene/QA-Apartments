import React from 'react';
import {NavLink} from 'react-router-dom';

class Home extends React.Component {
        // constructor(){
          // super()
        //     this.state={
              
        //     }
        // }
      render(){
        return (
          <div className='pageheader'>
            <div className='row'>
              <div className="col-md-6">
                <h2>QA Apartments</h2>
                <NavLink to="/apartments/addApartment" exact activeClassName="active"><button>Add Apartment</button></NavLink>
                <p>
                button with add person to apartment
                </p>
                <p>notifications</p>
                </div>
              </div>
          </div>
        );
      }
    };


export default Home;