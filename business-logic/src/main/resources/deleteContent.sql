SELECT * FROM pg_stat_activity WHERE state = 'active';
SELECT pg_terminate_backend(7920)