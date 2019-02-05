import React, { Component } from "react"
import { BrowserRouter, Route } from "react-router-dom"
import RentACarAdminTabs from "../../layout/tabs/RentACarAdminTabs";
import AdminRentServiceInfo from "./AdminRentServiceInfo";
import CarManipulation from "./CarManipulation";
import CarDiscountManipulation from "./CarDiscountsManipulation";
import { getOneRentService, getAllBranchOfficesByRentId, getAllCarsByRentId, getAllCarTypes, getAllCarDiscountsByRentId } from "../../../store/actions/RentACarActions"

import { connect } from "react-redux"
import RentACarStatistic from "./RentACarStatistic";

class DashboardRentACarAdminLogged extends Component {

    state = {
        otvoriProzorZaDodavanje: false
    }

    componentDidMount = () => {
        this.props.getOneRentService(2);
        this.props.getAllBranchOfficesByRentId(2);
        this.props.getAllCarsByRentId(2);
        this.props.getAllCarTypes();
        this.props.getAllCarDiscountsByRentId(2);
    }

    prikaziCardZaDodavanje = (e) => {

        e.preventDefault();
        this.setState({
            otvoriProzorZaDodavanje: true
        })

    }

    iskljuciCardZaDodavanje = (e) => {
        e.preventDefault();
        this.setState({
            otvoriProzorZaDodavanje: false
        })
    }



    render() {
        return (

            <div>
                <BrowserRouter>
                    <div >
                        <div>
                            <Route path="/" component={RentACarAdminTabs}></Route>
                        </div>

                        <div>
                            <Route path="/rentAdminRentService" render={(props) => <AdminRentServiceInfo otvoriProzor={this.state.otvoriProzorZaDodavanje} prikaziCardZaDodavanje={this.prikaziCardZaDodavanje} iskljuciCardZaDodavanje={this.iskljuciCardZaDodavanje} rentACarService={this.props.rentACarService} branchOffices={this.props.branchOffices} />} />
                            <Route path="/rentAdminCars" render={(props) => <CarManipulation rentACarService={this.props.rentACarService} otvoriProzor={this.state.otvoriProzorZaDodavanje} prikaziCardZaDodavanje={this.prikaziCardZaDodavanje} iskljuciCardZaDodavanje={this.iskljuciCardZaDodavanje} cars={this.props.cars} carTypes={this.props.carTypes} branchOffices={this.props.branchOffices} />} ></Route>
                            <Route path="/rentAdminDiscounts" render={(props) => <CarDiscountManipulation otvoriProzor={this.state.otvoriProzorZaDodavanje} prikaziCardZaDodavanje={this.prikaziCardZaDodavanje} iskljuciCardZaDodavanje={this.iskljuciCardZaDodavanje} carDiscounts={this.props.carDiscounts} cars={this.props.cars} />}></Route>
                            <Route path="/rentACarStatistic" render={(props) => <RentACarStatistic rentServiceId={this.props.rentACarService.id} />} />
                        </div>
                    </div>
                </BrowserRouter>
            </div>

        );
    }

};

const mapStateToProps = (state) => {
    return {
        rentACarService: state.rentACar.rentService,
        branchOffices: state.rentACar.branchOffices,
        cars: state.rentACar.cars,
        carTypes: state.rentACar.carTypes,
        carDiscounts: state.rentACar.carDiscounts

    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        getOneRentService: (id) => dispatch(getOneRentService(id)),
        getAllBranchOfficesByRentId: (id) => dispatch(getAllBranchOfficesByRentId(id)),
        getAllCarsByRentId: (id) => dispatch(getAllCarsByRentId(id)),
        getAllCarTypes: () => dispatch(getAllCarTypes()),
        getAllCarDiscountsByRentId: (id) => dispatch(getAllCarDiscountsByRentId(id))

    }
}



export default connect(mapStateToProps, mapDispatchToProps)(DashboardRentACarAdminLogged);