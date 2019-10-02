package org.evertones.model;

public class Account implements Model {

    private Integer  id;
    private String   name;
    private Timezone timezone;
    private Details  details;

    public Account() {
        super();
    }

    public Account(Integer id, String name, Timezone timezone, Details details) {
        super();
        this.id = id;
        this.name = name;
        this.timezone = timezone;
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

}
