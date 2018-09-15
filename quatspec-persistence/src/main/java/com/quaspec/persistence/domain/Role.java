package com.quaspec.persistence.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name="Role")
@Table(name="role")
@NamedQueries({
        @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
        @NamedQuery(name="Role.findAllByName", query="select r from Role r where LOWER(r.name)=:NAME")})
public class Role {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name",unique=true, length=50)
    private String name;

    @Column(name="status")
    private boolean status = false;

    @ManyToMany(fetch=FetchType.LAZY,targetEntity=Menu.class)
    @JoinTable(name="role_menu",
            joinColumns =@JoinColumn(name="role_id"),
            inverseJoinColumns=@JoinColumn(name="menu_id"))
    private Set<Menu> menus = new HashSet<Menu>();

    public Role() {
    }
    public Role(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id =id;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String role) {
        this.name = role;
    }

    public boolean isStatus(){
        return this.status;
    }
    public boolean getStatus(){
        return this.status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }

    public Set<Menu> getMenus(){
        return this.menus;
    }
    public void setMenus(Set<Menu> menus){
        this.menus = menus;
    }

    public void addMenu(Menu menu){
        this.menus.add(menu);
    }
    public void removeMenu(Menu menu){
        if(this.menus.contains(menu)){
            this.menus.remove(menu);
        }
    }
    @Override
    public boolean equals(Object object){
        if(object instanceof Role && ((Role)object).getId().equals(this.getId())){
            return true;
        }
        return false;
    }
}
