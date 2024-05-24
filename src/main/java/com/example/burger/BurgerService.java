package com.example.burger;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BurgerService {

    private final BurgerRepository burgerRepository;
    private final BurgerMapper burgerMapper;


    public Burger createBurger(BurgerDto.BurgerPost burgerPost){
        return burgerRepository.save(burgerMapper.toBurger(burgerPost));
    }

    public Burger updateBurger(BurgerDto.BurgerPatch burgerPatch, Long id){
        Burger burger = findBurger(id);
        Optional.ofNullable(burgerPatch.getName())
                .ifPresent(name -> burger.setName(name));
        Optional.ofNullable(burgerPatch.getPrice())
                .ifPresent(price -> burger.setPrice(price));
        burgerRepository.save(burger);
        return burger;
    }

    public Burger findBurger(Long id) {
        return burgerRepository.findById(id)
                .orElseThrow( () -> new BusinessLogicException(ExceptionCode.BURGER_NOT_FOUND));
    }

    public void removeBurger(Long id) {
        burgerRepository.deleteById(id);
    }

}
