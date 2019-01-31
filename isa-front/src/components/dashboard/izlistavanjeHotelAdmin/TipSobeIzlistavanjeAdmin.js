import React, { Component } from 'react'
import { BrowserRouter, Switch, Link, Route } from "react-router-dom";
import axios from 'axios'
import { connect } from 'react-redux'
//import { deleteHotel } from '../../../store/actions/HotelActions';
import "./izlistavanje.css"


class TipSobeIzlistavanjeAdmin extends Component {

    state = {
        tipovi: [],
    }

    componentDidMount() {
        axios.get('http://localhost:8092/api/hotel/tipSobe/all')
            .then(res => {
                console.log(res);
                this.setState({
                    tipovi: res.data
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
        const { tipovi } = this.state;
        var rezervisano = "";
        const tipoviList = tipovi.length ? (tipovi.map(tip => {
            return (
                <div className="post card grey lighten-2">
                    <div className="card-content container">
                        <span className="card-title center"><strong>{tip.id}</strong></span>
                        <div className="right-align">
                        </div>
                        <div className="left-align">
                            <p>Naziv: {tip.roomType}</p>
                            <p>Kapacitet: {tip.kapacitet}</p>
                            <p>Hotel: {tip.hotel_tipSobe.name} {tip.hotel_tipSobe.adress}</p>
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
                    <h2 className="red-text lighten-1 center">Lista tipova soba</h2>
                    {tipoviList}
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

export default TipSobeIzlistavanjeAdmin;