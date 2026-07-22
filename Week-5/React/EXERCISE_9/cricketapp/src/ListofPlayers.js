
import React from 'react';

function ListofPlayers() {

    const players = [
        { name: "Virat Kohli", score: 85 },
        { name: "Rohit Sharma", score: 78 },
        { name: "KL Rahul", score: 65 },
        { name: "Hardik Pandya", score: 72 },
        { name: "Rishabh Pant", score: 60 },
        { name: "Jasprit Bumrah", score: 55 },
        { name: "Ravindra Jadeja", score: 68 },
        { name: "Shubman Gill", score: 80 },
        { name: "Mohammed Siraj", score: 50 },
        { name: "Suryakumar Yadav", score: 75 },
        { name: "Yuzvendra Chahal", score: 62 }
    ];

    const playerDetails = players.map(player =>
        <li key={player.name}>
            {player.name} - {player.score}
        </li>
    );


    const filteredPlayers = players.filter(
        player => player.score < 70
    );


    return (
        <div>
            <h2>List of Players</h2>

            <h3>All Players</h3>
            <ul>
                {playerDetails}
            </ul>

            <h3>Players with score below 70</h3>
            <ul>
                {
                    filteredPlayers.map(player =>
                        <li key={player.name}>
                            {player.name} - {player.score}
                        </li>
                    )
                }
            </ul>
        </div>
    );
}

export default ListofPlayers;
