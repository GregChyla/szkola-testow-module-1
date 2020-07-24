package modul2.model;

import lombok.Getter;

public enum ProductType {

    FOOD(0.08),
    BOOKS(0.23),
    HEALTHCARE(0.15),
    DRUGS(1.5);

    @Getter
    private final double vatForType;

    ProductType(double vat) {
        this.vatForType = vat;
    }
}
