USE CommunityPortal;

SELECT * FROM Events
WHERE status='upcoming';

SELECT
u.full_name,
e.title
FROM Users u
JOIN Registrations r
ON u.user_id=r.user_id
JOIN Events e
ON r.event_id=e.event_id;

SELECT
city,
COUNT(*) AS total_events
FROM Events
GROUP BY city;

SELECT
u.full_name,
COUNT(e.event_id) AS total_events
FROM Users u
JOIN Events e
ON u.user_id=e.organizer_id
GROUP BY u.full_name;
