import React from "react"
import FlightReservation from "./FlightReservation";
import HotelReservation from "./HotelReservation";
import CarReservation from "./CarReservation";



const ShoppingCartReservation = ({ carReservation, hotelReservation, avioCompanyReservation }) => {

    return (



        <div className=" contrainer">
            {avioCompanyReservation != undefined ? <FlightReservation></FlightReservation> : ''}
            {hotelReservation != undefined ? <HotelReservation></HotelReservation> : ''}
            {carReservation != undefined ? <CarReservation carReservation={carReservation}></CarReservation> : ''}

        </div>
    );

};

export default ShoppingCartReservation;