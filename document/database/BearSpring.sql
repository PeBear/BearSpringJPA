DROP TABLE IF EXISTS public."users";
DROP TYPE IF EXISTS public."user_status";
CREATE TYPE public."user_status" AS ENUM (
    'REGISTER',
    'ACTIVE',
    'DEACTIVATE'
    );
CREATE TABLE public."users"
(
    "id"          SERIAL PRIMARY KEY,
    "username"    VARCHAR(50)        NOT NULL,
    "password"    VARCHAR(512)       NOT NULL,
    "email"       VARCHAR(100)       NOT NULL,
    "full_name"   VARCHAR(200)       NOT NULL,
    "mobile"      VARCHAR(20),
    "last_login"  TIMESTAMP,
    "login_ip"    VARCHAR(100),
    "login_fail"  INT       DEFAULT 0,
    "is_forget"   BOOLEAN   DEFAULT FALSE,
    "status"      public.user_status NOT NULL,
    "joined_at"   TIMESTAMP DEFAULT 'now()',
    "modified_at" TIMESTAMP DEFAULT 'now()'
);
CREATE UNIQUE INDEX ON public."users" ("username");

DROP TABLE IF EXISTS public."group";
CREATE TABLE public."group"
(
    "id"          SERIAL PRIMARY KEY,
    "name"        VARCHAR(50) NOT NULL,
    "description" VARCHAR(100),
    "is_active"   BOOLEAN DEFAULT TRUE
);

DROP TABLE IF EXISTS public."permission";
CREATE TABLE public."permission"
(
    "id"          SERIAL PRIMARY KEY,
    "code"        VARCHAR(50) NOT NULL,
    "name"        VARCHAR(50) NOT NULL,
    "description" VARCHAR(100),
    "category"    VARCHAR(100),
    "is_active"   BOOLEAN DEFAULT TRUE
);

DROP TABLE IF EXISTS public."user_group";
CREATE TABLE public."user_group"
(
    "user_id"  INT,
    "group_id" INT,
    PRIMARY KEY ("user_id", "group_id")
);

DROP TABLE IF EXISTS public."group_permission";
CREATE TABLE public."group_permission"
(
    "group_id"      INT,
    "permission_id" INT,
    PRIMARY KEY ("group_id", "permission_id")
);

DROP TABLE IF EXISTS public."configuration";
CREATE TABLE public."configuration"
(
    "id"          SERIAL PRIMARY KEY,
    "code"        VARCHAR(50) NOT NULL,
    "value"       VARCHAR     NOT NULL,
    "description" VARCHAR(100),
    "category"    VARCHAR(100),
    "is_active"   BOOLEAN DEFAULT TRUE
);
