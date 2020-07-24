package modul2.model;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Product {

    private String id;
    private double netPrice;
    private ProductType type;
}
