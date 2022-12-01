package icc.core.tabtest.model;


import java.util.Arrays;
import java.util.List;

public class Category{
    // フィールド
    private final String name;
    private final List<Item> listOfItems;
    //コンストラクタ
    public Category(String name, Item ... item){
        this.name = name;
        this.listOfItems = Arrays.asList(item);
    }
    // setter getter
    public String getName() { return name; }
    // public void setName(String name) { this.name = name;}

    // public void setListOfItems(List<Item> listOfItems) { this.listOfItems = listOfItems;}
    public List<Item> getListOfItems() { return listOfItems;}

}