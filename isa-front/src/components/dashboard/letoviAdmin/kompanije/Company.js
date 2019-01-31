import React, {Component} from 'react'

class Company extends Component
{
    state = {

    }

    handleChange()
    {

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
                                        <label htmlFor="name">Naziv</label>
                                        <input type="text" id="name"/>
                                    </div>
                                    <div className="input-field">
                                        <label htmlFor="address">Adresa</label>
                                        <input type="text" id="address"/>
                                    </div>
                                    <div className="input-field">
                                        <label htmlFor="desc">Opis</label>
                                        <textarea id="desc"/>
                                    </div>
                                    <div className="input-field col s12">
                                        <select i
                                        ="dest" onChange={this.handleChange} className="browser-default">
                                            <option value="vr1" defaultValue>PostojecaDest1</option>
                                            <option value="vr2">PostojecaDest2</option>
                                            <option value="vr3">PostojecaDest3</option>
                                        </select>
                                    </div>
                                    <div className="input-field col s12">
                                        <select id="flight" className="browser-default" multiple>
                                            <option value="v41">PostojeciLet1</option>
                                            <option value="sad">PostojeciLet2</option>
                                            <option value="wqe">PostojeciLet3</option>
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