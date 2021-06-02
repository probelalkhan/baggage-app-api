package com.siemens.logistics.flights.controller;

import com.siemens.logistics.flights.model.FlightAllocationModel;
import com.siemens.logistics.flights.model.FlightsInfoModel;
import com.siemens.logistics.flights.model.MucModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

@RequestMapping("/flights")
@RestController
public class FlightController {

    private static Logger logger = LogManager.getLogger(FlightController.class);

    private static List<FlightsInfoModel> flightsInfoList;

    @Autowired
    private static Map<String, FlightAllocationModel> mapTask;

    @PostConstruct
    public void loadTasks() {
        mapTask = new HashMap<>();

        mapTask.put("1", new FlightAllocationModel("1", "MUC 01", "", "", 0, "project", "0", "", "", "", ""));
        mapTask.put("2", new FlightAllocationModel("2", "MUC 02", "", "", 0, "project", "0", "", "", "", ""));
        mapTask.put("3", new FlightAllocationModel("3", "MUC 03", "", "", 0, "project", "0", "", "", "", ""));

        mapTask.put("11", new FlightAllocationModel("11", "Flight 11", "11-01-2021 15:45", "11-01-2021 17:45", 2, "task", "1", "AI-11", "AI", "11-01-2021 19:00", "11-01-2021 19:00"));
        mapTask.put("12", new FlightAllocationModel("12", "Flight 12", "11-01-2021 05:45", "11-01-2021 07:45", 2, "task", "1", "AI-12", "AI", "11-01-2021 10:45", "11-01-2021 10:45"));
        mapTask.put("13", new FlightAllocationModel("13", "Flight 13", "11-01-2021 23:40", "12-01-2021 01:40", 3, "task", "1", "AI-13", "AI", "12-01-2021 04:15", "12-01-2021 04:15"));

        mapTask.put("21", new FlightAllocationModel("21", "Flight 21", "11-01-2021 19:15", "11-01-2021 20:15", 1, "task", "2", "AI-21", "AI", "11-01-2021 23:05", "11-01-2021 23:05"));
        mapTask.put("22", new FlightAllocationModel("22", "Flight 22", "11-01-2021 08:00", "11-01-2021 10:00", 2, "task", "2", "6E-222", "6E", "11-01-2021 13:10", "11-01-2021 13:10"));
        mapTask.put("23", new FlightAllocationModel("23", "Flight XX", "11-01-2021 00:35", "11-01-2021 02:35", 2, "task", "2", "AI-23", "AI", "11-01-2021 05:30", "11-01-2021 05:30"));

        mapTask.put("31", new FlightAllocationModel("31", "Flight 31", "11-01-2021 09:45", "11-01-2021 11:45", 2, "task", "3", "AI-31", "AI", "11-01-2021 14:20", "11-01-2021 14:20"));
        mapTask.put("32", new FlightAllocationModel("32", "Flight 32", "11-01-2021 12:10", "11-01-2021 14:40", 2, "task", "3", "GA-032", "GA", "11-01-2021 16:25", "11-01-2021 16:25"));
        mapTask.put("33", new FlightAllocationModel("33", "Flight 33", "11-01-2021 22:20", "12-01-2021 03:20", 5, "task", "3", "AI-33", "AI", "12-01-2021 07:35", "12-01-2021 07:35"));

        mapTask.put("34", new FlightAllocationModel("34", "Flight 34", "11-01-2021 09:45", "11-08-2020 11:45", 2, "task", "3", "AI-31", "AI", "11-01-2021 15:40", "11-01-2021 15:40"));
        mapTask.put("35", new FlightAllocationModel("35", "Flight 35", "11-01-2021 12:10", "11-08-2020 14:40", 2, "task", "3", "GA-032", "GA", "11-01-2021 17:45", "11-01-2021 17:45"));
        mapTask.put("36", new FlightAllocationModel("36", "Flight 36", "11-01-2021 22:20", "11-08-2020 03:20", 5, "task", "3", "AI-33", "AI", "11-01-2021 05:50", "11-01-2021 05:50"));

        flightsInfoList = new ArrayList<>();
        flightsInfoList.add(new FlightsInfoModel("AI", "101", "15/01/2021 17:00", "15/01/2021 17:00",
                "15/01/2021 17:00", "SCHEDULED", "NZ", "", "", "2",
                "", "1A", "", "", "", "HOST", "15/01/2021 01:00"));
        flightsInfoList.add(new FlightsInfoModel("AI", "101", "15/01/2021 17:00", "15/01/2021 17:00",
                "15/01/2021 17:00", "SCHEDULED", "NZ", "", "", "2",
                "", "1A", "", "", "", "HOST", "15/01/2021 01:00"));
        flightsInfoList.add(new FlightsInfoModel("AI", "101", "15/01/2021 17:00", "15/01/2021 17:00",
                "15/01/2021 17:00", "SCHEDULED", "NZ", "", "", "2",
                "", "1A", "", "", "", "HOST", "15/01/2021 01:00"));
        flightsInfoList.add(new FlightsInfoModel("AI", "101", "15/01/2021 17:00", "15/01/2021 17:00",
                "15/01/2021 17:00", "SCHEDULED", "NZ", "", "", "2",
                "", "1A", "", "", "", "HOST", "15/01/2021 01:00"));
        flightsInfoList.add(new FlightsInfoModel("AI", "101", "15/01/2021 17:00", "15/01/2021 17:00",
                "15/01/2021 17:00", "SCHEDULED", "NZ", "", "", "2",
                "", "1A", "", "", "", "HOST", "15/01/2021 01:00"));
        flightsInfoList.add(new FlightsInfoModel("AI", "101", "15/01/2021 17:00", "15/01/2021 17:00",
                "15/01/2021 17:00", "SCHEDULED", "NZ", "", "", "2",
                "", "1A", "", "", "", "HOST", "15/01/2021 01:00"));
        flightsInfoList.add(new FlightsInfoModel("AI", "101", "15/01/2021 17:00", "15/01/2021 17:00",
                "15/01/2021 17:00", "SCHEDULED", "NZ", "", "", "2",
                "", "1A", "", "", "", "HOST", "15/01/2021 01:00"));
        flightsInfoList.add(new FlightsInfoModel("AI", "101", "15/01/2021 17:00", "15/01/2021 17:00",
                "15/01/2021 17:00", "SCHEDULED", "NZ", "", "", "2",
                "", "1A", "", "", "", "HOST", "15/01/2021 01:00"));
        flightsInfoList.add(new FlightsInfoModel("AI", "101", "15/01/2021 17:00", "15/01/2021 17:00",
                "15/01/2021 17:00", "SCHEDULED", "NZ", "", "", "2",
                "", "1A", "", "", "", "HOST", "15/01/2021 01:00"));
        flightsInfoList.add(new FlightsInfoModel("AI", "101", "15/01/2021 17:00", "15/01/2021 17:00",
                "15/01/2021 17:00", "SCHEDULED", "NZ", "", "", "2",
                "", "1A", "", "", "", "HOST", "15/01/2021 01:00"));
        flightsInfoList.add(new FlightsInfoModel("AI", "101", "15/01/2021 17:00", "15/01/2021 17:00",
                "15/01/2021 17:00", "SCHEDULED", "NZ", "", "", "2",
                "", "1A", "", "", "", "HOST", "15/01/2021 01:00"));
        flightsInfoList.add(new FlightsInfoModel("AI", "101", "15/01/2021 17:00", "15/01/2021 17:00",
                "15/01/2021 17:00", "SCHEDULED", "NZ", "", "", "2",
                "", "1A", "", "", "", "HOST", "15/01/2021 01:00"));
    }

