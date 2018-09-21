package com.quatspec.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name="Menu")
@Table(name="menu")
@NamedQueries({
    @NamedQuery(name="menu.findAll",query = "select c from Menu as c order by c.displayIndex asc"),
    @NamedQuery(name="menu.findAllActiveMenuByProfileId", query="select c from Menu as c where c.profile.id=:profileId order by c.displayIndex asc"),
    //@NamedQuery(name="menu.findAllActiveMenuByRoleIDsAndUserTypeId",query="select distinct(c) from Menu as c,Role as r where r.id in :IDS and c MEMBER OF r.menus and c.status=true and c.userType.id=:USERTYPEID order by c.displayIndex asc")
})
public class Menu {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name", nullable = false)
    private String name="";

    @Column( name="status")
    private boolean status=false;

    @Column(name="menu_url")
    private String menuURL="";

    @Column(name="menu_icon")
    private String menuIcon="";

    @Column(name="display_index")
    private int displayIndex =0;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="profile_id")
    private Profile profile;

    public Menu(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMenuURL() {
        return menuURL;
    }

    public void setMenuURL(String menuURL) {
        this.menuURL = menuURL;
    }

    public int getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
    public boolean equals(Object object){
         if(object instanceof  Menu && ((Menu)object).getId().equals(this.id)){
             return true;
         }
         return false;
    }
}
