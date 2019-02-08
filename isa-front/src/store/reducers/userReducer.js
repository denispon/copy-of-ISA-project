const initState = {

    user: undefined,
    useri: [],
    friends: [],
    friendRequests: [],
    userBonusPoints: undefined,
    error: false,
    success: false,
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

        case 'GET_ALL_USERS_FRIEND_REQUESTS':
            return {
                ...state,
                friendRequests: action.friendRequests
            }

        case 'GET_ALL_USER_FRIENDS':
            return {
                ...state,
                friends: action.friends
            }

        case 'USER_CHANGES_HIS_ATRIBUTES':
            return {
                ...state,
                user: action.user
            }

        case 'LOG_IN_USER':
            return {
                ...state,
                user: action.user
            }

        case 'LOAD_USER_AFTER_REFRESH':
            return {
                ...state,
                user: action.user
            }

        case 'LOG_OUT_USER':
            return {
                ...state,
                user: undefined
            }

        case 'GET_USER_BONUS_POINTS':
            return {
                ...state,
                userBonusPoints: action.userBonusPoints
            }

        case 'SHOW_ERROR':
            return {
                ...state,
                error: action.error
            }

        case 'HIDE_ERROR':
            return {
                ...state,
                error: false
            }
        case 'SHOW_SUCCESS':
            return {
                ...state,
                success: action.success
            }

        case 'HIDE_SUCCESS':
            return {
                ...state,
                success: false
            }


        default:
            break;
    }

    return state;

}

export default userReducer;

