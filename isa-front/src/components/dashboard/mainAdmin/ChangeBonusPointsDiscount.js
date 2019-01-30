import React, { Component } from "react"

class ChangeBonusPointsDiscount extends Component {

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
                                    <div className="input-field">
                                        <label htmlFor="bonusPoeni">Broj bonus poena</label>
                                        <input type="number" id='bonusPoeni' />
                                    </div>
                                    <div className="input-field">
                                        <label htmlFor="popust">Popust</label>
                                        <input type="number" id='popust' />
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

export default ChangeBonusPointsDiscount;