doc:
	cd src/ ; javadoc rps rps.strategy util -d ../docs

compile:
	cd src/ ; javac util/*.java rps/*.java rps/strategy/*.java -d ../classes

test: compile
	javac -classpath test-1.7.jar test/*.java
	java -jar test-1.7.jar PlayerTest
	java -jar test-1.7.jar ShapeTest
	java -jar test-1.7.jar PermuteStrategyTest

jar: compile doc
	jar cvfm rps.jar manifest-ex docs test -C classes rps -C classes util

launch: jar
	clear ; java -jar rps.jar

clean:
	rm -rf classes/* docs/* lib/* test/*.class
