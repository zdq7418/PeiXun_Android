package com.zdq.peixun.bean;

import java.sql.Timestamp;

/**
 * Reliability entity. @author MyEclipse Persistence Tools
 */

public class Reliability implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer peixunId;
	private String ip;
	private Integer type;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public Reliability() {
	}

	/** full constructor */
	public Reliability(Integer peixunId, String ip, Integer type, Timestamp time) {
		this.peixunId = peixunId;
		this.ip = ip;
		this.type = type;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPeixunId() {
		return this.peixunId;
	}

	public void setPeixunId(Integer peixunId) {
		this.peixunId = peixunId;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}