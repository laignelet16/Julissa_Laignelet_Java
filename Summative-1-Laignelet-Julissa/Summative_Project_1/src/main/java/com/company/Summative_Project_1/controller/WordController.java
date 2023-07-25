package com.company.Summative_Project_1.controller;

import com.company.Summative_Project_1.model.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class WordController {
    List<Definition> words;

    public WordController(){
        Definition word1 = new Definition(100, "grenadine", "thin syrup mae from pomegranate juice");
        Definition word2 = new Definition(101, "pomegranate", "shrub or small tree having large red many-seeded fruit");
        Definition word3 = new Definition(102, "hefty", "of considerable weight and size");
        Definition word4 = new Definition(103, "carbasus", "lint or gauze");
        Definition word5 = new Definition(104, "proximo", "of next month");
        Definition word6 = new Definition(105, "bilious", "ill-tempered; very unpleasant");
        Definition word7 = new Definition(106, "mnemon", "unit of memory, largely hyptheical");
        Definition word8 = new Definition(107, "wheeple", "to whistle feebly");
        Definition word9 = new Definition(108, "miosis", "abnormal contraction of the pupil of the eye");
        Definition word10 = new Definition(109, "damine", "having antlers like a fallow deer");
        Definition word11 = new Definition(110, "futurology", "study of future");
        words = Arrays.asList(word1, word2, word3, word4, word5, word6, word7, word8, word9, word10, word11);
    }

    //route to GET a word of the day without input
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getRandomDayWord() {
        Random random = new Random();
        int index = random.nextInt(words.size());
        return words.get(index);
    }
}
