package com.day5.c3.repository;

import org.springframework.data.repository.CrudRepository;

import com.day5.c3.model.Language;

public interface LanguageRepo extends CrudRepository<Language, Integer> {
}
