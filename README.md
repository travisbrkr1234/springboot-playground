# springboot-playground
###This is going to be the playground for understanding springboot, it was borrowed from [here](http://www.javacodegeeks.com/2014/06/spring-boot-fast-mvc-start.html)
Credits go to Alexey Zvolinskiy

##*PreRequisites*
###Gradle v 2.5 [download](http://gradle.org/gradle-download/) (you will need gradle installed and have its bin folder appended to your path)
to do this, in windows, download gradle and run:
```
setx PATH "%PATH%;C:\yourGradleLocation\bin" /M
```
## 

###To run this project (sparknotes version):



-    git clone this repo
-    open cmd and cd to the cloned repo's directory
-    run
```
gradle.bat build
```
-  IF the build is successful run:
```
gradle bootRun
```
-    open a web browser and navigate to localhost:8080/hello
this will load the hello.jsp from the project

##Working from https://spring.io/guides/gs/integration/