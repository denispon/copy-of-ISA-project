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

export const createUserShoppingCart = (userId) => {

    return (dispatch, getState) => {
        axios.post('http://localhost:8095/api/purchases/shoppingCart/', { id: -1, bonusPoints: 0, userId: userId, carReservationId: null, roomReservationId: null, price: 0 })
            .then(res => {
                console.log(res.data)
                dispatch({ type: 'CREATE_USER_SHOPPING_CART', userShoppingCart: res.data })
            })
    }

}

export const addRentACarReservationToShoppingCart = (idKorpe, dateFrom, dateTo, car) => {

    return (dispatch, getState) => {
        axios.put('http://localhost:8095/api/purchases/shoppingCart/addCarReservation/' + idKorpe, { id: -1, dateFrom: dateFrom, dateTo: dateTo, rating: 0, carRating: 0, reservedCar: { id: car.id, rentPrice: car.rentPrice, carType: { id: car.carType.id, numberOfSeats: '', modelYear: '', model: '', brand: '', carType: '' }, rentService: { id: car.rentService.id, name: '', adress: '', description: '' }, branchOffice: { id: car.branchOffice.id, name: '', adress: '', city: '', rentServiceDTO: { id: car.rentService.id, adress: '', name: '', description: '' } } }, branchOfficeFrom: { id: car.branchOffice.id, name: '', adress: '', city: '', rentServiceDTO: { id: car.rentService.id, adress: '', name: '', description: '' } }, branchOfficeTo: { id: car.branchOffice.id, name: '', adress: '', city: '', rentServiceDTO: { id: car.rentService.id, adress: '', name: '', description: '' } }, service: { id: car.rentService.id, adress: '', name: '', description: '' } })
            .then(res => {
                console.log(res.data)
                dispatch({ type: 'ADD_CAR_RESERVATION_TO_SHOPPING_CART', userShoppingCart: res.data })
            })
    }
}

export const removeRentACarReservationFromShoppingCart = (idKorpe) => {

    return (dispatch, getState) => {
        axios.delete('http://localhost:8095/api/purchases/shoppingCart/deleteCarReservation/' + idKorpe)
            .then(res => {
                console.log(res.data)
                dispatch({ type: 'REMOVE_CAR_RESERVATION_FROM_SHOPPING_CART', userShoppingCart: res.data })
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

export const getAllUserReservations = (id) => {

    return (dispatch, getState) => {
        axios.get('http://localhost:8095/api/purchases/reservation/allByUser/' + id)
            .then(res => {
                console.log(res.data)
                res.data.map(reservation => {
                    return (dispatch(addRentCarReservationToCollection(reservation.carReservationId)));
                })

                dispatch({ type: 'GET_USER_RESERVATIONS', userReservations: res.data })
            })

    }

}

export const addRentCarReservationToCollection = (id) => {

    return (dispatch, getState) => {
        axios.get('http://localhost:8090/api/rentacar/reservation/' + id)
            .then(res => {
                console.log(res.data)
                dispatch({ type: 'GET_USER_RENT_A_CAR_RESERVATIONS', rentCarReservations: res.data })
            })
    }

}


export const createBonusPointsDiscount = (bonusPointsDiscount) => {

    return (dispatch, getState) => {

        axios.post('http://localhost:8095/api/purchases/bonusPoitsDiscounts/', { id: bonusPointsDiscount.id, points: bonusPointsDiscount.points, discount: bonusPointsDiscount.discount })
            .then(res => {
                console.log(res);
                dispatch({ type: 'CREATE_BONUS_POINTS_DISCOUNT', bonusPointsDiscount: res.data });
            })
    }
}


export const editBonusPointsDiscount = (id, bonusPointsDiscount) => {

    return (dispatch, getState) => {

        axios.put('http://localhost:8095/api/purchases/bonusPoitsDiscounts/' + id, { id: bonusPointsDiscount.id, points: bonusPointsDiscount.points, discount: bonusPointsDiscount.discount })
            .then(res => {
                console.log(res);
                dispatch({ type: 'UPDATE_BONUS_POINTS_DISCOUNT', editedDiscount: res.data });
            })
    }
}


export const deleteBonusPointsDiscount = (id) => {

    return (dispatch, getState) => {

        axios.delete('http://localhost:8095/api/purchases/bonusPoitsDiscounts/' + id)
            .then(res => {
                console.log(res);
                dispatch({ type: 'DELETE_BONUS_POINTS_DISCOUNT', deletedDiscount: res.data });
            })

    }
}
