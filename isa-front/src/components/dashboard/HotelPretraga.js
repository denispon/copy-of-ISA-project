import React, { Component } from 'react'
import UserLoggedTabs from '../layout/tabs/UserLoggedTabs';
import { connect } from 'react-redux'
import { filterHotel } from '../../store/actions/HotelActions';

class HotelPretraga extends Component {

    state = {
        ime_adresa:"",
        datum_dolaska:"",
        datum_odlaska:"",
        sobe:"",
        gosti:""
    }

    handleChange = (e) => {
        this.setState({
            [e.target.id]: e.target.value
        })
    }

    handleSubmit = (e) => {
        e.preventDefault();
        //this.props.history.push('/listaHotela')
        this.props.filterHotel(this.state)
    }

    render() {
        return (
            <div>
                <UserLoggedTabs></UserLoggedTabs>
                <div className="container">
                    <form className="white" onSubmit={this.handleSubmit} >
                        <h2 className="red-text lighten-1 center">Pretraga hotela</h2>
                        <div className="container">
                            <div className="input-field">
                                <label htmlFor="ime_adresa">Ime ili adresa</label>
                                <input type="text" id='ime_adresa' onChange = {this.handleChange}/>
                            </div>
                            <div>
                                <label htmlFor="datum_dolaska" className="active">Datum dolaska</label>
                                <input type="date" id='datum_dolaska' className="datepicker" onChange = {this.handleChange}/>
                            </div>
                            <div>
                                <label htmlFor="datum_odlaska" className="active">Datum odlaska</label>
                                <input type="date" id='datum_odlaska' className="datepicker" onChange = {this.handleChange}/>
                            </div>
                            <div className="input-field">
                                <label htmlFor="sobe">Broj soba</label>
                                <input type="number" id='sobe' onChange = {this.handleChange}/>
                            </div>
                            <div className="input-field">
                                <label htmlFor="gosti">Broj gostiju</label>
                                <input type="number" id='gosti' onChange = {this.handleChange}/>
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

const mapDispatchToProps = (dispatch) =>{
    return{
        filterHotel: (filter) => dispatch(filterHotel(filter))
    }
}

export default connect(null, mapDispatchToProps)(HotelPretraga);