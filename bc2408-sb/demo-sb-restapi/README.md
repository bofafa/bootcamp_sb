### mvn

- mvn compile (main code)
- mvn test-compile (main compile + test compile)
- mvn test (main compile + test compile + test), test -> bean cycle + server starts (i.e. check autowired)
- mvn package (all the above + generate jar)
- mvn install (all the above + copy the jar from project to m2)