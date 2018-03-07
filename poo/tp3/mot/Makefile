all: clean compile test doc

doc:
	rm -rf docs
	mkdir docs
	javadoc Word.java -d docs

compile:
	javac Word.java
	javac WordMain.java
	javac -classpath .:test-1.7.jar WordTest.java

test: compile
	java -jar test-1.7.jar WordTest
	rm -f *.class

archive: clean
	tar -zcvf lombart_vasilev_tp3.tar.gz *

clean:
	rm -f *.class lombart_vasilev_tp3.tar.gz Makefile~
	rm -rf docs
