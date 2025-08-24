package com.apartment.maintenance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(properties = {
    // Force an in-memory DB so tests never touch Neon/Render
    "spring.datasource.url=jdbc:h2:mem:testdb;MODE=PostgreSQL;DB_CLOSE_DELAY=-1;DATABASE_TO_LOWER=TRUE;DEFAULT_NULL_ORDERING=HIGH",
    "spring.datasource.driver-class-name=org.h2.Driver",
    "spring.datasource.username=sa",
    "spring.datasource.password=",

    // Let Hibernate create/drop tables for the test
    "spring.jpa.hibernate.ddl-auto=create-drop",
    "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect",

    // Keep migrations out of the way (remove later if you want to test them)
    "spring.flyway.enabled=false",
    "spring.liquibase.enabled=false"
})
@ActiveProfiles("test") // harmless now; useful later if you add application-test.*
class BackendApplicationTests {

    @Test
    void contextLoads() {}
}
