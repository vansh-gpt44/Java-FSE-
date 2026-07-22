import React from 'react';
import {useParams} from 'react-router-dom';
import trainers from './TrainersMock';

function TrainerDetail(){

    const {id} = useParams();

    const trainer =
        trainers.find(
            t => t.TrainerId.toString() === id
        );

    return (
        <div>
            <h2>Trainer Details</h2>
            {
                trainer &&
                <>
                <p>ID: {trainer.TrainerId}</p>
                <p>Name: {trainer.Name}</p>
                <p>Email: {trainer.Email}</p>
                <p>Phone: {trainer.Phone}</p>
                <p>Technology: {trainer.Technology}</p>
                <p>Skills: {trainer.Skills.join(", ")}</p>
                </>
            }
        </div>
    );
}

export default TrainerDetail;