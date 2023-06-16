package net.hwyz.iov.cloud.account.service;


import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 *
 * @author hwyz_leo
 */
@Log4j2
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("net.hwyz.iov.cloud.account.service.infrastructure.repository.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("应用启动完成");
    }

}
