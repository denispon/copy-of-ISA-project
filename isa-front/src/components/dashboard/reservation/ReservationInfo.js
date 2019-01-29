import React from 'react'
import FlightReservation from './FlightReservation'
import HotelReservation from './HotelReservation'
import CarReservation from './CarReservation';


const ReservationInfo = () => {

    return (

        <div className="container">
            <div className="card indigo darken-2">

                <div className="card-content">

                    <span className="card-title flow-text white-text  "><strong>Rezervacija 1028</strong></span>

                    <FlightReservation></FlightReservation>

                    <HotelReservation></HotelReservation>

                    <CarReservation></CarReservation>

                </div>

            </div>
        </div>

    );
};


export default ReservationInfo;