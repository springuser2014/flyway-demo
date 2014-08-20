CREATE OR REPLACE FUNCTION transport.truthy(b boolean)
  RETURNS boolean AS
$BODY$
    BEGIN
        RETURN b;
    END;
    $BODY$
  LANGUAGE plpgsql VOLATILE;

ALTER FUNCTION transport.truthy(boolean) OWNER TO mark;

-- will fail the migration
--insert into transport.car (rego, ebox_id) values ('abc123', 1);
