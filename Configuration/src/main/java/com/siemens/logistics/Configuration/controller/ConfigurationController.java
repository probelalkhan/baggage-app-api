package com.siemens.logistics.Configuration.controller;

import com.siemens.logistics.Configuration.model.api_models.*;
import com.siemens.logistics.Configuration.model.api_models.airport.AirportResponse;
import com.siemens.logistics.Configuration.model.api_models.airport.GetAirportData;
import com.siemens.logistics.Configuration.model.api_models.carrier.CarrierResponse;
import com.siemens.logistics.Configuration.model.api_models.carrier.GetCarrierData;
import com.siemens.logistics.Configuration.model.api_models.country.CountryResponse;
import com.siemens.logistics.Configuration.model.api_models.country.GetCountryData;
import com.siemens.logistics.Configuration.model.table_models.airports;
import com.siemens.logistics.Configuration.model.table_models.carrier;
import com.siemens.logistics.Configuration.model.table_models.countries;
import com.siemens.logistics.Configuration.services.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@RestController
@RequestMapping("/config")
public class ConfigurationController {

    @Autowired
    CountryService countryService;

    @Autowired
    AirportService airportService;

    @Autowired
    CarrierService carrierService;

    private static Logger logger = LogManager.getLogger(ConfigurationController.class);

    @PostMapping("/allCountries")
    public CountryResponse countries() {
        List<countries> samplelist = countryService.getAllCountries();
        GetCountryData data = new GetCountryData(samplelist);
        logger.info(data);
        return new CountryResponse(true, 200, 0, "Success", data);
    }

    @PostMapping("/allAirports")
    public AirportResponse airports() {
        logger.info("Airports method reached.");
        List<airports> samplelist = airportService.getAllAirports();

        logger.info("Now printing list.");

        logger.info(samplelist);

        logger.info("List printed.");
        GetAirportData data = new GetAirportData(samplelist);
        logger.info(data);
        return new AirportResponse(true, 200, 0, "Success", data);
    }

    @PostMapping("/temp")
    public void temp() {
        System.out.println("Reaching here");
    }

    @PostMapping("/allCarriers")
    public CarrierResponse carriers() {
        List<carrier> carrierlist = carrierService.getAllCarriers();
        GetCarrierData data = new GetCarrierData(carrierlist);
        return new CarrierResponse(true, 200, 0, "Success", data);
    }

