package modul2;

import lombok.Getter;
import lombok.Setter;
import modul2.model.Product;

public class VatService implements VatProvider {

    @Getter
    @Setter
    private double vatValue;


    public VatService() {
        this.vatValue = getDefaultVat();
    }

    public double getGrossPriceForDefaultVat(Product product) throws WrongVatException {
        return getGrossPrice(product.getNetPrice(), product);
    }

    private double getGrossPrice(final double netPrice, final Product product) throws WrongVatException {
        if (product.getType().getVatForType() > 1) {
            throw new WrongVatException();
        }
        return netPrice * (1 + getVatForType(product));
    }

    @Override
    public double getDefaultVat() {
        return 0.23;
    }

    @Override
    public double getVatForType(Product product) {
        return product.getType().getVatForType();
    }
}
