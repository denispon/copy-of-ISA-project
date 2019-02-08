import axios from 'axios'
import { bindActionCreators } from '../../../../../../../AppData/Local/Microsoft/TypeScript/3.2/node_modules/redux';

export const getUser = (id) => {

    return (dispatch, getState) => {
        var user = JSON.parse(localStorage.getItem('user'))
        if (user) {
            axios.get('http://localhost:8096/api/user/user/' + id, {
                headers: {
                    Role: user.role.role
                }
            })
                .then(res => {
                    console.log(res);
                    dispatch({ type: 'GET_USER', user: res.data });
                })
        }

    }

}

export const getUserFriendRequests = (id) => {

    return (dispatch, getState) => {
        var user = JSON.parse(localStorage.getItem('user'))
        if (user) {
            axios.get('http://localhost:8096/api/user/user/friendRequest/' + id, {
                headers: {
                    Role: user.role.role
                }
            })
                .then(res => {
                    console.log(res);
                    dispatch({ type: 'GET_ALL_USERS_FRIEND_REQUESTS', friendRequests: res.data });
                })
        }
    }
}

export const getUserFriends = (id) => {

    return (dispatch, getState) => {
        var user = JSON.parse(localStorage.getItem('user'))
        if (user) {
            axios.get('http://localhost:8096/api/user/user/friends/' + id, {
                headers: {
                    Role: user.role.role
                }
            })
                .then(res => {
                    console.log(res);
                    dispatch({ type: 'GET_ALL_USER_FRIENDS', friends: res.data });
                })
        }
    }
}

export const updateUser = (id, user) => {

    return (dispatch, getState) => {
        console.log(user);
        var userFromSession = JSON.parse(localStorage.getItem('user'))
        if (userFromSession) {
            axios.put('http://localhost:8096/api/user/user/' + id, { id: user.id, name: user.name, surname: user.surname, city: user.city, email: user.email, telephoneNumber: user.telephoneNumber, passport: user.passport }, {
                headers: {
                    Role: userFromSession.role.role
                }
            })
                .then(res => {
                    console.log(res);
                    dispatch({ type: 'USER_CHANGES_HIS_ATRIBUTES', user: res.data });
                    dispatch({ type: "SHOW_SUCCESS", success: true });
                })
        }

    }

}


export const logInUser = (email, password) => {

    return (dispatch, getState) => {

        axios.post('http://localhost:8096/api/user/user/login', { email: email, password: password })
            .then(res => {
                console.log(res);
                localStorage.setItem('user', JSON.stringify(res.data))
                window.location = '/'
                dispatch({ type: 'LOG_IN_USER', user: res.data });
            })
            .catch(error => {

                dispatch({ type: 'SHOW_ERROR', error: true })
            });

    }

}

export const hideError = () => {

    return (dispatch, getState) => {
        dispatch({ type: 'SHOW_ERROR', error: false })
    }

}

export const hideSucces = () => {

    return (dispatch, getState) => {
        dispatch({ type: 'HIDE_SUCCESS', success: false })
    }

}



export const loadUserAfterRefresh = (user) => {

    return (dispatch, getState) => {
        dispatch({ type: 'LOAD_USER_AFTER_REFRESH', user: user });
    }

}


export const logOutUser = () => {

    return (dispatch, getState) => {


        localStorage.setItem('user', undefined)
        window.location = '/'
        dispatch({ type: 'LOG_OUT_USER', user: undefined });


    }

}

export const getUserBonusPoints = (userId) => {

    return (dispatch, getState) => {
        var userFromSession = JSON.parse(localStorage.getItem('user'))
        if (userFromSession) {
            axios.get('http://localhost:8095/api/purchases/bonusPoints/' + userId, {
                headers: {
                    Role: userFromSession.role.role
                }
            })
                .then(res => {
                    console.log(res);
                    dispatch({ type: 'GET_USER_BONUS_POINTS', userBonusPoints: res.data });
                })
        }

    }

}