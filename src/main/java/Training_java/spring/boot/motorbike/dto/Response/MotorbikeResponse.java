package Training_java.spring.boot.motorbike.dto.Response;

import Training_java.spring.boot.motorbike.dto.Request.MotorbikeRequest;

public class MotorbikeResponse extends MotorbikeRequest {
    private String id;

    public MotorbikeResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MotorbikeResponse{" +
                "id='" + id + '\'' +
                ", name='" + getName() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", color='" + getColor() + '\'' +
                ", year=" + getYear() +
                '}';
    }
}
