import React, {Component} from 'react'
import UserLoggedTabs from '../layout/UserLoggedTabs';
import ReactDOM from 'react-dom';
import axios from 'axios';
import { NavLink } from "react-router-dom";
import "../layout/navbarLinks/navBarLinks.css";

class RegistracijaKorisnika extends Component
{
    render()
    {
        return(
            <div className="container">
                <h4>Registrujte se..    Vec imate nalog?</h4>
                <h5></h5>
                <h5><NavLink to="/prijavaKorisnika">Prijavite se</NavLink></h5>
                <form className="white">
                  <div className="input-field">
                     <label htmlFor="username">Korisnicko ime:</label>
                     <input type="text" id='username' />
                  </div>
                  <div className="input-field">
                     <label htmlFor="pass">Lozinka:</label>
                     <input type="password" id='pass' />
                  </div> 
                  <div className="input-field">
                     <label htmlFor="pass2">Ponovite lozinku:</label>
                     <input type="password" id='pass2' />
                  </div>
                  <div className="input-field">
                     <label htmlFor="name">Ime:</label>
                     <input type="text" id='name' />
                  </div> 
                  <div className="input-field">
                     <label htmlFor="surname">Prezime:</label>
                     <input type="text" id='surname' />
                  </div> 
                  <div className="input-field">
                     <label htmlFor="email">E-mail adresa:</label>
                     <input type="text" id='email' />
                  </div>
                  <input type="submit" className="btn blue lighten-1 z-depth-0" value="Registracija"/>
                </form>
            </div>
        );
    }
}

export default RegistracijaKorisnika