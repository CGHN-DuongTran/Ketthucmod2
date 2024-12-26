package enity;

public class OriginalPhone extends Phone{
    private String warrantyPeriod;
    private String warrantyScope; // Within country or international


    public OriginalPhone(String id, String name, double price, int quantity, String manufacturer,
                         String warrantyPeriod, String warrantyScope) {
        super(id, name, price, quantity, manufacturer);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyScope = warrantyScope;
    }

    public String getWarrantyPeriod() { return warrantyPeriod; }
    public void setWarrantyPeriod(String warrantyPeriod) { this.warrantyPeriod = warrantyPeriod; }

    public String getWarrantyScope() { return warrantyScope; }
    public void setWarrantyScope(String warrantyScope) { this.warrantyScope = warrantyScope; }
}