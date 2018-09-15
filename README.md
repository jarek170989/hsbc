Source of application is in /src/main/java.

Main class is /src/main/java/RPNParser.

Instruction to run application:
- mvn clean package
- mvn exec:java -Dexec.mainClass="RPNParser" -Dexec.args="'$rpn'"
    where $rpn is rpn expression ie. 20 3 - 2 +
