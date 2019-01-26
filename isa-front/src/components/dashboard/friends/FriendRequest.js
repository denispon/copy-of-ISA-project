import React from "react";
import "./friends.css"


const FriendRequest = () => {

    return (
        <div className="center container">
            <div className="row container center">
                <p className="col s7">Danijel Venus</p>
                <a class="waves-effect  waves-light teal btn friendsButton">Dodaj</a>
                <a class="waves-effect waves-light red btn friendsButton">Odbi</a>
            </div>
        </div>
    );

};

export default FriendRequest;