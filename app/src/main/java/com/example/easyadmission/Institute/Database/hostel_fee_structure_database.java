package com.example.easyadmission.Institute.Database;

public class hostel_fee_structure_database {
    String hostel_fee,electricity_bill;
    public  hostel_fee_structure_database(String hostel_fee,String electricity_bill)
    {
        this.hostel_fee = hostel_fee;
        this.electricity_bill = electricity_bill;
    }

    public String getHostel_fee() {
        return hostel_fee;
    }

    public void setHostel_fee(String hostel_fee) {
        this.hostel_fee = hostel_fee;
    }

    public String getElectricity_bill() {
        return electricity_bill;
    }

    public void setElectricity_bill(String electricity_bill) {
        this.electricity_bill = electricity_bill;
    }
}
