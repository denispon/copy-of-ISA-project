import React from "react"
import { BrowserRouter, Route } from "react-router-dom"
import RentACarAdminTabs from "../../layout/tabs/RentACarAdminTabs";
import AdminRentServiceInfo from "./AdminRentServiceInfo";
import CarManipulation from "./CarManipulation";
import CarDiscountManipulation from "./CarDiscountsManipulation";

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
                        <Route path="/rentAdminDiscounts" component={CarDiscountManipulation}></Route>
                    </div>
                </div>
            </BrowserRouter>
        </div>

    );

};

export default DashboardRentACarAdminLogged;