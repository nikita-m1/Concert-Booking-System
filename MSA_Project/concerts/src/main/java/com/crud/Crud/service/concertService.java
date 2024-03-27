package com.crud.Crud.service;

import com.crud.Crud.DTO.ConcertDTO;
import com.crud.Crud.entity.concert;
import com.crud.Crud.repository.concertRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class concertService {

    @Autowired
    private concertRepository concertRepository;

    public List<String> getConcerts() {
        List<concert> concerts = concertRepository.findAll();
        List<String> concerts_string = new ArrayList<>();
        for(int i =0;i<concerts.size();i++){
            concerts_string.add(concerts.get(i).toString());
        }
        return concerts_string;
    }

    public List<String> getConcertById(String cid) {
        Optional<concert> optionalConcert = concertRepository.findById(cid);
        List<String> concerts_string1 = new ArrayList<>();
        concerts_string1.add(optionalConcert.toString());
        return concerts_string1;
    }

    public ConcertDTO updateConcert(String cid, int Tickets) {
        concert existingConcert = concertRepository.findById(cid).orElse(null);
        if (existingConcert != null) {
            // Update properties
            existingConcert.setTickets_available(existingConcert.getTickets_available()-Tickets);
            // You can update other properties similarly

            concert updatedConcert = concertRepository.save(existingConcert);
            return convertToDTO(updatedConcert);
        }
        return null;
    }


    // Helper method to convert entity to DTO
    private ConcertDTO convertToDTO(concert concert) {
        ConcertDTO concertDTO = new ConcertDTO();
        BeanUtils.copyProperties(concert, concertDTO);
        return concertDTO;
    }
}
