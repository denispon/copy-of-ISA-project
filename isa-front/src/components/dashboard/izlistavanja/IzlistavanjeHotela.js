import React from 'react';
import KarticaHotela from './KarticaHotela';

const IzlistavanjeHotela = ({hoteli}) =>{

    return (
        <div>
            { hoteli && hoteli.map(hotel =>{
                return( 
                    <KarticaHotela hotel={hotel} key={hotel.id}></KarticaHotela>
                )
            })}
        </div>

    )
}

export default IzlistavanjeHotela;