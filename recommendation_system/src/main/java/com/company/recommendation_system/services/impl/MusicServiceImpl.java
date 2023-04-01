package com.company.recommendation_system.services.impl;

import com.company.recommendation_system.mappers.MusicMapper;
import com.company.recommendation_system.models.dtos.MusicDto;
import com.company.recommendation_system.models.entities.Genre;
import com.company.recommendation_system.models.enums.Status;
import com.company.recommendation_system.repository.GenreRep;
import com.company.recommendation_system.repository.MusicRep;
import com.company.recommendation_system.services.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService {
    private final MusicRep musicRep;
    private final GenreRep genreRep;
    MusicMapper musicMapper = MusicMapper.INSTANCE;
    @Override
    public MusicDto save(MusicDto musicDto, MultipartFile myImage, MultipartFile mySong) {
        File myImageFile = new File("..\\recommendation_system\\recommendation_system\\src\\main\\resources\\musics\\images\\"+myImage.getOriginalFilename());
        File mySongFile = new File("..\\recommendation_system\\recommendation_system\\src\\main\\resources\\musics\\songs\\"+mySong.getOriginalFilename());

        try{
            myImageFile.createNewFile();
            mySongFile.createNewFile();
            FileOutputStream outputImage = new FileOutputStream(myImageFile);
            FileOutputStream outputSong = new FileOutputStream(mySongFile);
            outputImage.write(myImage.getBytes());
            outputSong.write(mySong.getBytes());
            outputImage.close();
            outputSong.close();
        }catch (IOException e){
            throw new RuntimeException("error saving file");
        }

        List<Genre> genres = new ArrayList<>();
        for (Genre item: musicDto.getGenres()){
            Genre genre = genreRep.findByName(item.getName());
            genres.add(genre);
        }
        musicDto.setGenres(genres);
        musicDto.setImage(myImageFile.getAbsolutePath());
        musicDto.setSong(mySongFile.getAbsolutePath());

        return musicMapper.toDto(musicRep.save(musicMapper.toEntity(musicDto)));
    }

    @Override
    public List<MusicDto> findAll() {
        return musicMapper.toDtos(musicRep.findAll());
    }

    @Override
    public MusicDto findByName(String name) {
        return musicMapper.toDto(musicRep.findByName(name));
    }

    @Override
    public MusicDto findById(Long id) {
        return musicMapper.toDto(musicRep.findById(id).orElseThrow(()->new RuntimeException("Music not found")));
    }

    @Override
    public MusicDto delete(Long id) {
        MusicDto musicDto = findById(id);
        musicDto.setStatus(Status.DELETED);
        return musicMapper.toDto(musicRep.save(musicMapper.toEntity(musicDto)));
    }
}
