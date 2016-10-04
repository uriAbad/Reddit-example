package ctesting.cleancountries.Model;

/**
 * Created by Uri Abad on 23/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */
public class CountryModel {

    private String name;
    private String capital;
    private int population;
    private String region;
    private String denomination;

    public CountryModel() {

    }

    public CountryModel(String name, String capital, int population, String region, String
            denomination) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.region = region;
        this.denomination = denomination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    @Override
    public String toString() {
        return "CountryModel{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", region='" + region + '\'' +
                ", denomination='" + denomination + '\'' +
                '}';
    }
}
