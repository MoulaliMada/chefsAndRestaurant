/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.dinemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.service.RestaurantJpaService;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantJpaService RestaurantService;

    @GetMapping("/restaurants")
    public ArrayList<Restaurant> getRestaurents() {
        return RestaurantService.getRestaurents();
    }

    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return RestaurantService.addRestaurant(restaurant);
    }

    @GetMapping("/restaurants/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable("restaurantId") int restaurantId) {
        return RestaurantService.getRestaurantById(restaurantId);
    }

    @PutMapping("/restaurants/{restaurantId}")
    public Restaurant updateRestaurant(@PathVariable("restaurantId") int restaurantId,
            @RequestBody Restaurant restaurant) {
        return RestaurantService.updateRestaurant(restaurantId, restaurant);
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public void deleteRestaurant(@PathVariable("restaurantId") int restaurantId) {
        RestaurantService.deleteRestaurant(restaurantId);
    }
}
