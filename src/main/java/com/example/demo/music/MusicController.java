package com.example.demo.music;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusicController {

    @GetMapping("/music1")
    public ResponseEntity<Resource> playMusic1() {
        try {
            // Load MP3 from classpath
            Resource resource = new ClassPathResource("music/sample.mp3");
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, "audio/mpeg")
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"sample.mp3\"")
                    .body(resource);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/music2")
    public ResponseEntity<Resource> playMusic2() {
        try {
            // Load MP3 from classpath
            Resource resource = new ClassPathResource("music/sample2.mp3");
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, "audio/mpeg")
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"sample.mp3\"")
                    .body(resource);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
