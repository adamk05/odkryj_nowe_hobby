package chlopaki.z.frontu.hobby.domain;

/**
 * Klasa przechowująca obiekt Hobby
 */
public class Hobby {

    private String name;
    private String description;
    private String category;

    /**
     * Tworzenie obiektu Hobby
     * @param name nazwa hobby
     * @param description opis hobby
     * @param category kategoria hobby
     */
    public Hobby(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    /**
     * Pobiera nazwę hobby
     * @return nazwa hobby
     */
    public String getName() {
        return name;
    }

    /**
     * Ustawia nazwe hobby
     * @param name nazwa hobby
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Pobiera opis hobby
     * @return opis hobby
     */
    public String getDescription() {
        return description;
    }

    /**
     * Ustawia opis hobby
     * @param description opis hobby
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Pobiera kategorie hobby
     * @return kategoria hobby
     */
    public String getCategory() {
        return category;
    }

    /**
     * Ustawia kategorie hobby
     * @param category kategoria hobby
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
