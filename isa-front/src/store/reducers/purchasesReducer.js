const initState = {

    bonusPointsDiscounts: [],
    userShoppingCart: {},
    carReservation: undefined,
    hotelReservation: undefined,
    avioCompanyReservation: undefined,
    finalReservation: undefined,
    userReservations: undefined

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

    }
    return state
}

export default purchasesReducer;
