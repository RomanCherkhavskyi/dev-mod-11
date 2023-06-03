package services;

import org.flywaydb.core.Flyway;

public class FlywayMigration {

    public void flywayMigration(){

        Flyway flyway = Flyway
                .configure()
                .baselineOnMigrate(true)
                .dataSource("jdbc:h2:./mydb","","")
                .load();

        flyway.migrate();

    }
}