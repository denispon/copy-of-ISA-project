import React, { Component } from 'react'

class UserProfile extends Component {

    state = {

    }

    render() {
        return (
            <div className="container">
                <form className="white" >
                    <h2 className="red-text lighten-1">Veljko Petrovic</h2>


                    <div className="input-field">
                        <label htmlFor="ime">Ime</label>
                        <input type="text" id='ime' />
                    </div>
                    <div className="input-field">
                        <label htmlFor="prezime">Prezime</label>
                        <input type="text" id='prezime' />
                    </div>
                    <div className="input-field">
                        <label htmlFor="email">Email</label>
                        <input type="email" id='email' />
                    </div>
                    <div className="input-field">
                        <label htmlFor="grad">Grad</label>
                        <input type="text" id='grad' />
                    </div>
                    <div className="input-field">
                        <label htmlFor="telBroj">Telefonski broj</label>
                        <input type="text" id='telBroj' />
                    </div>
                    <div className="input-field">
                        <label htmlFor="pasos">Broj pasosa</label>
                        <input type="text" id='pasos' />
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
        )
    }
};

export default UserProfile;