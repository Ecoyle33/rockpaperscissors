package com.example.rockpaperscissors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ScoreController {

    static Score score = new Score(30, 20, 10);

    @GetMapping("/health-check")
    public String getHealthCheck(){
        return "All gooooood";
    }

    @GetMapping("/score")
    public Score getScore(){
        return score;
    }

    @GetMapping("/score/wins")
    public int getWins(){
        return score.getWins();
    }

    @GetMapping("/score/losses")
    public int getLosses(){
        return score.getLosses();
    }

    @GetMapping("/score/ties")
    public int getTies(){
        return score.getTies();
    }
}