    @RequestMapping(value = "/ExportPDF", method = RequestMethod.POST)
    public ReportResponse generatePdfReport(@RequestParam(name = "data")String data, @RequestParam(name = "reportName")String reportName, @RequestParam(name = "parameters")String parameters)  {
        System.out.println("Generate PDF Report Method " +reportName);
        System.out.println("Generate PDF Report Method " +parameters);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        String path="\\CRC_Reports\\Configuration\\";
        String templateDIR = "C:\\Users\\khantoob\\JaspersoftWorkspace\\Goa_CRC"+path;
        String exportDIR = "C:\\Users\\khantoob\\JaspersoftWorkspace\\Goa_CRC"+path+"\\Reports\\";
        String tableData = data;
        String report =reportName;
        String params =	parameters;
        System.out.println("data : "+tableData);


        String printFileName = null;
        BeanList DataBeanList = new BeanList();
        @SuppressWarnings("unchecked")

        Map parameter = new HashMap();
        if(!params.isEmpty()|| params.length() > 0 || !params.equalsIgnoreCase("")) {
            params = params.replace("[","");
            params = params.replace("}]", "");
            params = params.replace("{", "");
            params = params.replace("\"","");
            params = params.replace("null","");
            System.out.println(params);

            String[] rows = params.split("},");
            for(int i=0;i<rows.length;i++) {
                String[] param = rows[i].split(":",2);
                parameter.put(param[0],param[1]);
                System.out.println(param[0]+" "+param[1]);
            }
        }

        JRBeanCollectionDataSource beanColDataSource;
        String moduleName="";
        String sourceFileName="";

        if(reportName.contains("AirportReport")) {
            moduleName = "Airport";
            sourceFileName = templateDIR + "\\" + moduleName + ".jasper";
            System.out.println("Jasper file : " + sourceFileName);
            ArrayList<AirportDataBean> dataList = (ArrayList<AirportDataBean>) DataBeanList.getDataBeanList(tableData, reportName);
            beanColDataSource = new JRBeanCollectionDataSource(dataList);
            System.out.println("It contains");
        }
        else if(reportName.contains("CountryReport")){
            moduleName = "Countries";
            sourceFileName = templateDIR + "\\" + moduleName + ".jasper";
            System.out.println("Jasper file : " + sourceFileName);
            ArrayList<CountriesDataBean> dataList = (ArrayList<CountriesDataBean>) DataBeanList.getCountryBeanList(tableData, reportName);
            beanColDataSource = new JRBeanCollectionDataSource(dataList);
            System.out.println("It contains Country");
        }
        else{
            ArrayList<AirportDataBean> dataList = (ArrayList<AirportDataBean>) DataBeanList.getDataBeanList(tableData, reportName);
            beanColDataSource = new JRBeanCollectionDataSource(dataList);
        }

        try {
            printFileName = JasperFillManager.fillReportToFile(sourceFileName, parameter, beanColDataSource);
            if (printFileName != null) {
                /**
                 * 1- export to PDF
                 */
                JasperExportManager.exportReportToPdfFile(printFileName,
                        exportDIR + reportName+".pdf");
                System.out.println("File saved at "+exportDIR+reportName+".pdf");

            }
        } catch (JRException e) {
            e.printStackTrace();
            System.out.println("Error is: "+e.getMessage());
            return new ReportResponse(true, 200, 0, "Error", e.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error is: "+e.getMessage());
            return new ReportResponse(true, 200, 0, "Error", e.toString());
        }
        return new ReportResponse(true, 200, 0, "Success", "Download Successful.");
    }

    @RequestMapping(value = "/ExportXL", method = RequestMethod.POST)
    public ReportResponse generateXLReport(@RequestParam(name = "data")String data, @RequestParam(name = "reportName")String reportName, @RequestParam(name = "parameters")String parameters)  {
        System.out.println("Generate XL Report Method " +reportName);
        System.out.println("Generate XL Report Method " +parameters);
        String path="\\CRC_Reports\\Configuration\\";
        String templateDIR = "C:\\Users\\khantoob\\JaspersoftWorkspace\\Goa_CRC"+path;
        String exportDIR = "C:\\Users\\khantoob\\JaspersoftWorkspace\\Goa_CRC"+path+"\\Reports\\";
        String tableData = data;
        String report =reportName;
        String params =		parameters;
        String sourceFileName = "";
        System.out.println("data : "+tableData);
        System.out.println("Jasper file : "+sourceFileName);
        BeanList DataBeanList = new BeanList();

        params.replaceAll("null","");
        Map parameter = new HashMap();
        if(!params.isEmpty()|| params.length() > 0 || !params.equalsIgnoreCase("")) {
            params = params.replace("[","");
            params = params.replace("}]", "");
            params = params.replace("{", "");
            params = params.replace("\"","");

            String[] rows = params.split("},");
            for(int i=0;i<rows.length;i++) {
                String[] param = rows[i].split(":",2);
                parameter.put(param[0],(param[1].compareTo("null")==0)?"":param[1]);
                System.out.println(param[0]+" "+param[1]);
            }
        }

        JRBeanCollectionDataSource beanColDataSource;
        String moduleName="";

        if(reportName.contains("AirportReport")) {
            moduleName = "Airport";
            sourceFileName = templateDIR + "\\" + moduleName + ".jasper";
            System.out.println("Jasper file : " + sourceFileName);
            ArrayList<AirportDataBean> dataList = (ArrayList<AirportDataBean>) DataBeanList.getDataBeanList(tableData, reportName);
            beanColDataSource = new JRBeanCollectionDataSource(dataList);
            System.out.println("It contains airport");
        }
        else
        {
            moduleName = "Countries";
            sourceFileName = templateDIR + "\\" + moduleName + ".jasper";
            System.out.println("Jasper file : " + sourceFileName);
            ArrayList<CountriesDataBean> dataList = (ArrayList<CountriesDataBean>) DataBeanList.getCountryBeanList(tableData, reportName);
            beanColDataSource = new JRBeanCollectionDataSource(dataList);
            System.out.println("It contains Countries");
        }
        try {
            JasperFillManager.fillReportToFile(sourceFileName, templateDIR +"\\Reports\\"
                    + moduleName + ".jrprint", parameter, beanColDataSource);

            File file = new File(templateDIR +"\\Reports\\" + moduleName
                    + ".jrprint");
            // System.out.println(REPORT_DIRECTORY + "/" + reportName + ".jrprint");

            JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(file);
            JRXlsxExporter xlsExporter = new JRXlsxExporter();
            xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            xlsExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
                    exportDIR + reportName + ".xlsx");
            xlsExporter.exportReport();
            System.out.println("File saved at "+exportDIR + reportName + ".xlsx");
        } catch (JRException e) {
            e.printStackTrace();
            //System.out.println(e.toString());
            //System.out.println("Error "+e.getLocalizedMessage());
            return new ReportResponse(true, 200, 0, "Error", e.toString());
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Error "+e.getLocalizedMessage());
            return new ReportResponse(true, 200, 0, "Error", e.toString());
        }
        return new ReportResponse(true, 200, 0, "Error", "Download Successful.");

    }

}
