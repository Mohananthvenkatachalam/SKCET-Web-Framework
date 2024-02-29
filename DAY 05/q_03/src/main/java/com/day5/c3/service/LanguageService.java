package com.day5.c3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day5.c3.model.Language;
import com.day5.c3.repository.LanguageRepo;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepo languageRepo;

    public Language addLanguage(Language language) {
        return languageRepo.save(language);
    }

    public Iterable<Language> getAllLanguages() {
        return languageRepo.findAll();
    }

    public Language getLanguageById(int languageId) {
        return languageRepo.findById(languageId).orElse(null);
    }

    public Language updateLanguage(int languageId, Language language) {
        if (languageRepo.existsById(languageId)) {
            language.setLanguageId(languageId);
            return languageRepo.save(language);
        } else {
            return null;
        }
    }

    public boolean deleteLanguage(int languageId) {
        if (languageRepo.existsById(languageId)) {
            languageRepo.deleteById(languageId);
            return true;
        }
        return false;
    }
}
