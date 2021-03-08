-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.9.2
-- PostgreSQL version: 12.0
-- Project Site: pgmodeler.io
-- Model Author: ---


-- Database creation must be done outside a multicommand file.
-- These commands were put in this file only as a convenience.
-- -- object: gofit | type: DATABASE --
-- -- DROP DATABASE IF EXISTS gofit;
-- CREATE DATABASE gofit;
-- -- ddl-end --
-- 

-- object: gofit | type: SCHEMA --
-- DROP SCHEMA IF EXISTS gofit CASCADE;
CREATE SCHEMA gofit;
-- ddl-end --
-- ALTER SCHEMA gofit OWNER TO postgres;
-- ddl-end --

SET search_path TO pg_catalog,public,gofit;
-- ddl-end --

-- object: public.couhe_profiles | type: TABLE --
-- DROP TABLE IF EXISTS public.couhe_profiles CASCADE;
CREATE TABLE public.couhe_profiles (
	id bigserial NOT NULL,
	couch_info varchar(500),
	sport_achivements varchar(150),
	sports_grade integer,
	rating float,
	money_amount integer NOT NULL,
	CONSTRAINT couhes_pk PRIMARY KEY (id)

);
-- ddl-end --
-- ALTER TABLE public.couhe_profiles OWNER TO postgres;
-- ddl-end --

-- object: public.traininings | type: TABLE --
-- DROP TABLE IF EXISTS public.traininings CASCADE;
CREATE TABLE public.traininings (
	id bigserial NOT NULL,
	start_date_time timestamptz NOT NULL,
	end_date_time timestamptz NOT NULL,
	inventory smallint,
	capacity smallint NOT NULL,
	duration smallint NOT NULL,
	id_couhe_profiles bigint,
	id_subscriptions bigint,
	id_clients_profiles bigint,
	id_sport_types smallint,
	id_sport_levels smallint,
	CONSTRAINT shedules_pk PRIMARY KEY (id)

);
-- ddl-end --
-- ALTER TABLE public.traininings OWNER TO postgres;
-- ddl-end --

-- object: public.clients_profiles | type: TABLE --
-- DROP TABLE IF EXISTS public.clients_profiles CASCADE;
CREATE TABLE public.clients_profiles (
	id bigserial NOT NULL,
	user_info text,
	favorite_sport_type varchar(100),
	sport_achivements varchar(150),
	sport_grade varchar(150),
	CONSTRAINT clients_pk PRIMARY KEY (id)

);
-- ddl-end --
COMMENT ON TABLE public.clients_profiles IS E'Профиль клиента';
-- ddl-end --
-- ALTER TABLE public.clients_profiles OWNER TO postgres;
-- ddl-end --

-- object: public.subscriptions | type: TABLE --
-- DROP TABLE IF EXISTS public.subscriptions CASCADE;
CREATE TABLE public.subscriptions (
	id bigserial NOT NULL,
	start_date_time timestamptz NOT NULL,
	end_date_time timestamptz NOT NULL,
	initial_amount smallint NOT NULL,
	remaining_amount smallint NOT NULL,
	price serial NOT NULL,
	duration smallint NOT NULL,
	id_clients_profiles bigint,
	id_couhe_profiles bigint,
	CONSTRAINT subscriptions_pk PRIMARY KEY (id)

);
-- ddl-end --
COMMENT ON TABLE public.subscriptions IS E'Абонимент на тренировки';
-- ddl-end --
COMMENT ON COLUMN public.subscriptions.start_date_time IS E'Дата начала тренировки';
-- ddl-end --
COMMENT ON COLUMN public.subscriptions.end_date_time IS E'Дата окончания тренировки';
-- ddl-end --

