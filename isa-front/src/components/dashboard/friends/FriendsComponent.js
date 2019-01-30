import React from "react";
import { NavLink } from "react-router-dom"
import FriendRequest from "./FriendRequest";
import Friend from "./Friend";
import "./friends.css"
import SendFriendRequest from "./SendFriendRequest";
import FindFriend from "./FindFriend";


const FriendsComponent = () => {

    return (

        <div>
            <h2 className="center red-text lighten-1">Veljko's friends</h2>

            <div className="center ">
                <NavLink to="/dodajPrijatelja">Dodaj novog prijatelja</NavLink>
                <br />
                <NavLink to="/#">Pretrazi prijatelje</NavLink>
            </div>
            <FindFriend />
            <SendFriendRequest />
            <br />
            <br />

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