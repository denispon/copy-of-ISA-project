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

export const getUserShoppingCart = (id) => {

    return (dispatch, getState) => {
        axios.get('http://localhost:8095/api/purchases/shoppingCart/user/' + id)
            .then(res => {
                //nakon sto smo dobili korpu, moramo da ucitamo i rezervacije koje ona ima..
                console.log(res.data)
                dispatch(getCarReservation(res.data.carReservationId));
                dispatch({ type: 'GET_USER_SHOPPING_CART', userShoppingCart: res.data })
            })
    }

}

export const getCarReservation = (id) => {

    return (dispatch, getState) => {

        axios.get('http://localhost:8090/api/rentacar/reservation/' + id)
            .then(res => {
                console.log(res.data)
                dispatch({ type: 'GET_CAR_RESERVATION', carReservation: res.data })
            })
    }

}

export const makeReservation = (id) => {

    return (dispatch, getState) => {
        axios.post('http://localhost:8095/api/purchases/shoppingCart/' + id)
            .then(res => {
                console.log(res.data)
                dispatch({ type: 'MAKE_RESERVATION', finalReservation: res.data })
            })

    }

}
