package day07_actions_fileTestleri_waits;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class C03_FakerClass {

    @Test
    public void fakerClassTest(){

        Faker faker = new Faker();

        System.out.println(faker.name().firstName()); // Dominica

        System.out.println(faker.name().lastName()); // Cormier

        System.out.println(faker.name().nameWithMiddle()); // Alyse Medhurst Feest

        System.out.println(faker.address().fullAddress());
        // Apt. 485 9425 Will Isle, Dickenshaven, NM 34506

        System.out.println(faker.internet().emailAddress()); // bobbie.donnelly@gmail.com
        System.out.println(faker.internet().password(8,14,true,true,true));

        System.out.println(faker.gameOfThrones().character());

    }
}
