import React, { Component } from 'react'
import UserLoggedTabs from '../../layout/tabs/UserLoggedTabs';

class CreateCenaSobe extends Component {
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
                        <h2 className="red-text lighten-1 center">Dodavanje nove cene sobe</h2>
                        <div className="container">
                            <div className="input-field">
                                <label htmlFor="cenaSobeDodaj">Cena:</label>
                                <input type="number" id='cenaSobeDodaj' />
                            </div>
                            <div>
                                <label htmlFor="vaziOdDodaj" className="active">Važi od:</label>
                                <input type="date" id='vaziOdDodaj' className= "datepicker"/>
                            </div>
                            <div>
                                <label htmlFor="vaziDoDodaj" className="active">Važi do:</label>
                                <input type="date" id='vaziDoDodaj'/>
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

export default CreateCenaSobe;