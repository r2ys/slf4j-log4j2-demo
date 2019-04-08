<p align="center" >
  <img src="https://raw.githubusercontent.com/SDWebImage/SDWebImage/master/SDWebImage_logo.png" title="SDWebImage logo" float=left>
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
- Go to the [Github repository](https://github.com/r2ys/slf4j-log4j2-demo) for more information

## Who Uses It

- workmates from sunjinke.

## Communication

- If you **need help**, mail [hu](hudingwu@sunjinke.com). (Tag 'sdwebimage')
- If you'd like to **ask a general question**, use [Github pull requests](https://github.com/r2ys/slf4j-log4j2-demo/pulls).

### Build Project

At this point your project should build without error. If you are having problem, contact me[Communication](#Communication)

## Author
- [r2ys](https://github.com/r2ys/)

## Licenses

All source code is licensed under the [MIT License](https://raw.github.com/SDWebImage/SDWebImage/master/LICENSE).

## How To Use

* Objective-C

```objective-c
#import <SDWebImage/SDWebImage.h>
...
[imageView sd_setImageWithURL:[NSURL URLWithString:@"http://www.domain.com/path/to/image.jpg"]
             placeholderImage:[UIImage imageNamed:@"placeholder.png"]];
```