import connectors.DataBase;
import dao.ContinentDAO;
import dao.CountryDAO;

public class Main
{
    public static void main(String[] args)
    {
        CountryDAO.createCountry("Romania", "123", "Europa");
        CountryDAO.createCountry("Romania", "123", "Europa");
        CountryDAO.createCountry("Germania", "125", "Europa");
        CountryDAO.createCountry("Franta", "125", "Europa");
        CountryDAO.createCountry("USA", "125", "NorthAmerica");
        CountryDAO.createCountry("Canada", "125", "NorthAmerica");
        CountryDAO.createCountry("Japonia", "125", "Asia");
        CountryDAO.createCountry("SouthKorea", "125", "Asia");

        ContinentDAO.createContinent("Oceania");
        ContinentDAO.createContinent("Antartica");
        ContinentDAO.createContinent("Antartica");

        DataBase.getSingleton().debugPrintDataBase();
    }
}
