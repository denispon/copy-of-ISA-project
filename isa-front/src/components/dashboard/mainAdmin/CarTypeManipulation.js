import React from "react"
import { NavLink } from "react-router-dom"
import ChangeCarType from "./ChangeCarType";


const CarTypeManipulation = ({ carTypes }) => {


    return (
        <div className="container">

            <h4 className="center red-text lighten-1">Tipovi vozila</h4>

            <div className="center">
                <NavLink to="#" className="indigo-text lighten-1">Dodaj novi tip vozila</NavLink>

                {carTypes.map(carType => {
                    return (
                        <ChangeCarType carType={carType} key={carType.id} />
                    )
                })}

            </div>


        </div>
    );

};

export default CarTypeManipulation;