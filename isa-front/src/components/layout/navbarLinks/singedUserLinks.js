import React from "react";
import { NavLink } from "react-router-dom";
import "./navBarLinks.css";

const SignedInLinks = () => {
  return (
    <div>
      <ul className="right">
        <li className="isa_links">
          <NavLink to="/korpa">Korpa</NavLink>
        </li>
        <li className="isa_links">
          <NavLink to="/invitations">Pozivnice</NavLink>
        </li>
        <li className="isa_links">
          <NavLink to="/userReservations">Rezervacije</NavLink>
        </li>
        <li className="isa_links">
          <NavLink to="/friends"> Prijatelji</NavLink>
        </li>
        <li className="isa_links">
          <NavLink to="/userProfile">Profil</NavLink>
        </li>
        <li className="isa_links">
          <NavLink to="/">Izloguj se</NavLink>
        </li>
      </ul>
    </div>
  );
};

export default SignedInLinks;
