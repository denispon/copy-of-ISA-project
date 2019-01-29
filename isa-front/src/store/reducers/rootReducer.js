import hoteliReducer from './hoteliReducer'
import letoviReducer from './letoviReducer'
import rentACarReducer from './rentACarReducer'
import { combineReducers } from 'redux'

const rootReducer = combineReducers({
    hotel: hoteliReducer,
    let: letoviReducer,
    rentACar: rentACarReducer
});

export default rootReducer;