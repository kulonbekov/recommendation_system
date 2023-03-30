package com.company.recommendation_system.services.impl;

import com.company.recommendation_system.mappers.PictureMapper;
import com.company.recommendation_system.models.dtos.PictureDto;
import com.company.recommendation_system.models.entities.Picture;
import com.company.recommendation_system.models.entities.Tag;
import com.company.recommendation_system.models.enums.Status;
import com.company.recommendation_system.repository.PictureRep;
import com.company.recommendation_system.repository.TagRep;
import com.company.recommendation_system.services.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {
    private final PictureRep pictureRep;
    private final TagRep tagRep;
    PictureMapper pictureMapper = PictureMapper.INSTANCE;
    @Override
    public PictureDto save(PictureDto pictureDto, MultipartFile file) {


        File myFile = new File("..\\recommendation_system\\recommendation_system\\src\\main\\resources\\images\\"+file.getOriginalFilename());

        try{
            myFile.createNewFile();
            FileOutputStream output = new FileOutputStream(myFile);
            output.write(file.getBytes());
            output.close();
        }catch (IOException e){
            throw new RuntimeException("error saving file");
        }

        List<Tag> tags = new ArrayList<>();
        for (Tag item: pictureDto.getTags()) {
            Tag tag = tagRep.findByName(item.getName());
            System.out.println(tag.getName());
            tags.add(tag);
        }
        pictureDto.setTags(tags);

        pictureDto.setImage(myFile.getAbsolutePath());
        return pictureMapper.toDto(pictureRep.save(pictureMapper.toEntity(pictureDto)));
    }

    @Override
    public List<PictureDto> findAll() {
        return pictureMapper.toDtos(pictureRep.findAll());
    }

    @Override
    public PictureDto findById(Long id) {
        return pictureMapper.toDto(pictureRep.findById(id).orElseThrow(()->new RuntimeException("Picture not found")));
    }

    @Override
    public PictureDto delete(Long id) {
        PictureDto pictureDto = findById(id);
        pictureDto.setStatus(Status.DELETED);
        return pictureMapper.toDto(pictureRep.save(pictureMapper.toEntity(pictureDto)));
    }
}
