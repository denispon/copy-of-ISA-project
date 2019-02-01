import React, { Component } from "react";
import { NavLink } from "react-router-dom"
import FriendRequest from "./FriendRequest";
import Friend from "./Friend";
import "./friends.css"
import SendFriendRequest from "./SendFriendRequest";
import FindFriend from "./FindFriend";
import { connect } from "react-redux";
import { getUserFriendRequests, getUserFriends } from "../../../store/actions/UserActions"


class FriendsComponent extends Component {

    state = {

    }

    componentDidMount() {

        this.props.getUserFriendRequests(2);
        this.props.getUserFriends(2);

    }

    render() {
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

                {this.props.friendRequests.map(friendRequest => {
                    return (
                        <FriendRequest friendRequest={friendRequest} />
                    );
                })}

                {this.props.friends.map(friend => {
                    return (
                        <Friend friend={friend} />
                    );
                })}
            </div>

        );
    }
};



const mapStateToProps = (state) => {
    return {
        friendRequests: state.user.friendRequests,
        friends: state.user.friends
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        getUserFriendRequests: (id) => dispatch(getUserFriendRequests(id)),
        getUserFriends: (id) => dispatch(getUserFriends(id))
    }
}



export default connect(mapStateToProps, mapDispatchToProps)(FriendsComponent);