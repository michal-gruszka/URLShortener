DO
$do$
DECLARE
   arr char[] := array['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'];
   i char;
   j char;
   k char;
   m char;
BEGIN
DROP TABLE IF EXISTS code_pool;
CREATE TEMP TABLE code_pool_tmp (
	code varchar(4) unique not null
) ON COMMIT DROP;
   FOREACH i IN ARRAY arr
   LOOP
	FOREACH j IN ARRAY arr
	LOOP
		FOREACH k IN ARRAY arr
		LOOP
			FOREACH m IN ARRAY arr
			LOOP
				INSERT INTO code_pool_tmp VALUES (concat(i,j,k,m));
			END LOOP;
		END LOOP;
	END LOOP;
   END LOOP;

CREATE TABLE code_pool AS SELECT * FROM code_pool_tmp ORDER BY RANDOM();
END
$do$