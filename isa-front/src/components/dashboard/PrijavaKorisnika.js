import React, { Component } from 'react'
import UserLoggedTabs from '../layout/tabs/UserLoggedTabs';
import ReactDOM from 'react-dom';
import axios from 'axios';
import { NavLink } from "react-router-dom";
import "../layout/navbarLinks/navBarLinks.css";

class PrijavaKorisnika extends Component {
    render() {
        return (
            <div className="container">
                <h4>Prijavite se</h4>
                <form className="white">
                    <div className="input-field">
                        <label htmlFor="username">Korisnicko ime:</label>
                        <input type="text" id='username' />
                    </div>
                    <div className="input-field">
                        <label htmlFor="pass">Lozinka:</label>
                        <input type="password" id='pass' />
                    </div>
                    <input type="submit" className="btn blue lighten-1 z-depth-0" value="Prijava" />
                </form>

            </div>
        );
    }
}

export default PrijavaKorisnika;