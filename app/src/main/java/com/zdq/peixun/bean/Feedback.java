package com.zdq.peixun.bean;

/**
 * Feedback entity. @author MyEclipse Persistence Tools
 */

public class Feedback implements java.io.Serializable {

	// Fields

	private Integer id;
	private String content;
	private String ontactInformation;

	// Constructors

	/** default constructor */
	public Feedback() {
	}

	/** full constructor */
	public Feedback(String content, String ontactInformation) {
		this.content = content;
		this.ontactInformation = ontactInformation;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOntactInformation() {
		return this.ontactInformation;
	}

	public void setOntactInformation(String ontactInformation) {
		this.ontactInformation = ontactInformation;
	}

}