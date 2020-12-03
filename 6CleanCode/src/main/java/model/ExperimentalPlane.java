package model;

import type.ExperimentalPlaneClassification;
import type.ExperimentalPlaneType;

import java.util.Objects;

public class ExperimentalPlane extends Plane {

    private ExperimentalPlaneType type;
    private ExperimentalPlaneClassification classification;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalPlaneType type, ExperimentalPlaneClassification classification) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classification = classification;
    }

    public ExperimentalPlaneClassification getClassification() {
        return classification;
    }

    public void setClassification(ExperimentalPlaneClassification classification) {
        this.classification = classification;
    }

    public ExperimentalPlaneType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane that = (ExperimentalPlane) o;
        return type == that.type &&
                classification == that.classification;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, classification);
    }

    @Override
    public String toString() {
        String str = super.toString();
        return str.substring(0, str.length() - 2) +
                ", type=" + type +
                ", classification=" + classification +
                '}';
    }
}
