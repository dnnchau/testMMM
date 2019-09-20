package com.tma.musicmanager.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Singer")
public class Singer {
	private Integer singerID;
	private String singerName;
	private String singerDesc;
	private Set<Song> song = new HashSet<Song>();

	public Singer() {
	}

	public Singer(Integer singerID, String singerName, String singerDesc) {
		super();
		this.singerID = singerID;
		this.singerName = singerName;
		this.singerDesc = singerDesc;
	}

	@Id
	@Column(name = "singerID")
	public Integer getSingerID() {
		return singerID;
	}

	public void setSingerID(Integer singerID) {
		this.singerID = singerID;
	}

	@Column(name = "singerName")
	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	@Column(name = "singerDesc")
	public String getSingerDesc() {
		return singerDesc;
	}

	public void setSingerDesc(String singerDesc) {
		this.singerDesc = singerDesc;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "singer")

	public Set<Song> getSong() {
		return this.song;
	}

	public void setSong(Set<Song> song) {
		this.song = song;
	}

}
