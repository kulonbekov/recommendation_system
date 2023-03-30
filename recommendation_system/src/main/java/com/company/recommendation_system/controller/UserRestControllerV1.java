package com.company.recommendation_system.controller;

import com.company.recommendation_system.models.dtos.PictureDto;
import com.company.recommendation_system.repository.PictureRep;
import com.company.recommendation_system.services.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
public class UserRestControllerV1 {

    private final PictureService pictureService;


    @GetMapping("/find/all")
    ResponseEntity<List<PictureDto>> findAll() {
        return ResponseEntity.ok(pictureService.findAll());
    }

    @GetMapping("/find/by/id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        return new ResponseEntity<>(pictureService.findById(id), HttpStatus.FOUND);
    }

    @DeleteMapping("/delete")
    ResponseEntity<?> delete(@RequestParam Long id) {
        return new ResponseEntity<>(pictureService.delete(id), HttpStatus.OK);
    }
}
