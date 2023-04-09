# czm-devops-workshop-ukol

Homework for DevOps seminar by [CZM](https://czm.fel.cvut.cz/). 

## Assigment
_(in Czech)_
> Vytvořte DB, která bude obsahovat tabulku Produkt, která bude mít vhodně zvolený primární klíč, pojmenování produktu a cenu,
Vytvořte svou oblíbenou technologií (klidně Spring Boot) aplikaci, která vystaví POST endpoint /create-product, přes který půjde vytvářet po jednom produkty, které se uloží do DB a GET endpoint /get-products, který vrátí json všech doposavaď vytvořených produktů, můžete počítat s hodným uživatelem, který vám bude posílat validní data.
Jak aplikaci tak DB kontejnerizujte a spojte je spolu do docker network tak, aby v pořádku komunikovali.
Veškerý kód nahrajte na k tomu vytvořené veřejné git repository.

## Docker commands

This was my solution when connecting Postgres DB container to Spring boot app container


1. `docker run -itd -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 --name ukol-db postgres` (DB container)
2. `docker exec -it ukol-db psql -U postgres` and in **psql** create DB and Product table
3. `docker network create ukol-network`
4. `docker network connect ukol-network ukol-db`

5. update _spring.datasource.url_ in _application.properties_
6. `clean` and `install` Spring boot project with **Maven** (build JAR)
7. `docker build -t ukol-image .` (App image)

8. `docker run -it -p 8080:8080 --name ukol-container --network ukol-network ukol-image`
