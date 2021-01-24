package com.example.springreadconfig;

import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author HariomYadav
 * @since 24/01/21
 */
@Component
@ConfigurationProperties(prefix = "hariom")
@Getter
@Setter
@NoArgsConstructor
public class MySetting {
    private String address;
    private int pin;
    private List<String> collegeList;
    private Map<String, String> collegeMap;//config name can be collegemap
}
