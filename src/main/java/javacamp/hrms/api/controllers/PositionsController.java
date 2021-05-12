package javacamp.hrms.api.controllers;

import javacamp.hrms.business.abstracts.PositionService;
import javacamp.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/api/positions")
public class PositionsController {

    private PositionService positionService;

    @Autowired
    public PositionsController(PositionService positionService) {
        this.positionService = positionService;
    }


    @GetMapping("/getall")
    public List<Position> getAll(){
        return positionService.getall();
    }


}
