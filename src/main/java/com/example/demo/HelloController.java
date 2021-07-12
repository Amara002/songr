package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class HelloController {
    @Autowired
    private AlbumRepo AlbumRepo;
    @GetMapping("/hello")
    String helloWorld(){
        return "hello";
    }

    @GetMapping("/capitalize/hello")
    String hello(@RequestParam( name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println(name);
        return "HelloWorld";
}
Album album[]={

};
    @GetMapping("/albums")
    public String albums( Model model) {
//        ArrayList<Album> albums= new ArrayList<>();
//        Album kolthom = new Album("kolthoom","om kolthoom",20,1000,"https://music.metason.net/image?fn=A-249512.jpeg&sc=_63");
//        Album Nassif = new Album("Nassif","zaytoon",10,500,"https://yt3.ggpht.com/ytc/AKedOLQ1SD-aYFhu2VajRNCGoFljVW2APPZ8WL99O3RPrQ=s900-c-k-c0x00ffffff-no-rj");
//        Album Rageb  = new Album("Rageb","3alameh",8,700,"https://i.ytimg.com/vi/q8mGjGeAGhs/hqdefault.jpg"
//                );
//        albums.add(kolthom);
//        albums.add(Nassif);
//        albums.add(Rageb);
//        model.addAttribute("album", albums);
        model.addAttribute("albums", AlbumRepo.findAll());
        return "album";
    }
    @GetMapping("/addAlbum")
    public String getAddAlbumView(){
        return "addAlbum.html";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(@RequestParam(value = "title") String title ,
                                 @RequestParam(value= "artist") String artist,
                                 @RequestParam(value="songCount") int songCount,
                                 @RequestParam(value="length") long length,
                                 @RequestParam(value="imageUrl") String imageUrl){
        Album album = new Album(title,artist,songCount,length,imageUrl);
        AlbumRepo.save(album);
        return  new RedirectView("/albums");
    }
}
