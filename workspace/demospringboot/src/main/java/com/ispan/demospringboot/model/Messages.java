package com.ispan.demospringboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "messages")
public class Messages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	//not null = nullable false(預設為true)
	@Column(name = "text", columnDefinition = "nvarchar(200)", nullable = true)
	private String text;
	
	//Date如果是util 一定要加Temporal
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name = "added", columnDefinition = "datetime") //columnDefinition 為資料型別
	private Date added;

	public Messages() {
	}
	
	//如果創建沒有給時間 會自動增加
	@PrePersist
	public void onCreate() {
		if(added == null) {
			added = new Date();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

}