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

    @ApiOperation("Фильтрация по автору")
    @GetMapping("/find/all/by/author")
    ResponseEntity<List<MusicDto>> findAllByAuthor(@RequestParam String author) {
        return ResponseEntity.ok(musicService.findAllByAuthor(author));
    }

    @ApiOperation("Фильтрация по жанру")
    @GetMapping("/find/all/by/genre")
    ResponseEntity<List<MusicDto>> findAllByGenre(@RequestParam String genre) {
        return ResponseEntity.ok(musicService.findAllByGenre(genre));
    }

    @ApiOperation("Фильтрация по названию")
    @GetMapping("/find/all/by/name")
    ResponseEntity<List<MusicDto>> findAllByName(@RequestParam String name) {
        return ResponseEntity.ok(musicService.findAllByName(name));
    }

    @ApiOperation("Поиск трека по названию")
    @GetMapping("/find/by/name")
    ResponseEntity<?> findByName(@RequestParam String name) {
        try {
            MusicDto musicDto = musicService.findByName(name);
            if (musicDto == null) {
                throw new NullPointerException();
            }
            return new ResponseEntity<>(musicDto, HttpStatus.FOUND);
        } catch (NullPointerException e) {
            return new ResponseEntity<>("Music not found", HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation("Рекомендация (популярное))")
    @GetMapping("/find/all/by/popular")
    ResponseEntity<List<MusicDto>> findAllByPopular() {
        return ResponseEntity.ok(musicService.findAllByPopular());
    }

    @ApiOperation("Рекомендация (новинки))")
    @GetMapping("/find/all/by/new")
    ResponseEntity<List<MusicDto>> findAllByNew() {
        return ResponseEntity.ok(musicService.findAllByNew());
    }

    @ApiOperation("Рекомендация (по вкусу пользователя)")
    @GetMapping("/find/all/by/user-popular")
    ResponseEntity<List<MusicDto>> findAllByUserPopular(@RequestParam String name) {
        return ResponseEntity.ok(musicService.findAllByUserPopular(name));
    }

    @ApiOperation("Удаления трека по Id")
    @DeleteMapping("/delete")
    ResponseEntity<?> delete(@RequestParam Long id) {
        return new ResponseEntity<>(musicService.delete(id), HttpStatus.OK);
    }

}
