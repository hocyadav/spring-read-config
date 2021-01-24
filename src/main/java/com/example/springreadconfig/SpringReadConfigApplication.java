package com.example.springreadconfig;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringReadConfigApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringReadConfigApplication.class, args);
    }

    @Autowired
    private DbSetting dbSetting;//read as multiple value from bean

    @Value (value = "${server.port}")//read single value
    private String port;

    @Autowired
    private MySetting mySetting;

    @Autowired
    private MySettingAdvance mySettingAdvance;

    @Autowired
    private ConfigMap configMap;

    @Autowired
    private YmlConfig ymlConfig;

    @Autowired
    private Map4Config map4Config;//not working

    @Autowired
    private Map5Config map5Config;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("dbSetting = " + dbSetting.getConnection());
        System.out.println("dbSetting = " + dbSetting.getHost());
        System.out.println("dbSetting = " + dbSetting.getPort());
        System.out.println("port = " + port);

        System.out.println("mySetting = " + mySetting.getAddress());
        System.out.println("mySetting = " + mySetting.getCollegeList());
        System.out.println("mySetting = " + mySetting.getCollegeMap());
        System.out.println("vit = " + Optional.ofNullable(mySetting.getCollegeMap().get("vit")).orElse("NA"));
        System.out.println("mySetting = " + mySetting.getPin());

        System.out.println("mySettingAdvance = " + mySettingAdvance.getUsername());
        System.out.println("configMap = " + configMap.getMap1());

        System.out.println("ymlConfig = " + ymlConfig);

        System.out.println("map4Config = " + map4Config.getMap());//not working: solution make it 3 level

        //awesome
        System.out.println("map5Config = " + map5Config.getAllUsers());//working its 3 level config
        System.out.println("map5Config = " + map5Config.getAllUsers().get("default"));//working its 3 level config
        System.out.println("map5Config = " + map5Config.getAllUsers().get("user1"));//working its 3 level config
        System.out.println("map5Config = " + Optional.ofNullable(map5Config.getAllUsers().get("user2"))
                                                     .orElseGet(() -> map5Config.getAllUsers().get("default")));//working its 3 level config

        final Map5Config.Details aDefault = map5Config.getDetails("user2");
        System.out.println("map5Config = " + aDefault);//working its 3 level config
    }

//    private Map5Config.Details getDetails(final String user2) {
//        return Optional.ofNullable(map5Config.getAllUsers().get(user2)).orElse(map5Config.allUsers.get("default"));
//    }
}
