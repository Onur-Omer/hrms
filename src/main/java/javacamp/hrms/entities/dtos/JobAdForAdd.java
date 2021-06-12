package javacamp.hrms.entities.dtos;

import javacamp.hrms.entities.concretes.City;
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.concretes.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdForAdd {

    private String title;

    private String description;

    private int maxSalary;

    private int minSalary;

    private int numberOfEmployee;

    private Date lastDate;

    private Date firstDate;

    private int employerId;

    private int positionId;

    private int cityId;
}
