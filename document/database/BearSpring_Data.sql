-- permission
TRUNCATE TABLE public.permission CASCADE;
INSERT INTO public.permission (code, name, description, category, is_active)
VALUES ('group_add', 'Add Group', 'Adds a new group', 'User Management', TRUE);
INSERT INTO public.permission (code, name, description, category, is_active)
VALUES ('group_read', 'Read  Groups', 'Reads an existing group', 'User Management', TRUE);
INSERT INTO public.permission (code, name, description, category, is_active)
VALUES ('group_update', 'Update Groups', 'Updates an existing group', 'User Management', TRUE);
INSERT INTO public.permission (code, name, description, category, is_active)
VALUES ('group_activate', 'Activate Group', 'Activates - Deactives an existing group', 'User Management', TRUE);
INSERT INTO public.permission (code, name, description, category, is_active)
VALUES ('user_add', 'Add User', 'Add a new user', 'User Management', TRUE);
INSERT INTO public.permission (code, name, description, category, is_active)
VALUES ('user_read', 'Read User', 'Reads an existing user information', 'User Management', TRUE);
INSERT INTO public.permission (code, name, description, category, is_active)
VALUES ('user_update', 'Update User', 'Updates an existing user', 'User Management', TRUE);
INSERT INTO public.permission (code, name, description, category, is_active)
VALUES ('user_activate', 'Activate User', 'Activates - Deactives an existing user', 'User Management', TRUE);

-- group
TRUNCATE TABLE public.group CASCADE;
INSERT INTO public.group (id, name, description, is_active)
VALUES (1, 'Administrator', 'Administrator', TRUE);
INSERT INTO public.group (id, name, description, is_active)
VALUES (2, 'User Management', 'User Management', TRUE);
INSERT INTO public.group (id, name, description, is_active)
VALUES (3, 'Add Group', 'Add Group', TRUE);

-- group_permission
TRUNCATE TABLE public.group_permission CASCADE;
INSERT INTO public.group_permission (group_id, permission_id)
SELECT 1, id
FROM public.permission;

INSERT INTO public.group_permission (group_id, permission_id)
SELECT 2, id
FROM public.permission p
WHERE p.category = 'User Management';

INSERT INTO public.group_permission (group_id, permission_id)
SELECT 3, id
FROM public.permission p
WHERE p.category = 'User Management';

-- configuration
TRUNCATE TABLE public.configuration CASCADE;
INSERT INTO public.configuration (code, value, description, category, is_active)
VALUES ('user.admin.account.name', 'admin', 'user.admin.account.name', 'User Config', TRUE);
INSERT INTO public.configuration (code, value, description, category, is_active)
VALUES ('user.admin.account.hash', '$2a$10$amQjSro4hiuq/Sr/qrnHWOsHH5VhkMZSCHXa02JnXc9umM5HXGOHu', 'user.admin.account.hash', 'User Config', TRUE);
INSERT INTO public.configuration (code, value, description, category, is_active)
VALUES ('user.admin.account.email', 'admin@gmail.com', 'user.admin.account.email', 'User Config', TRUE);
INSERT INTO public.configuration (code, value, description, category, is_active)
VALUES ('user.admin.account.fullName', 'Administrator', 'user.admin.account.fullName', 'User Config', TRUE);
INSERT INTO public.configuration (code, value, description, category, is_active)
VALUES ('user.idle.checking.enabled', 'false', 'user.idle.checking.enabled', 'User Config', TRUE);
INSERT INTO public.configuration (code, value, description, category, is_active)
VALUES ('user.login.attempt', '5', 'user.login.attempt', 'User Config', TRUE);
INSERT INTO public.configuration (code, value, description, category, is_active)
VALUES ('pagination.records.per.page', '20', 'Number of records per page', 'Pagination', TRUE);
INSERT INTO public.configuration (code, value, description, category, is_active)
VALUES ('pagination.pages', '10', 'Number of pages to be generated', 'Pagination', TRUE);
INSERT INTO public.configuration (code, value, description, category, is_active)
VALUES ('file.maximum.upload.size', '50000', 'Maximum upload file size', 'File Config', TRUE);
INSERT INTO public.configuration (code, value, description, category, is_active)
VALUES ('file.storage.path', '/storage/', 'Path of storage files folder', 'File Config', TRUE);

/*
SELECT dd.calendar_date, t.amount
FROM (SELECT DATE_TRUNC('day', dd):: DATE AS calendar_date
      FROM GENERATE_SERIES('2022-06-01'::TIMESTAMP, '2022-06-30'::TIMESTAMP, '1 day'::INTERVAL) dd) dd
         LEFT JOIN public.transaction t ON t.date::date = dd.calendar_date;
*/
