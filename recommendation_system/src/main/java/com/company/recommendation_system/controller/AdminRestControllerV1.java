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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Api(tags = "2. Администрация")
@RestController
@RequestMapping(value = "/api/v1/admin")
@RequiredArgsConstructor
public class AdminRestControllerV1 {

    private final PictureService pictureService;

    @ApiOperation("Добавления контента")
    @PostMapping("/picture-save")
    public ResponseEntity pictureSave(@ModelAttribute PictureDto pictureDto, @RequestPart MultipartFile file){
        try{
            pictureService.save(pictureDto,file);
            return ResponseEntity.ok(pictureDto);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("error saving file", HttpStatus.NO_CONTENT);
        }
    }
}
