import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails(props) {
    const cohort = props.cohort;

    return (
        <div className={styles.box}>
            <h3 className={
                cohort.status === "ongoing"
                ? styles.ongoing
                : styles.completed
            }>
                {cohort.name}
            </h3>

            <dl>
                <dt>ID</dt>
                <dd>{cohort.id}</dd>

                <dt>Name</dt>
                <dd>{cohort.name}</dd>

                <dt>Status</dt>
                <dd>{cohort.status}</dd>
            </dl>
        </div>
    );
}

export default CohortDetails;
