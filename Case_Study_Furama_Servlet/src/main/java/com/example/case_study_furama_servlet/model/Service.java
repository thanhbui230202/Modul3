package com.example.case_study_furama_servlet.model;

public class Service {
    private int service_id;
    private String service_name;
    private int service_area;
    private double service_cost;
    private int service_max_people;
    private RentType rentType_id;
    private ServiceType serviceType_id;
    private String standard_room;
    private String description_other_convenience;
    private double pool_area;
    private int number_of_floors;

    public Service() {
    }

    public Service(int service_id, String service_name, int service_area, double service_cost, int service_max_people, RentType rentType_id, ServiceType serviceType_id, String standard_room, String description_other_convenience, double pool_area, int number_of_floors) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_area = service_area;
        this.service_cost = service_cost;
        this.service_max_people = service_max_people;
        this.rentType_id = rentType_id;
        this.serviceType_id = serviceType_id;
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.pool_area = pool_area;
        this.number_of_floors = number_of_floors;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getService_area() {
        return service_area;
    }

    public void setService_area(int service_area) {
        this.service_area = service_area;
    }

    public double getService_cost() {
        return service_cost;
    }

    public void setService_cost(double service_cost) {
        this.service_cost = service_cost;
    }

    public int getService_max_people() {
        return service_max_people;
    }

    public void setService_max_people(int service_max_people) {
        this.service_max_people = service_max_people;
    }

    public RentType getRentType_id() {
        return rentType_id;
    }

    public void setRentType_id(RentType rentType_id) {
        this.rentType_id = rentType_id;
    }

    public ServiceType getServiceType_id() {
        return serviceType_id;
    }

    public void setServiceType_id(ServiceType serviceType_id) {
        this.serviceType_id = serviceType_id;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public double getPool_area() {
        return pool_area;
    }

    public void setPool_area(double pool_area) {
        this.pool_area = pool_area;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(int number_of_floors) {
        this.number_of_floors = number_of_floors;
    }
}
