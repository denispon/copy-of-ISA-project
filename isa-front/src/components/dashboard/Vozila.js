import React, { Component } from 'react'
import UserLoggedTabs from '../layout/tabs/UserLoggedTabs';
import axios from 'axios'


class Cenovnici extends Component {

    state = {
        vozila: []
    }

    componentDidMount() {
        const id = this.props.match.params.serviceId;//id servisa
        axios.get('http://localhost:8090/api/rentacar/car/getByRentService/' + id)//tvoj url za pronalazak vozila po id servisa
            .then(res => {
                console.log(res);
                this.setState({
                    vozila: res.data
                })
            })
    }

    render() {
        const { vozila } = this.state;
        var imeServisa = "";
        const vozilaList = vozila.length ? (vozila.map(vozilo => {
            imeServisa = vozilo.rentService.name;
            return (
                <div className="post card grey lighten-2">
                    <div className="card-content container">
                        <span className="card-title center"><strong>{vozilo.carType.model} {vozilo.carType.brand}</strong></span>
                        <div className="left-align">
                            <p>Cena: {vozilo.rentPrice}</p>
                            <p>Filijala: {vozilo.branchOffice.name} {vozilo.branchOffice.city} {vozilo.branchOffice.adress}</p>
                        </div>
                    </div>
                </div>
            )
        })) : (<div className="center">Nisu pronadjena vozila.</div>)

        return (
            <div>
                <UserLoggedTabs></UserLoggedTabs>
                <div className="container center">
                    <h2 className="red-text lighten-1 center">Vozila servisa {imeServisa}</h2>
                    {vozilaList}
                </div>
            </div>
        )
    }
}

export default Cenovnici;