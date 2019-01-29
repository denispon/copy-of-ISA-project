import React, { Component } from 'react'
import UserLoggedTabs from '../layout/tabs/UserLoggedTabs';
import { Link } from "react-router-dom"
import axios from 'axios'


class HotelIzlistavanje extends Component {

    state = {
        hoteli: []
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

