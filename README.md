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
#Some basic notes about how to integrate something:

Lets make some assumptions:

* you want a form to submit to the same page
* you want to be able to change what the page does based on what is submitted.
* you are working on the same version of the software I am. 

###To Do:

1. Add something like the following to ./src/main/java/com.datamigration/MigrationApp.java  

    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }

1.a This serves one page when it is browsed to, and then a runs data through a java file when the form is submitted.
1.b It is probably important that I do not talk about importing anything. This is because the files are of the same package.
1.b.i _I Think_. I could be wrong.'
2. Add a file, in this case 'Greeting' to ./src/main/java/com.datamigration/Greeting.java
2.a make sure that the first line includes ```package whateverYourPackageName;``` on the first line.
2.b Example:

    package com.datamigration;

    public class Greeting {

        private long id;
        private String content;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

    }

2.b.1 A


Things to ask other people about:
1. tabs vs spaces
2. how the hell do dependencies work wrt gradle/maven/myLibrary?
