import React from 'react'
import {NavLink} from 'react-router-dom'

import Company from './Company'


const CompaniesMain = () =>
{
    return(
        <div className="container">
            <div className="center">
                <NavLink to="/" className="indigo-text lighten-1">Dodaj novu kompaniju</NavLink>
                <Company/>
                <Company/>
                <Company/>
            </div>
        </div>
    );
}

export default CompaniesMain