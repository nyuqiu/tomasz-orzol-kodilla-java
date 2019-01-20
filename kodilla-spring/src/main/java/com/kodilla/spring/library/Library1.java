package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public final class Library1 {
    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    @Autowired
    public Library1(final LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public Library1() {
    }

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}