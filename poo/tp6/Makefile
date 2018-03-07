doc:
	cd src/ ; javadoc -d ../docs -subpackages image

compile:
	cd src/ ; javac image/*.java -d ../classes

test: compile
	javac -classpath test-1.7.jar test/*.java
	java -jar test-1.7.jar GrayColorTest
	java -jar test-1.7.jar PixelTest
	java -jar test-1.7.jar ImageTest

jar-example: compile
	cd classes; jar cvf ../imageExample.jar image

jar-main: compile doc
	jar cvfm image.jar manifest-ex docs images test -C classes image

clean:
	rm -rf classes/* docs/* lib/* test/*.class imageExample.jar
