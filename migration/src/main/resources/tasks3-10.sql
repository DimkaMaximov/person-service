
----- #3 Запрос, выводящий общие записи из 2 таблиц
SELECT * FROM contact
    INNER JOIN person_data ON contact.id = person_data.contact_id
ORDER BY contact.id;


----- #4 Запрос, удаляющий повторяющиеся (без учета id) строки из таблицы
--проверка наличия дубликатов
--SELECT * FROM illness WHERE id NOT IN (SELECT max(id) FROM illness GROUP BY medical_card_id);

DELETE FROM illness
WHERE id NOT IN (SELECT max(id) FROM illness GROUP BY medical_card_id);

--SELECT * FROM illness;


----- #5 Запрос, выводящий первые 50% записей из таблицы (первые значит те где наименьший id)
DROP INDEX IF EXISTS address_id_idx;
CREATE INDEX IF NOT EXISTS address_id_idx ON address (id);

SELECT * FROM address
ORDER BY id
LIMIT ((SELECT count(id) FROM address) / 2);


----- #6 Запрос, выводящий список ФЛ c их родителями, у которых мед.статус отсутствует
SELECT * FROM person_data
    INNER JOIN medical_card ON person_data.medical_card_id = medical_card.id
WHERE medical_card.med_status IS NULL
ORDER BY person_data.id;


----- #7 Представление из нескольких таблиц
DROP VIEW IF EXISTS person_info;

CREATE VIEW person_info AS
SELECT contact.id, last_name, first_name, phone_number, email, country_id, city
FROM contact
    JOIN address ON contact.id = address.contact_id
    JOIN person_data ON contact.id = person_data.contact_id;

SELECT * FROM person_info;


----- #8 Хранимая процедура для извлечения данных из таблицы
DROP FUNCTION IF EXISTS get_contact(integer);
CREATE FUNCTION get_contact(integer) RETURNS SETOF contact
AS $$
SELECT * FROM contact WHERE id = $1;
$$ LANGUAGE SQL;

--SELECT * FROM get_contact((random()*100)::int) AS contact;


----- #9 Хранимая процедура, для модификации таблицы
DROP PROCEDURE IF EXISTS save_contact(varchar(32), varchar(128), text);
CREATE OR REPLACE PROCEDURE save_contact(phone_number varchar(32), email varchar(128), profile_link text)
AS $$
INSERT INTO contact
VALUES (nextval('contact_seq'), phone_number, email, profile_link);
$$ LANGUAGE SQL;

-- CALL save_contact(random()::text, random()::text, random()::text);
-- SELECT * FROM contact WHERE id = (SELECT MAX(id) FROM contact );


----- #10 Триггер, реагирующий на добавление данных
CREATE OR REPLACE FUNCTION add_new_illness() RETURNS TRIGGER
AS $$
BEGIN
    INSERT INTO illness (id, medical_card_id, appearance_dttm)
    VALUES (nextval('illness_seq'), NEW.id,  now());
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER tr_new_illness AFTER INSERT ON medical_card
FOR EACH ROW EXECUTE PROCEDURE add_new_illness();

-- INSERT INTO medical_card (registry_dt) VALUES (now());
-- SELECT * FROM illness WHERE id = (SELECT MAX(id) FROM illness );