<p align="center" >
  <img src="https://www.slf4j.org/images/logos/slf4j-logo.jpg" title="slf4j" float=left>
</p>

[![Build Status](http://img.shields.io/travis/SDWebImage/SDWebImage/master.svg?style=flat)](https://travis-ci.org/SDWebImage/SDWebImage)
[![Pod Version](http://img.shields.io/cocoapods/v/SDWebImage.svg?style=flat)](http://cocoadocs.org/docsets/SDWebImage/)
[![Pod Platform](http://img.shields.io/cocoapods/p/SDWebImage.svg?style=flat)](http://cocoadocs.org/docsets/SDWebImage/)
[![Pod License](http://img.shields.io/cocoapods/l/SDWebImage.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Carthage compatible](https://img.shields.io/badge/Carthage-compatible-4BC51D.svg?style=flat)](https://github.com/SDWebImage/SDWebImage)
[![codecov](https://codecov.io/gh/SDWebImage/SDWebImage/branch/master/graph/badge.svg)](https://codecov.io/gh/SDWebImage/SDWebImage)

本示例提供slf4j+log4j2的使用示例和规范示范配置

## Requirements

- IntelliJ IDEA 2017.2 or later
- SpringBoot 2.1.4

#### Backwards compatibility

- For SpringBoot 1.5.9

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

* import dependency
```xml
<!--slf4j-->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.26</version>
</dependency>

<!--log4j2-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
    <version>2.1.3.RELEASE</version>
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

* log4j2 config , refer to log4j2.xml

* or refer to log4j2.properties
