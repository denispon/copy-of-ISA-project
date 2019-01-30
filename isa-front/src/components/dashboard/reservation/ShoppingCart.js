import React from "react"
import ShoppingCartReservation from "./ShoppingCartReservation";


const ShoppingCart = () => {

    return (
        <div>
            <h2 className="center red-text lighten-1">Korpa</h2>

            <div className="container">
                <ShoppingCartReservation></ShoppingCartReservation>

                <h5 className="red-text lighten-1" ><strong>Ukupna cena: 10480 din</strong></h5>
                <p>Bonus poeni</p>
                <a class="btn-floating btn-small waves-effect waves-light red"><i class="material-icons">-</i></a>
                0 poena
                <a class="btn-floating btn-small waves-effect waves-light red"><i class="material-icons">+</i></a>

                <div className="row right">
                    <div className="col s8">
                        <button className="btn  indigo lighten-1">Dodeli je prijatelju</button>
                    </div>
                    <div className="col s2">
                        <button className="btn red lighten-1 z-depth-0">Naruci</button>
                    </div>
                </div>
            </div>




        </div>
    );

};

export default ShoppingCart;