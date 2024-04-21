package com.home.SpringBootAutomation.model;

import com.home.SpringBootAutomation.Enum.TypeOfCertification;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Table(name = "DrivingLicence_tbl")
@Entity(name ="DrivingLicenceEntity" )
public class DrivingLicence {

	//گواهینامه رانندگی

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "drivingLicence_id")
	private long id;

//	@Pattern(regexp = "^[A-Za-zا-ی\\s]{1,20}$", message = "Invalid Name")
	@Column(name ="DrivingLicence_name")
	private String name;

//	@Pattern(regexp = "^[A-Za-zا-ی\\s]{1,20}$", message = "Invalid Last Name")
	@Column(name ="DrivingLicence_lastname")
	private String lastname;

//	@Pattern(regexp = "^[A-Za-zا-ی\\s]{1,20}$", message = "Invalid FathersName")
	@Column(name ="DrivingLicence_fathersName")
	private String fathersName;

//	@Pattern(regexp = "^[0-9\\s]{10}$", message = "Invalid NationalID")
	@Column(name ="DrivingLicence_nationalID")
	private Long nationalID; // شماره ملی

//	@PastOrPresent(message = "Invalid birthDate ")
	@Column(name ="DrivingLicence_birthdate")
	private LocalDate birthdate;

	@Column(name ="DrivingLicence_typeOfCertification")
	private TypeOfCertification typeOfCertification; //نوع گواهی نامه


//	@PastOrPresent(message = "Invalid issuance Date")
	@Column(name ="DrivingLicence_issuanceDate")
	private LocalDate issuanceDate;//تاریخ صدور

//	@Pattern(regexp = "^[A-Za-zا-ی\\s]{1,20}$", message = "Invalid SerialNumber")
	@Column(name ="DrivingLicence_serialNumber")
	private String serialNumber; // شماره گواهی نامه

	@Column(name ="DrivingLicence_LicenseSuspension")
	private boolean licenseSuspension;//تعلیق گواهینامه

//	@PastOrPresent(message = "Invalid LicenseSuspension Date")
	@Column(name ="DrivingLicence_LicenseSuspensionDate")
	private LocalDate licenseSuspensionDate;//تاریخ تعلیق گواهینامه

//	@FutureOrPresent(message = "Invalid End Date")
	@Column(name ="DrivingLicence_endDate")
	private LocalDate endDate;//تاریخ پایان اعتبار

//	@PastOrPresent(message = "Invalid Renewal Date")
	@Column(name ="DrivingLicence_renewal")
	private LocalDate renewal;//تاریخ تمدید مجدد

	@Column(name ="DrivingLicence_Deleted")
	private boolean deleted;//حذف

}