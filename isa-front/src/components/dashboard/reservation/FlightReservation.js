import React from "react"
import StarRating from './StarRating'
import CancelReservation from './CancelReservation'

const FlightReservation = () => {

    return (

        <div className="card">

            <div className="card-content">

                <span className="card-title red-text lighten-1"><strong>Let</strong></span>

                <div className="container">
                    <div className="row ">
                        <div className="col s4">
                            <p>Srbobran-Tokio</p>
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
                            <p>Sediste N50</p>
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

export default FlightReservation;