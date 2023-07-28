package com.example.springdatarelational32.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("#{tablePropertiesProvider.getTabName()}")
public class ChinsEntity {
    @Id
    @Column("id")
    private int id;

    @Column("#{tablePropertiesProvider.getColumn1Name()}")
    private String name;
    
    @Column("#{tablePropertiesProvider.getColumn2Name()}")
    private String color;
    
    @Column("#{tablePropertiesProvider.getColumn3Name()}")
    private String birthday;
    
    @Column("#{tablePropertiesProvider.getColumn4Name()}")
    private Integer weight;
    
    @Column("#{tablePropertiesProvider.getColumn5Name()}")
    private String sex;
    
    @Column("#{tablePropertiesProvider.getColumn6Name()}")
    private Byte forSale;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Byte getForSale() {
        return forSale;
    }

    public void setForSale(Byte forSale) {
        this.forSale = forSale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChinsEntity that = (ChinsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (forSale != null ? !forSale.equals(that.forSale) : that.forSale != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (forSale != null ? forSale.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChinsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", birthday='" + birthday + '\'' +
                ", weight=" + weight +
                ", sex='" + sex + '\'' +
                ", forSale=" + forSale +
                '}';
    }
}
