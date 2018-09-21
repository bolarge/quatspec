package com.quatspec.persistence.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name="app_configuration")
@NamedQueries({
	@NamedQuery(name="Config.findConfigByAssetType", query = "select a from AppConfiguration as a where a.type=:ASSET_TYPE"),
	@NamedQuery(name="Config.findConfigByOfferType", query = "select a from AppConfiguration as a where a.type=:OFFER_TYPE")
})
public class AppConfiguration implements Serializable {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

    @Column(name="config_name")
    protected String name;

    @Column(name="config_value")
    protected String value;

    @Column(name = "asset_type")
    protected String assetType;

    @Column(name="config_status")
    protected boolean status;
    
    @Column(name="config_type")
    protected String type;

        public AppConfiguration(){}

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
    public boolean equals(Object object){
            if(object instanceof AppConfiguration && ((AppConfiguration)object).getId().equals(this.id)){
                return true;
            }
            return false;
    }
}
