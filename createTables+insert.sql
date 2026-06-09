CREATE DATABASE nr_user_db;
CREATE DATABASE nr_ticket_db;
CREATE DATABASE nr_assignment_db;
CREATE DATABASE nr_activity_db;
CREATE DATABASE nr_notification_db;

USE nr_user_db;

CREATE TABLE roles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE teams (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    description VARCHAR(255)
);

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100),
    email VARCHAR(100),
    role_id BIGINT,
    team_id BIGINT,
    active BOOLEAN
);

INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');

INSERT INTO teams (name, description) VALUES
('Backend', 'Backend development team'),
('Frontend', 'Frontend development team'),
('QA', 'Testing and Quality Assurance'),
('DevOps', 'Deployment and Infrastructure'),
('Database', 'Database Management');

INSERT INTO users (full_name, email, role_id, team_id, active) VALUES
('Nikola Rajic', 'nikola@gmail.com', 1, 1, true),
('Marko Markovic', 'marko@gmail.com', 2, 2, true),
('Janko Jankovic', 'janko@gmail.com', 2, 3, true),
('Ana Petrovic', 'ana@gmail.com', 2, 4, true),
('Petar Pavlovic', 'petar@gmail.com', 2, 5, true),
('Milan Jovic', 'milan@gmail.com', 2, 1, true),
('Jovana Petrovic', 'jovana@gmail.com', 2, 2, true),
('Stefan Nikolic', 'stefan@gmail.com', 2, 3, true),
('Ivana Simic', 'ivana@gmail.com', 2, 4, true),
('Luka Markovic', 'luka@gmail.com', 2, 5, true),
('Teodora Ilic', 'teodora@gmail.com', 2, 1, false),
('Nemanja Vasic', 'nemanja@gmail.com', 2, 2, true);

USE nr_ticket_db;

CREATE TABLE ticket_categories (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    description VARCHAR(255)
);

CREATE TABLE tickets (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(150),
    description TEXT,
    status VARCHAR(50),
    priority VARCHAR(50),
    type VARCHAR(50),
    reporter_id BIGINT,
    created_at DATETIME,
    updated_at DATETIME
);

CREATE TABLE ticket_status_history (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ticket_id BIGINT,
    old_status VARCHAR(50),
    new_status VARCHAR(50),
    changed_at DATETIME
);

INSERT INTO ticket_categories (name, description) VALUES
('Bug', 'Software bug'),
('Feature', 'Feature request'),
('Support', 'Support issue'),
('Task', 'Internal task'),
('Incident', 'System incident'),
('Change', 'Change request'),
('Security', 'Security problem');

use nr_ticket_db;

select * from tickets;


INSERT INTO tickets
(title, description, status, priority, type, reporter_id, created_at, updated_at)
VALUES
('Payment bug', 'Users cannot complete payment process', 'OPEN', 'HIGH', 'BUG', 2, '2026-04-21 00:07:54', '2026-04-21 00:07:54'),
('Add notifications page', 'Create notifications management page', 'OPEN', 'MEDIUM', 'FEATURE', 3, '2026-04-21 00:07:54', '2026-04-21 00:07:54'),
('Profile image upload issue', 'Images are not uploading correctly', 'IN_PROGRESS', 'MEDIUM', 'BUG', 4, '2026-04-21 00:07:54', '2026-04-21 00:07:54'),
('Monthly analytics report', 'Prepare monthly business report', 'OPEN', 'LOW', 'TASK', 5, '2026-04-21 00:07:54', '2026-04-21 00:07:54'),
('Server memory issue', 'Production server RAM usage is too high', 'OPEN', 'CRITICAL', 'INCIDENT', 1, '2026-04-21 00:07:54', '2026-04-21 00:07:54'),
('Database backup setup', 'Automate nightly database backups', 'OPEN', 'HIGH', 'TASK', 2, '2026-04-21 00:07:54', '2026-04-21 00:07:54'),
('Security review', 'Check suspicious login attempts', 'OPEN', 'HIGH', 'SECURITY', 3, '2026-04-21 00:07:54', '2026-04-21 00:07:54'),
('Dark mode request', 'Users requested dark mode theme', 'OPEN', 'LOW', 'FEATURE', 4, '2026-04-21 00:07:54', '2026-04-21 00:07:54'),
('Email delay problem', 'Emails are delivered with delay', 'IN_PROGRESS', 'MEDIUM', 'SUPPORT', 5, '2026-04-21 00:07:54', '2026-04-21 00:07:54');

INSERT INTO ticket_status_history
(ticket_id, old_status, new_status, changed_at)
VALUES
(1,'NEW','OPEN',NOW()),
(2,'NEW','OPEN',NOW()),
(3,'OPEN','IN_PROGRESS',NOW()),
(4,'NEW','OPEN',NOW()),
(5,'NEW','OPEN',NOW()),
(6,'NEW','OPEN',NOW()),
(7,'NEW','OPEN',NOW());

