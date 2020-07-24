package modul2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import modul2.model.Product;

@RequiredArgsConstructor
public class VatService {

    private final VatProvider vatProvider;

    @Getter
    @Setter
    private double vatValue;

    public double getGrossPriceForDefaultVat(Product product) throws WrongVatException {
        return getGrossPrice(product.getNetPrice(), product);
    }

    private double getGrossPrice(final double netPrice, final Product product) throws WrongVatException {
        if (product.getType().getVatForType() > 1) {
            throw new WrongVatException();
        }
        return netPrice * (1 + vatProvider.getVatForType(product));
    }
}
