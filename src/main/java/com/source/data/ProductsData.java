package com.source.data;

import java.util.LinkedHashMap;

public class ProductsData {
    public static LinkedHashMap<String, String> getPriceFilterData() {
        LinkedHashMap<String, String> mapData = new LinkedHashMap<String, String>();
        mapData.clear();
        mapData.put("nameAscending", "Name (A to Z)");
        mapData.put("nameDescending", "Name (Z to A)");
        mapData.put("priceAscending", "Price (low to high)");
        mapData.put("priceDescending", "Price (high to low)");
        return mapData;
    }
}
