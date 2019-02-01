const initState = {
    hoteli: []
}

const hoteliReducer = (state = initState, action) => {
    switch(action.type){
        case 'CREATE_HOTEL':
            console.log('kreiran hotel', action.hotel);
            break;
        case 'DELETE_HOTEL':
            console.log('izbrisan hotel', action.hotelId);
            break;
        case 'EDIT_HOTEL':
            console.log('izmenjen hotel', action.hotelId);
            window.location = '/listaHotelaAdmin';
            break;
            
    }
    return state
}

export default hoteliReducer;

