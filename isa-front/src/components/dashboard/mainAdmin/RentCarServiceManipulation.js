import React from "react"
import { NavLink } from "react-router-dom"
import ChangeRentService from "../rentACarAdmin/ChangeRentService"


const RentCarServiceManipulation = ({ rentACarServices }) => {

    return (
        <div className="container">

            <h4 className="center red-text lighten-1">Rent servisi</h4>

            <div className="center">
                <NavLink to="#" className="indigo-text lighten-1">Dodaj novi rent servis</NavLink>

                {rentACarServices.map(rentACarService => {
                    return (
                        <ChangeRentService rentACarService={rentACarService} key={rentACarService.id} />
                    )
                })}

            </div>


        </div>
    );



}

export default RentCarServiceManipulation;