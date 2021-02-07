package com.example.springreadconfig;

import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author HariomYadav
 * @since 24/01/21
 */
@Component //or @Configuration
@ConfigurationProperties (prefix = "ymlkey1")//1. root as key : parent field name
@Getter
@Setter
public class YmlConfig {
    Map<String, String> application;//child key name 1
    Map<String, List<String>> config;//child key name2
    Map<String, ClassA> users;//child key name3
    Map<String, Details> all_users_config;//child key name4.. so total 4 entries in above "ymlkey1"

    @Getter
    @Setter
    public static class ClassA {//static class : imp
        String username;
        String password;
    }

    @Getter
    @Setter
    @ToString
    private static class Details {
        List<LogType> logType;
        Integer logFrequency;
        Integer logDurationInSec;
        Integer logWaitTimeInSec;
    }
}