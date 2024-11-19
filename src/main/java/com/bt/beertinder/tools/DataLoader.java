/*package com.bt.beertinder.tools;

import com.bt.beertinder.model.Beer;
import com.bt.beertinder.model.Preference;
import com.bt.beertinder.model.User;
import com.bt.beertinder.repository.BeerRepository;
import com.bt.beertinder.repository.PreferenceRepository;
import com.bt.beertinder.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(
            BeerRepository beerRepository,
            UserRepository userRepository,
            PreferenceRepository preferenceRepository
    ) {
        return args -> {
            List<Beer> beers = Arrays.asList(
                    Beer.builder()
                            .name("Żywiec")
                            .description("Klasyczne polskie piwo typu lager o pełnym słodowym smaku.")
                            .imageUrl("https://example.com/zywiec.jpg")
                            .build(),

                    Beer.builder()
                            .name("Tyskie")
                            .description("Popularne polskie piwo jasne pełne o zbalansowanym smaku.")
                            .imageUrl("https://duzyben.pl/hpeciai/3e1a739bb0266d9e4ef9737e1d06a4ea/pol_pl_PIWO-TYSKIE-GRONIE-5-2-0-5L-BUT-ZW-54_1_1.jpg")
                            .build(),

                    Beer.builder()
                            .name("Heineken")
                            .description("Międzynarodowe piwo premium typu pilzner o charakterystycznej goryczce.")
                            .imageUrl("https://duzyben.pl/hpeciai/f62cf813b1957724c036754c86eda7f4/pol_pl_PIWO-HEINEKEN-0-5L-BUT-BZW-59_1_1.jpg")
                            .build(),

                    Beer.builder()
                            .name("Guinness")
                            .description("Irlandzkie piwo typu stout o kremowej pianie i kawowym posmaku.")
                            .imageUrl("https://kulturasmaku.pl/zdjecia/produkt/23413/6146/0x992/3m/Piwo_Guinness_0_5l_KulturaSmaku.jpg")
                            .build(),

                    Beer.builder()
                            .name("Corona")
                            .description("Lekkie meksykańskie piwo typu lager, idealne na upalne dni.")
                            .imageUrl("https://kulturasmaku.pl/zdjecia/produkt/15633/3784/0x992/3m/Piwo_Corona_Extra_0_355l_KulturaSmaku.jpg.jpg")
                            .build()
            );

            beers = beerRepository.saveAll(beers);

            List<User> users = Arrays.asList(
                    User.builder()
                            .username("jan_kowalski")
                            .email("jan.kowalski@example.com")
                            .preferences(new ArrayList<>())
                            .build(),

                    User.builder()
                            .username("anna_nowak")
                            .email("anna.nowak@example.com")
                            .preferences(new ArrayList<>())
                            .build(),

                    User.builder()
                            .username("piotr_wisniewski")
                            .email("piotr.wisniewski@example.com")
                            .preferences(new ArrayList<>())
                            .build()
            );

            users = userRepository.saveAll(users);

            List<Preference> preferences = Arrays.asList(
                    Preference.builder()
                            .user(users.get(0))
                            .beer(beers.get(0))
                            .liked(true)
                            .build(),

                    Preference.builder()
                            .user(users.get(0))
                            .beer(beers.get(1))
                            .liked(false)
                            .build(),

                    Preference.builder()
                            .user(users.get(1))
                            .beer(beers.get(2))
                            .liked(true)
                            .build(),

                    Preference.builder()
                            .user(users.get(1))
                            .beer(beers.get(3))
                            .liked(true)
                            .build(),

                    Preference.builder()
                            .user(users.get(2))
                            .beer(beers.get(4))
                            .liked(true)
                            .build()
            );

            preferenceRepository.saveAll(preferences);

            System.out.println("Database has been populated with sample data!");
            System.out.println("Added " + beers.size() + " beers");
            System.out.println("Added " + users.size() + " users");
            System.out.println("Added " + preferences.size() + " preferences");
        };
    }
}*/