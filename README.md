# 360t-assignment

Ensure you have Maven and Java installed.
Check versions:
java -version
mvn -v
Navigate to your project root (where pom.xml is).
Compile and run:
mvn clean compile exec:java -Dexec.mainClass="com.example.JavaAssignment.Application"
Expected behavior/output:
Player1 sending: [Player1 -> Player2] Hello
Player2 received: [Player1 -> Player2] Hello
Player2 sending: [Player2 -> Player1] Hello-1
Player1 received: [Player2 -> Player1] Hello-1
Player1 sending: [Player1 -> Player2] Hello-1-1
...
Player1 finished after 10 messages.
This runs both players in the same JVM, meeting your single-process requirement.
