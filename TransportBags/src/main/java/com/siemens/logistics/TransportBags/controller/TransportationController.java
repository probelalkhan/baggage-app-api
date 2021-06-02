package com.siemens.logistics.TransportBags.controller;

import com.siemens.logistics.TransportBags.model.api_models.bags.BagsResponse;
import com.siemens.logistics.TransportBags.model.api_models.bags.GetBagsData;
import com.siemens.logistics.TransportBags.model.api_models.bsm.BSMResponse;
import com.siemens.logistics.TransportBags.model.api_models.bsm.getBsmData;
import com.siemens.logistics.TransportBags.model.api_models.fblb.FBLBResponse;
import com.siemens.logistics.TransportBags.model.api_models.fblb.GetFBLBData;
import com.siemens.logistics.TransportBags.model.table_models.BAG_BAGS;
import com.siemens.logistics.TransportBags.model.table_models.bsm;
import com.siemens.logistics.TransportBags.model.table_models.FBLB;
import com.siemens.logistics.TransportBags.services.BagsService;
import com.siemens.logistics.TransportBags.services.FBLBService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import com.siemens.logistics.TransportBags.services.SampleService;

import java.util.List;

@RestController
@RequestMapping("/transportation")
public class TransportationController {

    @Autowired
    BagsService bagService;

    @Autowired
    FBLBService fblbService;

    private static Logger logger = LogManager.getLogger(TransportationController.class);


    @GetMapping("/getAllBags")
    public BagsResponse gettingBags() {
        logger.info("Get bags sample details request received");
        List<BAG_BAGS> bagsList = bagService.getAllBags();
        GetBagsData data = new GetBagsData(bagsList);
        logger.info(data);
        return new BagsResponse(true, 200, 0, "Success", data);
    }

    /*@GetMapping("/AllBags/{tagid}/{gid}/{start}/{end}")
    public BagsResponse gettingBagsbyParam(@PathVariable(value = "tagid") String tagid,@PathVariable(value = "gid") String gid, @PathVariable(value = "start") String start,@PathVariable(value = "end") String end)
    {
        logger.info("Get bags sample details request received");
        List<BAG_BAGS> bagsList = bagService.getBagsbybagidAndDates(tagid,gid,start,end);
        GetBagsData data = new GetBagsData(bagsList);
        logger.info(data);
        return new BagsResponse(true, 200, 0, "Success", data);
    }

    @GetMapping("/BagsById/{tagid}/{gid}/{start}/{end}")
    public BagsResponse gettingBagsbyId(@PathVariable(value = "tagid") String tagid,@PathVariable(value = "gid") String gid,@PathVariable(value = "start") String start,@PathVariable(value = "end") String end)
    {
        logger.info("Get bags sample details request received");
        List<BAG_BAGS> bagsList = bagService.getBagsbybagid(tagid,gid,start,end);
        GetBagsData data = new GetBagsData(bagsList);
        logger.info(data);
        return new BagsResponse(true, 200, 0, "Success", data);
    }
    */

    @PostMapping("/AllBags")
    public BagsResponse gettingBagsbyParamPost(@RequestParam(name = "tagid") String tagid,@RequestParam(name = "gid") String gid, @RequestParam(name = "start") String start,@RequestParam(name = "end") String end) {
        logger.info("Get bags sample details request received");
        logger.info(end);
        List<BAG_BAGS> bagsList = bagService.getBagsbybagidAndDates(tagid, gid, start, end);
        GetBagsData data = new GetBagsData(bagsList);
        logger.info(data);
        return new BagsResponse(true, 200, 0, "Success", data);
    }

    @PostMapping("/BagsById")
    public BSMResponse gettingBagsbyId(@RequestParam(name = "tagid") String tagid, @RequestParam(name = "gid") String gid, @RequestParam(name = "start") String start, @RequestParam(name = "end") String end)
    {
        logger.info("Get bags sample details request received");
        List<BAG_BAGS> bagsList = bagService.getBagsbybagid(tagid,gid,start,end);
        GetBagsData data = new GetBagsData(bagsList);
        logger.info(data);
        return new BSMResponse(true, 200, 0, "Success", data);
    }

    @PostMapping("/allFBLB")
    public FBLBResponse fblb() {
        List<FBLB> fblblist = fblbService.getALLFBLB();
        GetFBLBData data = new GetFBLBData(fblblist);
        return new FBLBResponse(true, 200, 0, "Success", data);
    }

    @PostMapping("/allBSM")
    public BSMResponse bsm() {
        List<bsm> bsmlist = fblbService.getALLBSM();
        getBsmData data = new getBsmData(bsmlist);
        return new BSMResponse(true, 200, 0, "Success", data);
    }

}
