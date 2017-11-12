package com.example.faisal.cse_600;

/**
 * Created by Faisal on 9/27/2016.
 */
public class mobiles {


    private String ID,QUANTITY,NAME,PRICE,IMAGE;
    private int RES;

    public mobiles(String id, String name, String price, String quantity, String image) {

        this.setID(id);
        this.setNAME(name);
        this.setPRICE(price);
        this.setQUANTITY(quantity);
        this.setIMAGE(image);

    }

    public mobiles(String id, String name, String price, String quantity, String image, int imageResource) {

        this.setID(id);
        this.setNAME(name);
        this.setPRICE(price);
        this.setQUANTITY(quantity);
        this.setIMAGE(image);
this.setRES(imageResource);
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(String QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getIMAGE() {
        return IMAGE;
    }

    public void setIMAGE(String IMAGE) {
        this.IMAGE = IMAGE;
    }

    public int getRES() {
        return RES;
    }

    public void setRES(int RES) {
        this.RES = RES;
    }
}
