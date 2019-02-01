import React, { Component } from 'react'
import { BrowserRouter, Switch, Link, Route } from "react-router-dom";
import axios from 'axios'
import { connect } from 'react-redux'
import { deleteHotel } from '../../../store/actions/HotelActions';


class HotelIzlistavanjeAdmin extends Component {

    state = {
        hoteli: [],
    }

    componentDidMount() {
        axios.get('http://localhost:8092/api/hotel/hotel/all')
            .then(res => {
                console.log(res);
                this.setState({
                    hoteli: res.data
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

    handleDeleteClick = (hotelId) => {
        this.props.deleteHotel(hotelId)
    }

    handleIzmeniClick = (hotelId) => {
        this.props.history.push('/izmenaHotelaAdmin/'+hotelId)
    }

    render() {
        const { hoteli } = this.state;
        const hoteliList = hoteli.length ? (hoteli.map(hotel => {
            return (
                <div className="post card grey lighten-2">
                    <div className="card-content container">
                        <span className="card-title center"><strong>{hotel.name}</strong></span>
                        <div className="right-align">
                        </div>
                        <div className="left-align">
                            <p>Adresa: {hotel.adress}</p>
                            <p>Opis: {hotel.promotionalDescription}</p>
                            <Link to="/#">Prikaz na mapi</Link>
                            <button className="btn-floating btn-large waves-effect waves-light red right" onClick = {() => this.handleDeleteClick(hotel.id)}><i>x</i></button>
                            <button className="btn-floating btn-large waves-effect waves-light green right" onClick = {() => this.handleIzmeniClick(hotel.id)}>Izmeni</button>
                            <p className="w hide">Adresa: {hotel.adress}</p>
                            <p className="w hide">Opis: {hotel.promotionalDescription}</p>
                        </div>
                    </div>
                </div>
            )
        })) : (<div className="center">Nije pronadjen nijedan hotel.</div>)

        return (
            <div>
                <div className="container center">
                    <h2 className="red-text lighten-1 center">Lista hotela</h2>
                    {hoteliList}
                </div>
            </div>
        )
    }
}

const mapDispatchToProps = (dispatch) =>{
    return{
        deleteHotel: (hotel) => dispatch(deleteHotel(hotel))
    }
}

export default connect(null, mapDispatchToProps)(HotelIzlistavanjeAdmin);