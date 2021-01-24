package com.example.springreadconfig;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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
@ConfigurationProperties (prefix = "map5")
@Getter
@Setter
@ToString
public class Map5Config {
    Map<String, Details> allUsers;

    @Getter
    @Setter
    @ToString
    public static class Details {
        List<String> logType;

        Integer logFrequency;

        Integer logDurationInSec;

        Integer logWaitTimeInSec;
    }

    //extra helper method to get user config else it will return default entries
    public Map5Config.Details getDetails(final String user) {
        return Optional.ofNullable(this.getAllUsers().get(user)).orElse(this.allUsers.get("default"));
    }
}
