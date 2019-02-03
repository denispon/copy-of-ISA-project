import React, { Component } from 'react'
import axios from 'axios'
import { NavLink } from 'react-router-dom'


class Cenovnici extends Component {

    state = {
        vozila: [],
        sakriPretragu: true,
        ponistiPretragu: false,
        carType: '',
        datumPocetka: undefined,
        datumKraja: undefined,
        vremePocetka: undefined,
        vremeKraja: undefined,
        dateFrom: '',
        dateTo: ''
    }

    componentDidMount() {
        this.getAllCars();
    }

    getAllCars = () => {
        const id = this.props.match.params.serviceId;//id servisa
        axios.get('http://localhost:8090/api/rentacar/car/getByRentService/' + id)//tvoj url za pronalazak vozila po id servisa
            .then(res => {
                console.log(res);
                this.setState({
                    vozila: res.data
                })
            })
    }

    toggleForm = () => {
        this.setState({
            sakriPretragu: false
        })
    }

    hideForm = () => {
        this.setState({
            sakriPretragu: true
        })
    }

    handleSubmit = (e) => {
        e.preventDefault();

    }

    handleDateTimeChange = (e) => {

        if (e.target.id == "datumPocetka" || e.target.id == "vremePocetka") {

            var datumPocetka = undefined;
            var vremePocetka = undefined;
            if (e.target.id == "datumPocetka") {
                datumPocetka = e.target.value;
                if (this.state.vremePocetka)
                    vremePocetka = this.state.vremePocetka;
            }
            else {
                vremePocetka = e.target.value;
                if (this.state.datumPocetka)
                    datumPocetka = this.state.datumPocetka;

            }

            var formatDatumIVremeZaApi = datumPocetka + 'T' + vremePocetka + ':00';

            this.setState({

                datumPocetka: datumPocetka,
                vremePocetka: vremePocetka,
                dateFrom: formatDatumIVremeZaApi

            })

        }
        else if (e.target.id == "datumKraja" || e.target.id == "vremeKraja") {

            var datumKraja = undefined;
            var vremeKraja = undefined;
            if (e.target.id == "datumKraja") {
                datumKraja = e.target.value;
                if (this.state.vremeKraja)
                    vremeKraja = this.state.vremeKraja;
            }
            else {
                vremeKraja = e.target.value;
                if (this.state.datumKraja)
                    datumKraja = this.state.datumKraja;

            }

            var formatDatumIVremeZaApi = datumKraja + 'T' + vremeKraja + ":00";

            this.setState({

                datumKraja: datumKraja,
                vremeKraja: vremeKraja,
                dateTo: formatDatumIVremeZaApi

            })

        }


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

                <div className="container center">
                    <h2 className="red-text lighten-1 center">Vozila servisa {imeServisa}</h2>
                    {this.props.ulogovanUser && this.state.sakriPretragu ?
                        <NavLink to="#" onClick={this.toggleForm}>Prikazi formu za rezervaciju</NavLink>
                        :
                        ''
                    }
                    {this.props.ulogovanUser && this.state.sakriPretragu == false ?
                        <div>
                            <NavLink to="#" onClick={this.hideForm}>Sakrij formu</NavLink>
                            <div className="card">
                                <div className="card-content">

                                    <div className="container">
                                        <form className="white" onSubmit={this.handleSubmit} >

                                            <div>
                                                <label htmlFor="datumPocetka" className="active">Datum pocetka rezervacije</label>
                                                <input type="date" id='datumPocetka' onChange={this.handleDateTimeChange} value={this.state.datumPocetka} />
                                            </div>

                                            <div>
                                                <label htmlFor="vremePocetka" className="active">Vreme pocetka rezervacije</label>
                                                <input type="time" id='vremePocetka' onChange={this.handleDateTimeChange} value={this.state.vremePocetka} />
                                            </div>


                                            <div>
                                                <label htmlFor="datumKraja" className="active">Datum kraja rezervacije</label>
                                                <input type="date" id='datumKraja' onChange={this.handleDateTimeChange} value={this.state.datumKraja} />
                                            </div>

                                            <div>
                                                <label htmlFor="vremeKraja" className="active">Vreme kraja rezervacije</label>
                                                <input type="time" id='vremeKraja' onChange={this.handleDateTimeChange} value={this.state.vremeKraja} />
                                            </div>

                                            <div className="input-field">
                                                <button className="btn purple darken-3 z-depth-0">Pretraga</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        :
                        ''
                    }
                    {
                        this.state.ponistiPretragu ?

                            <NavLink to="#" onClick={this.getAllCars}>Ponistite pretragu</NavLink>


                            :
                            ''
                    }


                    {vozilaList}
                </div>
            </div>
        )
    }
}

export default Cenovnici;