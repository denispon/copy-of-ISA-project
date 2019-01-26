import React from "react";
import { NavLink } from "react-router-dom"
import "./friends.css"


const Friend = () => {

    return (
        <div className="center container">
            <div className="row container center">
                <p className="col s7">Dragan Ivetic</p>
                <NavLink to="/#" className=" red-text " >Obrisi prijatelja</NavLink>

            </div>
        </div>
    );

};

export default Friend;