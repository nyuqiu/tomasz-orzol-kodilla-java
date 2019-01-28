package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User steven = new Millenials("Steven Links");
        User john = new YGeneration("John Hemerald");
        User franek = new ZGeneration("Franek");

        //When
        String stevenShouldPublish = steven.sharePost();
        System.out.println("Steven should: " + stevenShouldPublish);
        String johnShouldPublish = john.sharePost();
        System.out.println("John should: " + johnShouldPublish);
        String franekShouldPublish = franek.sharePost();
        System.out.println("Kodilla should: " + franekShouldPublish);

        //Then
        Assert.assertEquals("Using Facebook", stevenShouldPublish);
        Assert.assertEquals("Using Twitter", johnShouldPublish);
        Assert.assertEquals("Using Snapchat", franekShouldPublish);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User steven = new Millenials("Steven Links");

        //When
        String stevenShouldPublish = steven.sharePost();
        System.out.println("Steven should: " + stevenShouldPublish);
        steven.setSocialPublisher(new SnapchatPublisher());
        stevenShouldPublish = steven.sharePost();
        System.out.println("Steven now should: " + stevenShouldPublish);

        //Then
        Assert.assertEquals("Using Snapchat", stevenShouldPublish);
    }
}
