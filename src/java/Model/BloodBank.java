/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Builder;

/**
 *
 * @author The Crush
 */
@Entity
public class BloodBank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bloodBankId;
    private String bloodBankName;
    private String location;
    @Column(unique = true)
    private String username;
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bloodBank")
    private List<Blood> blood;

    @OneToMany(mappedBy = "bloodBankRequests")
    private List<Request> requests;

    public BloodBank() {
    }
@Builder
    public BloodBank(String bloodBankName, String location, String username, String password) {
        this.bloodBankName = bloodBankName;
        this.location = location;
        this.username = username;
        this.password = password;
    }

    public int getBloodBankId() {
        return bloodBankId;
    }

    public void setBloodBankId(int bloodBankId) {
        this.bloodBankId = bloodBankId;
    }

    public String getBloodBankName() {
        return bloodBankName;
    }

    public void setBloodBankName(String bloodBankName) {
        this.bloodBankName = bloodBankName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Blood> getBlood() {
        return blood;
    }

    public void setBlood(List<Blood> blood) {
        this.blood = blood;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

}
