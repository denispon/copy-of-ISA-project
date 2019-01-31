import axios from 'axios'

export const getAllBonusPointsDiscounts = () => {

    return (dispatch, getState) => {
        axios.get('http://localhost:8095/api/purchases/bonusPoitsDiscounts/all')
            .then(res => {
                console.log(res.data);
                dispatch({ type: 'GET_ALL_BONUS_POINTS_DISCOUNTS', bonusPointsDiscounts: res.data })
            })
    }

}