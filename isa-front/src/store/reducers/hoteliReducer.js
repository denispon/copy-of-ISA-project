const initState = {
    hoteli: []
}

const hoteliReducer = (state = initState, action) => {
    switch(action.type){
        case 'CREATE_HOTEL':
            console.log('kreiran hotel', action.hotel)
            
    }
    return state
}

export default hoteliReducer;