# Toll Station Queue Simulation

A Java-based simulation application designed to model and analyze traffic flow, server utilization, and queue waiting times at a toll station using a Poisson distribution model for car arrivals.

## Features

- **Dynamic Queue Simulation:** Models vehicle arrivals with a Poisson arrival rate ($\lambda$).
- **Configurable Parameters:** Simulates dynamic service times composed of both a constant baseline delay and variable service durations.
- **Comparative Analysis:** Evaluates multiple test cases (varying number of servers, service times, and fixed delays) to compare queuing behavior and efficiency metrics.
- **Maven Architecture:** Built using standard Maven layout for seamless dependency management and reliable compilation.

## Requirements

- **Java JDK:** 17 or higher (tested up to JDK 25)
- **Apache Maven:** 3.8+

## Building the Project

To build the executable JAR package, open your terminal (e.g., Cygwin, Bash, or Command Prompt) in the project root directory and run:

```bash
mvn clean package
```

The compiled artifact will be generated in the `target/` directory:
`target/toll-simulation-1.0-SNAPSHOT.jar`

## Running the Simulation

Execute the packaged JAR using Java:

```bash
java -jar target/toll-simulation-1.0-SNAPSHOT.jar
```

## Simulation Configuration

The main simulation setup currently configures:
- **Arrival Rate ($\lambda$):** Vehicle arrivals per unit time.
- **Number of Gates ($N$):** Active toll booths for each test scenario.
- **Service Times ($E[S]$ & Constant Delays):** Individual processing duration metrics per booth.

---