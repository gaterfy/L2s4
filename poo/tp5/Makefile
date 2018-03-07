folders:
	mkdir classes lib docs

doc:
	cd src/ ; javadoc hanoi hanoi.util -d ../docs

compile:
	cd src/ ; javac hanoi/*.java -d ../classes

test: compile
	javac -classpath test-1.7.jar test/*.java
	java -jar test-1.7.jar DiscTest
	java -jar test-1.7.jar TowerTest

jar: compile doc
	jar cvfm appli.jar manifest-ex docs test -C classes hanoi

launch: jar
	clear
	java -jar appli.jar 3

clean:
	rm -rf classes/ docs/ lib/ test/*.class
