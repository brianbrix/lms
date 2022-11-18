package com.company.lms.model.soap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CustomerResponse", namespace = "http://credable.io/cbs/customer")
@ToString
public class CustomerResponse {
    private Customer customer;
    public CustomerResponse(){}

    public CustomerResponse(Customer customer) {
        this.customer = customer;
    }
//    @XmlElement
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
