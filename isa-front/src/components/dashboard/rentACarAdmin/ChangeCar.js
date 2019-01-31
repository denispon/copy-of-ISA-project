import React, { Component } from "react"
import StarRating from "../reservation/StarRating";


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
                            <span className="card-title indigo-text lighten-1 left"><strong>{this.props.car.id}</strong></span>
                            <StarRating></StarRating>

                            <div className="container">

                                <form className="white" >
                                    <div className="input-field">
                                        <label htmlFor="rentPrice">Cena</label>
                                        <input type="text" id='rentPrice' defaultValue={this.props.car.rentPrice} />
                                    </div>
                                    <div class="input-field col s12">
                                        <select className="browser-default">
                                            {this.props.carTypes.map(carType => {
                                                return (
                                                    <option selected={carType.id == this.props.car.carType.id} value={carType.id}>{carType.brand} {carType.model} {carType.modelYear}, {carType.carType}, broj sedista: {carType.numberOfSeats}</option>
                                                );
                                            })}
                                        </select>
                                    </div>
                                    <div class="input-field col s12">
                                        <select className="browser-default">
                                            {this.props.branchOffices.map(branch => {
                                                return (
                                                    <option selected={branch.id == this.props.car.branchOffice.id} value={branch.id}>{branch.name}, {branch.adress}, {branch.city} </option>
                                                );
                                            })}
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