rdbms-400
=========

This test creates a multitenancy discriminator for a class, and tries to index it. 
Running it creates the following log entries, showing successfully created index

```
13:29:55,813 (main) DEBUG [DataNucleus.Persistence] - Managing Persistence of Class : mydomain.model.Person [Table : PERSON, InheritanceStrategy : new-table]
13:29:55,819 (main) DEBUG [DataNucleus.Datastore.Schema] - Field [mydomain.model.Person.id] -> Column(s) [PERSON.ID] using mapping of type "org.datanucleus.store.rdbms.mapping.java
.LongMapping" (org.datanucleus.store.rdbms.mapping.column.BigIntColumnMapping)
13:29:55,819 (main) DEBUG [DataNucleus.Datastore.Schema] - Table PERSON will manage the persistence of the fields for class mydomain.model.Person (inheritance strategy="new-table")
 
13:29:55,819 (main) DEBUG [DataNucleus.Datastore.Schema] - Field [mydomain.model.Person.name] -> Column(s) [PERSON."NAME"] using mapping of type "org.datanucleus.store.rdbms.mappin
g.java.StringMapping" (org.datanucleus.store.rdbms.mapping.column.VarCharColumnMapping)
13:29:55,819 (main) DEBUG [DataNucleus.Datastore.Schema] - Field [MULTITENANCY] -> Column(s) [PERSON.TENANT] using mapping of type "org.datanucleus.store.rdbms.mapping.java.StringM
apping" (org.datanucleus.store.rdbms.mapping.column.VarCharColumnMapping)
13:29:55,819 (main) DEBUG [DataNucleus.Datastore.Schema] - Table/View PERSON has been initialised
13:29:55,820 (main) DEBUG [DataNucleus.Connection] - ManagedConnection OPENED : "org.datanucleus.store.rdbms.ConnectionFactoryImpl$ManagedConnectionImpl@132ddbab [conn=org.datanucl
eus.store.rdbms.datasource.dbcp2.PoolingDataSource$PoolGuardConnectionWrapper@297ea53a, commitOnRelease=true, closeOnRelease=true, closeOnTxnEnd=true]" on resource "nontx" with iso
lation level "serializable" and auto-commit=false
13:29:55,820 (main) DEBUG [DataNucleus.Datastore.Schema] - Schema Transaction STARTED with connection "org.datanucleus.store.rdbms.datasource.dbcp2.PoolingDataSource$PoolGuardConne
ctionWrapper@297ea53a" with isolation "serializable"
13:29:55,823 (main) DEBUG [DataNucleus.Datastore.Schema] - Check of existence of PERSON returned no table
13:29:55,824 (main) DEBUG [DataNucleus.Datastore.Schema] - CREATE TABLE PERSON
(
    ID BIGINT NOT NULL,
    "NAME" VARCHAR(255) NULL,
    TENANT VARCHAR(255) NOT NULL,
    CONSTRAINT PERSON_PK PRIMARY KEY (ID)
)
13:29:55,825 (main) DEBUG [DataNucleus.Datastore.Schema] - SQL Execution Time = 1 ms
13:29:55,828 (main) DEBUG [DataNucleus.Datastore.Schema] - Loading column info for table(s) "PERSON" in Catalog "", Schema ""
13:29:55,857 (main) DEBUG [DataNucleus.Datastore.Schema] - Column info loaded for Catalog "", Schema "", 1 tables, time = 28 ms
13:29:55,857 (main) DEBUG [DataNucleus.Datastore.Schema] - Column info retrieved for table "PERSON" : 3 columns found
13:29:55,882 (main) DEBUG [DataNucleus.Datastore.Schema] - CREATE INDEX IDX_TENANT ON PERSON (TENANT)
13:29:55,883 (main) DEBUG [DataNucleus.Datastore.Schema] - SQL Execution Time = 1 ms
```
using DN core/api-jpa/rdbms from GitHub master, with HSQLDB 2.3.3 using Java 11.0.11
