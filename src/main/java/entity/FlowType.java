package entity;

import org.hibernate.type.EnumType;

public enum FlowType  {
    LOCAL("LOCAL"),NATION("NATION");
    private String name;
    private FlowType(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return name;
    }
}
