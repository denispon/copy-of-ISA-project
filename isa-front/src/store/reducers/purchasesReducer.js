const initState = {

    bonusPointsDiscounts: [],
    userShoppingCart: undefined,
    carReservation: undefined,
    hotelReservation: undefined,
    avioCompanyReservation: undefined,
    finalReservation: undefined,
    userReservations: undefined,
    rentCarReservations: []

}

const purchasesReducer = (state = initState, action) => {
    switch (action.type) {
        case 'GET_ALL_BONUS_POINTS_DISCOUNTS':
            return {
                ...state,
                bonusPointsDiscounts: action.bonusPointsDiscounts
            }
        case 'GET_USER_SHOPPING_CART':
            return {
                ...state,
                userShoppingCart: action.userShoppingCart
            }

        case 'GET_CAR_RESERVATION':
            return {
                ...state,
                carReservation: action.carReservation
            }
        case 'MAKE_RESERVATION':
            return {
                ...state,
                userShoppingCart: undefined,
                carReservation: undefined,
                avioCompanyReservation: undefined,
                hotelReservation: undefined,
                finalReservation: action.finalReservation
            }

        case 'GET_USER_RESERVATIONS':
            return {
                ...state,
                userReservations: action.userReservations,
                rentCarReservations: []
            }

        case 'GET_USER_RENT_A_CAR_RESERVATIONS':
            return {
                ...state,
                rentCarReservations: state.rentCarReservations.concat(action.rentCarReservations)
            }
    }
    return state
}

export default purchasesReducer;
