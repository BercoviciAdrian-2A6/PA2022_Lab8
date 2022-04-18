package dao;

import connectors.DataBase;
import models.Continent;

import java.util.UUID;

public class ContinentDAO
{
    public static Continent createContinent(String continentName)
    {
        if (DataBase.getSingleton().databaseContainsContinent(null, continentName))//already exists
            return null;

        Continent continent;
        continent = new Continent(continentName);
        DataBase.getSingleton().addContinentToDatabase(continent);

        return continent;
    }

    public static Continent getContinent(UUID id)
    {
        return DataBase.getSingleton().getContinent(id, null);
    }

    public static Continent getContinent(String continentName)
    {
        return DataBase.getSingleton().getContinent( null, continentName);
    }
}
