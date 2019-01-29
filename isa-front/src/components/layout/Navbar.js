import React from "react";
import { Link } from "react-router-dom";
import SingedUserLinks from "./navbarLinks/singedUserLinks";
import SignedOutOutLinks from './navbarLinks/SignedOutUserLinks';
import SignedInLinks from "./navbarLinks/singedUserLinks";

const Navbar = () => {
  return (
    <nav className="nav-wrapper indigo darken-2">
      <div className="container">
        <Link to="/" className="brand-logo left">
          ISA
        </Link>
        <SignedOutOutLinks />
        <SignedInLinks></SignedInLinks>
      </div>
    </nav>
  );
};

export default Navbar;
