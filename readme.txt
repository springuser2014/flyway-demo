############
## Maven plugin
############

- properties in pom
- flyway reads from target, make sure compile phase has been run
- configuration can be pushed into pom
- typical commands:

mvn compile flyway:info
                  :clean
                  :validate
                  :migrate

- initialising an existing database
mvn flyway:init -Dflyway.initVersion=1 -Dflyway.initDescription="Base version"
mvn flyway:migrate

###########
## API
###########
- programatically configured through properties
- migration run as part of app startup

###########
## CLI
###########

Download
http://repo1.maven.org/maven2/org/flywaydb/flyway-commandline/3.0/flyway-commandline-3.0.tar.gz

Docs
http://flywaydb.org/documentation/commandline/

Run Migrations
flyway migrate -driver=org.postgresql.Driver -url=jdbc:postgresql://localhost:5432/flyway -user=mark -password=mark -schemas=transport,management -initOnMigrate=true -initVersion=1 -locations=filesystem:/home/mark/Workspace/eroad/flyway-demo/src/main/resources/db/migration/
