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
        case 'CREATE_USLUGA':
            console.log('kreirana usluga', action.usluga);
            break;
        case 'DELETE_USLUGA':
            console.log('obrisana usluga', action.uslugaId);
            break;
        case 'EDIT_USLUGA':
            console.log('izmenjena usluga', action.uslugaId);
            window.location = '/listaDodatnihUslugaAdmin';
            break;
        case 'CREATE_TIP':
            console.log('kreiran tip', action.tip);
            break;
        case 'DELETE_TIP':
            console.log('izbrisan tip', action.tipId);
            break;
        case 'EDIT_TIP':
            console.log('izmenjen tip', action.tipId);
            window.location = '/listaTipovaSobaAdmin';
            break;
        case 'CREATE_SOBA':
            console.log('kreirana soba', action.soba);
            break;
        case 'DELETE_SOBA':
            console.log('izbrisana soba', action.soba);
            break;
        case 'EDIT_SOBA':
            console.log('izmenjena soba', action.sobaId);
            window.location = '/listaHotelskihSobaAdmin';
            break;
            
    }
    return state
}

export default hoteliReducer;

