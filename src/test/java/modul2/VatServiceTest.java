package modul2;

import lombok.RequiredArgsConstructor;
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
    @DisplayName("should return 1.23 when given 1 as price of product")
    void shouldReturn1_23whenGivenOne() throws WrongVatException {
        product = new Product("1", 1);
        assertThat(vatService.getGrossPriceForDefaultVat(product)).isEqualTo(1.23);
    }

    @Test
    @DisplayName("should return 1.1 when given 1 as price of product and Vat value as 0.1")
    void shouldReturn1_1WhenVatIs0_1AndPriceIs1() throws WrongVatException {
        product = new Product("1", 1);
        vatService.setVatValue(0.1);
        assertThat(vatService.getGrossPriceForDefaultVat(product)).isEqualTo(1.1);
    }

    @Test
    @DisplayName("should return 2 when given 1 as price of product and Vat value as 1")
    void shouldReturn2WhenVatIs1AndPriceIs1() throws WrongVatException {
        product = new Product("1", 1);
        vatService.setVatValue(1);
        assertThat(vatService.getGrossPriceForDefaultVat(product)).isEqualTo(2);
    }

    @Test
    @DisplayName("should throw WrongVatException when Vat is more than 1")
    void shouldThrowExceptionWhenVatIsOver1() throws WrongVatException {
        product = new Product("1", 1);
        vatService.setVatValue(1.1);
        assertThatThrownBy( () -> {
           vatService.getGrossPriceForDefaultVat(product);
        }).isInstanceOf(WrongVatException.class)
        .hasMessage("Wrong VAT amount");
    }
}
