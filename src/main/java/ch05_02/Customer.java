package ch05_02;

import lombok.Builder;

public class Customer {

    private String name;
    private String id;

    @Builder
    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
