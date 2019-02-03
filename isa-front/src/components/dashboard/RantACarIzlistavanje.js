import React, { Component } from 'react'
import UserLoggedTabs from '../layout/tabs/UserLoggedTabs';
import "./neregistrovan.css";
import axios from 'axios'


class RentACarIzlistavanje extends Component {

    state = {
        servisi: []
    }

    componentDidMount() {
        axios.get('http://localhost:8090/api/rentacar/rentACarService/all')//tvoj url
            .then(res => {
                console.log(res);
                this.setState({
                    servisi: res.data
                })
            })
    }

    handleVozilaClick = (serviceId) => {
        this.props.history.push('/vozila/' + serviceId)
    }

    handleFilijalaClick = (serviceId) => {
        this.props.history.push('/filijale/' + serviceId)
    }

    render() {
        const { servisi } = this.state;
        const servisiList = servisi.length ? (servisi.map(servis => {
            return (
                <div className="post card grey lighten-2">
                    <div className="card-content container">
                        <span className="card-title center">{servis.name}</span>
                        <div className="left-align">
                            <p>Adresa: {servis.adress}</p>
                            <p>Opis: {servis.description}</p>
                            <button className="buttons btn-small waves-effect waves-light indigo right" onClick={() => this.handleVozilaClick(servis.id)}>Vozila</button>
                            <button className="buttons btn-small waves-effect waves-light indigo right" onClick={() => this.handleFilijalaClick(servis.id)}>Filijale</button>
                        </div>
                    </div>
                </div>
            )
        })) : (<div className="center">Nije pronadjen nijedan servis.</div>)

        return (
            <div>
                <UserLoggedTabs></UserLoggedTabs>
                <div className="container center">
                    <h2 className="red-text lighten-1 center">Lista servisa</h2>
                    {servisiList}
                </div>
            </div>
        )
    }
}

export default RentACarIzlistavanje;