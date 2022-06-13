DROP TABLE IF EXISTS "bear_expense"."profile";
CREATE TABLE "bear_expense"."profile"
(
    "id"         SERIAL PRIMARY KEY,
    "name"       VARCHAR(50) NOT NULL,
    "currency"   INT         NOT NULL,
    "is_deleted" BOOLEAN DEFAULT (FALSE)
);

DROP TABLE IF EXISTS "bear_expense"."wallet";
DROP TYPE IF EXISTS "bear_expense"."wallet_term_type";
CREATE TYPE "bear_expense"."wallet_term_type" AS ENUM (
    'DAILY',
    'QUARTERLY',
    'MONTHLY',
    'YEARLY'
    );
DROP TYPE IF EXISTS "bear_expense"."wallet_type";
CREATE TYPE "bear_expense"."wallet_type" AS ENUM (
    'CASH',
    'DEPOSIT',
    'CREDIT',
    'LOAN',
    'SAVING'
    );
CREATE TABLE "bear_expense"."wallet"
(
    "id"              SERIAL PRIMARY KEY,
    "name"            VARCHAR(50) not null,
    "type"            "bear_expense".wallet_type,
    "icon"            INT,
    "currency"        INT         not null,
    "initial_ammount" DECIMAL default 0,
    "last_amount"     DECIMAL,
    "loan_interest"   DECIMAL,
    "saving_interest" DECIMAL,
    "credit_interest" DECIMAL,
    "term_type"       "bear_expense".wallet_term_type,
    "term"            INT,
    "is_deleted"      BOOLEAN DEFAULT (FALSE)
);

DROP TABLE IF EXISTS "bear_expense"."profile_wallet" CASCADE;
CREATE TABLE "bear_expense"."profile_wallet"
(
    "id"         SERIAL PRIMARY KEY,
    "profile_id" INT,
    "wallet_id"  INT,
    "index"      INT
);
CREATE INDEX ON "bear_expense"."profile_wallet" ("profile_id");

DROP TABLE IF EXISTS "bear_expense"."category";
DROP TYPE IF EXISTS "bear_expense"."category_type";
CREATE TYPE "bear_expense"."category_type" AS ENUM (
    'EXPENSE',
    'INCOME'
    );

CREATE TABLE "bear_expense"."category"
(
    "id"    SERIAL PRIMARY KEY,
    "name"  VARCHAR(50)                  not null,
    "color" INT                          not null,
    "icon"  INT                          not null,
    "type"  "bear_expense".category_type not null
);

DROP TABLE IF EXISTS "bear_expense"."wallet_category";
CREATE TABLE "bear_expense"."wallet_category"
(
    "id"          SERIAL PRIMARY KEY,
    "wallet_id"   BIGINT,
    "category_id" BIGINT,
    "index"       INT
);
CREATE INDEX ON "bear_expense"."wallet_category" ("wallet_id");

DROP TABLE IF EXISTS "bear_expense"."transaction";
DROP TYPE IF EXISTS "bear_expense"."transaction_type";
CREATE TYPE "bear_expense"."transaction_type" AS ENUM (
    'EXPENSE',
    'INCOME'
    );
CREATE TABLE "bear_expense"."transaction"
(
    "id"          SERIAL PRIMARY KEY,
    "wallet_id"   INT                             not null,
    "category_id" INT                             not null,
    "type"        "bear_expense".transaction_type not null,
    "amount"      DECIMAL                         not null,
    "date"        TIMESTAMP                       not null,
    "memo"        VARCHAR(250),
    "created_at"  TIMESTAMP DEFAULT (NOW()),
    "modified_at" TIMESTAMP DEFAULT (NOW())
);

DROP TABLE IF EXISTS "bear_expense"."common";
CREATE TABLE "bear_expense"."common"
(
    "id"        SERIAL PRIMARY KEY,
    "code"      VARCHAR(50)  not null,
    "key"       VARCHAR(50)  not null,
    "value"     VARCHAR(250) not null,
    "is_active" BOOLEAN DEFAULT (TRUE)
);
