import React, { Component } from 'react'
import "./registrovan.css"
import axios from 'axios'


class LoggedUserHotelList extends Component {

    state = {
        hoteli: []
    }

    componentDidMount() {
        /*const imeAdresa = this.props.match.params.imeAdresa; 
        const datumOd = this.props.match.params.datumOd;
        const datumDo = this.props.match.params.datumDo;
        const brojSoba = this.props.match.params.brojSoba;
        const brojGostiju = this.props.match.params.brojGostiju;*/
        axios.get('http://localhost:8092/api/hotel/hotel/all')
            .then(res => {
                console.log(res);
                this.setState({
                    hoteli: res.data
                })
            })
    }

    handleSobeClick = (hotelId) => {
        this.props.history.push('/sobeLogged/'+hotelId /*+'/'+this.props.match.params.datumOd+'/'+this.props.match.params.datumDo*/)
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
                            <button className="buttonsReg btn-small waves-effect waves-light indigo right" onClick = {() => this.handleUslugeClick(hotel.id)}>Dodatne usluge</button>
                            <button className="buttonsReg btn-small waves-effect waves-light indigo right" onClick = {() => this.handleCenovnikClick(hotel.id)}>Cenovnik usluga</button>
                            <button className="buttonsReg btn-small waves-effect waves-light indigo right" onClick = {() => this.handleSobeClick(hotel.id)}>Sobe</button>
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

export default LoggedUserHotelList;