package com.example.springreadconfig;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author HariomYadav
 * @since 24/01/21
 */
@Getter
@Setter
@Component
@ConfigurationProperties("map1")

@AllArgsConstructor
@NoArgsConstructor

public class ConfigMap {
    Map<String, String> map1 = new HashMap<>();
}
