package top.r2ys.slf4jlog4j2demo;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@Slf4j
@SpringBootApplication
//public class Slf4jLog4j2DemoApplication extends SpringBootServletInitializer {
public class Slf4jLog4j2DemoApplication {

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ExampleEntity {
        private String id;
        private String name;
    }

    /**
     * package:org.slf4j
     */
    private static final Logger logger = LoggerFactory.getLogger(Slf4jLog4j2DemoApplication.class);

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(this.getClass());
//    }

    public static void main(String[] args) {
		SpringApplication.run(Slf4jLog4j2DemoApplication.class, args);

		testWithLombok();

		testWithLogger();

	}

    /**
     * lombok slf4j
     */
    public static void testWithLombok() {
        ExampleEntity entity = new ExampleEntity("0", "alpha");

        // 系统日志
        System.out.println("[Slf4jLog4j2DemoApplication.testWithLombok(Slf4jLog4j2DemoApplication.java:45)]" + "sout->" + entity.toString());
        System.err.println("[Slf4jLog4j2DemoApplication.testWithLombok(Slf4jLog4j2DemoApplication.java:46)]" + "serr->" + entity.toString());

        // 使用lombok->log打印日志

        // trace
        log.trace("{}", entity.toString());

        // debug
        log.debug("{}", entity.toString());

        // info
        // 需要自行实现toString
        log.info("{}", entity.toString());
        log.info("{}", entity);

        // warn
        try {
            throw new Exception("程序异常");
        } catch (Exception e) {
            log.warn("{}", e.toString());
            log.warn("{}", e.getMessage());
            log.warn("", e);
        }

        // error
        try {
            throw new RuntimeException("运行时异常");
        } catch (RuntimeException e) {
            log.error("{}", e.toString());
            log.error("{}", e.getMessage());
            log.error("", e);
        }
    }

    /**
     * logger
     */
    public static void testWithLogger() {
        ExampleEntity entity = new ExampleEntity("0", "alpha");

        // 使用lombok->log打印日志
        // debug
        logger.debug("{}", entity.toString());

        // warn
        try {
            throw new Exception("程序异常");
        } catch (Exception e) {
            logger.warn("{}", e.toString());
            logger.warn("{}", e.getMessage());
            logger.warn("", e);
        }

        // info
        // 需要自行实现toString
        logger.info("{}", entity.toString());
        logger.info("{}", entity);

        // error
        try {
            throw new RuntimeException("运行时异常");
        } catch (RuntimeException e) {
            logger.error("{}", e.toString());
            logger.error("{}", e.getMessage());
            logger.error("", e);
        }
    }

}
