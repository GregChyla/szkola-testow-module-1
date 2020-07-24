package modul2;

import modul2.model.Product;

public interface VatProvider {
    double getDefaultVat();
    double getVatForType(Product product);
}
