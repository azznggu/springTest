create table movie_info(
 	movie_no number primary key,
	movie_title varchar2(100) not null,
	movie_director varchar2(100) not null,
    movie_actor varchar2(100) not null,
    movie_genre varchar2(100) not null,
    originalfile varchar2(200),
    savedfile varchar2(300)
);