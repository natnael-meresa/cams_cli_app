package org.pams.domain;

public class Customer {

    private Long customerId;
    private String firstName;
    private String lastName;

    public Customer(Long customerId,
                    String firstName,
                    String lastName) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}