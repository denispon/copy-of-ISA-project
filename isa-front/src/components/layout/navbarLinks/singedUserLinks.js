import React from "react";
import { NavLink } from "react-router-dom";
import "./navBarLinks.css";

const SignedInLinks = () => {
  return (
    <div>
      <ul className="right">
        <li className="isa_links">
          <NavLink to="/pocetna">korpa</NavLink>
        </li>
        <li className="isa_links">
          <NavLink to="/#">invitacije</NavLink>
        </li>
        <li className="isa_links">
          <NavLink to="/#">rezervacije</NavLink>
        </li>
        <li className="isa_links">
          <NavLink to="/friends"> prijatelji</NavLink>
        </li>
        <li className="isa_links">
          <NavLink to="/userProfile">profil</NavLink>
        </li>
        <li className="isa_links">
          <NavLink to="/">izloguj se</NavLink>
        </li>
      </ul>
    </div>
  );
};

export default SignedInLinks;
