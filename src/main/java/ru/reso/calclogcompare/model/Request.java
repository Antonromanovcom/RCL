package ru.reso.calclogcompare.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Request {

    /*@Getter
    @Setter
    private LinkedHashMap<String, ComparedParam> hash;*/
    @Getter
    @Setter
    private ArrayList<ComparedParam> compareList;

    @Getter
    @Setter
    long elapsedTime;


    public Request(LinkedHashMap<String, ComparedParam> hash, long elapsedTime) {

        compareList = new ArrayList<>();

        for(String name : hash.keySet()) {
           compareList.add(hash.get(name));
        }

        this.elapsedTime = elapsedTime;
    }

}
