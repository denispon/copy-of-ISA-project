import React from "react"
import { BrowserRouter, Route } from "react-router-dom"
import RentACarAdminTabs from "../../layout/tabs/RentACarAdminTabs";

const DashboardRentACarAdminLogged = () => {

    return (

        <div>
            <BrowserRouter>
                <div >
                    <div>
                        <Route path="/" component={RentACarAdminTabs}></Route>
                    </div>
                </div>
            </BrowserRouter>
        </div>

    );

};

export default DashboardRentACarAdminLogged;