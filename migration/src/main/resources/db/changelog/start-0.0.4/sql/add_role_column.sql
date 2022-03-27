CREATE TYPE user_role AS ENUM ('ROLE_ADMIN', 'ROLE_USER');
ALTER TABLE contact ADD COLUMN role user_role;