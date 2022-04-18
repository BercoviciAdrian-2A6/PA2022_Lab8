package dao;

import connectors.DataBase;
import models.Continent;
import models.Country;

import java.util.UUID;

public class CountryDAO
{
    public static Country createCountry(String countryName, String countryCode, String continentName)
    {
        if (DataBase.getSingleton().databaseContainsCountry(null, countryName))
            return null;

        Continent continent;

        if (DataBase.getSingleton().databaseContainsContinent(null, continentName))
            continent = ContinentDAO.getContinent(continentName);
        else
            continent = ContinentDAO.createContinent(continentName);

        Country country = new Country(countryName, countryCode, continent);

        DataBase.getSingleton().addCountryToDatabase(country);

        return country;
    }

    public static Country getCountry(UUID id)
    {
        return DataBase.getSingleton().getCountry(id, null);
    }

    public static Country getCountry(String countryName)
    {
        return DataBase.getSingleton().getCountry(null, countryName);
    }
}
