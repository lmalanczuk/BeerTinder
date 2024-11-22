package com.bt.beertinder.tools;

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
                            .name("Żywiec Jasne Pełne")
                            .description("Klasyczne polskie piwo typu lager o dobrze zbalansowanym smaku z wyczuwalną słodową bazą i subtelną goryczką.")
                            .imageUrl("https://strona.zywiec.com.pl/wp-content/uploads/2023/03/zywiec_pelne_main.png")
                            .build(),

                    Beer.builder()
                            .name("Tyskie Gronie")
                            .description("Złocisty lager z delikatnym aromatem słodu zbożowego i nutami białego chleba. Doskonałe do codziennego delektowania się.")
                            .imageUrl("https://duzyben.pl/hpeciai/3e1a739bb0266d9e4ef9737e1d06a4ea/pol_pl_PIWO-TYSKIE-GRONIE-5-2-0-5L-BUT-ZW-54_1_1.jpg")
                            .build(),

                    Beer.builder()
                            .name("Lech Premium")
                            .description("Jasnozłote piwo pilzneńskie o lekkim, orzeźwiającym smaku, idealne na ciepłe dni.")
                            .imageUrl("https://alkoholemajer.pl/wp-content/uploads/2020/10/0003616_lech-premium-piwo-jasne-500-ml_550.jpeg")
                            .build(),

                    Beer.builder()
                            .name("Żubr")
                            .description("Piwo typu lager o delikatnym, słodowym smaku i łagodnym charakterze, cenione za swoją autentyczność i lokalny styl.")
                            .imageUrl("https://lewiatangrudziadz-alfa.pl/2870-large_default/zubr-piwo-jasne-4-x-500-ml.jpg")
                            .build(),

                    Beer.builder()
                            .name("Porter Bałtycki Komes")
                            .description("Ciemne, mocne piwo o bogatym smaku z nutami karmelu, suszonych owoców i czekolady. Idealne dla koneserów piw kraftowych.")
                            .imageUrl("https://hurt.hurtownia-piwa.pl/wp-content/uploads/sites/5/2023/05/komes-porter-baltycki-min_big.jpg")
                            .build(),

                    Beer.builder()
                            .name("Perła Chmielowa")
                            .description("Regionalne piwo lager, wyróżniające się wyrazistym smakiem i aromatem polskiego chmielu.")
                            .imageUrl("https://www.estop24.pl/thumbs/w1000h1200q88/img/products/big/perla.png?v=c32285d907a4a78df9736c679ca0568a")
                            .build(),

                    Beer.builder()
                            .name("Trzech Kumpli Misty")
                            .description("Piwo w stylu New England IPA, pełne owocowych aromatów i soczystej, gładkiej konsystencji.")
                            .imageUrl("https://duzyben.pl/hpeciai/7da62651176f441e947308f092b8e31c/pol_pl_PIWO-MISTY-TRZECH-KUMPLI-0-5L-BUT-BZW-368_1_1.jpg")
                            .build(),

                    Beer.builder()
                            .name("Żywiec Porter")
                            .description("Bogaty, słodowy porter bałtycki o nutach czekolady i kawy. Produkowane przez Grupę Żywiec.")
                            .imageUrl("https://res.cloudinary.com/dj484tw6k/f_auto,q_auto,c_pad,b_white,w_288,h_288/v1681809600/002fc99e-08db-4fc0-8533-572f6a586113.jpg")
                            .build(),

                    Beer.builder()
                            .name("Okocim Jasne Pełne")
                            .description("Pełny smak piwa typu lager z tradycjami. Carlsberg Polska.")
                            .imageUrl("https://www.limi.pl/2645-large_default/okocim-jasne-pelne-butelka-zwrotna-500ml-wraz-z-kaucja-05zl.jpg")
                            .build(),

                    Beer.builder()
                            .name("Ciechan Miodowe")
                            .description("Jasne piwo z dodatkiem miodu gryczanego, o delikatnej słodyczy i łagodnym smaku.")
                            .imageUrl("https://darwina.pl/img/products/32/60/8/1_max.jpg")
                            .build(),
                    Beer.builder()
                            .name("Amber Koźlak")
                            .description("Bogaty smak z nutami karmelowymi, piwo dolnej fermentacji.")
                            .imageUrl("https://sklepimpuls.pl/wp-content/uploads/2022/08/Amber_Kozlak_craft_brewery_piwo_rzemieslnicze_karuzela.png")
                            .build(),

                    Beer.builder()
                            .name("Książęce Pszeniczne")
                            .description("Orzeźwiające piwo pszeniczne z nutami goździków i bananów.")
                            .imageUrl("https://www.delikatesyemis.pl/content/images/thumbs/0018821_5901359014968-ksiazece-zlote-pszeniczne-piwo-500-ml_550.jpeg")
                            .build(),

                    Beer.builder()
                            .name("Lwówek Książęcy")
                            .description("Tradycyjne polskie piwo o bursztynowej barwie i pełnym smaku.")
                            .imageUrl("https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjYjBglefcepMVozCaguQRDBNBpZecFD0w2DdqCXuaBK6t3Y_FZVneO5X7f5qw3Vyiig06silIhtsLcYLBQmOILjI_3FFc3wQHhC460j6-BF-sdOrjx8cXrWYTN0ucbVpGH3NxLsc-vrwo/s1600/P2140580.JPG")
                            .build(),

                    Beer.builder()
                            .name("Zamkowe Miodowe")
                            .description("Łagodne, słodkie piwo z dodatkiem miodu akacjowego.")
                            .imageUrl("https://www.beer-o-pedia.lasypolskie.pl/lib/exe/fetch.php?media=encyklopedia:piwa:n:namyslow_zamkowe_z_zamku_6.jpg")
                            .build(),

                    Beer.builder()
                            .name("Nałęczowskie Pils")
                            .description("Piwo w stylu pils, wyraziste i orzeźwiające, z nutami polskiego chmielu.")
                            .imageUrl("https://www.browar.biz/filedata/fetch?id=2054311")
                            .build(),

                    Beer.builder()
                            .name("Jan Olbracht Rzemieślniczy Czarnolas")
                            .description("Stout o smaku kawy i czekolady, z aksamitną konsystencją.")
                            .imageUrl("https://sklepimpuls.pl/wp-content/uploads/2022/10/jan-olbracht-tajemnice-krola-stout.png")
                            .build(),

                    Beer.builder()
                            .name("Pinta Atak Chmielu")
                            .description("Pierwsze polskie IPA, o intensywnym aromacie chmielowym i owocowym.")
                            .imageUrl("https://sklep.piwoteka.pl/images/items/43/pinta-atak-min_top.jpg")
                            .build(),

                    Beer.builder()
                            .name("Kormoran Orkiszowe")
                            .description("Piwo o nutach zbożowych, delikatne i lekko słodkie, na bazie orkiszu.")
                            .imageUrl("https://darwina.pl/img/products/30/44/9/1.jpg")
                            .build(),

                    Beer.builder()
                            .name("Grand Imperial Porter")
                            .description("Ciemne, pełne piwo z intensywnym aromatem czekolady, kawy i karmelu.")
                            .imageUrl("https://sklep.piwoteka.pl/images/items/1705/amber-grand_top.jpg")
                            .build(),

                    Beer.builder()
                            .name("Łomża Export")
                            .description("Tradycyjny lager o delikatnym smaku i złocistej barwie.")
                            .imageUrl("https://beviqua.com/cdn/shop/products/lomzaexport_779x.jpg?v=1631716615")
                            .build(),
                    Beer.builder()
                            .name("Cornelius Weizen Bier")
                            .description("Niefiltrowane piwo pszeniczne o owocowo-goździkowym aromacie.")
                            .imageUrl("https://darwina.pl/img/products/29/85/1/1_max.jpg")
                            .build(),

                    Beer.builder()
                            .name("Żubr Ciemnozłoty")
                            .description("Piwo o lekko karmelowym smaku i łagodnej goryczce.")
                            .imageUrl("https://res.cloudinary.com/dj484tw6k/f_auto,q_auto,c_pad,b_white,w_288,h_288/v1499883656/be/42347.jpg")
                            .build(),

                    Beer.builder()
                            .name("Ciechan Pszeniczne")
                            .description("Orzeźwiające piwo pszeniczne o nutach bananów i goździków.")
                            .imageUrl("https://darwina.pl/img/products/30/99/8/1_max.jpg")
                            .build(),

                    Beer.builder()
                            .name("Brok Export")
                            .description("Piwo typu lager o wyrazistym smaku i umiarkowanej goryczce.")
                            .imageUrl("https://kwit.pl/i/products/6806d08fe29097179c581aeeb524ef470ae4de61_original.jpg?1553216521")
                            .build(),

                    Beer.builder()
                            .name("Zawiercie Czekoladowe")
                            .description("Stout o wyraźnym aromacie czekolady i delikatnej goryczce.")
                            .imageUrl("https://gameplay.pl/galeria/ilustracja/68_81792483.JPG")
                            .build(),

                    Beer.builder()
                            .name("Fortuna Czarne")
                            .description("Ciemne piwo o słodkawym, karmelowym smaku z nutą kawy.")
                            .imageUrl("https://www.allepiwo.pl/userdata/public/gfx/1446/0e2c391ada36bd3c21cceecc5a1699bb.jpg")
                            .build(),

                    Beer.builder()
                            .name("Lwówek Belg")
                            .description("Piwo w stylu Belgian Ale o nutach owoców i przypraw.")
                            .imageUrl("https://lh3.googleusercontent.com/proxy/7UehGJa2iEQo2FreoROzs0dSutu--s8_vNHpUJ2UAIrXawhiu9xAxe1C6ijJAaIcR_HX1A8fRoaMS71WbBW74e5wMjMmcwZfDekxNXygQRSHKg")
                            .build(),

                    Beer.builder()
                            .name("Black Boss Porter")
                            .description("Mocny porter o nutach palonego słodu i delikatnej słodyczy.")
                            .imageUrl("https://sklep.piwoteka.pl/images/items/1898/black-boss_big.jpg")
                            .build(),

                    Beer.builder()
                            .name("Lwówek Jankes")
                            .description("Piwo w stylu American Pale Ale, o cytrusowym aromacie i wyrazistej goryczce.")
                            .imageUrl("https://img.e-spar.pl/photos/hc2/5905912650112.jpg")
                            .build(),

                    Beer.builder()
                            .name("Kormoran Porter Warmiński")
                            .description("Tradycyjny porter bałtycki o głębokim smaku czekolady, kawy i karmelu.")
                            .imageUrl("https://darwina.pl/img/products/30/44/9/1.jpg")
                            .build(),
                    Beer.builder()
                            .name("Piwo na Miodzie Gryczanym")
                            .description("Piwo o wyjątkowej słodyczy miodu gryczanego i lekkim finiszu.")
                            .imageUrl("https://www.spizarniapodlysagora.pl/moduly/sklep/UserFiles/big/1246/-/Manufaktura-Piwna-Piwo-na-Miodzie-Gryczanym.jpg")
                            .build(),

                    Beer.builder()
                            .name("Brok Sambor")
                            .description("Tradycyjny lager o łagodnym smaku z nutami zbożowymi.")
                            .imageUrl("https://api.marketdino.pl/media/filer_public/a8/35/a835d8d5-2cd6-4121-b4cb-6d4ac4ca646b/5900535004045_01.jpg")
                            .build(),

                    Beer.builder()
                            .name("Amber Żywe")
                            .description("Niefiltrowane piwo o głębokim smaku i naturalnej mętności.")
                            .imageUrl("https://sklepimpuls.pl/wp-content/uploads/2020/11/AmberZywe.png")
                            .build(),

                    Beer.builder()
                            .name("Zamkowe Export")
                            .description("Lager o wyważonym smaku i złocistej barwie, klasyk w polskich domach.")
                            .imageUrl("https://www.beer-o-pedia.lasypolskie.pl/lib/exe/fetch.php?media=encyklopedia:piwa:z1:zywiec_zamkowe_jasne_pelne.jpg")
                            .build(),

                    Beer.builder()
                            .name("Komes Potrójny Złoty")
                            .description("Piwo w stylu Belgian Tripel, mocne i owocowe z wyraźną nutą przypraw.")
                            .imageUrl("https://hurt.hurtownia-piwa.pl/wp-content/uploads/sites/5/2023/05/komes-potrojny-zloty-min_top.jpg")
                            .build(),

                    Beer.builder()
                            .name("Brackie Pale Ale Belgijskie")
                            .description("Piwo górnej fermentacji inspirowane belgijskimi tradycjami.")
                            .imageUrl("https://lh3.googleusercontent.com/proxy/WDqRf6O8vaQJwPKMeixDjItfJKywzycHXAjI8zGPBjEd4LlF1_4-8ElQ9p--oqJKDW6oKtrVe1L_geapbsm5q4S8ZtsIxzZOs9mjL8b95UDfwnE")
                            .build(),

                    Beer.builder()
                            .name("Cornelius Grapefruit")
                            .description("Piwo smakowe o wyraźnej nucie grejpfruta, idealne na lato.")
                            .imageUrl("https://sklep.piwoteka.pl/images/items/1582/cornelius-grapefrut_top.jpg")
                            .build(),

                    Beer.builder()
                            .name("Fortuna Mirabelka")
                            .description("Owocowe piwo inspirowane tradycyjnymi polskimi smakami mirabelki.")
                            .imageUrl("https://sklep.piwoteka.pl/images/items/2671/fortuna-mirabelka-bezalko_top.jpg")
                            .build(),

                    Beer.builder()
                            .name("Książęce Lager Pszeniczny")
                            .description("Połączenie stylu piw pszenicznych i tradycyjnych lagerów. Posiada owocowo-kwiatowy bukiet z nutami miodu lipowego i brzoskwini. Idealne na letni dzień.")
                            .imageUrl("https://leclerc24.net.pl/public/upload/sellasist_cache/thumb_page_af8d6b9f06cb085d3f6ea042758e24ad.jpg")
                            .build(),

                    Beer.builder()
                            .name("Książęce Złote Pszeniczne")
                            .description("Piwo o lekkim, pszenicznym smaku z delikatnymi nutami cytrusowymi i goździków. Idealne na letnie wieczory.")
                            .imageUrl("https://polish-shop.ch/5035-medium_default/piwo-ksiazece-pszeniczne-butelka-500ml.jpg")
                            .build(),
                    Beer.builder()
                            .name("Pinta Modern Drinking")
                            .description("Nowoczesne piwo w stylu IPA z wyraźnym, cytrusowym aromatem oraz intensywną goryczką. Idealne dla fanów nowofalowych smaków.")
                            .imageUrl("https://duzyben.pl/hpeciai/e4d16d93bc84a60931ffe804ffcff308/pol_pl_PIWO-MODERN-DRINKING-PINTA-0-5L-BUT-BZW-370_1_1.jpg")
                            .build(),

                    Beer.builder()
                            .name("Amber Chmielowy Lager")
                            .description("Pełne piwo o bogatym smaku i wyraźnym aromacie polskiego chmielu. Doskonałe na każdą okazję.")
                            .imageUrl("https://sklepimpuls.pl/wp-content/uploads/2024/06/AMBER-CHMIELOWY-800x800.png")
                            .build(),

                    Beer.builder()
                            .name("Kormoran Jasne")
                            .description("Lekkie piwo typu lager o subtelnym smaku słodu i delikatnej goryczce, idealne na ciepłe dni.")
                            .imageUrl("https://sklepimpuls.pl/wp-content/uploads/2022/09/kormoran-jasny-pilsner.webp")
                            .build(),

                    Beer.builder()
                            .name("Fortuna Czarne Whisky Wood")
                            .description("Ciemne piwo o wyjątkowym smaku dębowych nut whisky i karmelu. Dla miłośników intensywnych smaków.")
                            .imageUrl("https://www.piwnemosty.pl/hpeciai/863aa43799df8f5003b5e91a1bbea6c3/pol_pl_Fortuna-Czarne-Whisky-Wood-butelka-500-ml-4952_1.webp")
                            .build(),

                    Beer.builder()
                            .name("Jan Olbracht Rzemieślniczy Piotrek z Bagien")
                            .description("Ciemne piwo o karmelowym i kawowym posmaku, z nutami palonego słodu.")
                            .imageUrl("https://static.onemorebeer.pl/JO/_P/IO/_B/AG/_K/IW/_B/UT/_5/00/0/BIG.jpg?hash=dfa8cae352ca9bfb07c20435357a5dad")
                            .build(),

                    Beer.builder()
                            .name("Cornelius Banana")
                            .description("Pszeniczne piwo z wyraźnym aromatem bananowym i delikatną słodyczą. Orzeźwiające i lekkie.")
                            .imageUrl("https://sklep.piwoteka.pl/images/items/1583/cornelius-banan_top.jpg")
                            .build(),

                    Beer.builder()
                            .name("Komes Podwójny Ciemny")
                            .description("Ciemne piwo o intensywnym smaku, z nutami karmelu i kawy. Pełne i mocne.")
                            .imageUrl("https://jestemhopheadem.pl/foto/2022/Lezaki/IMG_3775.jpg")
                            .build(),

                    Beer.builder()
                            .name("Lwówek Ratuszowy")
                            .description("Tradycyjne piwo lager z delikatną goryczką i nutami zbożowymi, o klasycznym smaku.")
                            .imageUrl("https://kwit.pl/i/products/0b0b02e22912493a9d735f8ee6bd37d70b3c9abe_original.jpg?1449883148")
                            .build(),

                    Beer.builder()
                            .name("Żywiec APA")
                            .description("American Pale Ale z wyraźną goryczką i nutami cytrusowymi, pełne owocowych aromatów.")
                            .imageUrl("https://duzyben.pl/hpeciai/0f9433da12f1696b681c4c50f3a30d68/pol_pl_PIWO-ZYWIEC-APA-0-5L-BUT-ZW-196_1_1.jpg")
                            .build(),

                    Beer.builder()
                            .name("Amber Po Godzinach")
                            .description("Niefiltrowane piwo pszeniczne z aromatem goździków i bananów. Naturalnie mętne, lekkie i orzeźwiające.")
                            .imageUrl("https://static.onemorebeer.pl/AM/B_/IN/D_/PA/L_/LA/G_/BU/T_/50/0/0/BIG.jpg?hash=d4bc0a082b305ee81b5904e4fcb0ff1d")
                            .build(),
                    Beer.builder()
                            .name("Ciechan Wyborne")
                            .description("Klasyczne piwo jasne pełne, o wyrazistym, słodowym smaku z delikatną goryczką.")
                            .imageUrl("https://i2.wp.com/2.bp.blogspot.com/-AmUNXD6jzjM/T6qWyIwUkgI/AAAAAAAABLQ/ulp8y5N59uM/s1600/Ciechan+Wyborne.jpg")
                            .build(),

                    Beer.builder()
                            .name("Pinta Imperator Bałtycki")
                            .description("Ciemne piwo typu porter bałtycki, złożony smak z nutami suszonych owoców i czekolady.")
                            .imageUrl("https://www.spizarniapodlysagora.pl/moduly/sklep/UserFiles/big/1387/-/Pinta-Imperator-Baltycki-0-33L.jpg")
                            .build(),

                    Beer.builder()
                            .name("Tatra Mocne")
                            .description("Mocne piwo typu lager o intensywnym, słodowym smaku i wyraźnej goryczce.")
                            .imageUrl("https://res.cloudinary.com/dj484tw6k/image/upload/v1690325259/83411.png")
                            .build(),

                    Beer.builder()
                            .name("Namysłów Białe Pszeniczne")
                            .description("Pszeniczne piwo o delikatnym smaku i lekkiej mętności, z subtelnymi nutami goździków i cytrusów.")
                            .imageUrl("https://nowoscihandlowe.pl/wp-content/uploads/2018/12/24-Copy.png")
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
}