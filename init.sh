#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE DATABASE auth_db;
    CREATE DATABASE task_db;
    CREATE DATABASE analytics_db;
    CREATE DATABASE notification_db;

    -- Даем все права пользователю postgres на все БД
    GRANT ALL PRIVILEGES ON DATABASE auth_db TO postgres;
    GRANT ALL PRIVILEGES ON DATABASE task_db TO postgres;
    GRANT ALL PRIVILEGES ON DATABASE analytics_db TO postgres;
    GRANT ALL PRIVILEGES ON DATABASE notification_db TO postgres;
EOSQL