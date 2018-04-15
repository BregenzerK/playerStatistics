import React from 'react';
import {Link} from "react-router-dom";
import 'font-awesome/css/font-awesome.min.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';

export default class PlayerDetail extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            player: {}
        }
    }

    componentWillMount() {
        fetch("/api/player/" + this.props.match.params.id)
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({
                        player: result
                    });
                },
                (error) => {
                    this.setState({
                        error
                    });
                }
            )
    }

    splitPositions() {
        if (this.state.player.playedPositions) {
            return this.state.player.playedPositions.split('-').map((position, index )=> (
                <span key={index} className="played-positions">{position}</span>
            ))
        }
        return <span className="played-positions"></span>
    }

    render() {
        return (
            <div>
                <h2 className="h2-responsive">{this.state.player.firstName} {this.state.player.lastName}</h2>
                <div className="row padding-top">
                    <div className="col-12 col-md-6">
                        <div className="card card-cascade">
                            <div className="card-body">
                                <h3 className="card-title">Personal Information</h3>
                                <p className="card-text"> Age: {this.state.player.age} years <br></br>
                                    Height: {this.state.player.height} cm <br></br>
                                    Weight: {this.state.player.weight} kg <br></br>
                                    Active player: <span><i className="fa fa-check" aria-hidden="true"></i> </span>
                                    <br></br>
                                </p></div>
                        </div>
                    </div>
                    <div className="col-12 col-md-6">
                        <div className="card card-cascade">
                            <div className="card-body">
                                <h3 className="card-title">Team Information</h3>
                                <p className="card-text">Tournament name: {this.state.player.tournamentName}<br></br>
                                    Team name: {this.state.player.teamName}<br></br>
                                    Played positions: {this.splitPositions()}
                                    <br></br>
                                    Position: {this.state.player.positionText}<br></br></p>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="row padding-top">
                    <div className="col-12 col-md-6">
                        <div className="card card-cascade">
                            <div className="card-body">
                                <h3 className="card-title">Game Performance</h3>
                                <p className="card-text"> Played: {this.state.player.minsPlayed} min <br></br>
                                    Goals: {this.state.player.goal}<br></br>
                                    Assist total: {this.state.player.assistTotal}<br></br>
                                    Yellow cards: {this.state.player.yellowCard}<br></br>
                                    Red cards: {this.state.player.redCard}<br></br></p>
                            </div>
                        </div>
                    </div>
                    <div className="col-12 col-md-6">
                        <div className="card card-cascade">
                            <div className="card-body">
                                <h3 className="card-title">Averages</h3>
                                <p className="card-text"> Rating: {this.state.player.rating} <br></br>
                                    Shots per Game: {this.state.player.shotsPerGame} <br></br>
                                    Pass success: {this.state.player.passSuccess}% <br></br></p>
                            </div>
                        </div>
                    </div>
                </div>
                <Link
                    to={"/"}>
                    <button className="btn btn-primary pull-right">Go back</button>
                </Link>
            </div>
        );
    }
}