/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.dinemaster.repository;

import java.util.*;

import com.example.dinemaster.model.Chef;
import com.example.dinemaster.model.Restaurant;

public interface ChefRepository {
    ArrayList<Chef> getChefs();

    Chef addChef(Chef chef);

    Chef getChefById(int chefId);

    Chef updateChef(int chefId, Chef chef);

    void deleteChef(int chefId);

    Restaurant getdetRestaurentOfChef(int chefId);
}