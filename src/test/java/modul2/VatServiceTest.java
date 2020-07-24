package modul2;

import lombok.RequiredArgsConstructor;
import modul2.model.Product;
import modul2.model.ProductType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RequiredArgsConstructor
class VatServiceTest {

    private VatService vatService;
    private Product product;

    @BeforeEach
    void setup() {
        vatService = new VatService();
    }

    @Test
    @DisplayName("should return 1.23 when given 1 as price of product and product type is BOOKS")
    void shouldReturn1_23whenGivenOne() throws WrongVatException {
        product = new Product("1", 1, ProductType.BOOKS);
        assertThat(vatService.getGrossPriceForDefaultVat(product)).isEqualTo(1.23);
    }

    @Test
    @DisplayName("should return 1.1 when given 1 as price of product product type is FOOD")
    void shouldReturn1_1WhenVatIs0_1AndPriceIs1() throws WrongVatException {
        product = new Product("1", 1, ProductType.FOOD);
        assertThat(vatService.getGrossPriceForDefaultVat(product)).isEqualTo(1.08);
    }

    @Test
    @DisplayName("should return 1.15 when given 1 as price of product and type is Healthcare")
    void shouldReturn2WhenVatIs1AndPriceIs1() throws WrongVatException {
        product = new Product("1", 1, ProductType.HEALTHCARE);
        assertThat(vatService.getGrossPriceForDefaultVat(product)).isEqualTo(1.15);
    }

    @Test
    @DisplayName("should throw WrongVatException when given product type of Drugs")
    void shouldThrowExceptionWhenProductTypeIsDrugs() {
        product = new Product("1", 1, ProductType.DRUGS);
        assertThatThrownBy(() -> vatService.getGrossPriceForDefaultVat(product)).isInstanceOf(WrongVatException.class)
                .hasMessage("Wrong VAT amount");
    }
}
