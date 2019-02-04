import React, { Component } from "react"
import UserLoggedTabs from "../../layout/tabs/UserLoggedTabs";
import { BrowserRouter, Route } from "react-router-dom"
import RentACarPretraga from "../classicUser/RentACarPretraga";
import RentACarIzlistavanje from "../classicUser/RantACarIzlistavanje";
import Vozila from "../classicUser/Vozila.js"
import Filijale from "../classicUser/Filijale.js"


class DashboardUserLogged extends Component {

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
                            <Route exact path="/vozila" component={RentACarIzlistavanje}></Route>
                            <Route path="/listaVozila" component={RentACarIzlistavanje}></Route>

                            <Route path="/vozila/:serviceId" render={(props) => <Vozila userId={2} ulogovanUser={true} {...props} />}></Route>
                            <Route path="/filijale/:serviceId" component={Filijale}></Route>
                        </div>
                    </div>

                </BrowserRouter>
            </div>
        );
    }

}

export default DashboardUserLogged