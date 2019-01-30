import React from "react"
import ReservationInfo from "../reservation/ReservationInfo";

const Invitation = () => {

    return (

        <div className="card">
            <div className="card-content">
                <span className="card-title indigo-text lighten-1"><strong>Branko je kreirao rezervaciju za Vas:</strong></span>
                <ReservationInfo></ReservationInfo>
                <div className="row">
                    <div className="col s1">
                        <button className="btn  indigo lighten-1">Prihvati</button>
                    </div>
                    <div className="col s1">
                        <button className="btn red lighten-1 z-depth-0">Odbaci</button>
                    </div>
                </div>
            </div>

        </div>

    );

};

export default Invitation;