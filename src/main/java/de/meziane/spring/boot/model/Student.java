package de.meziane.spring.boot.model;

import java.time.LocalDate;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author M. Kettou
 */
public class Student {

    private Long id;
    private String lastName;
    private String firstName;
    private LocalDate dob;
    private LocalDate doi;
    private int semester;

    /**
     *
     */
    public Student() {

    }

    public Student(final String fName, final String lName, final LocalDate dOb, final LocalDate dOi,
            final int semester) {
        lastName = lName;
        firstName = fName;
        dob = dOb;
        doi = dOi;
        this.semester = semester;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the dob
     */
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    public LocalDate getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(final LocalDate dob) {
        this.dob = dob;
    }

    /**
     * @return the currentSemester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * @param currentSemester the currentSemester to set
     */
    public void setCurrentSemester(final int semester) {
        this.semester = semester;
    }

    /**
     * @return the doi
     */
    // @Temporal(DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    public LocalDate getDoi() {
        return doi;
    }

    /**
     * @param doi the doi to set
     */

    public void setDoi(final LocalDate doi) {
        this.doi = doi;
    }

}
