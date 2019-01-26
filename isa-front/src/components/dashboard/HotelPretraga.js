import React, {Component} from 'react'
import UserLoggedTabs from '../layout/UserLoggedTabs';



class HotelPretraga extends Component {

    state = {

    }

    render() {
        return (
            <div>
                <UserLoggedTabs></UserLoggedTabs>
                <div className="container">
                    
                    <form className="white" >
                        <h2 className="red-text lighten-1 center">Pretraga hotela</h2>
                        <div className="container">
                            <div className="input-field">
                                <label htmlFor="ime_adresa">Ime ili adresa</label>
                                <input type="text" id='ime_adresa' />
                            </div>     
                            <div className="input-field">
                                <label htmlFor="datom_dolaska">Datum dolaska</label>
                                <input type="text" id='datom_dolaska' />
                            </div> 
                            <div className="input-field">
                                <label htmlFor="datum_odlaska">Datum odlaska</label>
                                <input type="text" id='datum_odlaska' />
                            </div> 
                            <div className="input-field">
                                <label htmlFor="sobe">Broj soba</label>
                                <input type="number" id='sobe' />
                            </div> 
                            <div className="input-field">
                                <label htmlFor="gosti">Broj gostiju</label>
                                <input type="number" id='gosti' />
                            </div> 
                            <div className="input-field">
                                <button className="btn blue lighten-1 z-depth-0">Pretraži</button>
                             </div>
                        </div>
                    </form>
                </div>
            </div>
        )
    }
};

export default HotelPretraga;