package models;

import java.util.UUID;

public class Continent
{
    UUID id;
    String name;

    public Continent(String name)
    {
        id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Continent - " + name;
    }
}
