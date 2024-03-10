package com.example.lab5_q3.Controller;
import com.example.lab5_q3.API.ApiResponse;
import com.example.lab5_q3.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    ArrayList<Event> events = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Event> getEvents(){
        return events ;
    }


    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event){

        events.add(event);

        return new ApiResponse("added");
    }


    @PutMapping("/update/{index}")
    public ApiResponse updateEvent(@RequestBody Event event , @PathVariable int index){

        events.set(index , event);

        return new ApiResponse("updated");
    }


    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent (@PathVariable int index){

        events.remove(index);

        return new ApiResponse("delete");
    }


    @PutMapping("/change/{Cap}")
    public ApiResponse changeCap(@PathVariable int Cap){

        for (Event event : events){
            event.setCapacity(Cap);
        }

        return new ApiResponse("Changed");
    }



    @GetMapping("/search/{Id}")
    public ArrayList<Event> searchID(@PathVariable String Id){
        ArrayList<Event> searchByID = new ArrayList<>();

        for (Event event : events){
           if( event.getID().contains(Id)){
            searchByID.add(event);
        }}

        return searchByID;

    }


}
