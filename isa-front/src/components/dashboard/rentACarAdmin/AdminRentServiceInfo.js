import React from "react"
import ChangeRentService from "./ChangeRentService";
import BranchOfficeManipulation from "./BranchOfficeManipulation"


const AdminRentServiceInfo = ({ rentACarService, branchOffices }) => {

    return (
        <div className="container">
            <ChangeRentService rentACarService={rentACarService} izmena={true} ></ChangeRentService>
            <BranchOfficeManipulation branchOffices={branchOffices}></BranchOfficeManipulation>
        </div>
    );

};

export default AdminRentServiceInfo;