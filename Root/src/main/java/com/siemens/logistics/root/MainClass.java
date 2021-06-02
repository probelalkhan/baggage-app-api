package com.siemens.logistics.root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@SpringBootApplication(scanBasePackages = {"com.siemens.logistics.common", "com.siemens.logistics.user_management","com.siemens.logistics.TransportBags","com.siemens.logistics.flights","com.siemens.logistics.Configuration"})
@ComponentScan({"com.siemens.logistics.common", "com.siemens.logistics.user_management","com.siemens.logistics.TransportBags","com.siemens.logistics.flights","com.siemens.logistics.Configuration"})
@EnableJpaRepositories({"com.siemens.logistics.user_management","com.siemens.logistics.TransportBags","com.siemens.logistics.flights","com.siemens.logistics.Configuration"})
@EntityScan({"com.siemens.logistics.user_management","com.siemens.logistics.TransportBags","com.siemens.logistics.flights","com.siemens.logistics.Configuration"})

public class MainClass {
    private static Logger logger = LogManager.getLogger(MainClass.class);
    public static void main(String[] args) {
        SpringApplication.run(MainClass.class, args);
    }
}
