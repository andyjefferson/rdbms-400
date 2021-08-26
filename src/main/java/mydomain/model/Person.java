package mydomain.model;

import javax.persistence.*;
import org.datanucleus.api.jpa.annotations.MultiTenant;

@Entity
@Table(indexes = {@Index(name = "idx_tenant", columnList = "tenant")})
@MultiTenant(column="tenant")
public class Person
{
    @Id
    Long id;

    String name;

    public Person(long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }
}
