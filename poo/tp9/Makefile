doc:
	cd src/ ; javadoc -d ../docs -subpackages goosegame

compile:
	cd src/ ; javac goosegame/*.java -d ../classes

test: compile
	javac -classpath test-1.7.jar test/goosegame/*.java
	java -jar test-1.7.jar goosegame.BasicCellTest
	java -jar test-1.7.jar goosegame.GooseCellTest
	java -jar test-1.7.jar goosegame.GoosegameBoardTest
	java -jar test-1.7.jar goosegame.PlayerTest
	java -jar test-1.7.jar goosegame.StartCellTest
	java -jar test-1.7.jar goosegame.TeleportCellTest
	java -jar test-1.7.jar goosegame.TrapCellTest
	java -jar test-1.7.jar goosegame.WaitingCellTest

jar: compile doc
	jar cvfm goosegame.jar manifest-ex docs test -C classes goosegame

launch: jar
	clear ; java -jar goosegame.jar

clean:
	rm -rf classes/* docs/* lib/* test/goosegame/*.class
