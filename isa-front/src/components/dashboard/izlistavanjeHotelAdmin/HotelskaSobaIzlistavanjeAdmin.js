import React, { Component } from 'react'
import { BrowserRouter, Switch, Link, Route } from "react-router-dom";
import axios from 'axios'
import { connect } from 'react-redux'
//import { deleteHotel } from '../../../store/actions/HotelActions';
import "./izlistavanje.css"


class HotelskaSobaIzlistavanjeAdmin extends Component {

    state = {
        sobe: [],
    }

    componentDidMount() {
        axios.get('http://localhost:8092/api/hotel/hotelskaSoba/all')
            .then(res => {
                console.log(res);
                this.setState({
                    sobe: res.data
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
        const { sobe } = this.state;
        var rezervisano = "";
        const sobeList = sobe.length ? (sobe.map(soba => {
            if(soba.reserved){
                rezervisano = "DA";
            }else{
                rezervisano = "NE";
            }
            return (
                <div className="post card grey lighten-2">
                    <div className="card-content container">
                        <span className="card-title center"><strong>{soba.id}</strong></span>
                        <div className="right-align">
                        </div>
                        <div className="left-align">
                            <p>Sprat: {soba.floor}</p>
                            <p>Originalna cena: {soba.originalnaCena}</p>
                            <p>Rezervisana: {rezervisano}</p>
                            <p>Tip sobe: {soba.tipSobe_hotelskeSobe.roomType}</p>
                            <p>Hotel: {soba.hotel_hotelskeSobe.name} {soba.hotel_hotelskeSobe.adress}</p>
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
                    <h2 className="red-text lighten-1 center">Lista hotelskih soba</h2>
                    {sobeList}
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

export default HotelskaSobaIzlistavanjeAdmin;