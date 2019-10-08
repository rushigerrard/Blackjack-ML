# Blackjack-ML
Building a blackjack game with agents playing against the dealer using varied ML strategies

## Prerequisites
- Java 1.8
- Maven 3.6.1

## Installation
Blackjack-Agent is a standard Maven project.

`$ mvn clean install`

2 executable jars - `MonitorBoardState.jar` and `TrialGameBasicStrategy.jar` would be generated in the `target` folder.

## Execution
`$ java -jar .\target\TrialGameBasicStrategy.jar <no-of-rounds-of-game>`

If `no-of-rounds` not specified, by default it will be 10.

## gRPC
To compile the gRPC `.proto` file and generate the stub classes, run the following command from the `python` directory.

`$ python -m grpc_tools.protoc -I. --python_out=. --grpc_python_out=. blackjack.proto`