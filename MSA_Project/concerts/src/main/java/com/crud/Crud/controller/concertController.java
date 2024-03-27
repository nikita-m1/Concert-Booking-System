package com.crud.Crud.controller;

import com.crud.Crud.DTO.ConcertDTO;
import com.crud.Crud.service.concertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/display")
public class concertController {

    @Autowired
    private concertService concertService;

    @GetMapping
    public List<String> findAllConcerts() {
        return concertService.getConcerts();
    }

    @GetMapping("/{cid}")
    public List<String> findConcertById(@PathVariable("cid") String cid) {
        return concertService.getConcertById(cid);
    }

    @PutMapping("/{cid}/{Tickets}")
    public ResponseEntity<String> updateConcert(@PathVariable("cid") String cid,
                                                @PathVariable("Tickets") int Tickets) {
        ConcertDTO updatedConcertDTO = concertService.updateConcert(cid, Tickets);
        if (updatedConcertDTO != null) {
            return ResponseEntity.ok("Concert updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
