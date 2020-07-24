package modul2;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Product {

    private String id;
    private double netPrice;
}
