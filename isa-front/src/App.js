import React, { Component } from "react";
import "./App.css";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Navbar from "./components/layout/Navbar";
import DashboardUserLogged from "./components/layout/tabs/UserLoggedTabs";
import Friends from "./components/dashboard/friends/FriendsComponent";
import UserProfile from "./components/dashboard/UserProfile";
import HotelPretraga from "./components/dashboard/HotelPretraga";
import LetoviPretraga from "./components/dashboard/LetoviPretraga";
import RentACarPretraga from "./components/dashboard/RentACarPretraga";
import HoteliIzlistavanje from "./components/dashboard/HoteliIzlistavanje";
import LetoviIzlistavanje from "./components/dashboard/LetoviIzlistavanje";
import RentACarIzlistavanje from "./components/dashboard/RantACarIzlistavanje";
import RegistracijaKorisnika from './components/dashboard/RegistracijaKorisnika';
import PrijavaKorisnika from './components/dashboard/PrijavaKorisnika';
import UserReservations from './components/dashboard/reservation/UserReservations';
import ShoppingCart from './components/dashboard/reservation/ShoppingCart';
import DashboardMainAdminLogged from './components/dashboard/mainAdmin/DashboardMainAdminLogged';
import DashboardRentACarAdminLogged from './components/dashboard/rentACarAdmin/DashboardRentACarAdminLogged';
import CreateHotel from './components/dashboard/CreateHotel';


class App extends Component {

  render() {
    return (
      <BrowserRouter>
        <div className="App">
          <Navbar />
          <Switch>
            <Route exact path="/" component={DashboardRentACarAdminLogged}></Route>
            <Route exact path="/" component={DashboardMainAdminLogged}></Route>
            <Route exact path="/" component={DashboardUserLogged}></Route>
            <Route path="/friends" component={Friends}></Route>
            <Route path="/korpa" component={ShoppingCart}></Route>
            <Route path="/userProfile" component={UserProfile}></Route>
            <Route path="/smestaj" component={HotelPretraga}></Route>
            <Route path="/letovi" component={LetoviPretraga}></Route>
            <Route path="/vozila" component={RentACarPretraga}></Route>
            <Route path="/listaHotela" component={HoteliIzlistavanje}></Route>
            <Route path="/listaLetova" component={LetoviIzlistavanje}></Route>
            <Route path="/listaVozila" component={RentACarIzlistavanje}></Route>
            <Route path="/prijavaKorisnika" component={PrijavaKorisnika}></Route>
            <Route path="/registracijaKorisnika" component={RegistracijaKorisnika}></Route>
            <Route path="/createHotel" component={CreateHotel}></Route>
            <Route path="/userReservations" component={UserReservations}></Route>
          </Switch>
        </div>
      </BrowserRouter>
    );
  }
}

export default App;
