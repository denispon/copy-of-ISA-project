import React, {Component} from 'react'
import UserLoggedTabs from '../layout/UserLoggedTabs';
import "./izlistavanje.css"

const LetoviIzlistavanje = () => {

        return (
            <div>
                <UserLoggedTabs></UserLoggedTabs>
                <div className = "container center">
                    <h2 className="red-text lighten-1 center">Lista letova</h2>
                    <div className = "post card grey lighten-2">
                        <div className = "card-content container">
                            <span className = "card-title center">Prevoznik</span>
                            <div className = "left-align">
                                <p>Vreme i mesto polaska:</p>
                                <p>Vreme i mesto dolaska:</p>
                                <p>Broj stajanja:</p>
                                <p>Cena:</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )

};
export default LetoviIzlistavanje;