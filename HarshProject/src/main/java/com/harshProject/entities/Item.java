package com.harshProject.entities;

import jakarta.persistence.*;
import java.util.Date;

import com.sun.istack.NotNull;

@Entity
@Table(name = "CM_ITEMS_DTL")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long itemTypeId;

   @NotNull
    private Double discountPercentage;

   @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

   @NotNull
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "CM_ADMIN_ID", nullable = false)
    private Admin adminId;   

    // Getters and Setters

    public Long getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Long itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public Admin getAdminId() {
		return adminId;
	}

	public void setAdminId(Admin adminId) {
		this.adminId = adminId;
	}



    
}
