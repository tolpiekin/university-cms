CREATE TABLE users (
    id          bigserial,
    username    varchar(30) NOT NULL,
    password    varchar(80),
    email       varchar(50) UNIQUE,
    primary key(id)
);

CREATE TABLE roles (
    id          bigserial,
    name        varchar(50) NOT NULL,
    primary key (id)
);

CREATE TABLE users_roles (
    user_id     bigint NOT NULL,
    role_id     bigint NOT NULL,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

CREATE TABLE groups (
    id bigserial,
    name varchar(255),
    primary key (id)
);

CREATE TABLE tutors (
    id bigserial,
    name varchar(255),
    user_id bigint,
    primary key (id),
    foreign key (user_id) references users (id)
);

CREATE TABLE courses (
    id bigserial,
    name character varying(255),
    group_id bigint,
    tutor_id bigint,
    primary key (id),
    foreign key (group_id) references groups (id),
    foreign key (tutor_id) references tutors (id)
);

CREATE TABLE students (
    id bigserial,
    name character varying(255),
    group_id bigint,
    user_id bigint,
    primary key (id),
    foreign key (group_id) references groups (id),
    foreign key (user_id) references users (id)
);

CREATE TABLE topics (
    id bigserial,
    name character varying(255),
    subject character varying(255),
    course_id bigint,
    primary key (id),
    foreign key (course_id) references courses (id)
);

CREATE TABLE timetable (
    id bigint NOT NULL,
    valid_from timestamp without time zone,
    valid_till timestamp without time zone,
    primary key (id)
);

CREATE TABLE day_of_week (
    id bigserial,
    date timestamp without time zone,
    timetable_id bigint,
    primary key (id),
    foreign key (timetable_id) references timetable (id)
);

CREATE TABLE lessons (
    id bigserial,
    hours integer NOT NULL,
    location character varying(255),
    start timestamp without time zone,
    course_id bigint,
    day_of_week_id bigint,
    group_id bigint,
    tutor_id bigint,
    primary key (id),
    foreign key (course_id) references courses (id),
    foreign key (day_of_week_id) references day_of_week (id),
    foreign key (group_id) references groups (id),
    foreign key (tutor_id) references tutors (id)
);