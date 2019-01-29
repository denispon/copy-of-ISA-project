import React, { Component } from 'react'
import UserLoggedTabs from '../layout/tabs/UserLoggedTabs';
import { Link } from "react-router-dom"
import axios from 'axios';

class LetoviIzlistavanje extends Component {
    state = {
        airlineData: []
    }

    componentDidMount() {
        axios.get('http://localhost:8091/api/aviocompany/company/all').then(res => {
            this.setState({
                airlineData: res.data
            })
        })
    }

    render() {

        return (
            <div className="post card grey lighten-2">
                {this.state.airlineData.map(airline =>
                    <div className="card-content container">
                        <span className="card-title center">{airline.name}</span>
                        <div className="left-align">
                            <p>Adresa: {airline.address}</p>
                            <p>Opis: {airline.description}</p>
                        </div>

                    </div>
                )}
            </div>
        )

    }


};
export default LetoviIzlistavanje;