package com.capgemini.wsb.persistence.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "time", nullable = false)
	private LocalDateTime time;

	@ManyToOne
	@JoinColumn(name = "PATIENT_ID")
	private PatientEntity patient;

	@ManyToOne
	@JoinColumn(name = "DOCTOR_ID")
	private DoctorEntity doctor;

	@OneToMany(mappedBy = "visit", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<MedicalTreatmentEntity> medicalTreatments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public List<MedicalTreatmentEntity> getMedicalTreatments() {
		return medicalTreatments;
	}

	public void setMedicalTreatments(List<MedicalTreatmentEntity> medicalTreatments) {
		this.medicalTreatments = medicalTreatments;
	}
}
