package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedian() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Book book1 = new Book("Author1", "Title1", 1999, "Signature1");
        Book book2 = new Book("Author1", "Title1", 1989, "Signature1");
        Book book3 = new Book("Author1", "Title1", 2010, "Signature1");
        Book book4 = new Book("Author1", "Title1", 1800, "Signature1");
        Book book5 = new Book("Author1", "Title1", 1954, "Signature1");
        Book book6 = new Book("Author1", "Title1", 1533, "Signature1");
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);
        bookSet.add(book6);
        //When
        int medianOfBookYear = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(medianOfBookYear, 1989, 0);
    }
}