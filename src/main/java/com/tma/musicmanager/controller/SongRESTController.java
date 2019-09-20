
package com.tma.musicmanager.controller;

import java.util.List;

import javax.persistence.Entity;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tma.musicmanager.model.Song;
import com.tma.musicmanager.service.SongService;

@RestController
@RequestMapping("/song")
public class SongRESTController {

	@RequestMapping("")
	@ResponseBody
	public String welcome() {
		return "Welcome to Rest";
	}

	private SongService songService;

	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET, produces = {
	 * MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	 */

	@GetMapping(value = "/songs")
	public List<Song> getSongs() {

		List<Song> list = songService.getAllSong();
		return list;

		// return (List<Song>) songService.findAll();
	}

	/*
	 * @GetMapping(value = "/songs/{songId}", produces = {
	 * MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }) public
	 * Song getSong(@PathVariable("songId") Integer songId) { return
	 * songService.get(songId); }
	 */

	/*
	 * @RequestMapping(value = "/songs/{songID}", method = RequestMethod.GET,
	 * produces = { MediaType.APPLICATION_JSON_VALUE,
	 * MediaType.APPLICATION_XML_VALUE })
	 * 
	 * @ResponseBody public Song getSong(@PathVariable("songID") Integer songID) {
	 * return songService.get(songID);}
	 */

	/*
	 * @PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE,
	 * MediaType.APPLICATION_ATOM_XML_VALUE }) public Song addSong(@RequestBody Song
	 * song) { return SongDAOImpl.addSong(song); }
	 * 
	 * public Response add(@RequestBody Song song) { //songService.add(song); return
	 * song; }
	 */

}
