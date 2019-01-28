export const createHotel = (hotel) => {

    return (dispatch, getState) =>{
        dispatch({type: 'CREATE_HOTEL', hotel: hotel});
    }

};