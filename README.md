# quarkus-bug-config-list

Sample app to demonstrate a bug in Quarkus 3.17.2 when overriding list config properties. This demo contains 
an `application.yaml` file with the following config: 

```yaml
countries:
  - de
```

Running the application only prints the value of this `countries` config.

According to the Quarkus documentation, config properties can be overwritten via system properties, such as:

```shell
mvn compile quarkus:dev -Dcountries=nl
```

This does not work in Quarkus 3.17.2, you can see the value printed is the default in the `application.yaml`: 

```
2024-12-03 11:01:11,937 INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [cdi, config-yaml]
countries: [de]
```

However, this used to work in Quarkus 3.16. To test, switch to the branch `quarkus3.16` and run the command again:

```shell
git checkout quarkus3.16
mvn compile quarkus:dev -Dcountries=nl
```

you can now see the correct value in the console: 
```
2024-12-03 11:03:18,675 INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [cdi, config-yaml]
countries: [nl]
```

## Notes

This only seems to happen with config properties specified as a yaml list. String and boolean properties can be 
overridden as expected.