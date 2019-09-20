package com.tma.musicmanager.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gerne")
public class Gerne {
	private Integer gerneID;
	private String gerneName;
	private String gerneDesc;
	private Set<Song> song = new HashSet<Song>(0);

	public Gerne() {
	}

	public Gerne(Integer gerneID, String gerneName, String gerneDesc) {
		this.gerneID = gerneID;
		this.gerneName = gerneName;
		this.gerneDesc = gerneDesc;
	}

	@Id
	@Column(name = "gerneID")
	public Integer getGerneId() {
		return gerneID;
	}

	public void setGerneId(Integer gerneId) {
		this.gerneID = gerneId;
	}

	@Column(name = "gerneName")
	public String getGerneName() {
		return gerneName;
	}

	public void setGerneName(String gerneName) {
		this.gerneName = gerneName;
	}

	@Column(name = "gerneDesc")
	public String getGerneDesc() {
		return gerneDesc;
	}

	public void setGerneDesc(String gerneDesc) {
		this.gerneDesc = gerneDesc;
	}

	@OneToMany(mappedBy = "gerne")
	public Set<Song> getSong() {
		return song;
	}

	public void setSong(Set<Song> song) {
		this.song = song;
	}
}
