import React, { Component } from 'react'
import UserLoggedTabs from '../../layout/tabs/UserLoggedTabs';

class CreateDodatnaUsluga extends Component {
    state = {

    }

    handleSubmit = (e) => {
        e.preventDefault();
    }

    render() {
        return (
            <div>
                <UserLoggedTabs></UserLoggedTabs>
                <div className="container">
                    <form className="white" onSubmit={this.handleSubmit} >
                        <h2 className="red-text lighten-1 center">Dodavanje nove dodatne usluge</h2>
                        <div className="container">
                            <div className="input-field">
                                <label htmlFor="nazivDodatneUslugeDodaj">Naziv:</label>
                                <input type="text" id='nazivDodatneUslugeDodaj' />
                            </div>
                            <div className="input-field">
                                <label htmlFor="cenaDodatneUslugeDodaj">Cena:</label>
                                <input type="number" id='cenaDodatneUslugeDodaj' />
                            </div>
                            <div className="input-field">
                                <label htmlFor="popustDodaj">Popust:</label>
                                <input type="number" id='popustDodaj'/>
                            </div>
                            <div class="input-field col s12">
                                <select className="browser-default">
                                    <option value="" disabled selected>Hotel:</option>
                                </select>
                            </div>
                            <div className="input-field">
                                <button className="btn blue lighten-1 z-depth-0">Dodaj</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        )
    }
};

export default CreateDodatnaUsluga;