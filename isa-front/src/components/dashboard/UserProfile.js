import React, { Component } from 'react'
import { connect } from "react-redux"
import { getUser } from "../../store/actions/UserActions"

class UserProfile extends Component {

    state = {
        user: {},

        aktivna: ""
    }

    componentDidMount() {

        this.props.getUserById(2);

    }

    render() {

        this.state.user = this.props.user;
        var { name, surname, email, city, telephoneNumber, passport } = this.state.user;

        return (
            <div className="card">
                <div className="card-content">
                    <div className="container">
                        <form className="white" >
                            <h2 className="red-text lighten-1">Veljko Petrovic</h2>
                            <h4 className="indigo-text lighten-1">Bonus poeni : -5</h4>
                            <div className="input-field">
                                <label htmlFor="ime" className={this.state.aktivna}>Ime</label>
                                <input type="text" id='ime' defaultValue={name} />
                            </div>
                            <div className="input-field">
                                <label htmlFor="prezime">Prezime</label>
                                <input type="text" id='prezime' defaultValue={surname} />
                            </div>
                            <div className="input-field">
                                <label htmlFor="email">Email</label>
                                <input type="email" id='email' defaultValue={email} />
                            </div>
                            <div className="input-field">
                                <label htmlFor="grad">Grad</label>
                                <input type="text" id='grad' defaultValue={city} />
                            </div>
                            <div className="input-field">
                                <label htmlFor="telBroj">Telefonski broj</label>
                                <input type="text" id='telBroj' defaultValue={telephoneNumber} />
                            </div>
                            <div className="input-field">
                                <label htmlFor="pasos">Broj pasosa</label>
                                <input type="text" id='pasos' defaultValue={passport} />
                            </div>
                            <div className="input-field">
                                <label htmlFor="sifra">Sifra</label>
                                <input type="password" id='sifra' />
                            </div>
                            <div className="input-field">
                                <label htmlFor="sifra1">Ponovite sifru</label>
                                <input type="password" id='sifra1' />
                            </div>
                            <div className="input-field">
                                <button className="btn blue lighten-1 z-depth-0">Azuriraj</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        )
    }
};

const mapStateToProps = (state) => {
    return {
        user: state.user.user
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        getUserById: (id) => dispatch(getUser(id))
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(UserProfile);