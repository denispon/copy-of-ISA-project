import React from "react";
import FriendRequest from "./FriendRequest";
import Friend from "./Friend";
import "./friends.css"


const FriendsComponent = () => {

    return (

        <div>
            <h2 className="center red-text lighten-1">Veljko's friends</h2>
            <FriendRequest></FriendRequest>
            <FriendRequest></FriendRequest>
            <FriendRequest></FriendRequest>
            <FriendRequest></FriendRequest>
            <Friend></Friend>
            <Friend></Friend>
            <Friend></Friend>
            <Friend></Friend>
        </div>

    );
};

export default FriendsComponent;