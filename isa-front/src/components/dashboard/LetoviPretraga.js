import React, {Component} from 'react'
import UserLoggedTabs from '../layout/UserLoggedTabs';
import ReactDOM from 'react-dom';



class LetoviPretraga extends Component {

    state = {

    }

    
   /*componentDidMount() {
        var element = ReactDOM.findDOMNode(this.refs.dropdown)
      
        $(element).ready(function() {
          $('select').material_select();
        });
      }*/

    render() {
        return (
            <div>
                <UserLoggedTabs></UserLoggedTabs>
                <div className="container">
                    
                    <form className="white" >
                        <h2 className="red-text lighten-1 center">Pretraga letova</h2>
                        <div className="container">

                            <div class="input-field col s12">
                                <select className="browser-default">
                                    <option value="" disabled selected>Tip leta</option>
                                    <option value="1">Option 1</option>
                                    <option value="2">Option 2</option>
                                    <option value="3">Option 3</option>
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
                                    <option value="1">Option 1</option>
                                    <option value="2">Option 2</option>
                                    <option value="3">Option 3</option>
                                </select>                    
                            </div>
  
                            <div className="input-field">
                                <label htmlFor="mesto_polaska">Mesto polaska</label>
                                <input type="text" id='mesto_polaska' />
                            </div> 
                            <div className="input-field">
                                <label htmlFor="destinacija">Destinacija</label>
                                <input type="text" id='destinacija' />
                            </div> 
                            <div className="input-field">
                                <label htmlFor="datum_polaska">Datum polaska</label>
                                <input type="text" id='datum_polaska' className="datepicker"/>
                            </div> 
                            <div className="input-field">
                                <label htmlFor="datum_dolaska">Datum dolaska</label>
                                <input type="text" id='datum_dolaska' className="datepicker"/>
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