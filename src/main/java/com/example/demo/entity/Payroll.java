//package com.example.demo.entity;
//
//import java.sql.Date;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//
//@Table(name = "payroll")
//public class Payroll {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int payrollId;
//    @OneToOne
//    @JoinColumn(name = "employee_id", nullable = false)
//    private Employee employee;
//
//    @Column(name = "base_salary", nullable = false)
//    private double baseSalary;
//
//    @Column(name = "bonus")
//    private double bonus;
//
//    @Column(name = "deductions")
//    private double deductions;
//
//    @Temporal(TemporalType.DATE)
//    @Column(name = "payment_date")
//    private Date paymentDate;
//
//    public Payroll() {
//		super();
//	}
//
//	public Payroll(int payrollId, Employee employee, double baseSalary, double bonus, double deductions,
//			Date paymentDate) {
//		super();
//		this.payrollId = payrollId;
//		this.employee = employee;
//		this.baseSalary = baseSalary;
//		this.bonus = bonus;
//		this.deductions = deductions;
//		this.paymentDate = paymentDate;
//	}
//
//	@Override
//	public String toString() {
//		return "Payroll [payrollId=" + payrollId + ", employee=" + employee + ", baseSalary=" + baseSalary + ", bonus="
//				+ bonus + ", deductions=" + deductions + ", paymentDate=" + paymentDate + "]";
//	}
//
//	public int getPayrollId() {
//		return payrollId;
//	}
//
//	public void setPayrollId(int payrollId) {
//		this.payrollId = payrollId;
//	}
//
//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
//
//	public double getBaseSalary() {
//		return baseSalary;
//	}
//
//	public void setBaseSalary(double baseSalary) {
//		this.baseSalary = baseSalary;
//	}
//
//	public double getBonus() {
//		return bonus;
//	}
//
//	public void setBonus(double bonus) {
//		this.bonus = bonus;
//	}
//
//	public double getDeductions() {
//		return deductions;
//	}
//
//	public void setDeductions(double deductions) {
//		this.deductions = deductions;
//	}
//
//	public Date getPaymentDate() {
//		return paymentDate;
//	}
//
//	public void setPaymentDate(Date paymentDate) {
//		this.paymentDate = paymentDate;
//	}
//
//	
//
//}
