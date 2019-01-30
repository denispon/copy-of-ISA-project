import React, { Component } from "react"

class ChangeCarDiscount extends Component {

    state = {

    }

    render() {
        return (
            <div className="card indigo lighten-1">
                <div className="card-content">
                    <div className="card">
                        <div className="card-content">
                            <span className="card-title right"><a class="btn-floating btn-small waves-effect waves-light red"><i>x</i></a></span>
                            <span className="card-title indigo-text lighten-1 left"><strong>Id popusta</strong></span>

                            <div className="container">
                                <form className="white" >
                                    <div class="input-field col s12">
                                        <select className="browser-default">
                                            <option value="" disabled selected>Vozilo</option>
                                            <option value="1">Option 1</option>
                                            <option value="2">Option 2</option>
                                            <option value="3">Option 3</option>
                                        </select>
                                    </div>
                                    <div className="input-field">
                                        <label htmlFor="carDiscount">Popust</label>
                                        <input type="number" id='carDiscount' />
                                    </div>

                                    <div>
                                        <label htmlFor="datum_pocetka" className="active">Datum pocetka popusta</label>
                                        <input type="date" id='datum_pocetka' className="datepicker" />
                                    </div>

                                    <div>
                                        <label htmlFor="vreme_pocetka" className="active">Vreme pocetka popusta</label>
                                        <input type="time" id='vreme_pocetka' />
                                    </div>


                                    <div>
                                        <label htmlFor="datum_kraja" className="active">Datum kraja popusta</label>
                                        <input type="date" id='datum_kraja' className="datepicker" />
                                    </div>

                                    <div>
                                        <label htmlFor="vreme_kraja" className="active">Vreme kraja popusta</label>
                                        <input type="time" id='vreme_kraja' />
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