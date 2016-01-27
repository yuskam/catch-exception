# JDK 1.5 compiler issue #
```
caughtException() instanceof IllegalArgumentException;
```
This expression is not successfully compiled by the JDK 1.5 compiler. This is at least what happens on my local machine. Remarkably Eclipse does not have any problems to compile the expression.

The following Java class reproduces the problem.

```
/*
  Try to compile with JDK 1.5

    JAVA_HOME=C:\Program Files (x86)\Java\jdk1.5.0_15
    "C:\Program Files (x86)\Java\jdk1.5.0_15\bin\javac" TestJavacOfJdk1_5_0_15.java
*/
public class TestJavacOfJdk1_5_0_15 {

  public static <E extends Exception> E caughtException() {
    return null;
  }

  public void main(String[] args) {

    // compilation fails:
    // TestJavacOfJdk1_5_0_15.java:...: unexpected type
    // found   : java.lang.Exception
    // required: reference
    if (caughtException() instanceof IndexOutOfBoundsException) { 
      System.out.println("something");
    }
  }
}
```

This is why catch-exception requires JDK 1.6.