import React, { Component } from 'react'
import UserLoggedTabs from '../layout/tabs/UserLoggedTabs';
import { Link } from "react-router-dom"
import MapContainer from "./GoogleMapa/MapContainer";
import "./neregistrovan.css";
import axios from 'axios'


class HotelIzlistavanje extends Component {

    state = {
        hoteli: []
    }

    componentDidMount() {
        const imeAdresa = this.props.match.params.imeAdresa;
        const datumOd = this.props.match.params.datumOd;
        const datumDo = this.props.match.params.datumDo;
        const brojSoba = this.props.match.params.brojSoba;
        const brojGostiju = this.props.match.params.brojGostiju;
        axios.get('http://localhost:8092/api/hotel/hotel/filter/'+ imeAdresa +'/-1/-1/-1/-1')
            .then(res => {
                console.log(res);
                this.setState({
                    hoteli: res.data
                })
            })
    }

    handleSobeClick = (hotelId) => {
        this.props.history.push('/sobe/'+hotelId)
    }

    handleCenovnikClick = (hotelId) => {
        this.props.history.push('/cenovnici/'+hotelId)
    }

    handleUslugeClick = (hotelId) => {
        this.props.history.push('/usluge/'+hotelId)
    }

    render() {
        const { hoteli } = this.state;
        const hoteliList = hoteli.length ? (hoteli.map(hotel => {
            return (
                <div className="post card grey lighten-2">
                    <div className="card-content container">
                        <span className="card-title center">{hotel.name}</span>
                        <div className="left-align">
                            <p>Adresa: {hotel.adress}</p>
                            <p>Opis: {hotel.promotionalDescription}</p>
                            <button className="buttons btn-small waves-effect waves-light indigo right" onClick = {() => this.handleUslugeClick(hotel.id)}>Dodatne usluge</button>
                            <button className="buttons btn-small waves-effect waves-light indigo right" onClick = {() => this.handleCenovnikClick(hotel.id)}>Cenovnik usluga</button>
                            <button className="buttons btn-small waves-effect waves-light indigo right" onClick = {() => this.handleSobeClick(hotel.id)}>Sobe</button>
                            <Link to="/#">Prikaz na mapi</Link>
                        </div>
                    </div>
                </div>
            )
        })) : (<div className="center">Nije pronadjen nijedan hotel.</div>)

        return (
            <div>
                <UserLoggedTabs></UserLoggedTabs>
                <div className="container center">
                    <h2 className="red-text lighten-1 center">Lista hotela</h2>
                    {hoteliList}
                </div>
            </div>
        )
    }
}

export default HotelIzlistavanje;


