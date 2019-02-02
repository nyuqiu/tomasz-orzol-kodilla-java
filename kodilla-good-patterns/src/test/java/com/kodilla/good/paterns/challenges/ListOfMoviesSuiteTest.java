package com.kodilla.good.paterns.challenges;

import com.kodilla.good.patterns.challenges.MovieStore;
import org.junit.Assert;
import org.junit.Test;

public class ListOfMoviesSuiteTest {
    @Test
    public void testShowListOfMovies(){
        //Given\
        MovieStore movieStore = new MovieStore();
        //When

        //Then
        Assert.assertEquals("Żelazny Człowiek!Iron Man!Mściciele!Avengers!Błyskawica!Flash", movieStore.getMovies());
    }
}
