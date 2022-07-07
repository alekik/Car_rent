package com.company.car_rent.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "CLIENT")
@Entity
public class Client {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "FULL_NAME", nullable = false)
    @NotNull
    private String fullName;

    @Column(name = "EMAIL", nullable = false)
    @NotNull
    private String email;

    @Column(name = "PHONE_NUMBER", nullable = false)
    @NotNull
    private Integer phoneNumber;

    @Column(name = "DATE_OF_ISSUE_OF_THE_DRIVERS_LICENSE", nullable = false)
    @NotNull
    private LocalDate dateOfIssueOfTheDriversLicense;

    @Column(name = "DRIVERS_LICENSE_EXPIRATION_DATE", nullable = false)
    @NotNull
    private LocalDate driversLicenseExpirationDate;

    @Column(name = "ADRESS", nullable = false)
    @NotNull
    private String adress;

    @OneToMany(mappedBy = "client")
    private List<Deal> deal;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "client")
    private User user;

    public void setDeal(List<Deal> deal) {
        this.deal = deal;
    }

    public List<Deal> getDeal() {
        return deal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public LocalDate getDriversLicenseExpirationDate() {
        return driversLicenseExpirationDate;
    }

    public void setDriversLicenseExpirationDate(LocalDate driversLicenseExpirationDate) {
        this.driversLicenseExpirationDate = driversLicenseExpirationDate;
    }

    public LocalDate getDateOfIssueOfTheDriversLicense() {
        return dateOfIssueOfTheDriversLicense;
    }

    public void setDateOfIssueOfTheDriversLicense(LocalDate dateOfIssueOfTheDriversLicense) {
        this.dateOfIssueOfTheDriversLicense = dateOfIssueOfTheDriversLicense;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}