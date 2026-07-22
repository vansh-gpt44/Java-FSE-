
import React from 'react';

function IndianPlayers() {

    const OddTeamPlayers = [
        "Rohit Sharma",
        "Virat Kohli",
        "Hardik Pandya",
        "Jasprit Bumrah",
        "Ravindra Jadeja"
    ];

    const EvenTeamPlayers = [
        "KL Rahul",
        "Rishabh Pant",
        "Shubman Gill",
        "Mohammed Siraj",
        "Suryakumar Yadav",
        "Chahal"
    ];


    const [player1, player2, player3, player4, player5] = OddTeamPlayers;
    const [player6, player7, player8, player9, player10, player11] = EvenTeamPlayers;


    const T20players = [
        "Virat Kohli",
        "Rohit Sharma",
        "Hardik Pandya"
    ];

    const RanjiTrophyPlayers = [
        "Rahul",
        "Gill",
        "Jadeja"
    ];


    const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];


    return (
        <div>
            <h2>Indian Players</h2>

            <h3>Odd Team Players</h3>
            <p>{player1}, {player2}, {player3}, {player4}, {player5}</p>

            <h3>Even Team Players</h3>
            <p>{player6}, {player7}, {player8}, {player9}, {player10}, {player11}</p>


            <h3>Merged T20 and Ranji Players</h3>
            <ul>
                {
                    mergedPlayers.map(player =>
                        <li key={player}>{player}</li>
                    )
                }
            </ul>
        </div>
    );
}

export default IndianPlayers;
