--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: absence; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.absence (
    absence_id character varying(10) NOT NULL,
    absence_date date,
    is_valid boolean,
    student_id character varying(8),
    course_id character varying(10)
);


ALTER TABLE public.absence OWNER TO postgres;

--
-- Name: course_unit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_unit (
    course_id character varying(10) NOT NULL,
    teacher_id character varying(8)
);


ALTER TABLE public.course_unit OWNER TO postgres;

--
-- Name: processus_cor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.processus_cor (
    processus_id character varying(10) NOT NULL,
    commentary text,
    beginning_date date,
    ending_date date,
    step character varying(11),
    student_id character varying(8),
    CONSTRAINT processus_cor_step_check CHECK (((step)::text = ANY ((ARRAY['CONVOCATION'::character varying, 'OBSERVATION'::character varying, 'EXPELL'::character varying, 'CLOSED'::character varying])::text[])))
);


ALTER TABLE public.processus_cor OWNER TO postgres;

--
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
    first_name character varying(50),
    last_name character varying(50),
    student_id character varying(8) NOT NULL,
    "group" character varying(2),
    status character varying(8),
    CONSTRAINT student_group_check CHECK ((("group")::text = ANY ((ARRAY['H1'::character varying, 'H2'::character varying, 'G1'::character varying, 'G2'::character varying, 'J1'::character varying, 'J2'::character varying])::text[]))),
    CONSTRAINT student_status_check CHECK (((status)::text = ANY ((ARRAY['ACTIVE'::character varying, 'INACTIVE'::character varying])::text[])))
);


ALTER TABLE public.student OWNER TO postgres;

--
-- Name: teacher; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.teacher (
    first_name character varying(50),
    last_name character varying(50),
    teacher_id character varying(8) NOT NULL
);


ALTER TABLE public.teacher OWNER TO postgres;

--
-- Data for Name: absence; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.absence (absence_id, absence_date, is_valid, student_id, course_id) FROM stdin;
\.


--
-- Data for Name: course_unit; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_unit (course_id, teacher_id) FROM stdin;
\.


--
-- Data for Name: processus_cor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.processus_cor (processus_id, commentary, beginning_date, ending_date, step, student_id) FROM stdin;
\.


--
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.student (first_name, last_name, student_id, "group", status) FROM stdin;
\.


--
-- Data for Name: teacher; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.teacher (first_name, last_name, teacher_id) FROM stdin;
\.


--
-- Name: absence absence_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.absence
    ADD CONSTRAINT absence_pkey PRIMARY KEY (absence_id);


--
-- Name: course_unit pk_course; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_unit
    ADD CONSTRAINT pk_course PRIMARY KEY (course_id);


--
-- Name: processus_cor processus_cor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.processus_cor
    ADD CONSTRAINT processus_cor_pkey PRIMARY KEY (processus_id);


--
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (student_id);


--
-- Name: teacher teacher_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teacher
    ADD CONSTRAINT teacher_pkey PRIMARY KEY (teacher_id);


--
-- Name: absence fk_course; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.absence
    ADD CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES public.course_unit(course_id);


--
-- Name: absence fk_student; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.absence
    ADD CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES public.student(student_id);


--
-- Name: processus_cor fk_student; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.processus_cor
    ADD CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES public.student(student_id);


--
-- Name: course_unit fk_teacher; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_unit
    ADD CONSTRAINT fk_teacher FOREIGN KEY (teacher_id) REFERENCES public.teacher(teacher_id);


--
-- PostgreSQL database dump complete
--

