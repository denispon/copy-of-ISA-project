import React, {Component} from 'react'
import UserLoggedTabs from '../layout/UserLoggedTabs';
import ReactDOM from 'react-dom';
import axios from 'axios';



class LetoviPretraga extends Component {

    state = {

    }

    componentDidMount()
    {
        axios('http://localhost:8091/api/aviocompany/company/all').then(
            res=>{
                console.log(res);
            }
        )
    }

    handleSubmit = (e) => {
        e.preventDefault();
        this.props.history.push('/listaLetova')
    }

    //e ovako, za destinaciju mi treba select sa option-ima koji ce biti spisak destinacija koje podrzava
    //ta aviokompanija

    render() {
        return (
            <div>
                <UserLoggedTabs></UserLoggedTabs>
                <div className="container">
                    
                    <form className="white" onSubmit={this.handleSubmit}>
                        <h2 className="red-text lighten-1 center">Pretraga letova</h2>
                        <div className="container">

                            <div className="input-field">
                                <label htmlFor="destinacija">Destinacija</label>
                                <input type="text" id='destinacija' />
                            </div> 

                            <div class="input-field col s12">
                                <select className="browser-default">
                                    <option value="" disabled selected>Tip leta</option>
                                    <option value="1">One way</option>
                                    <option value="2">Round trip</option>
                                    <option value="3">Multi-city</option>
                                </select>
                            </div>

                            <div class="input-field col s12">
                                <select className="browser-default">
                                    <option value="" disabled selected>Putnik</option>
                                    <option value="1">Option 1</option>
                                    <option value="2">Option 2</option>
                                    <option value="3">Option 3</option>
                                </select>
                            </div>

                            <div class="input-field col s12">
                                <select className="browser-default">
                                    <option value="" disabled selected>Klasa</option>
                                    <option value="1">Economy</option>
                                    <option value="2">Business</option>
                                    <option value="3">First</option>
                                </select>                    
                            </div>
  
                            <div className="input-field">
                                <label htmlFor="mesto_polaska">Mesto polaska</label>
                                <input type="text" id='mesto_polaska' />
                            </div> 
                            
                            <div className="input-field">
                                <label htmlFor="datum_polaska"  className = "active">Datum polaska</label>
                                <input type="date" id='datum_polaska' className="datepicker"/>
                            </div> 
                            <div className="input-field">
                                <label htmlFor="datum_dolaska" className = "active">Datum dolaska</label>
                                <input type="date" id='datum_dolaska' className="datepicker"/>
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

export default LetoviPretraga;