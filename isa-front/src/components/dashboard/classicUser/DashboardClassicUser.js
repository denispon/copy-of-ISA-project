import React, { Component } from "react"
import UserLoggedTabs from "../../layout/tabs/UserLoggedTabs";
import { BrowserRouter, Route } from "react-router-dom"
import RentACarPretraga from "./RentACarPretraga";
import RentACarIzlistavanje from "./RantACarIzlistavanje";
import Vozila from "./Vozila.js"
import Filijale from "./Filijale.js"

class DashboardClassicUser extends Component {

    state = {

    }

    render() {

        return (
            <div>



                <BrowserRouter>
                    <div>
                        <div>

                            <Route path="/" component={UserLoggedTabs}></Route>

                        </div>
                        <div>
                            <Route exact path="/vozila" component={RentACarPretraga}></Route>
                            <Route path="/listaVozila" component={RentACarIzlistavanje}></Route>
                            <Route path="/vozila/:serviceId" component={Vozila}></Route>
                            <Route path="/filijale/:serviceId" component={Filijale}></Route>
                        </div>
                    </div>

                </BrowserRouter>
            </div>
        );
    }

}

export default DashboardClassicUser;