package com.siemens.logistics.Configuration.services;

import java.util.ArrayList;

public class BeanList {
    private static String report;

    public ArrayList<AirportDataBean> getDataBeanList(String jsonString, String reportName) {
        report = reportName;

        jsonString = jsonString.replace("[[","");
        jsonString = jsonString.replace("]]", "");
        jsonString = jsonString.replace("[", "");
        String[] rows;
        rows = jsonString.split("},");
        System.out.println(rows.length);
        System.out.println(jsonString.contains("}"));

        ArrayList<AirportDataBean> dataBeanListMT = new ArrayList<AirportDataBean>();
        if(jsonString.contains("}")) {
            for (int i = 0; i <= rows.length - 1; i++) {
                dataBeanListMT.add(new AirportDataBean(rows[i]));
            }
        }
        return dataBeanListMT;


    }

    public ArrayList<CountriesDataBean> getCountryBeanList(String jsonString, String reportName) {
        report = reportName;

        jsonString = jsonString.replace("[[","");
        jsonString = jsonString.replace("]]", "");
        jsonString = jsonString.replace("[", "");
        String[] rows;
        rows = jsonString.split("},");
        System.out.println(rows.length);
        System.out.println(jsonString.contains("}"));

        ArrayList<CountriesDataBean> dataBeanListMT = new ArrayList<CountriesDataBean>();
        if(jsonString.contains("}")) {
            for (int i = 0; i <= rows.length - 1; i++) {
                dataBeanListMT.add(new CountriesDataBean(rows[i]));
            }
        }
        return dataBeanListMT;
    }

}
