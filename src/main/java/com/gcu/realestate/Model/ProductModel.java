package com.gcu.realestate.Model;

public class ProductModel {
    
    String nameOfProperty = "";
    String location = "";
    String dateOfConstruction = "";
    String photoFileName = "";
    String description = "";
    double value = 0.0;
    int squareFeet = 0;
    int numBaths = 0;
    int numBRooms = 0;
    Long id = 0L;

    public ProductModel(String nameOfProperty, String location, String dateOfConstruction, String photoFileName,
            String description, double value, int squareFeet, int numBaths, int numBRooms, Long id) {
        this.nameOfProperty = nameOfProperty;
        this.location = location;
        this.dateOfConstruction = dateOfConstruction;
        this.photoFileName = photoFileName;
        this.description = description;
        this.value = value;
        this.squareFeet = squareFeet;
        this.numBaths = numBaths;
        this.numBRooms = numBRooms;
        this.id = id;
    }
    public String getNameOfProperty() {
        return nameOfProperty;
    }
    public void setNameOfProperty(String nameOfProperty) {
        this.nameOfProperty = nameOfProperty;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDateOfConstruction() {
        return dateOfConstruction;
    }
    public void setDateOfConstruction(String dateOfConstruction) {
        this.dateOfConstruction = dateOfConstruction;
    }
    public String getPhotoFileName() {
        return photoFileName;
    }
    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public int getSquareFeet() {
        return squareFeet;
    }
    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }
    public int getNumBaths() {
        return numBaths;
    }
    public void setNumBaths(int numBaths) {
        this.numBaths = numBaths;
    }
    public int getNumBRooms() {
        return numBRooms;
    }
    public void setNumBRooms(int numBRooms) {
        this.numBRooms = numBRooms;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "ProductsModel [nameOfProperty=" + nameOfProperty + ", location=" + location + ", dateOfConstruction="
                + dateOfConstruction + ", photoFileName=" + photoFileName + ", description=" + description + ", value="
                + value + ", squareFeet=" + squareFeet + ", numBaths=" + numBaths + ", numBRooms=" + numBRooms + ", id="
                + id + "]";
    }

    

}
