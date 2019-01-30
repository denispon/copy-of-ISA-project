import React from "react"
import ChangeCarDiscount from "./ChangeCarDiscount";
import { NavLink } from "react-router-dom"

const CarDiscountManipulation = () => {

    return (
        <div className="container">

            <h4 className="center red-text lighten-1">Popusti na vozila</h4>

            <div className="center">
                <NavLink to="#" className="indigo-text lighten-1">Dodaj novi popust</NavLink>

                <ChangeCarDiscount />
                <ChangeCarDiscount />
                <ChangeCarDiscount />
                <ChangeCarDiscount />
            </div>

        </div>
    );

};

export default CarDiscountManipulation;