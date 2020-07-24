package modul2;

import lombok.Getter;
import lombok.Setter;

public class VatService {

    @Getter
    @Setter
    private double vatValue;

    public VatService() {
        this.vatValue = 0.23;
    }

    public double getGrossPriceForDefaultVat(Product product) throws WrongVatException {
        return getGrossPrice(product.getNetPrice(), vatValue);
    }

    private double getGrossPrice(final double netPrice, final double vatValue) throws WrongVatException {
        if(vatValue > 1){
            throw new WrongVatException();
        }
        return netPrice * (1 + vatValue);
    }
}
