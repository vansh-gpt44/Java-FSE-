USE CommunityPortal;

INSERT INTO Users
(full_name,email,city,registration_date)
VALUES
('Alice Johnson','alice@example.com','New York','2024-12-01'),
('Bob Smith','bob@example.com','Los Angeles','2024-12-05'),
('Charlie Lee','charlie@example.com','Chicago','2024-12-10'),
('Diana King','diana@example.com','New York','2025-01-15'),
('Ethan Hunt','ethan@example.com','Los Angeles','2025-02-01');

INSERT INTO Events
(title,description,city,start_date,end_date,status,organizer_id)
VALUES
('Tech Innovators Meetup','A meetup for tech enthusiasts','New York',
'2025-06-10 10:00:00','2025-06-10 16:00:00','upcoming',1),

('AI & ML Conference','Conference on AI and ML advancements','Chicago',
'2025-05-15 09:00:00','2025-05-15 17:00:00','completed',3),

('Frontend Development Bootcamp','Hands-on frontend training','Los Angeles',
'2025-07-01 10:00:00','2025-07-03 16:00:00','upcoming',2);
