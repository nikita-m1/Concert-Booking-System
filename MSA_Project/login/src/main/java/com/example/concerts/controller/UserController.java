package com.example.concerts.controller;

import com.example.concerts.dto.UserDTO;
import com.example.concerts.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    private UserService userService;

    private LoadBalancerClient loadBalancerClient;

    // build create User REST API

    @GetMapping()
    public ResponseEntity<String> hello() {

        return new ResponseEntity<>("Welcome to Concert Booking! Please enter your registered id and password.",HttpStatus.OK);
    }


    @GetMapping("{id}/{pass}/{cid}")
    public ResponseEntity<List<String>> getuser_show_one_concert(@PathVariable("id") Long userId,@PathVariable("pass") String pass,@PathVariable("cid") String cid) {
        boolean result = userService.getUserById(userId,pass);

        if (result==false){
            List<String> list=new ArrayList<String>();
            list.add("Error");
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        ServiceInstance instance = loadBalancerClient.choose("concerts");
        String baseUrl = instance.getUri().toString();
        List<String> microservice2Response = restTemplate.getForObject(baseUrl+"/display/"+cid, List.class);

        return new ResponseEntity<>(microservice2Response, HttpStatus.OK);
    }

    @PutMapping("/{id}/{pass}/{cid}/{num_tickets}")
    public ResponseEntity<String> updateUserBook(
            @PathVariable("id") Long userId,
            @PathVariable("pass") String pass,
            @PathVariable("cid") String cid,
            @PathVariable("num_tickets") Integer num) {

        ServiceInstance instance = loadBalancerClient.choose("concerts");
        String baseUrl = instance.getUri().toString();
        // Assuming cid and num_tickets are the parameters to be sent to microservice B
        String url = baseUrl +"/display/"+ cid + "/" + num;

        // Make the PUT request to microservice B
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, null, String.class);

        // Return the response received from microservice B
        return responseEntity;
    }


    @PostMapping("/{id}/{pass}/{cid}/{num_tickets}/confirm")
    public ResponseEntity<String> getreceipt(
            @PathVariable("id") Long userId,
            @PathVariable("cid") String cid,
            @PathVariable("num_tickets") Integer num) {

        ServiceInstance instance = loadBalancerClient.choose("payments");
        String baseUrl = instance.getUri().toString();

        // Assuming cid and num_tickets are the parameters to be sent to microservice B
        String url = baseUrl+"/payment/addPayment/" + userId + "/" + cid  + "/" + num;

        // Make the PUT request to microservice B
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, null, String.class);

        // Return the response received from microservice B
        return responseEntity;
    }

    @GetMapping("{id}/{pass}")
    public ResponseEntity<List<String>> getUserById(@PathVariable("id") Long userId,@PathVariable("pass") String pass) {
        boolean result = userService.getUserById(userId,pass);

        if (result==false){
            List<String> list=new ArrayList<String>();
            list.add("Error");
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

//        List<String> microservice2Response = restTemplate.getForObject("http://concerts/display", List.class);
//        return new ResponseEntity<>(microservice2Response, HttpStatus.OK);
        ServiceInstance instance = loadBalancerClient.choose("concerts");
        String baseUrl = instance.getUri().toString();

        ResponseEntity<List> responseEntity = restTemplate.getForEntity(baseUrl + "/display", List.class);

        return ResponseEntity.ok(responseEntity.getBody());
    }

}