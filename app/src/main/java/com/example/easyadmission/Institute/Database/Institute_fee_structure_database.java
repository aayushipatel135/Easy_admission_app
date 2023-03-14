package com.example.easyadmission.Institute.Database;

public class Institute_fee_structure_database {
    String tuition_fee,registration_fee,caution_deposit;
    public Institute_fee_structure_database(String tuition_fee,String registration_fee,String caution_deposit)
    {
        this.tuition_fee = tuition_fee;
        this.registration_fee = registration_fee;
        this.caution_deposit = caution_deposit;
    }

    public String getTuition_fee() {
        return tuition_fee;
    }

    public void setTuition_fee(String tuition_fee) {
        this.tuition_fee = tuition_fee;
    }

    public String getRegistration_fee() {
        return registration_fee;
    }

    public void setRegistration_fee(String registration_fee) {
        this.registration_fee = registration_fee;
    }

    public String getCaution_deposit() {
        return caution_deposit;
    }

    public void setCaution_deposit(String caution_deposit) {
        this.caution_deposit = caution_deposit;
    }
}
