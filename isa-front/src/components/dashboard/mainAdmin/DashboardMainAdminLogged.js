import React, { Component } from "react"
import MainAdminLoggedTabs from "../../layout/tabs/MainAdminLoggedTabs"
import { BrowserRouter, Route } from "react-router-dom"
import AdministratorsDashboard from "./AdministratorsDashboard"
import MainAdminLoggedRentACarTabs from "../../layout/tabs/MainAdminLoggedRentACarTabs";
import CarTypeManipulation from "./CarTypeManipulation";
import BonusPointsDiscounts from "./BonusPointsDiscounts";
import { connect } from "react-redux";
import { getAllCarTypes, getAllRentACarServices } from "../../../store/actions/RentACarActions"
import { getAllBonusPointsDiscounts } from "../../../store/actions/PurchasesActions"
import RentCarServiceManipulation from "./RentCarServiceManipulation"

class DashboardMainAdminLogged extends Component {

    state = {
        otvoriProzorRentACarServisa: false,
    }

    componentDidMount() {
        this.props.getAllCarTypes();
        this.props.getAllBonusPointsDiscounts();
        this.props.getAllRentACarServices();
    }

    prikaziCardZaDodavanjeRentACarServisa = (e) => {

        e.preventDefault();
        this.setState({
            otvoriProzorRentACarServisa: true
        })

    }

    iskljuciCardZaDodavanjeRentACarServica = (e) => {
        e.preventDefault();
        this.setState({
            otvoriProzorRentACarServisa: false
        })
    }


    render() {
        return (
            <BrowserRouter>
                <div >
                    <div>
                        <Route path="/" component={MainAdminLoggedTabs}></Route>
                    </div>

                    <div>
                        <Route path="/mainAdminAdministrators" component={AdministratorsDashboard}></Route>
                        <Route path="/mainAdminBonusPoints" render={(props) => <BonusPointsDiscounts bonusPointsDiscounts={this.props.bonusPointsDiscounts} />} />
                        <Route path="/mainAdminRentCar" component={MainAdminLoggedRentACarTabs}></Route>
                        <Route path="/mainAdminRentCar/mainAdminRentServisi" render={(props) => <RentCarServiceManipulation otvoriProzorRentACarServisa={this.state.otvoriProzorRentACarServisa} prikaziCardZaDodavanjeRentACarServisa={this.prikaziCardZaDodavanjeRentACarServisa} iskljuciCardZaDodavanjeRentACarServica={this.iskljuciCardZaDodavanjeRentACarServica} rentACarServices={this.props.rentACarServices}></RentCarServiceManipulation>} />
                        <Route path="/mainAdminRentCar/mainAdminTipoviVozila" render={(props) => <CarTypeManipulation carTypes={this.props.carTypes} />} />


                    </div>
                </div>
            </BrowserRouter>
        );

    }

};


const mapStateToProps = (state) => {
    return {
        carTypes: state.rentACar.carTypes,
        bonusPointsDiscounts: state.purchases.bonusPointsDiscounts,
        rentACarServices: state.rentACar.rentServices

    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        getAllCarTypes: () => dispatch(getAllCarTypes()),
        getAllBonusPointsDiscounts: () => dispatch(getAllBonusPointsDiscounts()),
        getAllRentACarServices: () => dispatch(getAllRentACarServices())
    }
}



export default connect(mapStateToProps, mapDispatchToProps)(DashboardMainAdminLogged);