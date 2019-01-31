import React from "react"
import { NavLink } from "react-router-dom"
import ChangeBonusPointsDiscount from "./ChangeBonusPointsDiscount";


const BonusPointsDiscounts = ({ bonusPointsDiscounts }) => {

    return (
        <div className="container">

            <h4 className="center red-text lighten-1">Definisanje popusta na osnovu bonus poena</h4>

            <div className="center">
                <NavLink to="#" className="indigo-text lighten-1">Dodaj novi popust</NavLink>

                {bonusPointsDiscounts.map(discount => {
                    return (
                        <ChangeBonusPointsDiscount discount={discount} />
                    );
                })}


            </div>


        </div>
    );

};

export default BonusPointsDiscounts;