    @GetMapping("/getMuc")
    public List<MucModel> getMUC() {
        logger.info("Get all MUCs");

        List<MucModel> mucModels = Arrays.asList(
                new MucModel("1", "MUC 01"),
                new MucModel("2", "MUC 02"),
                new MucModel("3", "MUC 03")
        );
        logger.info("Returning List of MUc: "+mucModels);
        return mucModels;
    }

    @PostMapping("/getAllocation")
    public FlightAllocationModel[] getAllocation(@RequestBody FlightAllocationModel[] tasks) {
        System.out.println("Task List: "+Arrays.toString(tasks));

        for(FlightAllocationModel task: tasks) {
            mapTask.replace(task.getId(), task);
        }

        List<FlightAllocationModel> taskList = new ArrayList<FlightAllocationModel>();

        for(FlightAllocationModel model: mapTask.values()) {
            taskList.add(model);
        }
        System.out.println("Updated List: "+taskList.toString());
        return tasks;
    }

    @GetMapping("/getAllocation")
    public List<FlightAllocationModel> getAllocation(){
        System.out.println("req: ");
        List<FlightAllocationModel> taskList = new ArrayList<>();
        for(FlightAllocationModel model: mapTask.values()) {
            taskList.add(model);
        }
        return taskList;
    }

    @GetMapping("/info")
    public List<FlightsInfoModel> getFlightsInfoList(){
        System.out.println("Client Req: getFlightsInfoList() ");
        return flightsInfoList;
    }
}
