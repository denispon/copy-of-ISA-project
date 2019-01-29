import React from "react";
import "./navBarLinks.css";
import { NavLink } from "react-router-dom";


const SingedAdminLinks = () => {

    return (
        <div>
            <ul className="right">
                <li className="isa_links">
                    <NavLink to="/#">Profil</NavLink>
                </li>
                <li className="isa_links">
                    <NavLink to="/#">Izloguj se</NavLink>
                </li>
            </ul>
        </div>
    );

};

export default SingedAdminLinks;