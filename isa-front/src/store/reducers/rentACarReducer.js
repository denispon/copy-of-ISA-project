const initState = {

    carTypes: [],
    cars: [],
    incomes: [],
    branchOffices: [],
    rentServices: [],
    rentService: {},
    carDiscounts: [],

}

const rentACarReducer = (state = initState, action) => {
    switch (action.type) {
        case 'GET_ALL_CAR_TYPES':
            return {
                ...state,
                carTypes: action.carTypes
            }
        case 'GET_ONE_RENT_SERVICE':
            return {
                ...state,
                rentService: action.rentService
            }
        case 'GET_ALL_BRANCHES_BY_RENT_SERVICE':
            return {
                ...state,
                branchOffices: action.branchOffices
            }
        case 'GET_ALL_CARS_BY_RENT_SERVICE':
            return {
                ...state,
                cars: action.cars
            }

        case 'GET_ALL_CAR_DISCOUNTS_BY_RENT_SERVICE':
            return {
                ...state,
                carDiscounts: action.carDiscounts
            }
        case 'GET_ALL_RENT_A_CAR_SERVICES':
            return {
                ...state,
                rentServices: action.rentServices
            }
        case 'CREATE_RENT_A_CAR_SERVICE':
            return {
                ...state,
                rentServices: state.rentServices.concat(action.rentService)
            }
        case 'EDIT_RENT_A_CAR_SERVICE':
            return {
                ...state,
                rentServices: (state.rentServices.filter(item => item.id !== action.editedService.id)).concat(action.editedService)
            }

        case 'DELETE_RENT_A_CAR_SERVICE':
            return {
                ...state,
                rentServices: (state.rentServices.filter(item => item.id !== action.deletedService.id))

            }

        case 'CREATE_CAR_TYPE':
            return {
                ...state,
                carTypes: state.carTypes.concat(action.createdCarType)
            }

        case 'EDIT_CAR_TYPE':
            return {
                ...state,
                carTypes: (state.carTypes.filter(item => item.id !== action.editedCarType.id)).concat(action.editedCarType)
            }

        case 'DELETE_RENT_A_CAR_SERVICE':
            return {
                ...state,
                carTypes: (state.carTypes.filter(item => item.id !== action.deletedCarType.id))
            }

        case 'CREATE_BRANCH_OFFICE':
            return {
                ...state,
                branchOffices: state.branchOffices.concat(action.createtBranchOffice)
            }
        case 'UPDATE_BRANCH_OFFICE':
            return {
                ...state,
                branchOffices: (state.branchOffices.filter(item => item.id !== action.editedBranchOffice.id)).concat(action.editedBranchOffice)
            }
        case 'DELETE_BRANCH_OFFICE':
            return {
                ...state,
                branchOffices: state.branchOffices.filter(item => item.id !== action.deleteBranchOffice.id)
            }
    }
    return state
}

export default rentACarReducer;