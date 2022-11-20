package com.company.lms.model.soap;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "ns2:customer")
public class Customer {

    public Customer(){}
    private String createdAt;
    private String createdDate;
    private String customerNumber;
    private String email;
    private String firstName;
    private String gender;
    private int id;
    private Long idNumber;
    private String idType;
    private String lastName;
    private String middleName;
    private String mobile;
    private Double monthlyIncome;
    private String status;
    private String updatedAt;

    public Customer(String createdAt, String createdDate, String customerNumber, String email, String firstName, String gender, int id, Long idNumber, String idType, String lastName, String middleName, String mobile, Double monthlyIncome, String status, String updatedAt) {
        this.createdAt = createdAt;
        this.createdDate = createdDate;
        this.customerNumber = customerNumber;
        this.email = email;
        this.firstName = firstName;
        this.gender = gender;
        this.id = id;
        this.idNumber = idNumber;
        this.idType = idType;
        this.lastName = lastName;
        this.middleName = middleName;
        this.mobile = mobile;
        this.monthlyIncome = monthlyIncome;
        this.status = status;
        this.updatedAt = updatedAt;
    }

    @XmlElement(name = "ns2:createdAt")
    public String getCreatedAt() {
        return createdAt;
    }
    @XmlElement(name = "ns2:createdDate")
    public String getCreatedDate() {
        return createdDate;
    }
    @XmlElement(name = "ns2:customerNumber")
    public String getCustomerNumber() {
        return customerNumber;
    }
    @XmlElement(name = "ns2:email")
    public String getEmail() {
        return email;
    }
    @XmlElement(name = "ns2:firstName")
    public String getFirstName() {
        return firstName;
    }
    @XmlElement(name = "ns2:gender")
    public String getGender() {
        return gender;
    }
    @XmlElement(name = "ns2:id")
    public int getId() {
        return id;
    }
    @XmlElement(name = "ns2:idNumber")
    public Long getIdNumber() {
        return idNumber;
    }
    @XmlElement(name = "ns2:idType")
    public String getIdType() {
        return idType;
    }
    @XmlElement(name = "ns2:lastName")
    public String getLastName() {
        return lastName;
    }
    @XmlElement(name = "ns2:middleName")
    public String getMiddleName() {
        return middleName;
    }
    @XmlElement(name = "ns2:mobile")
    public String getMobile() {
        return mobile;
    }
    @XmlElement(name = "ns2:monthlyIncome")
    public Double getMonthlyIncome() {
        return monthlyIncome;
    }
    @XmlElement(name = "ns2:status")
    public String getStatus() {
        return status;
    }
    @XmlElement(name = "ns2:updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "createdAt='" + createdAt + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", idNumber=" + idNumber +
                ", idType='" + idType + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", monthlyIncome=" + monthlyIncome +
                ", status='" + status + '\'' +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
