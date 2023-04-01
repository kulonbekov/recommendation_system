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

    //ROLE_ADMIN
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

    //ROLE_USER
    //Filters
    //FindAllByAuthor
    @Override
    public List<MusicDto> findAllByAuthor(String author) {
        return musicMapper.toDtos(musicRep.findAllByAuthor(author));
    }
    //Filters
    //FindAllByGenre
    @Override
    public List<MusicDto> findAllByGenre(String genre) {
        return musicMapper.toDtos(musicRep.findAllByGenre(genre));
    }
    //Filters
    //FindAllByName
    @Override
    public List<MusicDto> findAllByName(String name) {
        return musicMapper.toDtos(musicRep.findAllByName(name));
    }

    //FindByName
    @Override
    public MusicDto findByName(String name) {
        return musicMapper.toDto(musicRep.findByName(name));
    }

    //Recommendation
    //Popular
    @Override
    public List<MusicDto> findAllByPopular() {
        return musicMapper.toDtos(musicRep.findAllByPopular());
    }

    @Override
    public List<MusicDto> findAllByNew() {
        return musicMapper.toDtos(musicRep.findAllByNew());
    }

    //Delete
    @Override
    public MusicDto delete(Long id) {
        MusicDto musicDto = musicMapper.toDto(musicRep.findById(id).orElseThrow(() -> new RuntimeException("Music not found")));
        musicDto.setStatus(Status.DELETED);
        return musicMapper.toDto(musicRep.save(musicMapper.toEntity(musicDto)));
    }
}
