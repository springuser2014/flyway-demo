package nz.co.eroad.flyway;

import com.google.inject.Inject;
import org.flywaydb.core.Flyway;

import javax.sql.DataSource;

public class FlywayConfigurer {

    private final DataSource dataSource;
    private final Flyway flyway;

    @Inject
    public FlywayConfigurer(DataSource dataSource) {
        this.dataSource = dataSource;
        this.flyway = new Flyway();

        init();
    }

    private void init() {
        this.flyway.setDataSource(this.dataSource);
        this.flyway.setSchemas("transport", "management");
        this.flyway.setInitVersion("1");
        this.flyway.setInitOnMigrate(true);
    }

    public Flyway getFlyway() {
        return this.flyway;
    }
}
