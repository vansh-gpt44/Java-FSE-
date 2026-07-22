import Trainer from './Trainer';

const trainers = [
    new Trainer(
        1,
        "John Smith",
        "john@gmail.com",
        "9876543210",
        "React",
        ["JavaScript","React","HTML"]
    ),
    new Trainer(
        2,
        "Mary Jane",
        "mary@gmail.com",
        "9876543211",
        "Java",
        ["Java","Spring Boot","SQL"]
    ),
    new Trainer(
        3,
        "David Lee",
        "david@gmail.com",
        "9876543212",
        "Cloud",
        ["AWS","Docker","Kubernetes"]
    )
];

export default trainers;