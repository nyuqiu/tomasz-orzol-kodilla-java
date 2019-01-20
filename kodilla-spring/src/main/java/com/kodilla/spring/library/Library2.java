package com.kodilla.spring.library;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public final class Library2 {
    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    public Library2(final LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public Library2() {
        // do nothing
    }

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}