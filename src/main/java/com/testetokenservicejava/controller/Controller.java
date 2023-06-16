package com.testetokenservicejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/array")
public class Controller {


    @Autowired
    private ArrayService arrayService;

    //exercise 1
    @PostMapping("/reverse")
    public ObjectDto[] arrayReverse (@RequestBody ObjectDto[] objects){

        return arrayService.reverseArray(objects);
    }
    //exercise 2
    @PostMapping("/inplace")
    public ObjectDto[] arrayReverseInplace (@RequestBody ObjectDto[] objects){

         arrayService.reverseArrayInPlace(objects);
         return objects;
    }

    //exercise 3
    @PostMapping("/inplacelist")
    public List<ObjectDto> arrayReverseInplaceList (@RequestBody List<ObjectDto> objects){

        arrayService.reverseListInPlaceList(objects);
        return objects;
    }

    //exercise 4
    @GetMapping
    public String[] returnCsv () throws IOException {

        String[] strings;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\rodrigo.pinheiro" +
                "\\IdeaProjects\\TesteTokenServiceJava\\src\\main\\resources\\cadastro.csv"))) { //your file

            strings= arrayService.readCSVFields(br);

        }
        return strings;
    }
}
