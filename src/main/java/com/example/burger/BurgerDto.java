package com.example.burger;

import lombok.Getter;
import lombok.Setter;

@Getter
public class BurgerDto {

    @Getter
    @Setter
    public static class BurgerPost{
        private String name;
        private Long price;
    }

    @Getter
    @Setter
    public static class BurgerPatch{
        private String name;
        private Long price;
    }

    @Getter
    @Setter
    public static class BurgerResponse{
        private Long id;
        private String name;
        private Long price;
    }
}
