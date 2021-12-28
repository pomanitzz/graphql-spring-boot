# GraphQL + Spring Boot 2

1. GraphQL
2. SpringBoot
3. H2 in runtime
4. Spring, Lombok, Java 11

#### How to run demo

1. Clone or download project
2. Run like SpringBoot app: GraphqlSpringbootApplication#main
3. Open: http://localhost:8080/graphiql

Try to run some requests.
Some examples:

1. Get all:

    ```
    query {
      vehicles(count: 10) 
      {
        id,
        brandName,
        modelCode
      }
    }
    ```

2. Get by id:

    ```
    query {
      vehicle(id: 2)
    }
    ```
3. Create:

    ```
    mutation {
      createVehicle(type: "Bus", modelCode: "Iron", brandName: "Bogdan", launchDate: "2008-08-08") 
      {
        id,
        modelCode
      }
    }
    ```