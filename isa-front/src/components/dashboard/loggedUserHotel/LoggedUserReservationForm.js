import React, { Component } from 'react'
import { connect } from 'react-redux'

class LoggedUserReservationForm extends Component{

    state ={
        rezervisi_od:"",
        rezervisi_do:""
    }

    handleChange = (e) => {
        this.setState({
            [e.target.id]: e.target.value
        })
    }

    handleSubmit = (e) => {
        this.props.history.push('/cenovniciLogged/'+this.props.match.params.hotelId)
    }

    render() {
        return (
            <div>
            <div className="container">
                    <form className="white" onSubmit={this.handleSubmit} >
                        <h2 className="red-text lighten-1 center">Rezervacija sobe</h2>
                        <div className="container">
                            <div>
                                <label htmlFor="rezervisi_od" className="active">Rezerviši od</label>
                                <input type="date" id='rezervisi_od' className="datepicker" onChange = {this.handleChange}/>
                            </div>
                            <div>
                                <label htmlFor="rezervisi_do" className="active">Rezerviši do</label>
                                <input type="date" id='rezervisi_do' className="datepicker" onChange = {this.handleChange}/>
                            </div>
                            <div className="input-field">
                                <button className="btn blue lighten-1 z-depth-0">Rezerviši</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        )
    }

};

export default LoggedUserReservationForm