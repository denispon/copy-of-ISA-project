import React from "react"
import MainAdminLoggedTabs from "../../layout/tabs/MainAdminLoggedTabs"
import { BrowserRouter, Route } from "react-router-dom"
import AdministratorsDashboard from "./AdministratorsDashboard"
import MainAdminLoggedRentACarTabs from "../../layout/tabs/MainAdminLoggedRentACarTabs";
import CarTypeManipulation from "./CarTypeManipulation";
import BonusPointsDiscounts from "./BonusPointsDiscounts";

const DashboardMainAdminLogged = () => {

    return (
        <BrowserRouter>
            <div >
                <div>
                    <Route path="/" component={MainAdminLoggedTabs}></Route>
                </div>

                <div>
                    <Route path="/mainAdminAdministrators" component={AdministratorsDashboard}></Route>
                    <Route path="/mainAdminBonusPoints" component={BonusPointsDiscounts} />
                    <Route path="/mainAdminRentCar" component={MainAdminLoggedRentACarTabs}></Route>
                    <Route path="/mainAdminRentCar/mainAdminTipoviVozila" component={CarTypeManipulation} />
                </div>
            </div>
        </BrowserRouter>
    );

};

export default DashboardMainAdminLogged;