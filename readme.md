<p align="center" >
  <img src="https://www.slf4j.org/images/logos/slf4j-logo.jpg" title="slf4j" float=left>
</p>

[![Build Status](http://img.shields.io/travis/SDWebImage/SDWebImage/master.svg?style=flat)](https://travis-ci.org/SDWebImage/SDWebImage)
[![License](http://img.shields.io/cocoapods/l/SDWebImage.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0.html)

本示例提供slf4j+log4j2的使用示例和规范示范配置

## Requirements

- IntelliJ IDEA 2017.2 or later
- SpringBoot 2.1.4.RELEASE

#### Backwards compatibility

- For SpringBoot 1.5.19.RELEASE, import manually:

```xml
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.11.2</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.11.2</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-jcl</artifactId>
    <version>2.11.2</version>
</dependency>
```

## Getting Started

- Read this Readme doc
- Go to the [Github repository](https://github.com/r2ys/slf4j-log4j2-demo/tree/alpha) for more information

## Who Uses It

- workmates from sunjinke.

## Communication

- If you **need help**, mail [hu](hudingwu@sunjinke.com).
- If you'd like to **ask a general question**, use [Github pull requests](https://github.com/r2ys/slf4j-log4j2-demo/pulls).

### Build Project

At this point your project should build without error. If you are having problem, contact me by [Communication](#Communication)

## Author
- [r2ys](https://github.com/r2ys/)

## Licenses

All source code is licensed under the [MIT License](https://raw.github.com/SDWebImage/SDWebImage/master/LICENSE).

## How To Use

* run or debug : Slf4jLog4j2DemoApplication

* import dependency manually, dependencies about slf4j and log4j2 has been integrated with an overall log4j-slf4j-impl

```xml
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-slf4j-impl</artifactId>
    <version>2.11.2</version>
</dependency>
```

don't forget to exclude dependency:spring-boot-starter-logging from spring-boot-starter when using spring-boot-starter or spring-boot-starter-web
```xml
<!--spring boot starter-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <exclusions>
        <exclusion>
            <!-- 去除logback依赖 -->
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

* instanciate log: use lombok or use slf4j
```java
import lombok.*;
import lombok.extern.slf4j.Slf4j;
...
@Slf4j
public class Slf4jLog4j2DemoApplication {

}
```
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
...    
private static final Logger logger = LoggerFactory.getLogger(Slf4jLog4j2DemoApplication.class);
```

* see Slf4jLog4j2DemoApplication

```java
...
    ExampleEntity entity = new ExampleEntity("0", "alpha");

    // 使用lombok->log打印日志
    // debug
    log.debug("{}", entity.toString());

    // warn
    try {
        throw new Exception("程序异常");
    } catch (Exception e) {
        log.warn("{}", e.toString());
        log.warn("{}", e.getMessage());
        log.warn("", e);
    }

    // info
    // 需要自行实现toString
    log.info("{}", entity.toString());
    log.info("{}", entity);

    // error
    try {
        throw new RuntimeException("运行时异常");
    } catch (RuntimeException e) {
        log.error("{}", e.toString());
        log.error("{}", e.getMessage());
        log.error("", e);
    }
```

* setup log configure path at application.yml / application.properties
```yaml
logging:
  config: classpath:log4j2.xml
```

* to modify log4j2 specific configuration properties, refer to log4j2.xml

* notice: 
if you are not using embedded tomcat or jetty container, modify log file location:
```xml
...
<Property name="filePath">${sys:catalina.home}/logs/slf4j-log4j2-demo/</Property>
...
```

* look up log from generated log file, such as logs/all.log、info.log、error.log in root directory


* make sure log4j2.xml below root directory or config directory when deployed. Usually we extracted this config file from jar.

* AsyncLogger, todo

```xml
<!--log4j2的AsyncLogger 需要添加-->
<dependency>
    <groupId>com.lmax</groupId>
    <artifactId>disruptor</artifactId>
    <version>3.3.7</version>
</dependency>
```