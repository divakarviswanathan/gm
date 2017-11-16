package com.globomart.productcatalogue.rest.entity;



import javax.validation.constraints.NotNull;

/**
 * @author divakar
 *
 */
public class ProductDTO {

	private long id;

	@NotNull
    private String name;


    private String description;

	@NotNull
    private String manufacturer;

	@NotNull
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", description=" + description + ", manufacturer="
				+ manufacturer + ", type=" + type + "]";
	}
}
