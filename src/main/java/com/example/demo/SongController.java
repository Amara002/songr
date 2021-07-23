package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/songs")
    public String getAllSongs(Model m){
        List<Song> songs = songRepository.findAll();
        m.addAttribute("songs",songs);
        return "Song.html";
    }

    @GetMapping("/addSong")
    public String getAddSong(){
        return "addSong";
    }

    @PostMapping("/songs")
    public RedirectView addSong(@RequestParam(value = "title") String title ,
                                @RequestParam(value= "trackNumber") int trackNumber,
                                @RequestParam(value="length") int length,
                                @RequestParam(value="albumID") long albumID, Model m){
        Album album = albumRepository.findById(albumID).get();
        Song songs = new Song(title,length,trackNumber,album);
        songRepository.save(songs);
        Album newAlbum = albumRepository.findById(album.getId()).get();
        m.addAttribute("songs", newAlbum.getSongs());
        return  new RedirectView("/songs");
    }
}
