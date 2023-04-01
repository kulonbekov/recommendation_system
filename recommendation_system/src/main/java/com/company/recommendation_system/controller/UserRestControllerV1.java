package com.company.recommendation_system.controller;

import com.company.recommendation_system.models.dtos.MusicDto;
import com.company.recommendation_system.services.MusicService;
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
    private final MusicService musicService;

    @ApiOperation("Вывод всех треков")
    @GetMapping("/find/all")
    ResponseEntity<List<MusicDto>> findAll() {
        return ResponseEntity.ok(musicService.findAll());
    }
    @ApiOperation("Поиск трека по Id")
    @GetMapping("/find/by/id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        return new ResponseEntity<>(musicService.findById(id), HttpStatus.FOUND);
    }
    @ApiOperation("Удаления трека по Id")
    @DeleteMapping("/delete")
    ResponseEntity<?> delete(@RequestParam Long id) {
        return new ResponseEntity<>(musicService.delete(id), HttpStatus.OK);
    }

}
