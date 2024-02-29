package com.day5.c3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.day5.c3.model.Language;
import com.day5.c3.service.LanguageService;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping
    public ResponseEntity<Language> addLanguage(@RequestBody Language language) {
        Language addedLanguage = languageService.addLanguage(language);
        return new ResponseEntity<>(addedLanguage, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Language>> getAllLanguages() {
        Iterable<Language> languages = languageService.getAllLanguages();
        return new ResponseEntity<>(languages, HttpStatus.OK);
    }

    @GetMapping("/{languageId}")
    public ResponseEntity<Language> getLanguageById(@PathVariable int languageId) {
        Language language = languageService.getLanguageById(languageId);
        return new ResponseEntity<>(language, HttpStatus.OK);
    }

    @PutMapping("/{languageId}")
    public ResponseEntity<Language> updateLanguage(@PathVariable int languageId, @RequestBody Language language) {
        Language updatedLanguage = languageService.updateLanguage(languageId, language);
        if (updatedLanguage != null) {
            return new ResponseEntity<>(updatedLanguage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{languageId}")
    public ResponseEntity<Boolean> deleteLanguage(@PathVariable int languageId) {
        boolean deleted = languageService.deleteLanguage(languageId);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