-- object: public.users | type: TABLE --
-- DROP TABLE IF EXISTS public.users CASCADE;
CREATE TABLE public.users (
	id bigserial NOT NULL,
	user_name varchar(50) NOT NULL,
	password varchar(150) NOT NULL,
	enabled boolean NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	adress varchar(100) NOT NULL,
	birthday_date date NOT NULL,
	gender smallint NOT NULL,
	photo_link varchar(100),
	phone varchar(20) NOT NULL,
	id_clients_profiles bigint,
	id_couhe_profiles bigint,
	CONSTRAINT users_pk PRIMARY KEY (id)

);
-- ddl-end --
COMMENT ON COLUMN public.users.user_name IS E'Уникальное имя юзера (email)';
-- ddl-end --
COMMENT ON COLUMN public.users.photo_link IS E'Ссылка на фото юзера';
-- ddl-end --
-- ALTER TABLE public.users OWNER TO postgres;
-- ddl-end --

-- object: public.inventories | type: TABLE --
-- DROP TABLE IF EXISTS public.inventories CASCADE;
CREATE TABLE public.inventories (
	id smallint NOT NULL,
	description varchar(100),
	id_traininings bigint,
	CONSTRAINT inventory_pk PRIMARY KEY (id)

);
-- ddl-end --
-- ALTER TABLE public.inventories OWNER TO postgres;
-- ddl-end --

