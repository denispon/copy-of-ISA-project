import React, { Component } from 'react'
import { BrowserRouter, Switch, Link, Route } from "react-router-dom";
import axios from 'axios'
import { connect } from 'react-redux'
//import { deleteHotel } from '../../../store/actions/HotelActions';
import "./izlistavanje.css"


class DodatnaUslugaIzlistavanjeAdmin extends Component {

    state = {
        usluge: [],
    }

    componentDidMount() {
        axios.get('http://localhost:8092/api/hotel/dodatneUsluge/all')
            .then(res => {
                console.log(res);
                this.setState({
                    usluge: res.data
                })
            })
    }

    /*componentDidUpdate() {
         axios.get('http://localhost:8092/api/hotel/hotel/all')
            .then(res => {
                console.log(res);
                this.setState({
                    hoteli: res.data
                })
        })
    }*/

    /*handleDeleteClick = (hotelId) => {
        this.props.deleteHotel(hotelId)
    }

    handleIzmeniClick = (hotelId) => {
    }*/

    render() {
        const { usluge } = this.state;
        var rezervisano = "";
        const uslugeList = usluge.length ? (usluge.map(usluga => {
            return (
                <div className="post card grey lighten-2">
                    <div className="card-content container">
                        <span className="card-title center"><strong>{usluga.id}</strong></span>
                        <div className="right-align">
                        </div>
                        <div className="left-align">
                            <p>Naziv: {usluga.additionalServiceName}</p>
                            <p>Cena: {usluga.additionalServicePrice}</p>
                            <p>Popust: {usluga.popust}</p>
                            <p>Hotel: {usluga.hotel_dodatneUsluge.name} {usluga.hotel_dodatneUsluge.adress}</p>
                            <button className="dugmici1 btn-floating btn-large waves-effect waves-light red right" /*onClick = {() => this.handleDeleteClick(hotel.id)}*/><i>x</i></button>
                            <button className="dugmici2 btn-floating btn-large waves-effect waves-light green right" /*onClick = {() => this.handleIzmeniClick(hotel.id)}*/>Izmeni</button>
                        </div>
                    </div>
                </div>
            )
        })) : (<div className="center">Nije pronadjena nijedana soba.</div>)

        return (
            <div>
                <div className="container center">
                    <h2 className="red-text lighten-1 center">Lista dodatnih usluga</h2>
                    {uslugeList}
                </div>
            </div>
        )
    }
}

/*const mapDispatchToProps = (dispatch) =>{
    return{
        deleteHotel: (hotel) => dispatch(deleteHotel(hotel))
    }
}*/

export default DodatnaUslugaIzlistavanjeAdmin;