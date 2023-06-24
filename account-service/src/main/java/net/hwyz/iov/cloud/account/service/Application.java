package net.hwyz.iov.cloud.account.service;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类
 *
 * @author hwyz_leo
 */
@Slf4j
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("net.hwyz.iov.cloud.account.service.infrastructure.repository.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("应用启动完成");
    }

}
