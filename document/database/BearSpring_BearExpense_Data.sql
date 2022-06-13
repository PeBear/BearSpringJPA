TRUNCATE TABLE "bear_expense".category CASCADE;
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Food', 1, 1, 'EXPENSE');
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Personal', 1, 1, 'EXPENSE');
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Clothes', 1, 1, 'EXPENSE');
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Housewares', 1, 1, 'EXPENSE');
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Medical', 1, 1, 'EXPENSE');
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Education', 1, 1, 'EXPENSE');
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Transportation', 1, 1, 'EXPENSE');
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Contact fee', 1, 1, 'EXPENSE');
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Exchange', 1, 1, 'EXPENSE');
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Cosmetic', 1, 1, 'EXPENSE');
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Holiday', 1, 1, 'EXPENSE');
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Cash', 1, 1, 'INCOME');
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Salary', 1, 1, 'INCOME');
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Investment', 1, 1, 'INCOME');
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Extra', 1, 1, 'INCOME');
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Side job', 1, 1, 'INCOME');
INSERT INTO "bear_expense".category (name, color, icon, type)
VALUES ('Bonus', 1, 1, 'INCOME');

-- common - currency
TRUNCATE TABLE "bear_expense".common CASCADE;
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('CURRENCY', 'VND', 'vnd', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('CURRENCY', 'USD', 'usd', TRUE);

-- common - language
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('LANGUAGE', 'ENG', 'eng', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('LANGUAGE', 'VN', 'vn', TRUE);

-- common - icon
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'DEFAULT', 'default', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'HOME', 'home', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'CASH', 'cash', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'BANK', 'bank', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'DEFAULT', 'default', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'HOME', 'home', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'CASH', 'cash', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'BANK', 'bank', TRUE);

-- common - color
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'BLACK', 'black', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'WHITE', 'white', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'PINK', 'pink', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'RED', 'red', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'YELLOW', 'yellow', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'GREEN', 'green', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'BLUE', 'blue', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'GREY', 'grey', TRUE);

-- common - icon
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'DEFAULT', 'default', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'HOME', 'bi bi-building', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'CASH', 'bi bi-card-checklist', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'BANK', 'bi bi-cart-dash', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'DEFAULT', 'bi bi-emoji-sunglasses', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'HOME', 'bi bi-heart-pulse', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'CASH', 'bi bi-headphones', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'BANK', 'bi bi-incognito', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'DEFAULT', 'bi bi-hypnotize', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'HOME', 'bi bi-joystick', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'CASH', 'bi bi-lightning', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'BANK', 'bi bi-watch', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'DEFAULT', 'bi bi-basket', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'HOME', 'bi bi-bank', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'CASH', 'bi bi-bicycle', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'BANK', 'bi bi-balloon', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'CASH', 'bi bi-camera', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'BANK', 'bi bi-camera-reels', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'DEFAULT', 'bi bi-cloud-drizzle', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'HOME', 'bi bi-clock', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'CASH', 'bi bi-coin', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'BANK', 'bi bi-currency-exchange', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'DEFAULT', 'bi bi-currency-dollar', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'HOME', 'bi bi-display', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'CASH', 'bi bi-emoji-laughing', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'BANK', 'bi bi-chat-dots', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'DEFAULT', 'bi bi-clipboard-data', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'HOME', 'bi bi-bi-gift', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'CASH', 'bi bi-heart', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'BANK', 'bi bi-house', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'HOME', 'bi bi-piggy-bank', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'CASH', 'bi bi-palette', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'BANK', 'bi bi-nintendo-switch', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('ICON', 'BANK', 'bi bi-music-note-beamed', TRUE);

-- common - color
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Red', '#C13346', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Red', '#E9C3BB', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Blue', '#B8E1FF,', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Blue', '#011F82', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Blue', '#CED1E6', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Pink', '#FEA6B6', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Pink', '#FFDCE3', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Purple', '#838BED', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Purple', '#3B3DA1', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Purple', '#1A1A74', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Peach', '#FBB579', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Peach', '#EEDCCE', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Green', '#619196', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Green', '#ADDDCE', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Green', '#70AE98', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Green', '#078C03', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Yellow', '#D9A404', TRUE);
INSERT INTO "bear_expense".common (code, "key", "value", is_active)
VALUES ('COLOR', 'Yellow', '#D9B959', TRUE);
