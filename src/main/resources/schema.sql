create table rss_feeds (
	id serial4 primary key,
	url varchar(255) not null,
	title varchar(50) not null,
	last_updated timestamp default current_timestamp not null
);

create table rss_items (
    id serial4 primary key,
    rss_feed_id int not null,
    guid varchar(255) null,
    description varchar not null,
    link varchar not null,
    title varchar not null,
    created_time timestamp not null
)
