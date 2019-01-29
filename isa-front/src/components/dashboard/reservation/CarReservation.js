import React from "react"
import StarRating from "./StarRating";
import CancelReservation from "./CancelReservation"

const CarReservation = () => {

    return (
        <div className="card">

            <div className="card-content">

                <span className="card-title red-text lighten-1"><strong>Vozilo</strong></span>
                <div className="container">
                    <div className="row ">
                        <div className="col s4">
                            <p>Zubac Komerc</p>
                        </div>
                        <div className="col s4">
                            <StarRating></StarRating>
                        </div>
                        <div className="col s4">
                            <CancelReservation></CancelReservation>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col s4">
                            <p>BMW x5</p>
                        </div>
                        <div className="col s4">
                            <StarRating></StarRating>
                        </div>
                    </div>
                </div>



            </div>

        </div>
    );

};

export default CarReservation;