CREATE OR REPLACE FUNCTION get_code_for(provided_url text)
RETURNS text AS
$func$
DECLARE
  code_var varchar;
BEGIN
SELECT code FROM url WHERE original_url = provided_url INTO code_var;
IF code_var IS NULL THEN
	SELECT code FROM code_pool INTO code_var;
	INSERT INTO url(original_url, code) VALUES (provided_url, code_var);
	DELETE FROM code_pool WHERE code = code_var;
END IF;
RETURN code_var;
END
$func$ LANGUAGE plpgsql;