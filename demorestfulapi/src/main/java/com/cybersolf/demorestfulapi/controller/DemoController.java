package com.cybersolf.demorestfulapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demorestful")
//ResponseEntity: cho phep can thiep status code
/**
 * Cac loai truyen tham so
 *  -Truyen truc tiep tren trinh duyet: GET
 *      cu phap: @RequestParam("tenthamso") kieudulieu biendaidien
 *      vi du: ?tenthamso=giatri
 *  -Truyen ngam:
 *     +urlcode:
 *       cu phap: @RequestParam("tenthamso") kieudulieu biendaidien
 *     +json:
 *       cu phap: @RequestBody doituong/listdoituong
 *  -Tham so dong vai tro nhu mot duong dan
 *       cu phap: @PathVariable("tenthamso") kieudulieu bi
 */
public class DemoController {
    @GetMapping
    public ResponseEntity<?> demoAdd(@RequestParam String username){
        return new ResponseEntity<>("hello "+username, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PostMapping
    public String postDemo(){
        return "post demo";
    }
    @PutMapping
    public String putDemo(){
        return "put demo";
    }
    @DeleteMapping
    public String deleteDemo(){
        return "delete demo";
    }
}
