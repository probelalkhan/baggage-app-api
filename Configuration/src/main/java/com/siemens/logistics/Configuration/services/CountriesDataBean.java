package com.siemens.logistics.Configuration.services;

import java.util.HashMap;

public class CountriesDataBean {
    String code;
    String name;
    String regioncode;
    String isonumeric;
    String riskinbound;
    String riskoutbound;
    String iso2ALPHA;
    String iso3ALPHA;

    public String getCode() {       return code;}

    public void setCode(String code) {        this.code = code;    }

    public String getName() {        return name;    }

    public void setName(String name) {        this.name = name;    }

    public String getRegioncode() {        return regioncode;    }

    public void setRegioncode(String regioncode) {        this.regioncode = regioncode;    }

    public String getIsonumeric() {        return isonumeric;    }

    public void setIsonumeric(String isonumeric) {        this.isonumeric = isonumeric;    }

    public String getRiskinbound() {        return riskinbound;    }

    public void setRiskinbound(String riskinbound) {        this.riskinbound = riskinbound;    }

    public String getRiskoutbound() {        return riskoutbound;    }

    public void setRiskoutbound(String riskoutbound) {        this.riskoutbound = riskoutbound;    }

    public String getIso2ALPHA() {        return iso2ALPHA;    }

    public void setIso2ALPHA(String iso2ALPHA) {        this.iso2ALPHA = iso2ALPHA;    }

    public String getIso3ALPHA() {        return iso3ALPHA;    }

    public void setIso3ALPHA(String iso3ALPHA) {        this.iso3ALPHA = iso3ALPHA;    }

    public CountriesDataBean(String values) {

        HashMap<String, String> my_dict = new HashMap<String, String>();
        System.out.println(values);
        values = values.replace("\"", "");
        values = values.replace("{", "");
        values = values.replace("[{", "");
        values = values.replace("}]", "");
        String[] valueList = values.split(",");
        //airport code
        for(int i=0;i<valueList.length;i++){
            String t1=valueList[i];
            String[] t2=t1.split(":");
            System.out.println(t2[0]+"\t"+t2[1]);
            my_dict.put(t2[0],t2[1]);
        }

        System.out.println(my_dict);
        setCode(my_dict.get("code"));
        setName(my_dict.get("name"));
        setRegioncode(my_dict.get("regioncode"));
        setIsonumeric(my_dict.get("isonumeric"));
        setRiskinbound(my_dict.get("riskinbound"));
        setRiskoutbound(my_dict.get("riskoutbound"));
        setIso2ALPHA(my_dict.get("iso2ALPHA"));
        setIso3ALPHA(my_dict.get("iso3ALPHA"));

    }
}
