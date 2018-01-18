import React, { Component } from 'react';
import {Route,
  BrowserRouter as Router,
  Redirect,
  NavLink,
  Switch,
  Link 
} from 'react-router-dom';
import logo from './logo.svg';
import Home from './components/Home'
import Apartments from './components/Apartments'
import AddApartment from './components/AddApartment'
import Calendar from './components/Calendar'
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <div className="container-fluid">
                  <ul className="header nav navbar-nav">
                    <li><NavLink to="/" exact activeClassName="active">Home</NavLink></li>  
                    <li><NavLink to="/apartments" activeClassName="active">Apartments</NavLink></li>
                    <li><NavLink to="/calendar" activeClassName="active">Calendar</NavLink></li>
                  </ul>
        </div>
        
        <Switch>
        <div className = "content">
          <Route exact path = "/" component={Home}/>
          <Route exact path = "/apartments" component={Apartments}/>
          <Route path = "/apartments/addApartment" component={AddApartment}/>
          <Route path = "/calendar" component={Calendar}/>

        </div>
        </Switch>
      </div>
    );
  }
}

export default App;
