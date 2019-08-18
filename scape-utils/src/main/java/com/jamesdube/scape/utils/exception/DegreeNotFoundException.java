package com.jamesdube.scape.utils.exception;

public class DegreeNotFoundException extends ScapeException {

    private Long id;

    public DegreeNotFoundException(Long id) {
        super("could not find degree using the id " + id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
