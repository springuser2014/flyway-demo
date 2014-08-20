package nz.co.eroad.flyway;

import com.google.inject.AbstractModule;

public class FlywayModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(FlywayConfigurer.class);
    }
}
