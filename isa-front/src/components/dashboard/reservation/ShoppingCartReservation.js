import React from "react"
import FlightReservation from "./FlightReservation";
import HotelReservation from "./HotelReservation";
import CarReservation from "./CarReservation";


const ShoppingCartReservation = () => {

    return (
        <div className="center contrainer">
            <FlightReservation></FlightReservation>
            <HotelReservation></HotelReservation>
            <CarReservation></CarReservation>
        </div>
    );

};

export default ShoppingCartReservation;