package com.example.burger;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BurgerMapper {

    Burger toBurger(BurgerDto.BurgerPost burgerPost);
    Burger toBurger(BurgerDto.BurgerPatch burgerPatch);
    BurgerDto.BurgerResponse toBurgerResponse(Burger burger);
}
