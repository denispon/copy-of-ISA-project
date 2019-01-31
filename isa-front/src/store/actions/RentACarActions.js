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
