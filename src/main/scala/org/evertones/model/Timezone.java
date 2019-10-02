package org.evertones.model;

public class Timezone implements Model {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public Timezone(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
