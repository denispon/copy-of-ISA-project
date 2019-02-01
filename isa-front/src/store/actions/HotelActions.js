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

export const deleteHotel = (hotelId) =>{
    return (dispatch, getState) =>{
        //async call to db dodavanje u bazu
        axios.delete('http://localhost:8092/api/hotel/hotel/'+hotelId)
            .then(res => {
            console.log(res);
      })
        dispatch({type: 'DELETE_HOTEL', hotelId});
    }
}

export const editHotel = (hotel) =>{
    return (dispatch, getState) =>{
        //async call to db dodavanje u bazu
        axios.put('http://localhost:8092/api/hotel/hotel/'+hotel.idIzmeni, { adress: hotel.adresaIzmeni, name: hotel.imeIzmeni, promotionalDescription: hotel.opisIzmeni })
            .then(res => {
            console.log(res);
            console.log(res.data);
      })
        dispatch({type: 'EDIT_HOTEL', hotel: hotel});
    }

}