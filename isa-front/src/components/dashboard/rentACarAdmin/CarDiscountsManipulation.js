import React from "react"
import ChangeCarDiscount from "./ChangeCarDiscount";
import { NavLink } from "react-router-dom"

const CarDiscountManipulation = ({ carDiscounts, cars }) => {

    return (
        <div className="container">

            <h4 className="center red-text lighten-1">Popusti na vozila</h4>

            <div className="center">
                <NavLink to="#" className="indigo-text lighten-1">Dodaj novi popust</NavLink>

                {carDiscounts.map(carDiscount => {

                    return (
                        <ChangeCarDiscount key={carDiscount.id} cars={cars} carDiscount={carDiscount} />
                    );

                })}
            </div>

        </div>
    );

};

export default CarDiscountManipulation;