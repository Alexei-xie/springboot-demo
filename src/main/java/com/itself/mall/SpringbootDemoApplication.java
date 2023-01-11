package com.itself.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author xxw
 * @Date 2022/08/09
 */
@EnableScheduling
@SpringBootApplication
public class SpringbootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
        System.out.println("#*#*#*#*#*#*#*#*#*\n" +
                            "      #*        #*\n" +
                            "      #*        #*\n" +
                            "      #*        #*\n" +
                            "      #*        #*\n" +
                            "      #*    #*  #*\n" +
                            "      #*     #* #*\n" +
                            "      #*          \n" +
                            "      #*          \n" +
                            "#*#*#*#*#*#*#*#*#*");
    }
}
