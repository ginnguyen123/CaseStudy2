package models;

import utils.DateUntil;

import java.time.Instant;
import java.util.Date;

public class Product {
    private long id;
    private String productName;
    private float prices;
    private int quantitys;
    private Date createAt;
    private Instant updateAt;
    private String madeIn;
    public Product(){}
    public Product(long id, String productName, float prices, int quantitys, String madeIn, Date createAt, Instant updateAt){
        this.id = id;
        this.productName = productName;
        this.prices = prices;
        this.quantitys = quantitys;
        this.madeIn = madeIn;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public float getPrices() {
        return prices;
    }
    public void setPrices(float prices) {
        this.prices = prices;
    }
    public int getQuantitys() {
        return quantitys;
    }
    public void setQuantitys(int quantitys) {
        this.quantitys = quantitys;
    }
    public String getMadeIn() {
        return madeIn;
    }
    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }
    public Date getCreateAt() {
        return createAt;
    }
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    public Instant getUpdateAt() {
        return updateAt;
    }
    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }
    public static Product parseProduct(String productListLine){
        String[] productListArray = productListLine.split(",");
        long id = Long.parseLong(productListArray[0]);
        String productName = productListArray[1];
        float productPrices = Float.parseFloat(productListArray[2]);
        int productQuantitys = Integer.parseInt(productListArray[3]);
        String madeIn = productListArray[4];

        DateUntil dateUtil = new DateUntil();
        Date createAt = DateUntil.parseStringToDate(productListArray[5]);
        Instant updateAt = DateUntil.parseStringToInstant(productListArray[6]);
        Product p = new Product(id, productName,productPrices,productQuantitys,madeIn,createAt,updateAt);
        return p;
    }
    public String toString() {
        //Product(long id, String nameProduct, double prices, int quantitys,
        // String madeIn, Date createAt, Instant updateAt)
        String stringCreatAt = DateUntil.formatDateToString(this.createAt);
        String stringUpdateAt = DateUntil.formatInstanstToString(this.updateAt);
        return String.format("%f,%s,%f,%d,%s,%s,%s",
                this.id,
                this.productName,
                this.prices,
                this.quantitys,
                this.madeIn,
                stringCreatAt,
                stringUpdateAt);
    }
}
