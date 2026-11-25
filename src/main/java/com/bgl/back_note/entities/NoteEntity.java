package com.bgl.back_note.entities;

import com.bgl.back_note.enums.RiskState;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "notes")
public class NoteEntity {

    @Id
    private String id;
    private Long patientId;
    private Integer height;
    private Integer weight;
    private boolean isSmoker;
    private double hemoglobin;
    private double cholesterol;
    private double microalbumin;
    private String patientNote;
    private RiskState riskState;

    // Constructor

    public NoteEntity() {
    }

    public NoteEntity(String id, Long patientId, Integer height, Integer weight, boolean isSmoker, double hemoglobin, double cholesterol, double microalbumin, String patientNote, RiskState riskState) {
        this.id = id;
        this.patientId = patientId;
        this.height = height;
        this.weight = weight;
        this.isSmoker = isSmoker;
        this.hemoglobin = hemoglobin;
        this.cholesterol = cholesterol;
        this.microalbumin = microalbumin;
        this.patientNote = patientNote;
        this.riskState = riskState;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public boolean isSmoker() {
        return isSmoker;
    }

    public void setSmoker(boolean smoker) {
        isSmoker = smoker;
    }

    public double getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(double hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public double getMicroalbumin() {
        return microalbumin;
    }

    public void setMicroalbumin(double microalbumin) {
        this.microalbumin = microalbumin;
    }

    public String getPatientNote() {
        return patientNote;
    }

    public void setPatientNote(String patientNote) {
        this.patientNote = patientNote;
    }

    public RiskState getRiskState() {
        return riskState;
    }

    public void setRiskState(RiskState riskState) {
        this.riskState = riskState;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NoteEntity that = (NoteEntity) o;
        return isSmoker == that.isSmoker && Double.compare(hemoglobin, that.hemoglobin) == 0 && Double.compare(cholesterol, that.cholesterol) == 0 && Double.compare(microalbumin, that.microalbumin) == 0 && Objects.equals(id, that.id) && Objects.equals(patientId, that.patientId) && Objects.equals(height, that.height) && Objects.equals(weight, that.weight) && Objects.equals(patientNote, that.patientNote) && riskState == that.riskState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientId, height, weight, isSmoker, hemoglobin, cholesterol, microalbumin, patientNote, riskState);
    }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "id='" + id + '\'' +
                ", patientId=" + patientId +
                ", height=" + height +
                ", weight=" + weight +
                ", isSmoker=" + isSmoker +
                ", hemoglobin=" + hemoglobin +
                ", cholesterol=" + cholesterol +
                ", microalbumin=" + microalbumin +
                ", patientNote='" + patientNote + '\'' +
                ", riskState=" + riskState +
                '}';
    }
}
