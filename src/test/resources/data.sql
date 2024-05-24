insert into rss_feeds (id, url, title) values (1, 'https://example.com/feed1', 'Feed1');
insert into rss_feeds (id, url, title) values (2, 'https://example.com/feed2', 'Feed2');
insert into rss_items (id, rss_feed_id, guid, description, link, title, created_time)
values(1, 1, '1', 'test11 description', 'http://example.com', 'Test title11', '2024-01-01T00:00:00');
insert into rss_items (id, rss_feed_id, guid, description, link, title, created_time)
values(2, 1, '1', 'test12 description', 'http://example.com', 'Test title12', '2024-01-01T00:00:01');
insert into rss_items (id, rss_feed_id, guid, description, link, title, created_time)
values(3, 2, '1', 'test21 description', 'http://example.com', 'Test title21', '2024-01-01T00:00:02');
insert into rss_items (id, rss_feed_id, guid, description, link, title, created_time)
values(4, 2, '1', 'test22 description', 'http://example.com', 'Test title22', '2024-01-01T00:00:03');