package com.company.recommendation_system.controller;

import com.company.recommendation_system.models.dtos.PictureDto;
import com.company.recommendation_system.repository.PictureRep;
import com.company.recommendation_system.services.PictureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "3. Пользователь")
@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
public class UserRestControllerV1 {

    private final PictureService pictureService;

    @ApiOperation("Вывод всех пинов")
    @GetMapping("/find/all")
    ResponseEntity<List<PictureDto>> findAll() {
        return ResponseEntity.ok(pictureService.findAll());
    }
    @ApiOperation("Поиск пина по Id")
    @GetMapping("/find/by/id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        return new ResponseEntity<>(pictureService.findById(id), HttpStatus.FOUND);
    }
    @ApiOperation("Удаления пина по Id")
    @DeleteMapping("/delete")
    ResponseEntity<?> delete(@RequestParam Long id) {
        return new ResponseEntity<>(pictureService.delete(id), HttpStatus.OK);
    }
}
