/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.jsoft.jdesktop.yourcompany;


import de.jsoft.jdesktop.yourcompany.iMUsers;

public class MUsers implements iMUsers
{

	
	private long id;


	private String username;

	private String password;
	private String role;


	/*
	public User(String username, String password, String role)
	{
		this.username = username;
		this.password = password;
		this.role = role;
	}
		*/
	@Override
	public long getId() {
		return id;
	}
	@Override
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getRole() {
		return role;
	}
	@Override
	public void setRole(String role) {
		this.role = role;
	}


}
