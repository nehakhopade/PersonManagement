package com.person.mgt.service;

import com.person.mgt.entity.Vehicle;
import com.person.mgt.repository.VehicleRepository;
import com.person.mgt.request.VehicleRequest;
import com.person.mgt.response.VehicleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    public VehicleResponse createServiceVehicle(VehicleRequest vehicleRequest) {

        Vehicle vehicle = new Vehicle();
        vehicle.setPlateNo(vehicleRequest.getPlateNo());
        vehicle.setVname(vehicleRequest.getVname());
        vehicle.setCompanyName(vehicleRequest.getCompanyName());
        vehicle.setPrice(vehicleRequest.getPrice());
        Vehicle vehicle1 = vehicleRepository.save(vehicle);
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setId(vehicle1.getId());
        return vehicleResponse;
    }

    public VehicleResponse getServiceVahicle(Long Id){

        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(Id);
        Vehicle vehicle = optionalVehicle.get();
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setId(vehicle.getId());
        vehicleResponse.setPlateNo(vehicle.getPlateNo());
        vehicleResponse.setVname(vehicle.getVname());
        vehicleResponse.setCompanyName(vehicle.getCompanyName());
        vehicleResponse.setPrice(vehicle.getPrice());
        return vehicleResponse;
    }

    public VehicleResponse removeServiceVehicle(Long Id){

        vehicleRepository.deleteById(Id);
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setMessage("Id is deleted");
        return vehicleResponse;
    }

    public List<VehicleResponse> getAllServiceVehicle(){
        Iterable<Vehicle> iterable = vehicleRepository.findAll();
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle vehicle:iterable)
        {
            result.add(vehicle);
        }
        List<VehicleResponse> vehicleResponseList = new ArrayList<>();
        for(Vehicle vehicle:result)
        {
            VehicleResponse vehicleResponse = new VehicleResponse();
            vehicleResponse.setId(vehicle.getId());
            vehicleResponse.setVname(vehicle.getVname());
            vehicleResponse.setCompanyName(vehicle.getCompanyName());
            vehicleResponse.setPrice(vehicle.getPrice());
            vehicleResponseList.add(vehicleResponse);
        }
        return vehicleResponseList;

    }
}