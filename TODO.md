- Add list of previously used applications - store API key for immediate access
- sript clean/build/bootRun and how to handle various scenarios.
- figure out how to set the freaking bootstrap path.
- Add security and other page mapping
- don't forget to update the pom and build

* [This](http://stackoverflow.com/a/25419184) for some reason I have been wanting to
display all of the contacts. Not quite sure why, however this is how to recursively iterate
through them.
* [This](http://stackoverflow.com/questions/29728842/thymeleaf-recursion-not-working) is
somewhat related as well, I think.  Really, though, what it shows is how to display results.

* What to really do:
1. figure out how to accept a form submission and write to file by calling a function
2. Accept appname and api key
3. query for needed data
4. get path to contact.csv
5. open contact.csv
6. do duplicate checking
7. find all custom fields
8. duplicate check and create
9. report done. 



# Basic Notes:
- `./src/main/java/com.datamigration/MigrationApp.java`
  - This file
