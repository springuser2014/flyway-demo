package nz.co.eroad.database;


import javax.inject.Singleton;
import javax.sql.DataSource;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.jolbox.bonecp.BoneCPDataSource;

public class DatabaseModule extends AbstractModule {

    public DatabaseModule() {
    }

    @Override
    protected void configure() {

    }

    @Provides
    @Singleton
    protected DataSource dataSource() {
        loadDriver();
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/flyway");
        dataSource.setUsername("mark");
        dataSource.setPassword("mark");
        return dataSource;
    }

    private void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load PostgreSQL JDBC Driver", e);
        }
    }
}
