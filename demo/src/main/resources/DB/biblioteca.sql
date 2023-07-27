--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

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
-- Name: autori; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.autori (
    id_autore integer NOT NULL,
    nome character varying(40),
    cognome character varying(40),
    data_nascita date
);


ALTER TABLE public.autori OWNER TO postgres;

--
-- Name: autori_id_autore_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.autori_id_autore_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.autori_id_autore_seq OWNER TO postgres;

--
-- Name: autori_id_autore_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.autori_id_autore_seq OWNED BY public.autori.id_autore;


--
-- Name: libri; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libri (
    id_libro integer NOT NULL,
    titolo character varying(100),
    categoria character varying(40),
    data_pubblicazione date
);


ALTER TABLE public.libri OWNER TO postgres;

--
-- Name: libri_autori; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libri_autori (
    id_autore integer NOT NULL,
    id_libro integer NOT NULL
);


ALTER TABLE public.libri_autori OWNER TO postgres;

--
-- Name: libri_id_libro_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.libri_id_libro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.libri_id_libro_seq OWNER TO postgres;

--
-- Name: libri_id_libro_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.libri_id_libro_seq OWNED BY public.libri.id_libro;


--
-- Name: prestiti; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.prestiti (
    id_utente integer NOT NULL,
    id_libro integer NOT NULL,
    timestamp_prestito_inizio timestamp without time zone NOT NULL,
    timestamp_prestito_fine timestamp without time zone
);


ALTER TABLE public.prestiti OWNER TO postgres;

--
-- Name: utenti; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utenti (
    id_utente integer NOT NULL,
    nome character varying(40),
    cognome character varying(40),
    data_nascita date,
    numero_telefono integer
);


ALTER TABLE public.utenti OWNER TO postgres;

--
-- Name: utenti_id_utente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.utenti_id_utente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.utenti_id_utente_seq OWNER TO postgres;

--
-- Name: utenti_id_utente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.utenti_id_utente_seq OWNED BY public.utenti.id_utente;


--
-- Name: autori id_autore; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autori ALTER COLUMN id_autore SET DEFAULT nextval('public.autori_id_autore_seq'::regclass);


--
-- Name: libri id_libro; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libri ALTER COLUMN id_libro SET DEFAULT nextval('public.libri_id_libro_seq'::regclass);


--
-- Name: utenti id_utente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utenti ALTER COLUMN id_utente SET DEFAULT nextval('public.utenti_id_utente_seq'::regclass);


--
-- Data for Name: autori; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.autori (id_autore, nome, cognome, data_nascita) FROM stdin;
\.


--
-- Data for Name: libri; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.libri (id_libro, titolo, categoria, data_pubblicazione) FROM stdin;
1	Divina Commedia	Poema allegorico-didascalico	1304-03-10
\.


--
-- Data for Name: libri_autori; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.libri_autori (id_autore, id_libro) FROM stdin;
\.


--
-- Data for Name: prestiti; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.prestiti (id_utente, id_libro, timestamp_prestito_inizio, timestamp_prestito_fine) FROM stdin;
1	1	2022-01-01 00:00:00	\N
1	1	2022-01-02 00:00:00	\N
1	1	2022-01-03 00:00:00	\N
1	1	2022-01-05 00:00:00	\N
1	1	2022-05-01 00:00:00	\N
1	1	2021-05-01 00:00:00	\N
1	1	2020-05-01 00:00:00	\N
1	1	2021-02-01 00:00:00	\N
1	1	1999-01-01 00:00:00	\N
1	1	2000-01-01 00:00:00	\N
\.


--
-- Data for Name: utenti; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.utenti (id_utente, nome, cognome, data_nascita, numero_telefono) FROM stdin;
1	Luca	Galiero	1995-01-10	333444555
\.


--
-- Name: autori_id_autore_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.autori_id_autore_seq', 1, false);


--
-- Name: libri_id_libro_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.libri_id_libro_seq', 1, true);


--
-- Name: utenti_id_utente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.utenti_id_utente_seq', 1, true);


--
-- Name: autori autori_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autori
    ADD CONSTRAINT autori_pkey PRIMARY KEY (id_autore);


--
-- Name: libri_autori libri_autori_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libri_autori
    ADD CONSTRAINT libri_autori_pkey PRIMARY KEY (id_autore, id_libro);


--
-- Name: libri libri_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libri
    ADD CONSTRAINT libri_pkey PRIMARY KEY (id_libro);


--
-- Name: prestiti prestiti_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prestiti
    ADD CONSTRAINT prestiti_pkey PRIMARY KEY (id_utente, id_libro, timestamp_prestito_inizio);


--
-- Name: utenti utenti_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utenti
    ADD CONSTRAINT utenti_pkey PRIMARY KEY (id_utente);


--
-- Name: libri_autori libri_autori_id_autore_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libri_autori
    ADD CONSTRAINT libri_autori_id_autore_fkey FOREIGN KEY (id_autore) REFERENCES public.autori(id_autore);


--
-- Name: libri_autori libri_autori_id_libro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libri_autori
    ADD CONSTRAINT libri_autori_id_libro_fkey FOREIGN KEY (id_libro) REFERENCES public.libri(id_libro);


--
-- Name: prestiti prestiti_id_libro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prestiti
    ADD CONSTRAINT prestiti_id_libro_fkey FOREIGN KEY (id_libro) REFERENCES public.libri(id_libro);


--
-- Name: prestiti prestiti_id_utente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prestiti
    ADD CONSTRAINT prestiti_id_utente_fkey FOREIGN KEY (id_utente) REFERENCES public.utenti(id_utente);


--
-- PostgreSQL database dump complete
--

