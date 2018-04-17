package app;

import app.model.enums.Size;
import app.model.ingredients.*;
import app.model.labels.BasicLabel;
import app.model.labels.Label;
import app.model.repository.BasicShampooRepository;
import app.model.repository.IngredientRepository;
import app.model.repository.LabelRepository;
import app.model.shampoos.BasicShampoo;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application {

    public static final Logger log = org.slf4j.LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(LabelRepository labelRepository, IngredientRepository ingredientRepository,
                                  BasicShampooRepository basicShampooRepository) {
        return (args) -> {

//            BasicLabel labelFresh = new BasicLabel("Fresh start", "Excited");
//            BasicLabel labelAutumn = new BasicLabel("Autumn color", "Relaxed");
//            BasicLabel labelSummer = new BasicLabel("Summer cool", "Minted");
//            BasicLabel labelWinter = new BasicLabel("Winter warm", "Nettle and Mint");
//
//            BasicIngredient bi1 = new Mint();
//            BasicIngredient bi2 = new Nettle();
//            BasicIngredient bi3 = new Strawberry();
//            BasicIngredient bi4 = new AmmoniumChloride();
//
//            Set<BasicIngredient> ingredientSet = new HashSet<>();
//            ingredientSet.add(bi1);
//            ingredientSet.add(bi2);
//            ingredientSet.add(bi3);
//            ingredientSet.add(bi4);
//            ingredientRepository.saveAll(ingredientSet);
//
//            BasicShampoo springSHampoo = new BasicShampoo("Spring", BigDecimal.valueOf(3.12), Size.MEDIUM,
//                    labelFresh);
//             springSHampoo.setIngredients(ingredientSet);
//
//            basicShampooRepository.save(springSHampoo);

//            log.info("Shampoo by size");
//            log.info("--------------------");
//            basicShampooRepository.findAllBySize(Size.MEDIUM)
//                    .forEach(
//                    basicShampoo -> {
//                        log.info(basicShampoo.toString());
//                    })
//            ;
//
//
//            log.info("Shampoo by size or labele ordered by price:");
//            log.info("--------------------");
//            basicShampooRepository
//                    .findAllBySizeOrLabelOrderByPriceAsc(Size.MEDIUM, labelRepository.getOne(10L))
//                    .forEach(
//                            basicShampoo -> {
//                                log.info(basicShampoo.toString());
//                            })
//            ;
//
//            log.info("Shampoo by price greater than::");
//            log.info("--------------------");
//            basicShampooRepository
//                    .findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal.valueOf(5))
//                    .forEach(
//                            basicShampoo -> {
//                                log.info(basicShampoo.toString());
//                            })
//            ;


            log.info("4. Select ingredients by name:");
            log.info("--------------------");
            ingredientRepository
                    .findAllByNameStartingWith("M")
                    .forEach(
                            basicIngredient -> {
                                log.info(basicIngredient.toString());
                            })
            ;



        };
    }
}
