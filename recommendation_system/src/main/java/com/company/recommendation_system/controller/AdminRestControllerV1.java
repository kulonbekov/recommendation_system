package com.company.recommendation_system.controller;

import com.company.recommendation_system.models.dtos.MusicDto;
import com.company.recommendation_system.services.MusicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "2. Администрация")
@RestController
@RequestMapping(value = "/api/v1/admin")
@RequiredArgsConstructor
public class AdminRestControllerV1 {

    private final MusicService musicService;


    @ApiOperation("Добавления треков")
    @PostMapping("/music-save")
    public ResponseEntity musicSave(@ModelAttribute MusicDto musicDto, @RequestPart MultipartFile myImage, @RequestPart MultipartFile mySong) {
        try {
            musicService.save(musicDto, myImage, mySong);
            return ResponseEntity.ok("Content saved successfully....");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error saving content", HttpStatus.NO_CONTENT);
        }
    }
}
