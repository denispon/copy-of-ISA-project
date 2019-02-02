import React, { Component } from 'react'
import UserLoggedTabs from '../../layout/tabs/UserLoggedTabs';

class CreateCenovnikUsluga extends Component {
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
                        <h2 className="red-text lighten-1 center">Dodavanje nove usluge u cenovnik</h2>
                        <div className="container">
                        <div className="input-field">
                                <label htmlFor="nazivCenovnikaDodaj">Naziv:</label>
                                <input type="number" id='nazivCenovnikaDodaj' />
                            </div> 
                            <div className="input-field">
                                <label htmlFor="cenaCenovnikaDodaj">Cena:</label>
                                <input type="number" id='cenaCenovnikaDodaj' />
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

export default CreateCenovnikUsluga;