-- object: traininings_fk | type: CONSTRAINT --
-- ALTER TABLE public.inventories DROP CONSTRAINT IF EXISTS traininings_fk CASCADE;
ALTER TABLE public.inventories ADD CONSTRAINT traininings_fk FOREIGN KEY (id_traininings)
REFERENCES public.traininings (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: couhe_profiles_fk | type: CONSTRAINT --
-- ALTER TABLE public.traininings DROP CONSTRAINT IF EXISTS couhe_profiles_fk CASCADE;
ALTER TABLE public.traininings ADD CONSTRAINT couhe_profiles_fk FOREIGN KEY (id_couhe_profiles)
REFERENCES public.couhe_profiles (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public.accents | type: TABLE --
-- DROP TABLE IF EXISTS public.accents CASCADE;
CREATE TABLE public.accents (
	id smallserial NOT NULL,
	description varchar(150) NOT NULL,
	id_traininings bigint,
	CONSTRAINT accents_pk PRIMARY KEY (id)

);
-- ddl-end --
-- ALTER TABLE public.accents OWNER TO postgres;
-- ddl-end --

-- object: traininings_fk | type: CONSTRAINT --
-- ALTER TABLE public.accents DROP CONSTRAINT IF EXISTS traininings_fk CASCADE;
ALTER TABLE public.accents ADD CONSTRAINT traininings_fk FOREIGN KEY (id_traininings)
REFERENCES public.traininings (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: clients_profiles_fk | type: CONSTRAINT --
-- ALTER TABLE public.users DROP CONSTRAINT IF EXISTS clients_profiles_fk CASCADE;
ALTER TABLE public.users ADD CONSTRAINT clients_profiles_fk FOREIGN KEY (id_clients_profiles)
REFERENCES public.clients_profiles (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: users_uq | type: CONSTRAINT --
-- ALTER TABLE public.users DROP CONSTRAINT IF EXISTS users_uq CASCADE;
ALTER TABLE public.users ADD CONSTRAINT users_uq UNIQUE (id_clients_profiles);
-- ddl-end --

-- object: couhe_profiles_fk | type: CONSTRAINT --
-- ALTER TABLE public.users DROP CONSTRAINT IF EXISTS couhe_profiles_fk CASCADE;
ALTER TABLE public.users ADD CONSTRAINT couhe_profiles_fk FOREIGN KEY (id_couhe_profiles)
REFERENCES public.couhe_profiles (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: users_uq1 | type: CONSTRAINT --
-- ALTER TABLE public.users DROP CONSTRAINT IF EXISTS users_uq1 CASCADE;
ALTER TABLE public.users ADD CONSTRAINT users_uq1 UNIQUE (id_couhe_profiles);
-- ddl-end --

-- object: subscriptions_fk | type: CONSTRAINT --
-- ALTER TABLE public.traininings DROP CONSTRAINT IF EXISTS subscriptions_fk CASCADE;
ALTER TABLE public.traininings ADD CONSTRAINT subscriptions_fk FOREIGN KEY (id_subscriptions)
REFERENCES public.subscriptions (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: clients_profiles_fk | type: CONSTRAINT --
-- ALTER TABLE public.subscriptions DROP CONSTRAINT IF EXISTS clients_profiles_fk CASCADE;
ALTER TABLE public.subscriptions ADD CONSTRAINT clients_profiles_fk FOREIGN KEY (id_clients_profiles)
REFERENCES public.clients_profiles (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: clients_profiles_fk | type: CONSTRAINT --
-- ALTER TABLE public.traininings DROP CONSTRAINT IF EXISTS clients_profiles_fk CASCADE;
ALTER TABLE public.traininings ADD CONSTRAINT clients_profiles_fk FOREIGN KEY (id_clients_profiles)
REFERENCES public.clients_profiles (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public.sport_types | type: TABLE --
-- DROP TABLE IF EXISTS public.sport_types CASCADE;
CREATE TABLE public.sport_types (
	id smallint NOT NULL,
	description varchar(50) NOT NULL,
	CONSTRAINT sport_types_pk PRIMARY KEY (id)

);
-- ddl-end --
-- ALTER TABLE public.sport_types OWNER TO postgres;
-- ddl-end --

-- object: public.sport_levels | type: TABLE --
-- DROP TABLE IF EXISTS public.sport_levels CASCADE;
CREATE TABLE public.sport_levels (
	id smallint NOT NULL,
	description varchar(50) NOT NULL,
	CONSTRAINT sport_level_pk PRIMARY KEY (id)

);
-- ddl-end --
-- ALTER TABLE public.sport_levels OWNER TO postgres;
-- ddl-end --

-- object: sport_types_fk | type: CONSTRAINT --
-- ALTER TABLE public.traininings DROP CONSTRAINT IF EXISTS sport_types_fk CASCADE;
ALTER TABLE public.traininings ADD CONSTRAINT sport_types_fk FOREIGN KEY (id_sport_types)
REFERENCES public.sport_types (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: sport_levels_fk | type: CONSTRAINT --
-- ALTER TABLE public.traininings DROP CONSTRAINT IF EXISTS sport_levels_fk CASCADE;
ALTER TABLE public.traininings ADD CONSTRAINT sport_levels_fk FOREIGN KEY (id_sport_levels)
REFERENCES public.sport_levels (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public.coach_sport_types | type: TABLE --
-- DROP TABLE IF EXISTS public.coach_sport_types CASCADE;
CREATE TABLE public.coach_sport_types (
	id_couhe_profiles bigint,
	id_sport_types smallint
);
-- ddl-end --
-- ALTER TABLE public.coach_sport_types OWNER TO postgres;
-- ddl-end --

-- object: couhe_profiles_fk | type: CONSTRAINT --
-- ALTER TABLE public.coach_sport_types DROP CONSTRAINT IF EXISTS couhe_profiles_fk CASCADE;
ALTER TABLE public.coach_sport_types ADD CONSTRAINT couhe_profiles_fk FOREIGN KEY (id_couhe_profiles)
REFERENCES public.couhe_profiles (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: sport_types_fk | type: CONSTRAINT --
-- ALTER TABLE public.coach_sport_types DROP CONSTRAINT IF EXISTS sport_types_fk CASCADE;
ALTER TABLE public.coach_sport_types ADD CONSTRAINT sport_types_fk FOREIGN KEY (id_sport_types)
REFERENCES public.sport_types (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public.income_coach_transaction | type: TABLE --
-- DROP TABLE IF EXISTS public.income_coach_transaction CASCADE;
CREATE TABLE public.income_coach_transaction (
	id bigserial NOT NULL,
	date_time timestamptz NOT NULL,
	id_couhe_profiles bigint,
	CONSTRAINT income_coach_transaction_pk PRIMARY KEY (id)

);
-- ddl-end --
-- ALTER TABLE public.income_coach_transaction OWNER TO postgres;
-- ddl-end --

-- object: couhe_profiles_fk | type: CONSTRAINT --
-- ALTER TABLE public.income_coach_transaction DROP CONSTRAINT IF EXISTS couhe_profiles_fk CASCADE;
ALTER TABLE public.income_coach_transaction ADD CONSTRAINT couhe_profiles_fk FOREIGN KEY (id_couhe_profiles)
REFERENCES public.couhe_profiles (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: couhe_profiles_fk | type: CONSTRAINT --
-- ALTER TABLE public.subscriptions DROP CONSTRAINT IF EXISTS couhe_profiles_fk CASCADE;
ALTER TABLE public.subscriptions ADD CONSTRAINT couhe_profiles_fk FOREIGN KEY (id_couhe_profiles)
REFERENCES public.couhe_profiles (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public.outcome_coach_transactions | type: TABLE --
-- DROP TABLE IF EXISTS public.outcome_coach_transactions CASCADE;
CREATE TABLE public.outcome_coach_transactions (
	id bigserial NOT NULL,
	date_time timestamptz NOT NULL,
	account varchar(100),
	id_couhe_profiles bigint,
	CONSTRAINT outcome_coach_transactions_pk PRIMARY KEY (id)

);
-- ddl-end --
-- ALTER TABLE public.outcome_coach_transactions OWNER TO postgres;
-- ddl-end --

-- object: couhe_profiles_fk | type: CONSTRAINT --
-- ALTER TABLE public.outcome_coach_transactions DROP CONSTRAINT IF EXISTS couhe_profiles_fk CASCADE;
ALTER TABLE public.outcome_coach_transactions ADD CONSTRAINT couhe_profiles_fk FOREIGN KEY (id_couhe_profiles)
REFERENCES public.couhe_profiles (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public.reviews | type: TABLE --
-- DROP TABLE IF EXISTS public.reviews CASCADE;
CREATE TABLE public.reviews (
	id integer NOT NULL,
	raiting smallint NOT NULL,
	text varchar(500) NOT NULL,
	id_couhe_profiles bigint,
	id_clients_profiles bigint,
	CONSTRAINT reviews_pk PRIMARY KEY (id)

);
-- ddl-end --
-- ALTER TABLE public.reviews OWNER TO postgres;
-- ddl-end --

-- object: couhe_profiles_fk | type: CONSTRAINT --
-- ALTER TABLE public.reviews DROP CONSTRAINT IF EXISTS couhe_profiles_fk CASCADE;
ALTER TABLE public.reviews ADD CONSTRAINT couhe_profiles_fk FOREIGN KEY (id_couhe_profiles)
REFERENCES public.couhe_profiles (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: clients_profiles_fk | type: CONSTRAINT --
-- ALTER TABLE public.reviews DROP CONSTRAINT IF EXISTS clients_profiles_fk CASCADE;
ALTER TABLE public.reviews ADD CONSTRAINT clients_profiles_fk FOREIGN KEY (id_clients_profiles)
REFERENCES public.clients_profiles (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public.client_transaction | type: TABLE --
-- DROP TABLE IF EXISTS public.client_transaction CASCADE;
CREATE TABLE public.client_transaction (
	id bigserial NOT NULL,
	date_time timestamptz NOT NULL,
	id_clients_profiles bigint,
	id_subscriptions bigint,
	CONSTRAINT client_transaction_pk PRIMARY KEY (id)

);
-- ddl-end --
-- ALTER TABLE public.client_transaction OWNER TO postgres;
-- ddl-end --

-- object: clients_profiles_fk | type: CONSTRAINT --
-- ALTER TABLE public.client_transaction DROP CONSTRAINT IF EXISTS clients_profiles_fk CASCADE;
ALTER TABLE public.client_transaction ADD CONSTRAINT clients_profiles_fk FOREIGN KEY (id_clients_profiles)
REFERENCES public.clients_profiles (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: subscriptions_fk | type: CONSTRAINT --
-- ALTER TABLE public.client_transaction DROP CONSTRAINT IF EXISTS subscriptions_fk CASCADE;
ALTER TABLE public.client_transaction ADD CONSTRAINT subscriptions_fk FOREIGN KEY (id_subscriptions)
REFERENCES public.subscriptions (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --


