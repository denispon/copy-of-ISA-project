import React, {Component} from 'react'

class Company extends Component
{
    state = {

    }
    //<!--SPISAK KARATA SA POPUSTIMA ZA BRZU REZ (??!) -->
    //konfiguracija mesta u avionima ide za svaki let posebno, kao i prtljag i cenovnik
    render()
    {
        return(
            <div className="card indigo lighten-1">
                <div className="card-content">
                    <div className="card">
                        <div className="card-content">
                            <span className="card-title right"><a className="btn-floating btn-small waves-effect waves-light red"><i>x</i></a></span>
                            
                            <div className="container">
                                <form className="white">
                                    <div className="input-field">
                                        <label htmlFor="name">Ime</label>
                                        <input type="text" placeholder="Postojece ime" id="name"/>
                                    </div>
                                    <div className="input-field">
                                        <label htmlFor="address">Adresa</label>
                                        <input type="text" placeholder="Postojeca adresa" id="address"/>
                                    </div>
                                    <div className="input-field">
                                        <label htmlFor="desc">Opis</label>
                                        <textarea placeholder="Postojeci opis" id="desc"/>
                                    </div>
                                    <div className="input-field">
                                        <label htmlFor="dest">Destinacija</label>
                                        <select id="dest">
                                            <option value="">PostojecaDest1</option>
                                            <option value="">PostojecaDest2</option>
                                            <option value="">PostojecaDest3</option>
                                        </select>
                                    </div>
                                    <div className="input-field">
                                        <label htmlFor="flight">Letovi</label>
                                        <select id="flight" multiple>
                                            <option value="">PostojeciLet1</option>
                                            <option value="">PostojeciLet2</option>
                                            <option value="">PostojeciLet3</option>
                                        </select>
                                    </div>
                                    <button className="btn green lighten-1 z-depth-0">Izmeni</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }

}

export default Company