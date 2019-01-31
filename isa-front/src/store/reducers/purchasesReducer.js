const initState = {

    bonusPointsDiscounts: []

}

const purchasesReducer = (state = initState, action) => {
    switch (action.type) {
        case 'GET_ALL_BONUS_POINTS_DISCOUNTS':
            return {
                ...state,
                bonusPointsDiscounts: action.bonusPointsDiscounts
            }
    }
    return state
}

export default purchasesReducer;