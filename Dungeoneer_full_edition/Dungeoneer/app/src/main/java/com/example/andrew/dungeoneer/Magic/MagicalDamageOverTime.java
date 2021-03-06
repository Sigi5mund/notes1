package com.example.andrew.dungeoneer.Magic;
import com.example.andrew.dungeoneer.Characters.Archetypes.Character;

import java.io.Serializable;

public class MagicalDamageOverTime implements ITick, Serializable {

    Character target;
    double damagePerTick;
    Integer duration;

    public MagicalDamageOverTime(Character target, Integer damagePerTick, Integer duration) {
        this.target = target;
        this.damagePerTick = damagePerTick;
        this.duration = duration;
    }

    public Character getTarget() {
        return this.target;
    }

    public double getDamagePerTick() {
        return this.damagePerTick;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void tick(){
        if (duration <=0) {
            return;
        }
        else
        {
            target.decreaseHealth(damagePerTick);
        setDuration(duration -1);
        }
    }


}
