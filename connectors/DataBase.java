package connectors;

import models.Continent;
import models.Country;

import java.util.HashMap;
import java.util.UUID;

public class DataBase
{
    static DataBase singleton = null;

    public static final DataBase getSingleton()
    {
        if ( singleton == null)
            singleton = new DataBase();

        return singleton;
    }

    private HashMap<UUID, Country> pseudoDB_countries = new HashMap<>();
    private HashMap<String, UUID> pseudoDB_countryNameUuidMap = new HashMap<>();
    private HashMap<UUID, Continent> pseudoDB_continents = new HashMap<>();
    private HashMap<String, UUID> pseudoDB_continentNameUuidMap = new HashMap<>();

    public void addCountryToDatabase(Country country)
    {
        pseudoDB_countries.put( country.getId(), country );
        pseudoDB_countryNameUuidMap.put(country.getName(), country.getId());
    }

    public void addContinentToDatabase(Continent continent)
    {
        pseudoDB_continents.put( continent.getId(), continent );
        pseudoDB_continentNameUuidMap.put( continent.getName(), continent.getId() );
    }

    public boolean databaseContainsCountry(UUID countryUuid, String countryName)
    {
        if (countryUuid == null)
            countryUuid = pseudoDB_countryNameUuidMap.get(countryName);

        return pseudoDB_countries.containsKey(countryUuid);
    }

    public boolean databaseContainsContinent(UUID continentUuid, String continentName)
    {
        if (continentUuid == null)
            continentUuid = pseudoDB_continentNameUuidMap.get(continentName);

        return pseudoDB_continents.containsKey(continentUuid);
    }

    public Country getCountry(UUID countryUuid, String countryName)
    {
        if (countryUuid == null)
            countryUuid = pseudoDB_countryNameUuidMap.get(countryName);

        if (!databaseContainsCountry(countryUuid, null))
            return null;

        return pseudoDB_countries.get(countryUuid);
    }

    public Continent getContinent(UUID continentUuid, String continentName)
    {
        if (continentUuid == null)
            continentUuid = pseudoDB_continentNameUuidMap.get(continentName);

        if (!databaseContainsContinent(continentUuid, null))
            return null;

        return pseudoDB_continents.get(continentUuid);
    }

    public void debugPrintDataBase()
    {
        System.out.println("Continents: ");

        for (UUID key: pseudoDB_continents.keySet())
        {
            System.out.println(pseudoDB_continents.get(key));
        }

        System.out.println("Countries: ");

        for (UUID key: pseudoDB_countries.keySet())
        {
            System.out.println(pseudoDB_countries.get(key));
        }
    }
}
