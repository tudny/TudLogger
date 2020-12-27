[![](https://jitpack.io/v/tudny/TudLogger.svg)](https://jitpack.io/#tudny/TudLogger)

# Installation
## Gradle
Add these lines to your `gradle.build`:

```gradle
repositories {
    // ...
    maven { url 'https://jitpack.io' }
}
```

and

```gradle
dependencies {
    // ...
    implementation 'com.github.tudny:TudLogger:v1.0'
}
```

## Maven
Add these lines to your build file
```maven
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

```
and
```maven
<dependency>
    <groupId>com.github.tudny</groupId>
    <artifactId>TudLogger</artifactId>
    <version>v1.0</version>
</dependency>
```

# Usage
Log (DEBUG) to standard output (System.out)
```java
Log.d("This is my message <3");
```

````bash
2020/12/26 20:49:58 | Debug | This is my message <3
````

Log (ERROR) to standard error output (System.err)
```java
Log.e("This is an error!");
```

```bash
2020/12/26 20:50:14 | Error | This is an error!
```

Log (ERROR) to standard error output (System.err) and print stack trace
```java
Exception someException = //...//
Log.e("The World is collapsing", someException);
```

```bash
2020/12/26 20:50:51 | Error | The World is collapsing
java.lang.Exception: Some Exception
	at com.github.tudny.tudlogger...
```

Change time display type
```java
// Print milliseconds
Log.setMilis(true);

// Don't print milliseconds
Log.setMilis(false);
```

```bash
2020/12/26 20:49:00.5010 | Debug | This is my message without millis <3
2020/12/26 20:49:00 | Debug | This is my message with millis <3
```

# Documentation
Available in [docs](https://tudny.github.io/TudLogger/).
