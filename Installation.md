# Prerequisites #

catch-exception-1.2.0 **requires JDK 1.6** due to [a compiler issue of JDK 1.5](http://code.google.com/p/catch-exception/wiki/Jdk15CompilerIssue).



# Download #

catch-exception-1.2.0 can be downloaded from [Maven Central](http://search.maven.org/) or from the
[Downloads page](http://code.google.com/p/catch-exception/downloads/list).

The Maven coordinates are
```
<dependency>
    <groupId>com.googlecode.catch-exception</groupId>
    <artifactId>catch-exception</artifactId>
    <version>1.2.0</version>
    <scope>test</scope> <!-- test scope to use it only in tests -->
</dependency>
```

If you want to catch throwables, use
```
<dependency>
    <groupId>com.googlecode.catch-exception</groupId>
    <artifactId>catch-throwable</artifactId>
    <version>1.2.0</version>
    <scope>test</scope> <!-- test scope to use it only in tests -->
</dependency>
```





# Dependencies #

Users who do not use Maven or another dependeny management tool have to manually download the libraries catch-exception depends on, namely Mockito and ,optionally, Powermock.

## Mockito ##

catch-exception-1.2.0 depends on [Mockito 1.8.5](http://code.google.com/p/mockito/).

The maven coordinates of that dependency are

```
<dependency>
  <groupId>org.mockito</groupId>
  <artifactId>mockito-core</artifactId>
  <version>1.8.5</version>
</dependency>
```

The library requires at least Mockito 1.8.1. Successfully tested versions are 1.8.1, 1.8.2, 1.8.3, 1.8.4, 1.8.5, 1.9.0-rc1, 1.9.0, 1.9.5-rc1, 1.9.5.

The versions 1.5, 1.6, 1.7 are not compatible with catch-exception.

## PowerMock ##

catch-exception-1.2.0 **optionally** uses [Powermock 1.4.10](http://code.google.com/p/powermock/) in order to catch exceptions thrown by final classes.

The maven coordinates of that dependency are

```
<dependency>
  <groupId>org.powermock</groupId>
  <artifactId>powermock-module-junit4</artifactId>
  <version>1.4.10</version>
  <scope>test</scope>
</dependency>
<dependency>
  <groupId>org.powermock</groupId>
  <artifactId>powermock-api-mockito</artifactId>
  <version>1.4.10</version>
  <scope>test</scope>
</dependency>
```

The library requires at least PowerMock 1.4.6. Successfully tested versions are 1.5.1, 1.5, 1.4.12, 1.4.11, 1.4.10, 1.4.9, 1.4.8, 1.4.7, 1.4.6.