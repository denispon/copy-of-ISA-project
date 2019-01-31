import React from "react"
import { NavLink } from "react-router-dom";
import ChangeCar from "./ChangeCar";


const CarManipulation = ({ cars, carTypes, branchOffices }) => {

    return (
        <div className="container">

            <h4 className="center red-text lighten-1">Vozila</h4>

            <div className="center">
                <NavLink to="#" className="indigo-text lighten-1">Dodaj novo vozilo</NavLink>

                {cars.map(car => {
                    return (
                        <ChangeCar car={car} carTypes={carTypes} branchOffices={branchOffices} />
                    );
                })}
            </div>

        </div>
    );

};

export default CarManipulation;