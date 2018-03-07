doc:
	cd src/ ; javadoc -d ../docs -subpackages rental

compile:
	cd src/ ; javac rental/*.java -d ../classes

test: compile
	javac -classpath test-1.7.jar test/rental/*.java
	java -jar test-1.7.jar rental.BrandCriterionTest
	java -jar test-1.7.jar rental.ClientTest
	java -jar test-1.7.jar rental.InterCriterionTest
	java -jar test-1.7.jar rental.PriceCriterionTest
	java -jar test-1.7.jar rental.RentalAgencyTest
	java -jar test-1.7.jar rental.VehicleTest
	java -jar test-1.7.jar rental.CarTest
	java -jar test-1.7.jar rental.MotorbikeTest

jar: compile doc
	jar cvfm rental.jar manifest-ex docs test -C classes rental

launch: jar
	clear ; java -jar rental.jar

clean:
	rm -rf classes/* docs/* lib/* test/rental/*.class
