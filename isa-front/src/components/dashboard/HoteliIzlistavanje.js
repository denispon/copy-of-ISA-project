import React, {Component} from 'react'
import { NavLink } from "react-router-dom"
import UserLoggedTabs from '../layout/UserLoggedTabs';
import "./izlistavanje.css"

class HotelPretraga extends Component {

    render() {
        return (
            <div>
                <UserLoggedTabs></UserLoggedTabs>
                <div className = "container center">
                    <h2 className="red-text lighten-1 center">Lista hotela</h2>
                    <div className = "post card grey lighten-4">
                        <div className = "card-content container">
                            <span className = "card-title center">Mali Poslovni Sistem</span>
                            <div className = "left-align">
                                <p>Adresa:</p>
                                <p>Opis:</p>
                                <NavLink to="https://www.youtube.com/">Prikaz na mapi</NavLink>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

};
export default HotelPretraga;
