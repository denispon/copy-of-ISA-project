import React, { Component } from "react"
import ShoppingCartReservation from "./ShoppingCartReservation";
import { connect } from "react-redux";
import { getUserShoppingCart, makeReservation, removeRentACarReservationFromShoppingCart, hideKreiranaRezervacija } from "../../../store/actions/PurchasesActions";
import ReactNotification from "react-notifications-component";
import "react-notifications-component/dist/theme.css";

class ShoppingCart extends Component {


    state = {

    }


    constructor(props) {
        super(props);
        this.kreiranaRezervacijaNotifikacija = this.kreiranaRezervacijaNotifikacija.bind(this);
        this.notificationDOMRef = React.createRef();
    }

    kreiranaRezervacijaNotifikacija() {
        this.notificationDOMRef.current.addNotification({
            title: "Rezervacija",
            message: "Uspesno kreirana rezervacija!",
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
            this.props.getUserShoppingCart(user.id);
        }



    }

    poruciIzKorpe = (event) => {

        this.props.makeReservation(this.props.userShoppingCart.id);

    }


    render() {

        if (this.props.kreiranaRezervacija) {
            this.kreiranaRezervacijaNotifikacija();
            this.props.hideKreiranaRezervacija();
        }

        return (
            <div>
                <h2 className="center red-text lighten-1">Korpa</h2>
                <div className="container center">
                    <ReactNotification ref={this.notificationDOMRef} />
                </div>
                {this.props.userShoppingCart != undefined ?
                    <div className="container">
                        <ShoppingCartReservation removeRentACarReservationFromShoppingCart={this.props.removeRentACarReservationFromShoppingCart} userShoppingCart={this.props.userShoppingCart} carReservation={this.props.carReservation} avioCompanyReservation={this.props.avioCompanyReservation} hotelReservation={this.props.hotelReservation}></ShoppingCartReservation>
                        <h5 className="red-text lighten-1" ><strong>Ukupna cena: {this.props.userShoppingCart.price} din</strong></h5>
                        <p>Bonus poeni</p>
                        <a class="btn-floating btn-small waves-effect waves-light red"><i class="material-icons">-</i></a>
                        {this.props.userShoppingCart.bonusPoints} poena
                    <a class="btn-floating btn-small waves-effect waves-light red"><i class="material-icons">+</i></a>

                        <div className="row right">
                            <div className="col s8">
                                <button className="btn  indigo lighten-1">Dodeli je prijatelju</button>
                            </div>
                            <div className="col s2">
                                <button className="btn red lighten-1 z-depth-0" onClick={this.poruciIzKorpe}>Naruci</button>
                            </div>
                        </div>
                    </div>

                    :

                    <div>
                        <h4 className="center indigo-text lighten-1">Vasa korpa je prazna</h4>
                    </div>
                }



            </div>
        );
    }

};

const mapStateToProps = (state) => {
    return {
        userShoppingCart: state.purchases.userShoppingCart,
        carReservation: state.purchases.carReservation,
        avioCompanyReservation: state.purchases.avioCompanyReservation,
        hotelReservation: state.purchases.hotelReservation,
        kreiranaRezervacija: state.purchases.kreiranaRezervacija
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        getUserShoppingCart: (id) => dispatch(getUserShoppingCart(id)),
        makeReservation: (id) => dispatch(makeReservation(id)),
        removeRentACarReservationFromShoppingCart: (id) => dispatch(removeRentACarReservationFromShoppingCart(id)),
        hideKreiranaRezervacija: () => dispatch(hideKreiranaRezervacija())

    }
}



export default connect(mapStateToProps, mapDispatchToProps)(ShoppingCart);
