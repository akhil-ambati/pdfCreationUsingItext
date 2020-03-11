public class Data {
    private String EntityType, EntityName;
    private double Quantity;

    public Data(String entityType, String entityName, double quantity) {
        EntityType = entityType;
        EntityName = entityName;
        Quantity = quantity;
    }

    public String getEntityType() {
        return EntityType;
    }

    public void setEntityType(String entityType) {
        EntityType = entityType;
    }

    public String getEntityName() {
        return EntityName;
    }

    public void setEntityName(String entityName) {
        this.EntityName = entityName;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }
}