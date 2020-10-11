package com.apollo.demo.simplekafka.controller;

import com.apollo.demo.simplekafka.model.Word;
import com.apollo.demo.simplekafka.service.WordServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/words")
public class WordController {

    private final WordServiceImpl wordService;
    private final List<String> ids = Arrays.asList("ID-0" , "ID-1" , "ID-2" , "ID-3" , "ID-4" , "ID-5");
    private final String sentence = "Hello World from MrMoon and the squad, this is from october 4th";
    private final List<String> words = Arrays.asList(sentence.split(" "));

    @GetMapping("/{number}")
    public ResponseEntity<Boolean> produceNumberOfWords(@PathVariable("number") String number) {
        int n = Integer.parseInt(number);
        Word word = new Word();
        while (n-- > 0) {
            System.out.println(n);
            word.setId(ids.get(new Random().nextInt(ids.size())));
            word.setWord(words.get(new Random().nextInt(words.size())));
            this.wordService.send(word);
        }
        return ResponseEntity.ok(n < 0);
    }

}
