package javacamp.hrms.api.controllers;

import javacamp.hrms.business.abstracts.PositionService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/positions")
public class PositionsController {

    private PositionService positionService;

    @Autowired
    public PositionsController(PositionService positionService) {
        this.positionService = positionService;
    }


    @GetMapping( "/getAllPositions")
    public DataResult<List<Position>> getAll(){
        return positionService.getall();
    }

    @PostMapping("/addPosition")
    public Result add(@Valid @RequestBody Position position){
        return this.positionService.add(position);
    }

    @GetMapping("/getByPositionId")
    public DataResult<Position> getById(int id){
        return this.positionService.getByPositionId(id);
    }
}
