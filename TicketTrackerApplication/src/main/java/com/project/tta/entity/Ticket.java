package com.project.tta.entity;


import java.time.LocalDate;

import jakarta.persistence.*;


@Entity
@Table(name = "tickets")
public class Ticket {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;


	    @Column(name = "title", nullable = false)
	    private String title;


	    @Column(name = "descript")
	    private String descript;
	    
	    @Column(name = "content")
	    private String content;


	    @Column(name = "createon")
	    private LocalDate createon;

	public Ticket()
	{
		
	}
	
	public Ticket(String title, String descript, String content)
	{
		this.title = title;
		this.descript = descript;
		this.content = content;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getCreateon() {
		return createon;
	}

	public void setCreateon(LocalDate createon) {
		this.createon = createon;
	}	
	
}
