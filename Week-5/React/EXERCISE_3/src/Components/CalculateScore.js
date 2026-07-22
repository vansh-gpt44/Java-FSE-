import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore(props) {

  const averageScore =
    (props.Total / props.goal) * 100;

  return (
    <div className="container">
      <h1>Student Score Calculator</h1>

      <p>Name: {props.Name}</p>

      <p>School: {props.School}</p>

      <p>Total Score: {props.Total}</p>

      <p>Goal Score: {props.goal}</p>

      <h2>
        Average Score: {averageScore.toFixed(2)}%
      </h2>
    </div>
  );
}

export default CalculateScore;