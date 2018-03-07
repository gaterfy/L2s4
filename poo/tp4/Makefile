folders:
	mkdir classes lib docs

doc:
	cd src/ ; javadoc example example.util -d ../docs

compile:
	cd src/ ; javac example/Robot.java -d ../classes

test: compile
	javac -classpath test-1.7.jar test/*.java
	java -jar test-1.7.jar BoxTest
	java -jar test-1.7.jar RobotTest

jar: compile
	cd classes/ ; jar cvf ../appli.jar example

jar-exec: compile
	cd classes ; jar cvf ../appli.jar example ; jar cvfm ../appli.jar ../manifest-ex example

launch: jar-exec
	clear
	java -jar appli.jar

clean:
	rm -rf classes/ docs/ lib/ test/*.class
