/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.dinemaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

import com.example.dinemaster.model.Chef;
import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.repository.ChefJpaRepository;
import com.example.dinemaster.repository.ChefRepository;
import com.example.dinemaster.repository.RestaurantJpaRepository;

@Service
public class ChefJpaService implements ChefRepository {
	@Autowired
	private ChefJpaRepository chefJpaRepository;

	@Autowired
	private RestaurantJpaRepository restaurantJpaRepository;

	@Override
	public ArrayList<Chef> getChefs() {
		List<Chef> chefList = chefJpaRepository.findAll();
		ArrayList<Chef> chefs = new ArrayList<>(chefList);
		return chefs;
	}

	@Override
	public Chef addChef(Chef chef) {
		Restaurant restaurant = chef.getRestaurant();
		int restaurantId = restaurant.getId();
		try {
			restaurant = restaurantJpaRepository.findById(restaurantId).get();
			chef.setRestaurant(restaurant);
			chefJpaRepository.save(chef);
			return chef;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Chef getChefById(int chefId) {
		try {
			Chef chef = chefJpaRepository.findById(chefId).get();
			return chef;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Chef updateChef(int chefId, Chef chef) {
		try {
			Chef newChef = chefJpaRepository.findById(chefId).get();
			if (chef.getRestaurant() != null) {
				int RestaurantId = chef.getRestaurant().getId();
				Restaurant newRestaurant = restaurantJpaRepository.findById(RestaurantId).get();
				newChef.setRestaurant(newRestaurant);
			}
			if (chef.getfirstName() != null) {
				newChef.setfirstName(chef.getfirstName());
			}
			if (chef.getlastName() != null) {
				newChef.setlastName(chef.getlastName());
			}
			if (chef.getexpertise() != null) {
				newChef.setexpertise(chef.getexpertise());
			}
			if (chef.getexperienceYears() != 0) {
				newChef.setexperienceYears(chef.getexperienceYears());
			}
			return newChef;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void deleteChef(int chefId) {
		try {
			chefJpaRepository.deleteById(chefId);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		throw new ResponseStatusException(HttpStatus.NO_CONTENT);
	}

	@Override
	public Restaurant getdetRestaurentOfChef(int chefId) {
		try {
			Chef chef = chefJpaRepository.findById(chefId).get();
			Restaurant restaurant = chef.getRestaurant();
			return restaurant;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}
