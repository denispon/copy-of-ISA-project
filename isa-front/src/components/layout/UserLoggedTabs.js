import React from "react";
import { NavLink } from "react-router-dom";
import "./layout.css"

const UserLoggedTabs = () => {

  return (

    <div className="row container">

      <ul className="tabs userLoggedTabsDiv">
        <li className="tab col s4">
          <NavLink to="/#" className="white-text text-darken-4">Letovi</NavLink>
        </li>
        <li className="tab col s4">
          <NavLink to="/#" className="white-text text-darken-4">Smestaj</NavLink>
        </li>
        <li className="tab col s4">
          <NavLink to="/#" className="white-text text-darken-4">Vozila</NavLink>
        </li>
      </ul>

    </div>

  );
};

export default UserLoggedTabs;
