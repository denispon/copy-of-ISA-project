import React, { Component } from 'react'
import UserLoggedTabs from '../layout/tabs/UserLoggedTabs';
import ReactDOM from 'react-dom';
import axios from 'axios';
import { NavLink } from "react-router-dom";
import "../layout/navbarLinks/navBarLinks.css";
import { connect } from "react-redux"
import { logInUser, hideError } from "../../store/actions/UserActions"
import { Redirect } from 'react-router-dom'
import ReactNotification from "react-notifications-component";
import "react-notifications-component/dist/theme.css";

class PrijavaKorisnika extends Component {

    state = {
        username: undefined,
        password: undefined
    }


    constructor(props) {
        super(props);
        this.addNotification = this.addNotification.bind(this);
        this.notificationDOMRef = React.createRef();
    }

    addNotification() {
        this.notificationDOMRef.current.addNotification({
            title: "Greska prilikom logovanja",
            message: "Neispravan unos!",
            type: "danger",
            insert: "top",
            container: "top-center",
            animationIn: ["animated", "fadeIn"],
            animationOut: ["animated", "fadeOut"],
            dismiss: { duration: 2000 },
            dismissable: { click: true }
        });
    }

    handleChange = (e) => {
        console.log(this.state.username)
        this.setState({
            [e.target.id]: e.target.value
        })
    }

    handleSubmit = (e) => {
        e.preventDefault();
        if (this.state.username && this.state.password) {
            this.props.logInUser(this.state.username, this.state.password)
        }

    }

    componentDidMount() {

    }

    render() {

        if (this.props.error) {
            this.addNotification();
            this.props.hideError();
        }

        return (
            <div className="container">
                <h4 className="center red-text lighten-1">Prijavite se</h4>


                <div className="container center">
                    <ReactNotification ref={this.notificationDOMRef} />
                </div>


                <div className="container">
                    <div className="card">
                        <div className="card-content">
                            <form className="white" onSubmit={this.handleSubmit}>
                                <div className="input-field">
                                    <label htmlFor="username">Korisnicko ime:</label>
                                    <input type="text" onChange={this.handleChange} id='username' />
                                </div>
                                <div className="input-field">
                                    <label htmlFor="password">Lozinka:</label>
                                    <input type="password" onChange={this.handleChange} id='password' />
                                </div>
                                <div className="center">
                                    <input type="submit" className="btn purple darken-2 z-depth-0" value="Prijava" />
                                </div>

                            </form>
                        </div>
                    </div>
                </div>



            </div>
        );
    }

}

const mapStateToProps = (state) => {

    return {
        user: state.user.user,
        error: state.user.error
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        logInUser: (email, password) => dispatch(logInUser(email, password)),
        hideError: () => dispatch(hideError())
    }
}



export default connect(mapStateToProps, mapDispatchToProps)(PrijavaKorisnika);
