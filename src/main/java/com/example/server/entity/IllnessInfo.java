package com.example.server.entity;


import com.example.server.entity.attachment.Attachment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class IllnessInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String illnessName;

    private String info1;
    private String info2;
    private String info3;
    private String info4;
    private String info5;
    private String info6;
    private String info7;
    private String info8;

    @OneToOne
    private Attachment photo;





}
