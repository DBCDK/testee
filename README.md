testee
======

A Java library containing classes to help ease the pain of testing Java EE applications.

> Pronounced testy
>
> Definition of testy   
> 1) easily annoyed : IRRITABLE  
> 2) marked by impatience or ill humor

### contents

 * NonContainerManagedExecutorService
 
> A ManagedExecutorImplementation which delegates its operations to a
 to a normal ExecutorService making it instantiable outside of a
 Java EE container.

 * SameThreadExecutorService

> An ExecutorService that executes tasks immediately in the calling thread during submit.

### Maven

Add the dependency to your Maven pom.xml

```xml
<dependency>
  <groupId>dk.dbc</groupId>
  <artifactId>dbc-commons-testee</artifactId>
  <version>1.1-SNAPSHOT</version>
</dependency>
```
### development

**Requirements**

To build this project JDK 1.8 or higher and Apache Maven is required.

### License

Copyright Dansk Bibliotekscenter a/s. Licensed under GPLv3.
See license text in LICENSE.txt
