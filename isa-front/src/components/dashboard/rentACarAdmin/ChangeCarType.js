import React, { Component } from "react"


class ChangeCarType extends Component {

    state = {

    }

    render() {
        return (
            <div className="card indigo lighten-1">
                <div className="card-content">
                    <div className="card">
                        <div className="card-content">
                            <span className="card-title right"><a class="btn-floating btn-small waves-effect waves-light red"><i>x</i></a></span>
                            <span className="card-title indigo-text lighten-1 left"><strong>Id tipa vozila</strong></span>



                            <div className="container">
                                <form className="white" >
                                    <div className="input-field">
                                        <label htmlFor="brend">Brend</label>
                                        <input type="text" id='brend' />
                                    </div>
                                    <div className="input-field">
                                        <label htmlFor="model">Model</label>
                                        <input type="text" id='model' />
                                    </div>
                                    <div className="input-field">
                                        <label htmlFor="godinaProizvodnje">Godina proizvodnje</label>
                                        <input type="number" id='godinaProizvodnje' />
                                    </div>
                                    <div className="input-field">
                                        <label htmlFor="vrsta">Vrsta auta</label>
                                        <input type="text" id='vrsta' />
                                    </div>
                                    <div className="input-field">
                                        <label htmlFor="brojSedista">Broj sedista</label>
                                        <input type="number" id='brojSedista' />
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

export default ChangeCarType;