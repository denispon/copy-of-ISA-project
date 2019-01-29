import React from 'react'
import StarRating from './StarRating'
import CancelReservation from './CancelReservation';


const HotelReservation = () => {

    return (


        <div className="card">

            <div className="card-content">

                <span className="card-title red-text lighten-1"><strong>Smestaj</strong></span>

                <div className="container">
                    <div className="row ">
                        <div className="col s4">
                            <p>Hotel Backa</p>
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
                            <p>Soba 209</p>
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

export default HotelReservation;