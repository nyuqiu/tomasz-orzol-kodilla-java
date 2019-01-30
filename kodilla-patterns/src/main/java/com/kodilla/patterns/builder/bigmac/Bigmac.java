package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {
    private final String bun;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    public static class BigmacBuilder {
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun) {
            if (bun.equals("bun with sezam") || bun.equals("normal bun")) {
                this.bun = bun;
            }
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            if (sauce.equals("standard") || sauce.equals("1000 islands") || sauce.equals("barbecue")) {
                this.sauce = sauce;
            }
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            switch (ingredient) {
                case "salad":
                    ingredients.add(ingredient);
                    break;
                case "onion":
                    ingredients.add(ingredient);
                    break;
                case "bacon":
                    ingredients.add(ingredient);
                    break;
                case "cucumber":
                    ingredients.add(ingredient);
                    break;
                case "peppers":
                    ingredients.add(ingredient);
                    break;
                case "chilli":
                    ingredients.add(ingredient);
                    break;
                case "mushrooms":
                    ingredients.add(ingredient);
                    break;
                case "prawns":
                    ingredients.add(ingredient);
                    break;
                case "cheese":
                    ingredients.add(ingredient);
                    break;
                default:
                    System.out.println(ingredient + " not available.");
            }
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    private Bigmac(final String bun, final int burgers, final String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
