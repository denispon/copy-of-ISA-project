import React, { Component } from "react";
import "./App.css";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Navbar from "./components/layout/Navbar";
import DashboardUserLogged from "./components/layout/UserLoggedTabs";
import Friends from "./components/dashboard/friends/FriendsComponent";
import UserProfile from "./components/dashboard/UserProfile";
import HotelPretraga from "./components/dashboard/HotelPretraga";

class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <div className="App">
          <Navbar />
          <Switch>
            <Route exact path="/" component={DashboardUserLogged}></Route>
            <Route path="/friends" component={Friends}></Route>
            <Route path="/userProfile" component={UserProfile}></Route>
            <Route path="/smestaj" component={HotelPretraga}></Route>
          </Switch>
        </div>
      </BrowserRouter>
    );
  }
}

export default App;
