# <img src="src/docs/asciidoc/images/spring-framework.png" width="80" height="80"> Spring Framework [![Build Status](https://build.spring.io/plugins/servlet/wittified/build-status/SPR-PUBM)](https://build.spring.io/browse/SPR)

This is the home of the Spring Framework: the foundation for all [Spring projects](https://spring.io/projects). Collectively the Spring Framework and the family of Spring projects is often referred to simply as "Spring". 

Spring provides everything required beyond the Java programming language for creating enterprise applications for a wide range of scenarios and architectures. Please read the [Overview](https://docs.spring.io/spring/docs/current/spring-framework-reference/overview.html#spring-introduction) section as reference for a more complete introduction.

## Code of Conduct

This project is governed by the [Spring Code of Conduct](CODE_OF_CONDUCT.adoc). By participating, you are expected to uphold this code of conduct. Please report unacceptable behavior to spring-code-of-conduct@pivotal.io.

## Access to Binaries

For access to artifacts or a distribution zip, see the [Spring Framework Artifacts](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Artifacts) wiki page.

## Documentation

The Spring Framework maintains reference documentation ([published](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/) and [source](src/docs/asciidoc)), Github [wiki pages](https://github.com/spring-projects/spring-framework/wiki), and an
[API reference](https://docs.spring.io/spring-framework/docs/current/javadoc-api/). There are also [guides and tutorials](https://spring.io/guides) across Spring projects.

## Build from Source

See the [Build from Source](https://github.com/spring-projects/spring-framework/wiki/Build-from-Source) Wiki page and the [CONTRIBUTING.md](CONTRIBUTING.md) file.

## Stay in Touch

Follow [@SpringCentral](https://twitter.com/springcentral), [@SpringFramework](https://twitter.com/springframework), and its [team members](https://twitter.com/springframework/lists/team/members) on Twitter. In-depth articles can be found at [The Spring Blog](https://spring.io/blog/), and releases are announced via our [news feed](https://spring.io/blog/category/news).

## License

The Spring Framework is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).

## 补充说明
* 1.剔除spring-aspectj模块，该模块是apectj的，语法上与java不同，右键该模块找到 load/unload modules
* 2.项目需要预编译，不然编译不成功
```shell
.\gradlew build
```
* 3.排除代码风格检查，影响个人模块编译，src --> checkstyle.xml 把<module> 删除标签里面全部内容 </module>
* 4.注意每个模块 kotlin 的版本（选择统一的一个高版本）
* 5.控制台中文乱码问题
  * idea 设置文件编码
  * idea --> help --> Edit Customer VM Option
    ```properties
        -Dfile.encoding=utf-8
    ```
* 6.新建模块，设置父工程为spring，即在settings.gradle 中
  ```groovy
    include '项目名'
  ```
* 7.自己模块，引入依赖
```groovy
dependencies {
    compile(project(":spring-beans"))
    compile(project(":spring-core"))
    compile(project(":spring-context"))
    compile(project(":spring-aop"))
//    compile(project(":spring-web"))
//    compile(project(":spring-webmvc"))

    /* 需要引入该aspectj的依赖，否则代理会出现问题，运行是出现问题 */
    compile group: 'org.aspectj', name: 'aspectjweaver', version: '1.9.4'

    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
}
```
