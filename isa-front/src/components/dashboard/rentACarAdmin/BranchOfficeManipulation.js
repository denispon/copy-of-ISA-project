import React from "react"
import { NavLink } from "react-router-dom"
import ChangeBranchOffice from "./ChangeBranchOffice";


const BranchOfficeManipulation = () => {

    return (
        <div className="container">

            <h4 className="center red-text lighten-1">Filijale</h4>

            <div className="center">
                <NavLink to="#" className="indigo-text lighten-1">Dodaj novu filijalu</NavLink>

                <ChangeBranchOffice />
                <ChangeBranchOffice />
                <ChangeBranchOffice />
                <ChangeBranchOffice />

            </div>


        </div>
    );

};

export default BranchOfficeManipulation;