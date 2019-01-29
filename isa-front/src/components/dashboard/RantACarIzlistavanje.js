import React, {Component} from 'react'
import UserLoggedTabs from '../layout/UserLoggedTabs';
import { Link } from "react-router-dom"

const RentACarIzlistavanje = () => {

        return (
            <div>
                <UserLoggedTabs></UserLoggedTabs>
                <div className = "container center">
                    <h2 className="red-text lighten-1 center">Lista letova</h2>
                    <div className = "post card grey lighten-2">
                        <div className = "card-content container">
                            <span className = "card-title center">Marka i model</span>
                            <div className = "left-align">
                                <p>Broj sedišta:</p>
                                <p>Cena:</p>
                                <Link to = "/#">Više detalja</Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )

};
export default RentACarIzlistavanje;