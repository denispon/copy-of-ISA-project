import React, { Component } from "react";
import ReservationInfo from "./ReservationInfo";
import { connect } from "react-redux"
import { getAllUserReservations, hideNeMozesOtkazatiRezervaciju, hideOtkazanaRezervacija } from "../../../store/actions/PurchasesActions"
import ReactNotification from "react-notifications-component";
import "react-notifications-component/dist/theme.css";

class UserReservations extends Component {

    constructor(props) {
        super(props);
        this.neMozeOtkazatiNotification = this.neMozeOtkazatiNotification.bind(this);
        this.notificationDOMRef = React.createRef();
    }

    neMozeOtkazatiNotification() {
        this.notificationDOMRef.current.addNotification({
            title: "Greska prilikom otkazivanja rezervacije",
            message: "Ne mozete otkazati ovu rezervaciju!",
            type: "danger",
            insert: "top",
            container: "top-center",
            animationIn: ["animated", "fadeIn"],
            animationOut: ["animated", "fadeOut"],
            dismiss: { duration: 2000 },
            dismissable: { click: true }
        });
    }

    otkazanaRezervacijaNotification = () => {
        this.notificationDOMRef.current.addNotification({
            title: "Rezervacija",
            message: "Uspesno otkazana rezervacija! Osvezite stranicu kako bi se primetile izmene.",
            type: "success",
            insert: "top",
            container: "top-center",
            animationIn: ["animated", "fadeIn"],
            animationOut: ["animated", "fadeOut"],
            dismiss: { duration: 2000 },
            dismissable: { click: true }
        });
    }

    componentDidMount() {

        var user = JSON.parse(localStorage.getItem('user'))
        if (user) {
            this.props.getAllUserReservations(user.id);
        }


    }




    render() {
        var user = JSON.parse(localStorage.getItem('user'));

        if (this.props.neMozeOtkazatiRezervaciju) {
            this.neMozeOtkazatiNotification();
            this.props.hideNeMozesOtkazatiRezervaciju();
        }

        if (this.props.otkazanaRezervacija) {
            this.otkazanaRezervacijaNotification();
            this.props.hideOtkazanaRezervacija();
        }

        return (

            <div>

                <h2 className="center red-text lighten-1">{user ? user.name : ''}'s reservations</h2>
                <div className="container center">
                    <ReactNotification ref={this.notificationDOMRef} />
                </div>
                {

                    this.props.userReservations ?
                        this.props.userReservations.map(reservation => {

                            return (
                                <ReservationInfo reservation={reservation} />
                            );
                        })
                        :
                        ''



                }



            </div>

        );
    }

};

const mapStateToProps = (state) => {
    return {
        userReservations: state.purchases.userReservations,
        neMozeOtkazatiRezervaciju: state.purchases.neMozeOtkazatiRezervaciju,
        otkazanaRezervacija: state.purchases.otkazanaRezervacija
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        getAllUserReservations: (id) => dispatch(getAllUserReservations(id)),
        hideNeMozesOtkazatiRezervaciju: () => dispatch(hideNeMozesOtkazatiRezervaciju()),
        hideOtkazanaRezervacija: () => dispatch(hideOtkazanaRezervacija())
    }
}



export default connect(mapStateToProps, mapDispatchToProps)(UserReservations);
