package ma.yc.airafraik.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Log
@Entity(name = "log")
public class LogEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id ;

    @Column(name = "log_date")
    private Timestamp date ;

    @Column(name = "log_message")
    private String message ;

    @Column(name = "log_key")
    private String key ;

    @Column(name = "log_level")
    private String level ;

}
