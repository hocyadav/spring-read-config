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
@Component
@ConfigurationProperties(prefix = "map4")
@Getter
@Setter
@ToString
public class Map4Config {
    Map<String, Details> map;

    @Getter
    @Setter
    @ToString
    private static class Details {
        List<String> logType;
        Integer logFrequency;
        Integer logDurationInSec;
        Integer logWaitTimeInSec;
    }
}
