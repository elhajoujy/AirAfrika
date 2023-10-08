package ma.yc.airafraik.dto;

import lombok.ToString;

import java.util.Date;


public class ResponseDto {
    private int status;
    private String data;
    private String message;
    private Date date;

    // Constructors
    public ResponseDto() {
        this.date = new Date();
    }

    public ResponseDto(int status, String data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.date = new Date();
    }

    //tojson method
    public String toJson() {
        return "{" +
                "status=" + status +
                ", data=" + data +
                ", message=" + message  +
                ", date=" + date +
                '}';
    }
    @Override
    public String toString() {
        return "{" +
                "status=" + status +
                ", data='" + data + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }

    // Getter and Setter methods
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
