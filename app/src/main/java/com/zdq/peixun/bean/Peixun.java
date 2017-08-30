package com.zdq.peixun.bean;

import java.sql.Timestamp;

/**
 * Peixun entity. @author MyEclipse Persistence Tools
 */

public class Peixun implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String ip;
	private String address;
	private Integer isreviewed;
	private Integer visitnum;
	private String source;
	private Timestamp time;
	private String remark;
	private Integer provinceId;
	private Integer cityId;
	private Integer districtId;

	// Constructors

	/** default constructor */
	public Peixun() {
	}

	/** full constructor */
	public Peixun(String name, String ip, String address, Integer isreviewed,
			Integer visitnum, String source, Timestamp time, String remark,
			Integer provinceId, Integer cityId, Integer districtId) {
		this.name = name;
		this.ip = ip;
		this.address = address;
		this.isreviewed = isreviewed;
		this.visitnum = visitnum;
		this.source = source;
		this.time = time;
		this.remark = remark;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.districtId = districtId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getIsreviewed() {
		return this.isreviewed;
	}

	public void setIsreviewed(Integer isreviewed) {
		this.isreviewed = isreviewed;
	}

	public Integer getVisitnum() {
		return this.visitnum;
	}

	public void setVisitnum(Integer visitnum) {
		this.visitnum = visitnum;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

}