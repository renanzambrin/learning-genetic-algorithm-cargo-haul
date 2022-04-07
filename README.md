![Build](https://github.com/renanzambrin/learning-genetic-algorithm-cargo-haul/workflows/Build/badge.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=renanzambrin_learning-genetic-algorithm-cargo-haul&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=renanzambrin_learning-genetic-algorithm-cargo-haul)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=renanzambrin_learning-genetic-algorithm-cargo-haul&metric=coverage)](https://sonarcloud.io/summary/new_code?id=renanzambrin_learning-genetic-algorithm-cargo-haul)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=renanzambrin_learning-genetic-algorithm-cargo-haul&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=renanzambrin_learning-genetic-algorithm-cargo-haul)

# Learning Genetic Algorithms - Cargo Haul

A logistic company hired you to haul some cargo. You can pick any package from their storage.
Each package is a rectangle box with a width, a height, a length, a weight and a delivery cost.
The logistic company will pay you a percentage of the total delivery cost for successfully delivered packages, as long as you keep within law requirements.

As the van owner, you want to receive the best payment possible, carrying the highest number of high-value packages without surpassing the van's max weight and using only the internal cargo area.

---

#### Van Internal Dimensions
- Width: 2.00 metres.
- Height: 1.76 metres.
- Length: 4.00 metres.
- Maximum weight: 1350 Kg.

#### Considerations:

Box width, height, length, weight and delivery cost can not be a null or negative values.

## Running test scenarios

The Scenario is only enabled when the property -DrunScenarios=true is added.

``./gradlew test --tests "learning.geneticalgorithm.cargohaul.scenario.ScenarioOneTest" -DrunScenarios=true``

