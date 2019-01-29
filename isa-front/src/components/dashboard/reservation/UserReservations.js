import React from "react";
import ReservationInfo from "./ReservationInfo";


const UserReservations = () => {

    return (

        <div>

            <h2 className="center red-text lighten-1">Veljko's reservations</h2>

            <ReservationInfo></ReservationInfo>
            <ReservationInfo></ReservationInfo>
            <ReservationInfo></ReservationInfo>

        </div>

    );

};

export default UserReservations;