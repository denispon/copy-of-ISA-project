import React from "react"
import StarRating from "./StarRating";
import CancelReservation from "./CancelReservation"
import DeleteFromShoppingCart from "./DeleteFromShoppingCart"
import { BrowserRouter, Switch, Route } from "react-router-dom";

//Ovde imamo situaciju kada je objekat slozen iz vise objekata
//pri prvom renderovanju ne ucitaju se svi objekti unutar njega
//i ukoliko ostavimo samo izraz npr carReservation.service.name
//pucace nam error cannot get name of undefined, jer service jos nije ucitan
//zbog toga na svaki ispis je postavljen i uslov ukoliko je objekat jos undefined da se nista ne ispisuje
//i tek kada dodje da mu dozvoli ispis

const CarReservation = ({ carReservation }) => {

    return (
        <div className="card">

            <div className="card-content">

                <span className="card-title red-text lighten-1"><strong>Vozilo</strong></span>
                <div className="container">
                    <div className="row ">
                        <div className="col s4">
                            {carReservation.service
                                && <p>{carReservation.service.name}</p>
                            }

                        </div>
                        <BrowserRouter>
                            <div className="col s4">
                                <Route path="/userReservations" component={StarRating}></Route>
                            </div>
                        </BrowserRouter>
                        <BrowserRouter>
                            <div className="col s4">
                                <Switch>
                                    <Route exact path="/korpa" component={DeleteFromShoppingCart}></Route>
                                    <Route exact path="/userReservations" component={CancelReservation}></Route>
                                </Switch>
                            </div>
                        </BrowserRouter>
                    </div>
                    <div className="row">
                        <div className="col s4">
                            {carReservation.reservedCar && carReservation.reservedCar.carType
                                && <p>{carReservation.reservedCar.carType.brand} {carReservation.reservedCar.carType.model} {carReservation.reservedCar.carType.modelYear}. {carReservation.reservedCar.carType.carType} broj sedista: {carReservation.reservedCar.carType.numberOfSeats} </p>
                            }
                        </div>
                        <BrowserRouter>
                            <div className="col s4">
                                <Route path="/userReservations" component={StarRating}></Route>
                            </div>
                        </BrowserRouter>
                    </div>
                    <div>
                        <p className="indigo-text left"><strong>Datum od:</strong> {carReservation.dateFrom}</p>
                        <br />
                        <p className="indigo-text left"><strong>Datum do:</strong> {carReservation.dateTo}</p>
                        <br />
                        <br />
                    </div>
                    <p className="red-text lighten-3 left"> <strong>Cena po danu: {carReservation.reservedCar && carReservation.reservedCar.rentPrice} din</strong></p>
                </div>



            </div>

        </div>
    );

};

export default CarReservation;