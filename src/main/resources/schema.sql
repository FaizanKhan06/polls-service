CREATE TABLE polls_entity (
    poll_id INT AUTO_INCREMENT PRIMARY KEY,  -- poll_id is the primary key and auto-incremented
    community_id INT NOT NULL,               -- community_id, assuming it cannot be null
    poll_start_date DATETIME,                -- poll_start_date, matching LocalDateTime
    poll_result VARCHAR(255),                -- poll_result, assuming it’s a string
    poll_end BOOLEAN NOT NULL               -- poll_end, a boolean indicating the poll status
);
