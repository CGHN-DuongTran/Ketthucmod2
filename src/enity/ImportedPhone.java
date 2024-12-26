package enity;

public class ImportedPhone extends Phone {
    private String importCountry;
    private String condition; // New or used

    // Constructor
    public ImportedPhone(String id, String name, double price, int quantity, String manufacturer,
                         String importCountry, String condition) {
        super(id, name, price, quantity, manufacturer);
        this.importCountry = importCountry;
        this.condition = condition;
    }

    // Getters and Setters
    public String getImportCountry() { return importCountry; }
    public void setImportCountry(String importCountry) { this.importCountry = importCountry; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
}