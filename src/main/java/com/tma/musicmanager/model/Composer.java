package com.tma.musicmanager.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "composer")
public class Composer {
	private Integer composerID;
	private String composerName;
	private String composerDesc;
	private Set<Song> song = new HashSet<Song>(0);

	public Composer() {
	}

	public Composer(Integer composerID, String composerName, String composerDesc) {
		super();
		this.composerID = composerID;
		this.composerName = composerName;
		this.composerDesc = composerDesc;
	}

	@Id
	@Column(name = "composerID")
	public Integer getComposerID() {
		return composerID;
	}

	public void setComposerID(Integer composerID) {
		this.composerID = composerID;
	}

	@Column(name = "composerName")
	public String getComposerName() {
		return composerName;
	}

	public void setComposerName(String composerName) {
		this.composerName = composerName;
	}

	@Column(name = "composerDesc")
	public String getComposerDesc() {
		return composerDesc;
	}

	public void setComposerDesc(String composerDesc) {
		this.composerDesc = composerDesc;
	}

	@OneToMany(mappedBy = "composer")
	public Set<Song> getSong() {
		return song;
	}

	public void setSong(Set<Song> song) {
		this.song = song;
	}
}
