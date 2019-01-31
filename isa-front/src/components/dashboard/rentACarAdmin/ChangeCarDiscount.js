import React, { Component } from "react"

class ChangeCarDiscount extends Component {

    state = {

        datumPocetka: {},
        datumKraja: {},
        vremePocetka: {},
        vremeKraja: {}

    }

    componentDidMount() {

        var Pocetak = this.props.carDiscount.dateFrom.split("T");
        var Kraj = this.props.carDiscount.dateTo.split("T")


        this.setState(
            {
                datumPocetka: Pocetak[0],
                datumKraja: Kraj[0],
                vremePocetka: Pocetak[1],
                vremeKraja: Kraj[1]
            }
        );

    }

    render() {
        return (
            <div className="card indigo lighten-1">
                <div className="card-content">
                    <div className="card">
                        <div className="card-content">
                            <span className="card-title right"><a class="btn-floating btn-small waves-effect waves-light red"><i>x</i></a></span>
                            <span className="card-title indigo-text lighten-1 left"><strong>{this.props.carDiscount.id}</strong></span>

                            <div className="container">
                                <form className="white" >
                                    <div class="input-field col s12">
                                        <select className="browser-default">

                                            {this.props.cars.map(car => {
                                                return (
                                                    <option selected={car.id == this.props.carDiscount.carId.id} value={car.id}>Id vozila: {car.id}, Cena: {car.rentPrice}</option>
                                                );
                                            })}
                                        </select>
                                    </div>
                                    <div className="input-field">
                                        <label htmlFor="carDiscount">Popust</label>
                                        <input type="number" id='carDiscount' defaultValue={this.props.carDiscount.carDiscountPrecentage} />
                                    </div>

                                    <div>
                                        <label htmlFor="datum_pocetka" className="active">Datum pocetka popusta</label>
                                        <input type="date" id='datum_pocetka' value={this.state.datumPocetka} />
                                    </div>

                                    <div>
                                        <label htmlFor="vreme_pocetka" className="active">Vreme pocetka popusta</label>
                                        <input type="time" id='vreme_pocetka' value={this.state.vremePocetka} />
                                    </div>


                                    <div>
                                        <label htmlFor="datum_kraja" className="active">Datum kraja popusta</label>
                                        <input type="date" id='datum_kraja' value={this.state.datumKraja} />
                                    </div>

                                    <div>
                                        <label htmlFor="vreme_kraja" className="active">Vreme kraja popusta</label>
                                        <input type="time" id='vreme_kraja' value={this.state.vremeKraja} />
                                    </div>

                                    <div className="input-field">
                                        <button className="btn blue lighten-1 z-depth-0">Azuriraj</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
};

export default ChangeCarDiscount;