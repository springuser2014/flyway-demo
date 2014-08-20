package nz.co.eroad.demo;

import com.google.inject.AbstractModule;

public final class DemoModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Demo.class);
    }
}
