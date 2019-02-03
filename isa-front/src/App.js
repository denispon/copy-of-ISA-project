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
import CreateHotel from './components/dashboard/dodavanjaHotel/CreateHotel';
import CreateTipSobe from './components/dashboard/dodavanjaHotel/CreateTipSobe';
import CreateHotelskaSoba from './components/dashboard/dodavanjaHotel/CreateHotelskaSoba';
import CreateCenaSobe from './components/dashboard/dodavanjaHotel/CreateCenaSobe';
import CreateRezervacijaSobe from './components/dashboard/dodavanjaHotel/CreateRezervacijaSobe';
import CreateDodatnaUsluga from './components/dashboard/dodavanjaHotel/CreateDodatnaUsluga';
import CreatePrihodHotela from "./components/dashboard/dodavanjaHotel/CreatePrihodHotela";
import InvitationPage from "./components/dashboard/invitation/InvitationPage";
import HoteliIzlistavanjeAdmin from "./components/dashboard/izlistavanjeHotelAdmin/HotelIzlistavanjeAdmin"
import HotelskaSobaIzlistavanjeAdmin from "./components/dashboard/izlistavanjeHotelAdmin/HotelskaSobaIzlistavanjeAdmin"
import TipSobeIzlistavanjeAdmin from "./components/dashboard/izlistavanjeHotelAdmin/TipSobeIzlistavanjeAdmin"
import DodatnaUslugaIzlistavanjeAdmin from "./components/dashboard/izlistavanjeHotelAdmin/DodatnaUslugaIzlistavanjeAdmin"
import CenaSobeIzlistavanjeAdmin from "./components/dashboard/izlistavanjeHotelAdmin/CenaSobeIzlistavanjeAdmin"
import RezervacijaSobeIzlistavanjeAdmin from "./components/dashboard/izlistavanjeHotelAdmin/RezervacijaSobeIzlistavanjeAdmin";
import PrihodHotelaIzlistavanjeAdmin from "./components/dashboard/izlistavanjeHotelAdmin/PrihodHotelaIzlistavanjeAdmin";
import IzmenaHotelaAdmin from "./components/dashboard/izlistavanjeHotelAdmin/IzmenaHotelaAdmin";
import Sobe from "./components/dashboard/Sobe";
import Cenovnici from "./components/dashboard/Cenovnici";
import DodatneUsluge from "./components/dashboard/DodatneUsluge";
import Vozila from "./components/dashboard/Vozila";
import Filijale from "./components/dashboard/Filijale";
import CreateCenovnikUsluga from "./components/dashboard/dodavanjaHotel/CreateCenovnikUsluga";
import LetoviAdminDashboard from "./components/dashboard/letoviAdmin/LetoviAdminDashboard";
import IzmenaDodatnihUslugaAdmin from "./components/dashboard/izlistavanjeHotelAdmin/IzmenaDodatnihUslugaAdmin";
import IzmenaTipaAdmin from "./components/dashboard/izlistavanjeHotelAdmin/IzmenaTipaAdmin";
import IzmenaHotelskihSobaAdmin from "./components/dashboard/izlistavanjeHotelAdmin/IzmenaHotelskihSobaAdmin";
import CenovnikIzlistavanjeAdmin from "./components/dashboard/izlistavanjeHotelAdmin/CenovnikIzlistavanjeAdmin";
import IzmenaCenovnikaAdmin from "./components/dashboard/izlistavanjeHotelAdmin/IzmenaCenovnikaAdmin";





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


            <Route path="/userReservations" component={UserReservations}></Route>
            <Route exact path="/invitations" component={InvitationPage} />
            <Route path="/friends" component={Friends}></Route>
            <Route path="/korpa" component={ShoppingCart}></Route>
            <Route path="/userProfile" component={UserProfile}></Route>


            <Route path="/smestaj" component={HotelPretraga}></Route>
            <Route path="/letovi" component={LetoviPretraga}></Route>
            <Route exact path="/vozila" component={RentACarPretraga}></Route>
            <Route path="/listaHotela" component={HoteliIzlistavanje}></Route>
            <Route path="/listaLetova" component={LetoviIzlistavanje}></Route>
            <Route path="/listaVozila" component={RentACarIzlistavanje}></Route>
            <Route path="/prijavaKorisnika" component={PrijavaKorisnika}></Route>
            <Route path="/registracijaKorisnika" component={RegistracijaKorisnika}></Route>
            <Route path="/createHotel" component={CreateHotel}></Route>
            <Route path="/createRoomType" component={CreateTipSobe}></Route>
            <Route path="/createHotelRoom" component={CreateHotelskaSoba}></Route>
            <Route path="/createRoomPrice/:sobaId" component={CreateCenaSobe}></Route>
            <Route path="/createRoomReservation" component={CreateRezervacijaSobe}></Route>
            <Route path="/createAdditionalService" component={CreateDodatnaUsluga}></Route>
            <Route path="/createHotelIncome" component={CreatePrihodHotela}></Route>
            <Route path="/createCenovnik" component={CreateCenovnikUsluga}></Route>
            <Route path="/listaHotelaAdmin" component={HoteliIzlistavanjeAdmin}></Route>
            <Route path="/listaHotelskihSobaAdmin" component={HotelskaSobaIzlistavanjeAdmin}></Route>
            <Route path="/listaTipovaSobaAdmin" component={TipSobeIzlistavanjeAdmin}></Route>
            <Route path="/listaDodatnihUslugaAdmin" component={DodatnaUslugaIzlistavanjeAdmin}></Route>
            <Route path="/listaRezervacijaSobaAdmin" component={RezervacijaSobeIzlistavanjeAdmin}></Route>
            <Route path="/listaPrihodaHotelaAdmin" component={PrihodHotelaIzlistavanjeAdmin}></Route>
            <Route path="/listaCenovnikaAdmin" component={CenovnikIzlistavanjeAdmin}></Route>
            <Route path="/izmenaHotelaAdmin/:hotelId" component={IzmenaHotelaAdmin}></Route>
            <Route path="/izmenaDodatnihUslugaAdmin/:uslugaId" component={IzmenaDodatnihUslugaAdmin}></Route>
            <Route path="/izmenaTipovaAdmin/:tipId" component={IzmenaTipaAdmin}></Route>
            <Route path="/izmenaHotelskihSobaAdmin/:sobaId" component={IzmenaHotelskihSobaAdmin}></Route>
            <Route path="/izmenaCenovnikaAdmin/:cenovnikId" component={IzmenaCenovnikaAdmin}></Route>
            <Route path="/sobe/:hotelId" component={Sobe}></Route>
            <Route path="/cenovnici/:hotelId" component={Cenovnici}></Route>
            <Route path="/usluge/:hotelId" component={DodatneUsluge}></Route>
            <Route path="/vozila/:serviceId" component={Vozila}></Route>
            <Route path="/filijale/:serviceId" component={Filijale}></Route>
            <Route path="/izlistavanjeCenaSobeAdmin/:sobaId" component={CenaSobeIzlistavanjeAdmin}></Route>

          </Switch>
        </div>
      </BrowserRouter>
    );
  }
}

export default App;
