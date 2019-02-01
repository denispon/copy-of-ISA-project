import React, { Component } from 'react'
import FlightReservation from './FlightReservation'
import HotelReservation from './HotelReservation'
import CarReservation from './CarReservation';
import { connect } from 'react-redux'
import { addRentCarReservationToCollection } from "../../../store/actions/PurchasesActions"

class ReservationInfo extends Component {


    componentDidMount() {

        addRentCarReservationToCollection(this.props.reservation.carReservationId);

    }



    render() {
        return (

            <div className="container">
                <div className="card indigo darken-2">

                    <div className="card-content">

                        <span className="card-title flow-text white-text  "><strong>Id: {this.props.reservation.id}</strong></span>

                        <FlightReservation></FlightReservation>

                        <HotelReservation></HotelReservation>

                        {this.props.rentCarReservations && this.props.rentCarReservations.find(el => el.id == this.props.reservation.carReservationId) ?

                            <CarReservation carReservation={this.props.rentCarReservations.find(el => el.id == this.props.reservation.carReservationId)} ></CarReservation>
                            :
                            ''
                        }
                        <h6 className="white-text " ><strong>Ukupna cena: {this.props.reservation.price} din</strong></h6>


                    </div>

                </div>
            </div>

        );
    }

};


const mapStateToProps = (state) => {
    return {
        rentCarReservations: state.purchases.rentCarReservations,
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        addRentCarReservationToCollection: (id) => dispatch(addRentCarReservationToCollection(id))
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(ReservationInfo);
