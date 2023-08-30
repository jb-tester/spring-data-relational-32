# What's new in Spring Data 3.2

[docs](https://github.com/spring-projects/spring-data-commons/wiki/Spring-Data-2023.1-%28Vaughan%29-Release-Note)

## Spring Data Commons: Limit for Repository Query Methods

Limiting result sizes worked in the past by either using the Top…/First… keywords (as in findTop10By) or PageRequest when using pagination. 
With the recent introduction of ScrollPosition, PageRequest isn’t applicable and a static limit is sometimes not what your use case requires. 
Spring Data 3.2 ships a Limit type to specify the number of results to be returned dynamically
```
interface UserRepository {
    List<User> findByLastname(String lastname, Limit limit);
}

repository.findByLastname("White", Limit.of(10));

repository.findByLastname("White", Limit.unlimited());
```
**Looks like no changes are required from IDEA here**

## Spring Data Relational: SpEL support though @Table and @Column annotations 

Mapping annotations for the table and column name respective mapped collections now accept SpEL expressions to determine table and column names at runtime using expressions.

```java
@Table("#{myTenantController.getPersonTableName()}")
static class Person {
@Id
@Column("#{myTenantController.getIdentifierColumnName()}") Long id;
}
```
Expression evaluation leverages Spring Data’s EvaluationContextExtension mechanism in which extension beans can contribute SpEL functionality. 
Note that expression results are used as table/column names. 
These are sanitized through a default SqlIdentifierSanitizer.words(), allowing characters and underscores to limit impact of unwanted SQL characters. A different sanitizer can be configured through RelationalMappingContext.

**No support in IDEA actually**   https://youtrack.jetbrains.com/issue/IDEA-326747


## Data Access and Transactions: JdbcClient support: [issue](https://github.com/spring-projects/spring-framework/issues/30931)

The new JdbcClient provides a unified facade for query/update statements on top of JdbcTemplate and NamedParameterJdbcTemplate, with flexible parameter options as well as flexible result retrieval options

```java
Optional<Integer> value = client.sql("SELECT AGE FROM CUSTMR WHERE ID = :id")
      .param("id", 3)
      .query((rs, rowNum) -> rs.getInt(1))
      .optional();
```
**No support in IDEA actually** https://youtrack.jetbrains.com/issue/IDEA-331159