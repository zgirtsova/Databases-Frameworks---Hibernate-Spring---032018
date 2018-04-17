package app.model.repository;

import app.model.enums.Size;
import app.model.labels.BasicLabel;
import app.model.labels.Label;
import app.model.shampoos.BasicShampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Set;

@Repository
public interface BasicShampooRepository extends JpaRepository<BasicShampoo, Long> {

    Set<BasicShampoo> findAllBySize(Size size);

    Set<BasicShampoo> findAllBySizeOrLabelOrderByPriceAsc(Size size, BasicLabel basicLabel);

    Set<BasicShampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);


}
