import React, { Component } from 'react'
import UserLoggedTabs from '../layout/tabs/UserLoggedTabs';
import axios from 'axios'


class Sobe extends Component {

    state = {
        sobe: []
    }

    componentDidMount() {
        const id = this.props.match.params.hotelId;
        axios.get('http://localhost:8092/api/hotel/hotelskaSoba/all/'+id)
            .then(res => {
                console.log(res);
                this.setState({
                    sobe: res.data
                })
            })
    }

    render() {
        const { sobe } = this.state;
        var imeHotela = "";
        const sobeList = sobe.length ? (sobe.map(soba => {
            imeHotela = soba.hotel_hotelskeSobe.name;
            return (
                <div className="post card grey lighten-2">
                    <div className="card-content container">
                        <span className="card-title center">{soba.id}</span>
                        <div className="left-align">
                            <p>Sprat: {soba.floor}</p>
                            <p>Cena: {soba.originalnaCena}</p>
                            <p>Tip sobe: {soba.tipSobe_hotelskeSobe.roomType}</p>
                        </div>
                    </div>
                </div>
            )
        })) : (<div className="center">Nije pronadjena nijedana soba.</div>)

        return (
            <div>
                <UserLoggedTabs></UserLoggedTabs>
                <div className="container center">
                    <h2 className="red-text lighten-1 center">Lista soba hotela {imeHotela}</h2>
                    {sobeList}
                </div>
            </div>
        )
    }
}

export default Sobe;