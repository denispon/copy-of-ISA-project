import React, { Component } from 'react'
import { connect } from "react-redux"
import { getUser, updateUser, getUserBonusPoints } from "../../store/actions/UserActions"


class UserProfile extends Component {

    state = {
        id: -1,
        name: '',
        surname: '',
        city: '',
        email: '',
        telephoneNumber: '',
        passport: ''
    }

    componentDidMount() {
        var user = JSON.parse(localStorage.getItem('user'))
        if (user) {
            this.props.getUserById(user.id);
            this.props.getUserBonusPoints(user.id);
        }



        if (this.props.user) {

            this.setState({
                id: this.props.user.id,
                name: this.props.user.name,
                surname: this.props.user.surname,
                city: this.props.user.city,
                email: this.props.user.email,
                telephoneNumber: this.props.user.telephoneNumber,
                passport: this.props.user.passport
            })

        }

    }

    handleChange = (e) => {
        this.setState({
            [e.target.id]: e.target.value
        })
    }

    handleSubmit = (e) => {
        e.preventDefault();
        //   console.log(this.state);
        this.props.updateUser(this.props.user.id, this.state);
    }

    render() {

        if (this.props.user) {


            var { name, surname, email, city, telephoneNumber, passport } = this.props.user;

            return (
                <div className="card">
                    <div className="card-content">
                        <div className="container">
                            <form className="white" onSubmit={this.handleSubmit} >
                                <h2 className="red-text lighten-1">{name} {surname}</h2>
                                <h5 className="indigo-text lighten-1">Bonus poeni : {this.props.userBonusPoints ? this.props.userBonusPoints.points : '0'}</h5>
                                <div className="input-field">
                                    <label htmlFor="name" className="active" >Ime</label>
                                    <input type="text" onChange={this.handleChange} id='name' defaultValue={name} />
                                </div>
                                <div className="input-field">
                                    <label htmlFor="surname" className="active">Prezime</label>
                                    <input type="text" onChange={this.handleChange} id='surname' defaultValue={surname} />
                                </div>
                                <div className="input-field">
                                    <label htmlFor="email" className="active">Email</label>
                                    <input type="email" onChange={this.handleChange} id='email' defaultValue={email} />
                                </div>
                                <div className="input-field">
                                    <label htmlFor="city" className="active">Grad</label>
                                    <input type="text" onChange={this.handleChange} id='city' defaultValue={city} />
                                </div>
                                <div className="input-field">
                                    <label htmlFor="telephoneNumber" className="active">Telefonski broj</label>
                                    <input type="text" onChange={this.handleChange} id='telephoneNumber' defaultValue={telephoneNumber} />
                                </div>
                                <div className="input-field">
                                    <label htmlFor="passport" className="active">Broj pasosa</label>
                                    <input type="text" onChange={this.handleChange} id='passport' defaultValue={passport} />
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
        else {
            return (<div></div>);
        }
    }
};

const mapStateToProps = (state) => {
    return {
        user: state.user.user,
        userBonusPoints: state.user.userBonusPoints
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        getUserById: (id) => dispatch(getUser(id)),
        updateUser: (id, user) => dispatch(updateUser(id, user)),
        getUserBonusPoints: (userId) => dispatch(getUserBonusPoints(userId))
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(UserProfile);