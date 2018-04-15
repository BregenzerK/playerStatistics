import React from 'react';
import {Route, Switch} from "react-router-dom";
import PlayerDetail from "./Player-detail"
import PlayerList from "./Player-list"
import 'font-awesome/css/font-awesome.min.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';

class App extends React.Component {

    render() {
        return (
            <div className="container">
                <h1 className="h1-responsive">Player Statistics</h1>
                <Switch>
                    <Route exact path='/' component={PlayerList}/>
                    <Route path='/player/:id' component={PlayerDetail} />
                </Switch>
            </div>
        );
    }
}

export default App;
