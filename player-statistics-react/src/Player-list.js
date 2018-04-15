import React from 'react';
import {Link} from "react-router-dom";
import 'font-awesome/css/font-awesome.min.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';

export default class PlayerList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            playerList:[],
        }
    }

    componentWillMount(){
        fetch("/api/players")
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({
                        playerList: result
                    });
                },
                (error) => {
                    this.setState({
                        error
                    });
                }
            )
    }

    render() {

        return (
            <div>
                <table className="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Ranking</th>
                        <th>Name</th>
                        <th>Tournament</th>
                        <th>Details</th>
                    </tr>
                    </thead>
                    <tbody className="playerList">
                    {this.state.playerList.map(player => (
                        <tr key={player.playerId}>
                            <td>{player.ranking}</td>
                            <td>{player.firstName} {player.lastName}</td>
                            <td>{player.tournamentName}</td>
                            <td className="text-center">
                                <Link
                                    to={"/player/" + player.playerId}>
                                    <i className="fa fa-long-arrow-right fa-2x"></i></Link>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        );
    }
}