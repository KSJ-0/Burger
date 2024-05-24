package com.example.burger;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("burger")
@RequiredArgsConstructor
public class BurgerController {

    private final BurgerService burgerService;

    @PostMapping
    public ResponseEntity postBurger (@Valid @RequestBody BurgerDto.BurgerPost burger) {
        burgerService.createBurger(burger);
        return new ResponseEntity("생성이 완료되었습니다.", HttpStatus.CREATED);
    }

    @PatchMapping("/{burger-id}")
    public ResponseEntity patchBurger (@Valid @RequestBody BurgerDto.BurgerPatch burger,
                                       @PathVariable ("burger-id") Long id){
        burgerService.updateBurger(burger, id);
        return new ResponseEntity("수정이 완료되었습니다.", HttpStatus.OK);
    }

    @DeleteMapping("{burger-id}")
    public ResponseEntity deleteBurger (@PathVariable ("burger-id") Long id) {
        burgerService.removeBurger(id);
        return new ResponseEntity("삭제가 완료되었습니다.",HttpStatus.OK);
    }

    @GetMapping("{burger-id}")
    public Burger getBurger (@PathVariable("burger-id") Long id) {
        return burgerService.findBurger(id);
    }

}
