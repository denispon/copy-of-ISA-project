import axios from 'axios'

export const getUser = (id) => {

    return (dispatch, getState) => {

        axios.get('http://localhost:8096/api/user/user/' + id)
            .then(res => {
                console.log(res);
                dispatch({ type: 'GET_USER', user: res.data });
            })

    }

}