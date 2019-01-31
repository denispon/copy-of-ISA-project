const initState = {

    user: {},
    useri: []
}

const userReducer = (state = initState, action) => {

    switch (action.type) {
        case 'GET_USER':
            return {
                ...state,
                user: action.user
            }

        case 'GET_ALL_USERS':
            return {
                ...state,
                useri: action.users
            }

        default:
            break;
    }

    return state;

}

export default userReducer;

