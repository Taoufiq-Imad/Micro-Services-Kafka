package ma.enset.billingservice;

import lombok.Data;
import lombok.ToString;

@Data @ToString
public class Customer {
    private Long id;
    private String name;
    private String email;
}
