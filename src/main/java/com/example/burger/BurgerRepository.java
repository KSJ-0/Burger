package com.example.burger;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BurgerRepository extends JpaRepository<Burger,Long> {

}
