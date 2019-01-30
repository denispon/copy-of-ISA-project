import React, { Component } from "react"


class ChangeRentService extends Component {

    state = {

    }

    render() {
        return (
            <div className="card indigo lighten-1">
                <div className="card-content">
                    <span className="card-title white-text lighten-1 center"><strong>Id rent servisa</strong></span>

                    <div className="card">
                        <div className="card-content">
                            <div className="container">
                                <form className="white" >
                                    <div className="input-field">
                                        <label htmlFor="ime">Ime</label>
                                        <input type="text" id='ime' />
                                    </div>
                                    <div className="input-field">
                                        <label htmlFor="adresa">Adresa</label>
                                        <input type="text" id='adresa' />
                                    </div>
                                    <div className="input-field">
                                        <textarea id="textarea1" class="materialize-textarea"></textarea>
                                        <label for="textarea1">Textarea</label>
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

export default ChangeRentService;