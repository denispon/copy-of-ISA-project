import axios from 'axios'

export const createHotel = (hotel) =>{
    return (dispatch, getState) =>{
        //async call to db dodavanje u bazu
        axios.post('http://localhost:8092/api/hotel/hotel/', { adress: hotel.adresaDodaj, name: hotel.imeDodaj, promotionalDescription: hotel.opisDodaj })
            .then(res => {
            console.log(res);
            //console.log(res.data);
      })
        dispatch({type: 'CREATE_HOTEL', hotel: hotel});
    }

}