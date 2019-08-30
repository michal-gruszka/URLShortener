CREATE OR REPLACE FUNCTION get_code_for(originalUrl text)
RETURNS text AS
$func$
DECLARE
  shortUrl varchar;
BEGIN
SELECT short_url FROM url WHERE original_url = originalUrl INTO shortUrl;
IF shortUrl IS NULL THEN
	SELECT code FROM code_pool INTO shortUrl;
	INSERT INTO url(original_url, short_url) VALUES (originalUrl, shortUrl);
	DELETE FROM code_pool WHERE code = shortUrl;
END IF;
RETURN shortUrl;
END
$func$ LANGUAGE plpgsql;