/**
 * Created by lingyanjiang on 17/1/9.
 */
public enum  ItemType {
    COMPANY_WIDE("Company"),
    DEPARTMENTAL("Departmental"),
    PROJECT_SPECIFIC("Project");

    private String itemCode;
    private ItemType(String dbCode) {
        this.itemCode = dbCode;
    }
    public String getItemCode() {
        return itemCode;
    }

    public static void main(String[] args) {
        ItemType type3 = ItemType.valueOf("PROJECT_SPECIFIC");
        System.out.println(type3);
        ItemType type4 = ItemType.values()[0];
        System.out.println(type4);
        ItemType type = ItemType.DEPARTMENTAL;
        System.out.println(type);
    }
}
