javac -sourcepath .\src -d build\classes -cp .\libs\commons-lang3-3.11.jar;.\libs\joda-time-2.10.10.jar src/ua/com/alevel/students/StudentsInfo.java src/ua/com/alevel/education/Education.java src/ua/com/alevel/Main.java
java -cp build\classes\;.\libs\commons-lang3-3.11.jar;.\libs\joda-time-2.10.10.jar ua.com.alevel.Main
