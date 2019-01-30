import React, { Component } from "react"


class ChangeCar extends Component {

    state = {

    }

    render() {
        return (
            <div className="card indigo lighten-1">
                <div className="card-content">
                    <div className="card">
                        <div className="card-content">
                            <span className="card-title right"><a class="btn-floating btn-small waves-effect waves-light red"><i>x</i></a></span>
                            <span className="card-title indigo-text lighten-1 left"><strong>Id vozila</strong></span>

                            <div className="container">
                                <form className="white" >
                                    <div className="input-field">
                                        <label htmlFor="rentPrice">Cena</label>
                                        <input type="text" id='rentPrice' />
                                    </div>
                                    <div class="input-field col s12">
                                        <select className="browser-default">
                                            <option value="" disabled selected>Tip vozila</option>
                                            <option value="1">Option 1</option>
                                            <option value="2">Option 2</option>
                                            <option value="3">Option 3</option>
                                        </select>
                                    </div>
                                    <div class="input-field col s12">
                                        <select className="browser-default">
                                            <option value="" disabled selected>Filijala</option>
                                            <option value="1">Option 1</option>
                                            <option value="2">Option 2</option>
                                            <option value="3">Option 3</option>
                                        </select>
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

export default ChangeCar;