package pd.example.demoprojectproblemtaskApi.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private int roomNo;
    private String date;
    private String problem;
    private String problemDescp;
    private String complainRaisedBy;
    private String phoneNumber;
    private String email;
    private String status;


}
