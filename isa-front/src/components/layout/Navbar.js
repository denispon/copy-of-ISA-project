import React from "react";
import { Link } from "react-router-dom";
import SingedUserLinks from "./navbarLinks/singedUserLinks";
import SignedOutOutLinks from './navbarLinks/SignedOutUserLinks';

const Navbar = () => {
  return (
    <nav className="nav-wrapper indigo darken-2">
      <div className="container">
        <Link to="/" className="brand-logo left">
          ISA
        </Link>
        <SignedOutOutLinks/>
      </div>
    </nav>
  );
};

export default Navbar;
