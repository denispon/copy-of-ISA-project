import React from 'react';
import { Link } from "react-router-dom"

const KarticaHotela = ({hotel}) =>{

    return (
        <div className = "post card grey lighten-2">
            <div className = "card-content container">
                <span className = "card-title center">{hotel.naziv}</span>
                <div className = "left-align">
                    <p>Adresa: {hotel.adresa}</p>
                    <p>Opis: {hotel.opis}</p>
                    <Link to="/#">Prikaz na mapi</Link>
                </div>
            </div>
        </div>
    )
}

export default KarticaHotela;