USE nr_assignment_db;

CREATE TABLE assignments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ticket_id BIGINT,
    agent_id BIGINT,
    assigned_at DATETIME,
    active BOOLEAN
);

CREATE TABLE assignment_history (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ticket_id BIGINT,
    old_agent_id BIGINT,
    new_agent_id BIGINT,
    changed_at DATETIME,
    reason VARCHAR(255)
);

INSERT INTO assignments
(ticket_id, agent_id, assigned_at, active)
VALUES
(1,2,NOW(),true),
(2,3,NOW(),true),
(3,4,NOW(),true),
(4,5,NOW(),true),
(5,6,NOW(),true),
(6,7,NOW(),true),
(7,8,NOW(),true);

INSERT INTO assignment_history
(ticket_id, old_agent_id, new_agent_id, changed_at, reason)
VALUES
(1,NULL,2,NOW(),'Initial assignment'),
(2,NULL,3,NOW(),'Initial assignment'),
(3,NULL,4,NOW(),'Initial assignment'),
(4,NULL,5,NOW(),'Initial assignment'),
(5,NULL,6,NOW(),'Initial assignment'),
(6,NULL,7,NOW(),'Initial assignment'),
(7,NULL,8,NOW(),'Initial assignment');

USE nr_activity_db;

CREATE TABLE comments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ticket_id BIGINT,
    user_id BIGINT,
    content TEXT,
    created_at DATETIME
);

CREATE TABLE activity_logs (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ticket_id BIGINT,
    activity_type VARCHAR(100),
    description TEXT,
    created_at DATETIME
);

CREATE TABLE attachments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ticket_id BIGINT,
    file_name VARCHAR(255),
    file_path VARCHAR(255),
    uploaded_at DATETIME
);

INSERT INTO comments
(ticket_id, user_id, content, created_at)
VALUES
(1,2,'Checking login issue',NOW()),
(2,3,'Feature accepted',NOW()),
(3,4,'Investigating email problem',NOW()),
(4,5,'Working on report',NOW()),
(5,6,'Restarting server',NOW()),
(6,7,'Upgrade planned',NOW()),
(7,8,'Security audit started',NOW());

INSERT INTO activity_logs
(ticket_id, activity_type, description, created_at)
VALUES
(1,'STATUS_CHANGE','Ticket opened',NOW()),
(2,'CREATED','Feature ticket created',NOW()),
(3,'COMMENT','Support comment added',NOW()),
(4,'TASK','Task created',NOW()),
(5,'INCIDENT','Production issue detected',NOW()),
(6,'CHANGE','Upgrade requested',NOW()),
(7,'SECURITY','Security case opened',NOW());

use nr_activity_db;

select * from attachments;

INSERT INTO attachments
(ticket_id, file_name, file_path, uploaded_at)
VALUES
(1,'login.png','/files/login.png',NOW()),
(2,'darkmode.pdf','/files/darkmode.pdf',NOW()),
(3,'mail.log','/files/mail.log',NOW()),
(4,'report.xlsx','/files/report.xlsx',NOW()),
(5,'server.txt','/files/server.txt',NOW()),
(6,'upgrade.docx','/files/upgrade.docx',NOW()),
(7,'audit.pdf','/files/audit.pdf',NOW());

USE nr_notification_db;

CREATE TABLE notifications (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ticket_id BIGINT,
    recipient_id BIGINT,
    message TEXT,
    created_at DATETIME
);

CREATE TABLE notification_logs (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    notification_id BIGINT,
    sent_at DATETIME,
    delivery_status VARCHAR(50)
);

use nr_notification_db;
select * from notifications;
INSERT INTO notifications
(ticket_id, recipient_id, message, created_at)
VALUES
(1,2,'Assigned to ticket 1',NOW()),
(2,3,'Assigned to ticket 2',NOW()),
(3,4,'Assigned to ticket 3',NOW()),
(4,5,'Assigned to ticket 4',NOW()),
(5,6,'Assigned to ticket 5',NOW()),
(6,7,'Assigned to ticket 6',NOW()),
(7,8,'Assigned to ticket 7',NOW()),
(8,1,'Ticket 8 is waiting for assignment',NOW()),
(9,1,'Ticket 9 is waiting for assignment',NOW()),
(10,1,'Ticket 10 is waiting for assignment',NOW());

INSERT INTO notification_logs
(notification_id, sent_at, delivery_status)
VALUES
(1,NOW(),'PENDING'),
(2,NOW(),'DELIVERED'),
(3,NOW(),'DELIVERED'),
(4,NOW(),'PENDING'),
(5,NOW(),'DELIVERED'),
(6,NOW(),'PENDING'),
(7,NOW(),'DELIVERED');