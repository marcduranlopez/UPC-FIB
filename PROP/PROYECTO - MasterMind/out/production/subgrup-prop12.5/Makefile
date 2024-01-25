CLASS_INPUT =	./main/domain/classes/*.java \
				./main/domain/classes/Exceptions/*.java \
				./main/domain/controllers/*.java \
				./main/data/*

CLASS_OUTPUT =	../../EXE/out/

JAR_OUTPUT =	../../EXE/

JUNIT_JARS = ../../lib/junit-4.12.jar:../../lib/hamcrest-core-1.3.jar

JUNIT_TESTS = ./test/*.java

JSON_JARS = ../../lib/gson-2.8.6.jar

CLASS_SOURCES =			$(CLASS_OUTPUT)main/domain/drivers/*.class \
						$(CLASS_OUTPUT)main/domain/classes/*.class \
						$(CLASS_OUTPUT)main/domain/classes/Exceptions/*.class \
						$(CLASS_OUTPUT)main/domain/controllers/*.class

all:
	javac -d $(CLASS_OUTPUT) $(CLASS_INPUT)
	javac -cp $(JUNIT_JARS) -d $(CLASS_OUTPUT) $(CLASS_INPUT) $(JUNIT_TESTS)
	javac -cp $(JSON_JARS) -d $(CLASS_OUTPUT) $(CLASS_INPUT)
jarDriver:
	javac -cp $(JSON_JARS) -d $(CLASS_OUTPUT) $(CLASS_INPUT) ./main/domain/drivers/driverDomain.java
	jar cmvf ./main/domain/drivers/Manifest.mf $(JAR_OUTPUT)driverDomain.jar -C $(CLASS_OUTPUT) .
	cp $(JSON_JARS) $(JAR_OUTPUT)
	java -jar $(JAR_OUTPUT)driverDomain.jar

executaDriver:
	java -jar $(JAR_OUTPUT)driverDomain.jar

UsuariTest: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.UsuariTest

TaulerTest: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TaulerTest

StatsTest: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.StatsTest

RecordTest: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.RecordTest

RankingTest: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.RankingTest

PartidaTest: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.PartidaTest

FiveGuessTest: all
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.FiveGuessTest
	
AllTest:
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.UsuariTest
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.TaulerTest
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.StatsTest
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.RecordTest
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.RankingTest
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.PartidaTest
	java -cp $(JUNIT_JARS):$(CLASS_OUTPUT) org.junit.runner.JUnitCore test.FiveGuessTest
	
clean:
	rm -r ../../EXE/out/*
