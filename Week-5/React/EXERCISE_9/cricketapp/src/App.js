
import React from 'react';
import ListofPlayers from './ListofPlayers';
import IndianPlayers from './IndianPlayers';

function App() {

    let flag = true;

    return (
        <div>
            {
                flag ?
                <ListofPlayers /> :
                <IndianPlayers />
            }
        </div>
    );
}

export default App;
