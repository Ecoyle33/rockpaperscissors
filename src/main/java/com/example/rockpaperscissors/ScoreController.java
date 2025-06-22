package com.example.rockpaperscissors;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ScoreController {

    static Score score = new Score(30, 20, 10);

    @GetMapping("/health-check")
    public String getHealthCheck(){
        return "All gooooood";
    }

    @PostMapping("/score/{result}")
    public Score increaseWins(@PathVariable String result){

        if (result.equalsIgnoreCase("wins")){
            score.setWins(score.getWins() + 1);
            return score;
        } else if (result.equalsIgnoreCase("losses")) {
            score.setLosses(score.getLosses() + 1);
            return score;
        } else if (result.equalsIgnoreCase("ties")) {
            score.setTies(score.getTies() + 1);
            return score;
        } else return score;

    }

    @PatchMapping("score/{result}")
    public Score updateScore(@RequestParam(name="new-value") int newValue, @PathVariable String result){

        if (result.equalsIgnoreCase("wins")){
            score.setWins(newValue);
            return score;
        }
        else if (result.equalsIgnoreCase("losses")){
            score.setLosses(newValue);
            return score;
        }
        else if (result.equalsIgnoreCase("ties")){
            score.setTies(newValue);
            return score;
        } else {
            return score;
        }
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
