package models;

import dao.CountryDAO;

import java.util.UUID;

public class Country
{
    UUID id;
    String name;
    String code;
    Continent continent;

    public Country(String name, String code, Continent continent)
    {
        id = UUID.randomUUID();
        this.name = name;
        this.code = code;
        this.continent = continent;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Continent getContinent() {
        return continent;
    }

    @Override
    public String toString() {
        return "Country: " + name + ", code: " + code + ", continent: " + continent.getName();
    }
}
