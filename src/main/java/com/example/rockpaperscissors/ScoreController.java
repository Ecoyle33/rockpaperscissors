package com.example.rockpaperscissors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/score/{winslossesorties}")
    public int getWinsLossesOrTies(@PathVariable String winslossesorties){
        if (winslossesorties.equalsIgnoreCase("wins")){
            return score.getWins();
        } else if (winslossesorties.equalsIgnoreCase("losses")) {
            return score.getLosses();
        } else if (winslossesorties.equalsIgnoreCase("ties")) {
            return score.getTies();
        }
        else {
            return -1;
        }
    }
}
