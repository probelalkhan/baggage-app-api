package com.siemens.logistics.Configuration.services;

import java.util.HashMap;
import java.util.Hashtable;

public class AirportDataBean {

    String airportCode;
    String countryCode;
    String name;
    String description;
    String ishome;
    String hbsDefaultIn;
    String hbsDefaultOut;
    String custDefaultIn;
    String custDefaultOut;
    String status;
    String descr;
    String eventTime;

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIshome() {
        return ishome;
    }

    public void setIshome(String ishome) {
        this.ishome = ishome;
    }

    public String getHbsDefaultIn() {
        return hbsDefaultIn;
    }

    public void setHbsDefaultIn(String hbsDefaultIn) {
        this.hbsDefaultIn = hbsDefaultIn;
    }

    public String getHbsDefaultOut() {
        return hbsDefaultOut;
    }

    public void setHbsDefaultOut(String hbsDefaultOut) {
        this.hbsDefaultOut = hbsDefaultOut;
    }

    public String getCustDefaultIn() {
        return custDefaultIn;
    }

    public void setCustDefaultIn(String custDefaultIn) {
        this.custDefaultIn = custDefaultIn;
    }

    public String getCustDefaultOut() {
        return custDefaultOut;
    }

    public void setCustDefaultOut(String custDefaultOut) {
        this.custDefaultOut = custDefaultOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public AirportDataBean(String values) {

        HashMap<String, String> my_dict = new HashMap<String, String>();
        System.out.println(values);
        values = values.replace("\"", "");
        values = values.replace("{", "");
        values = values.replace("[{", "");
        values = values.replace("}]", "");
        String[] valueList = values.split(",");
        for(int i=0;i< valueList.length;i++){
            String t1=valueList[i];
            int index=t1.indexOf(':');
            my_dict.put(t1.substring(0,index),t1.substring(index+1,t1.length()));
        }
        setAirportCode(my_dict.get("airportCode"));
        setCountryCode(my_dict.get("countryCode"));
        setDescr(my_dict.get("descr"));
        setCustDefaultIn(my_dict.get("custDefaultIn"));
        setCustDefaultOut(my_dict.get("custDefaultOut"));
        setEventTime(my_dict.get("eventTime"));
        setHbsDefaultIn(my_dict.get("hbsDefaultIn"));
        setHbsDefaultOut(my_dict.get("hbsDefaultOut"));
        setIshome(my_dict.get("ishome"));
        setName(my_dict.get("name"));
        setStatus(my_dict.get("status"));
        setDescription(my_dict.get("description"));
    }
}