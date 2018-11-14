package GameObjects;

import java.util.Collection;
import java.util.LinkedList;

public class Shield {
    private float baseReduction;
    private Collection<Modifiers> modifiers;
    private float extraPower;

    public Shield(float x){
        baseReduction = x;
        modifiers = new LinkedList<>();
        extraPower = 0;

    }

    public float calculateDamage(float d){
        d-=extraPower;
        if(d <0) { // si la reduccion de daño fue total, recupera el escudo que le queda
            extraPower = -d;
            return 0;
        }
        else {
            d *= (1-baseReduction);
            for (Modifiers m : modifiers){
                d = m.modify(d);
            }
        }
        return d;

    }

    public void add(float p){
        extraPower += p;
    }

}
