package com.person.mgt.controller;


import com.person.mgt.request.VehicleRequest;
import com.person.mgt.response.VehicleResponse;
import com.person.mgt.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/vehicleInfo")
public class VehicleController {

    @Autowired
   private VehicleService vehicleService;

    @PostMapping("/createVehicle")
    public VehicleResponse createVehicle(@RequestBody VehicleRequest vehicleRequest){
        VehicleResponse vehicleResponse = vehicleService.createServiceVehicle(vehicleRequest);
        return vehicleResponse;
    }

    @GetMapping("/getVehicle/{Id}")
    public VehicleResponse getVehicle(@PathVariable Long Id){
        VehicleResponse vehicleResponse = vehicleService.getServiceVahicle(Id);
        return vehicleResponse;
    }

    @DeleteMapping("/deleteVehicle/{Id}")
    public VehicleResponse deleteVehicle(Long Id){
        VehicleResponse vehicleResponse = vehicleService.removeServiceVehicle(Id);
        return vehicleResponse;
    }

    @GetMapping("/getAllVehicle")
    public List<VehicleResponse> getAllVehicle(){
        List<VehicleResponse> list = vehicleService.getAllServiceVehicle();
        return list;
    }








}
