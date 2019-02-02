import React, { Component } from 'react'
import UserLoggedTabs from '../../layout/tabs/UserLoggedTabs';


class CreateHotelskaSoba extends Component {
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
                        <h2 className="red-text lighten-1 center">Dodavanje nove rezervacije sobe</h2>
                        <div className="container">
                            <div className="input-field">
                                <label htmlFor="originalnaCenaSobeDodaj">Originalna cena:</label>
                                <input type="number" id='originalnaCenaSobeDodaj' />
                            </div>
                            <div className="input-field">
                                <label htmlFor="spratDodaj">Sprat:</label>
                                <input type="number" id='spratDodaj'/>
                            </div>
                            <div class="input-field col s12">
                                <select className="browser-default">
                                    <option value="" disabled selected>Rezervisana:</option>
                                    <option value="Da">Da</option>
                                    <option value="Ne">Ne</option>
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

export default CreateHotelskaSoba;