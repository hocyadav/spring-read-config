package com.example.springreadconfig;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

/**
 * @author HariomYadav
 * @since 24/01/21
 */
@Configuration
@ConfigurationProperties (prefix = "map5")
//ConfigurationProperties = binding for the properties defined in application.properties or application.yml files.
@Getter
@Setter
@ToString
@Validated
public class Map5Config {
    Map<String, Details> allUsers;

    @Getter
    @Setter
    @ToString
    public static class Details {
        List<String> logType;

//        @Min (10)
//        @NotNull
        @Value(10)
        Integer logFrequency;

        Integer logDurationInSec;

        Integer logWaitTimeInSec;
    }

    //extra helper method to get user config else it will return default entries
    public Map5Config.Details getDetails(final String user) {
        return Optional.ofNullable(this.getAllUsers().get(user)).orElse(this.allUsers.get("default"));
    }
}
