package com.example;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;

@QuarkusMain
public class ListConfigOverride {

    public static void main(String[] args) {
        Quarkus.run(SampleDemoApplication.class, args);
    }

    static class SampleDemoApplication implements QuarkusApplication {

        @ConfigProperty(name = "countries")
        List<String> countries;

        @Override
        public int run(String... args) {
            System.out.println("countries: " + countries);
            return 0;
        }
    }
}