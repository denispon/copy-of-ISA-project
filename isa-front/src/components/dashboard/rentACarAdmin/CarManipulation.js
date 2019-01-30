import React from "react"
import { NavLink } from "react-router-dom";
import ChangeCar from "./ChangeCar";


const CarManipulation = () => {

    return (
        <div className="container">

            <h4 className="center red-text lighten-1">Vozila</h4>

            <div className="center">
                <NavLink to="#" className="indigo-text lighten-1">Dodaj novo vozilo</NavLink>

                <ChangeCar />
                <ChangeCar />
                <ChangeCar />
            </div>

        </div>
    );

};

export default CarManipulation;