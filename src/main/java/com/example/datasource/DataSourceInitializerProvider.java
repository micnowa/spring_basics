package com.example.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceInitializerProvider {
    private final DataSource dataSource;

    @Autowired
    public DataSourceInitializerProvider(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {
        executeSqlScript("schema.sql");
        executeSqlScript("data.sql");
    }

    private void executeSqlScript(String scriptName) {
        var resourceDatabasePopulator = new ResourceDatabasePopulator(false,
                false,
                "UTF-8",
                new ClassPathResource(scriptName));
        resourceDatabasePopulator.execute(dataSource);
    }

}
