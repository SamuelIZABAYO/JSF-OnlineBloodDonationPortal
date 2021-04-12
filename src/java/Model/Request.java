/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;

/**
 *
 * @author The Crush
 */
@Entity
public class Request implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;
    private String requestedBloodGroup;
    private Date requestDate;
    
    @ManyToOne
    @JoinColumn(name = "requester")
    private Hospital hospitalRequests;

    @ManyToOne
    @JoinColumn(name = "bloodBankId")
    private BloodBank bloodBankRequests;

    @ManyToOne
    @JoinColumn(name = "donorId")
    private Donor donorRequests;

    public Request() {
    }
@Builder
    public Request(String requestedBloodGroup, Date requestDate, Hospital hospitalRequests, BloodBank bloodBankRequests, Donor donorRequests) {
        this.requestedBloodGroup = requestedBloodGroup;
        this.requestDate = requestDate;
        this.hospitalRequests = hospitalRequests;
        this.bloodBankRequests = bloodBankRequests;
        this.donorRequests = donorRequests;
    }

    public Request(String requestedBloodGroup, Date requestDate, Hospital hospitalRequests) {
        this.requestedBloodGroup = requestedBloodGroup;
        this.requestDate = requestDate;
        this.hospitalRequests = hospitalRequests;
    }

    public Request(String requestedBloodGroup, Date requestDate, BloodBank bloodBankRequests) {
        this.requestedBloodGroup = requestedBloodGroup;
        this.requestDate = requestDate;
        this.bloodBankRequests = bloodBankRequests;
    }

    public Request(String requestedBloodGroup, Date requestDate, Donor donorRequests) {
        this.requestedBloodGroup = requestedBloodGroup;
        this.requestDate = requestDate;
        this.donorRequests = donorRequests;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Hospital getHospitalRequests() {
        return hospitalRequests;
    }

    public void setHospitalRequests(Hospital hospitalRequests) {
        this.hospitalRequests = hospitalRequests;
    }

    public BloodBank getBloodBankRequests() {
        return bloodBankRequests;
    }

    public void setBloodBankRequests(BloodBank bloodBankRequests) {
        this.bloodBankRequests = bloodBankRequests;
    }

    public Donor getDonorRequests() {
        return donorRequests;
    }

    public void setDonorRequests(Donor donorRequests) {
        this.donorRequests = donorRequests;
    }

    public String getReason() {
        return requestedBloodGroup;
    }

    public void setReason(String requestedBloodGroup) {
        this.requestedBloodGroup = requestedBloodGroup;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

}
