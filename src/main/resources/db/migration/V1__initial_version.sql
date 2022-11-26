
CREATE TABLE public.courses (
    id bigint NOT NULL,
    name character varying(255),
    group_id bigint,
    tutor_id bigint
);


ALTER TABLE public.courses OWNER TO postgres;

CREATE TABLE public.day_of_week (
    id bigint NOT NULL,
    date timestamp without time zone,
    timetable_id bigint
);


ALTER TABLE public.day_of_week OWNER TO postgres;

CREATE TABLE public.groups (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.groups OWNER TO postgres;


CREATE TABLE public.lessons (
    id bigint NOT NULL,
    hours integer NOT NULL,
    location character varying(255),
    start timestamp without time zone,
    course_id bigint,
    day_of_week_id bigint,
    group_id bigint,
    tutor_id bigint
);


ALTER TABLE public.lessons OWNER TO postgres;

CREATE TABLE public.students (
    id bigint NOT NULL,
    name character varying(255),
    group_id bigint
);


ALTER TABLE public.students OWNER TO postgres;

CREATE TABLE public.timetable (
    id bigint NOT NULL,
    valid_from timestamp without time zone,
    valid_till timestamp without time zone
);


ALTER TABLE public.timetable OWNER TO postgres;

CREATE TABLE public.topics (
    id bigint NOT NULL,
    name character varying(255),
    subject character varying(255),
    course_id bigint
);


ALTER TABLE public.topics OWNER TO postgres;

CREATE TABLE public.tutors (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.tutors OWNER TO postgres;

ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.day_of_week
    ADD CONSTRAINT day_of_week_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.groups
    ADD CONSTRAINT groups_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT lessons_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.students
    ADD CONSTRAINT students_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.timetable
    ADD CONSTRAINT timetable_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.topics
    ADD CONSTRAINT topics_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.tutors
    ADD CONSTRAINT tutors_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT fk17ucc7gjfjddsyi0gvstkqeat FOREIGN KEY (course_id) REFERENCES public.courses(id);

ALTER TABLE ONLY public.courses
    ADD CONSTRAINT fk4jhfry3sn5bd3kimxu8e624kb FOREIGN KEY (tutor_id) REFERENCES public.tutors(id);

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT fk7mpviu6k2whwrnip1wn018da4 FOREIGN KEY (tutor_id) REFERENCES public.tutors(id);

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT fkckev3q6mdiwswdeh8gtgxdmx4 FOREIGN KEY (day_of_week_id) REFERENCES public.day_of_week(id);

ALTER TABLE ONLY public.topics
    ADD CONSTRAINT fkhn8u5k2hlwgftn6xkk7i2vh1o FOREIGN KEY (course_id) REFERENCES public.courses(id);

ALTER TABLE ONLY public.students
    ADD CONSTRAINT fkmsev1nou0j86spuk5jrv19mss FOREIGN KEY (group_id) REFERENCES public.groups(id);

ALTER TABLE ONLY public.day_of_week
    ADD CONSTRAINT fkp2cq4w2b4xs003ea8b4cu6kng FOREIGN KEY (timetable_id) REFERENCES public.timetable(id);

ALTER TABLE ONLY public.courses
    ADD CONSTRAINT fkqeed8jx354sfrloky6s2iu6wa FOREIGN KEY (group_id) REFERENCES public.groups(id);

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT fktdolsaotaqlwxbxwaxt00kimk FOREIGN KEY (group_id) REFERENCES public.groups(id);
