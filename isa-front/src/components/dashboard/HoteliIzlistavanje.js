import React, {Component} from 'react'
import UserLoggedTabs from '../layout/UserLoggedTabs';
import IzlistavanjeHotela from './izlistavanja/IzlistavanjeHotela';
import "./izlistavanje.css"
import { connect } from 'react-redux'


class HotelIzlistavanje extends Component {
    render() {
        const { hoteli } = this.props;
        return (
            <div>
                <UserLoggedTabs></UserLoggedTabs>
                <div className = "container center">
                    <h2 className="red-text lighten-1 center">Lista hotela</h2>
                    <IzlistavanjeHotela hoteli = {hoteli}></IzlistavanjeHotela>
                </div>
            </div>
        )
    }

}

const mapStateToProps = (state) =>{
    return{
        hoteli: state.hotel.hoteli
    }

}


export default connect(mapStateToProps)(HotelIzlistavanje);
            

