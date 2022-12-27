package com.flaviumircia.pibd_app.configurations;

import com.flaviumircia.pibd_app.misc.FileReader;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;

@Configuration
public class ApplicationConfig {
@Bean("app_config")
    public DataSource getDataSource() throws IOException {
        FileReader fileReader=new FileReader();
        HashMap<String,String> map=fileReader.readFromFile();
        DataSourceBuilder<?> dataSourceBuilder= DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/pibd_database");
        dataSourceBuilder.username(map.get("user"));
        dataSourceBuilder.password(map.get("password"));
        return dataSourceBuilder.build();
}
}
