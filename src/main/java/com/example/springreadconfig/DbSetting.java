package com.example.springreadconfig;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author HariomYadav
 * @since 24/01/21
 */
@Component//creating bean - and store all config value in bean and in other class get via autowire
@ConfigurationProperties("db")//read all value db.(app properties file) or db:(yml file)
@Getter
@Setter
@NoArgsConstructor
@ToString
public class DbSetting {
    private String connection;
    private String host;
    private int port;
}
