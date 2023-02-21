package luis.ejercicio.bitboxer2.enums;

import java.util.ArrayList;
import java.util.List;

public enum StateEnum {
    ACTIVE(1, "ACTIVE"),
    DISCONTINUED(2, "INACTIVE");

    private Integer id;
    private String description;


    private StateEnum(Integer id, String description) {
        this.id = id;
        this.description = description;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public static List<StateEnum> getValues() {

        List<StateEnum> res = new ArrayList<StateEnum>();
        for(StateEnum d : values())
            res.add(d);

        return res;
    }

    public static String[] getStringValues() {
        List<String> lista = new ArrayList<String>();

        for(StateEnum d : values())
            lista.add(d.getDescription());

        return lista.toArray(new String[values().length]);
    }

    public static StateEnum getFromId(Integer id) {
        if(id == null || id == 0)
            return null;

        for(StateEnum d : values()) {
            if(d.getId().equals(id))
                return d;
        }
        throw new IllegalArgumentException(
                "No existe un StateEnum con id '"+ id +"'");
    }

    public static StateEnum getFromDescription(String description) {
        if(description == null)
            return null;

        for(StateEnum d : values()) {
            if(d.getDescription().equalsIgnoreCase(description))
                return d;
        }
        throw new IllegalArgumentException(
                "No existe un StateEnum con descripcion '"+ description +"'");
    }
}
