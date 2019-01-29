import React from "react"
import MainAdminLoggedTabs from "../../layout/tabs/MainAdminLoggedTabs"
import { BrowserRouter, Route } from "react-router-dom"
import AdministratorsDashboard from "./AdministratorsDashboard"

const DashboardMainAdminLogged = () => {

    return (
        <BrowserRouter>
            <div >
                <div>
                    <Route path="/" component={MainAdminLoggedTabs}></Route>
                </div>

                <div>
                    <Route path="/mainAdminAdministrators" component={AdministratorsDashboard}></Route>
                </div>
            </div>
        </BrowserRouter>
    );

};

export default DashboardMainAdminLogged;