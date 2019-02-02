import axios from 'axios'

export const getAllCarTypes = () => {

    return (dispatch, getState) => {
        axios.get('http://localhost:8090/api/rentacar/carType/all')
            .then(res => {
                console.log(res.data);
                dispatch({ type: 'GET_ALL_CAR_TYPES', carTypes: res.data })
            })
    }

}


export const getOneRentService = (id) => {

    return (dispatch, getState) => {
        axios.get('http://localhost:8090/api/rentacar/rentACarService/' + id)
            .then(res => {
                console.log(res.data);
                dispatch({ type: 'GET_ONE_RENT_SERVICE', rentService: res.data })
            })
    }

}

export const getAllBranchOfficesByRentId = (id) => {

    return (dispatch, getState) => {

        axios.get('http://localhost:8090/api/rentacar/branchOffice/getAllByRentService/' + id)
            .then(res => {
                console.log(res.data);
                dispatch({ type: 'GET_ALL_BRANCHES_BY_RENT_SERVICE', branchOffices: res.data })
            })

    }
}

export const getAllCarsByRentId = (id) => {

    return (dispatch, getState) => {

        axios.get('http://localhost:8090/api/rentacar/car/getByRentService/' + id)
            .then(res => {
                console.log(res.data);
                dispatch({ type: 'GET_ALL_CARS_BY_RENT_SERVICE', cars: res.data })
            })
    }

}

export const getAllCarDiscountsByRentId = (id) => {

    return (dispatch, getState) => {

        axios.get('http://localhost:8090/api/rentacar/carDiscounts/rentService/' + id)
            .then(res => {
                console.log(res.data);
                dispatch({ type: 'GET_ALL_CAR_DISCOUNTS_BY_RENT_SERVICE', carDiscounts: res.data })
            })

    }

}

export const getAllRentACarServices = () => {

    return (dispatch, getState) => {

        axios.get('http://localhost:8090/api/rentacar/rentACarService/all')
            .then(res => {
                console.log(res.data);
                dispatch({ type: 'GET_ALL_RENT_A_CAR_SERVICES', rentServices: res.data })
            })

    }


}

export const createRentACarService = (rentService) => {

    return (dispatch, getState) => {

        axios.post('http://localhost:8090/api/rentacar/rentACarService/', { id: rentService.id, name: rentService.name, adress: rentService.adress, description: rentService.description })
            .then(res => {
                console.log(res);
                dispatch({ type: 'CREATE_RENT_A_CAR_SERVICE', rentService: res.data });
            })


    }

}

export const editRentACarService = (id, editedService) => {

    return (dispatch, getState) => {

        axios.put('http://localhost:8090/api/rentacar/rentACarService/' + id, { id: editedService.id, name: editedService.name, adress: editedService.adress, description: editedService.description })
            .then(res => {
                console.log(res);
                dispatch({ type: 'EDIT_RENT_A_CAR_SERVICE', editedService: res.data });
            })


    }

}

export const deleteRentACarService = (id) => {

    return (dispatch, getState) => {
        console.log("OVO JE ID" + id)
        axios.delete('http://localhost:8090/api/rentacar/rentACarService/' + id)
            .then(res => {
                console.log(res);
                dispatch({ type: 'DELETE_RENT_A_CAR_SERVICE', deletedService: res.data });
            })

    }

}
