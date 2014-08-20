package nz.co.eroad;


import com.google.inject.Guice;
import com.google.inject.Injector;
import nz.co.eroad.database.DatabaseModule;
import nz.co.eroad.demo.Demo;
import nz.co.eroad.demo.DemoModule;
import nz.co.eroad.flyway.FlywayConfigurer;
import nz.co.eroad.flyway.FlywayModule;
import org.flywaydb.core.Flyway;

import javax.sql.DataSource;

public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DatabaseModule(), new DemoModule(), new FlywayModule());

        Flyway flyway = injector.getInstance(FlywayConfigurer.class).getFlyway();
        flyway.migrate();

        Demo demo = injector.getInstance(Demo.class);
        demo.read();
    }
}
