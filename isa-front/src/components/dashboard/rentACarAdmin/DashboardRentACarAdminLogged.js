import React from "react"
import { BrowserRouter, Route } from "react-router-dom"
import RentACarAdminTabs from "../../layout/tabs/RentACarAdminTabs";
import AdminRentServiceInfo from "./AdminRentServiceInfo";
import CarManipulation from "./CarManipulation";

const DashboardRentACarAdminLogged = () => {

    return (

        <div>
            <BrowserRouter>
                <div >
                    <div>
                        <Route path="/" component={RentACarAdminTabs}></Route>
                    </div>

                    <div>
                        <Route path="/rentAdminRentService" component={AdminRentServiceInfo}></Route>
                        <Route path="/rentAdminCars" component={CarManipulation}></Route>
                    </div>
                </div>
            </BrowserRouter>
        </div>

    );

};

export default DashboardRentACarAdminLogged;