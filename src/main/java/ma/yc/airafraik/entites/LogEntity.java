package ma.yc.airafraik.entites;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "log", schema = "public", catalog = "AIRAFRIK")
public class LogEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "log_date")
    private Timestamp logDate;
    @Basic
    @Column(name = "log_message")
    private String logMessage;
    @Basic
    @Column(name = "log_key")
    private String logKey;
    @Basic
    @Column(name = "log_level")
    private String logLevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getLogDate() {
        return logDate;
    }

    public void setLogDate(Timestamp logDate) {
        this.logDate = logDate;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getLogKey() {
        return logKey;
    }

    public void setLogKey(String logKey) {
        this.logKey = logKey;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        LogEntity logEntity = (LogEntity) object;

        if (id != logEntity.id) return false;
        if (logDate != null ? !logDate.equals(logEntity.logDate) : logEntity.logDate != null) return false;
        if (logMessage != null ? !logMessage.equals(logEntity.logMessage) : logEntity.logMessage != null) return false;
        if (logKey != null ? !logKey.equals(logEntity.logKey) : logEntity.logKey != null) return false;
        if (logLevel != null ? !logLevel.equals(logEntity.logLevel) : logEntity.logLevel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (logDate != null ? logDate.hashCode() : 0);
        result = 31 * result + (logMessage != null ? logMessage.hashCode() : 0);
        result = 31 * result + (logKey != null ? logKey.hashCode() : 0);
        result = 31 * result + (logLevel != null ? logLevel.hashCode() : 0);
        return result;
    }
}
