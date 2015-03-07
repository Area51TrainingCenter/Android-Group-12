package johannfjs.com.models;

/**
 * Created by Johann on 06/03/2015.
 */
public class Heroes {
    private int paragonLevel;
    private boolean seasonal;
    private String name;
    private int id;
    private int level;
    private boolean hardcore;
    private int gender;
    private boolean dead;
    private String clas;
    private String last_updated;

    public Heroes(int paragonLevel, boolean seasonal, String name, int id, int level, boolean hardcore, int gender, boolean dead, String clas, String last_updated) {
        this.paragonLevel = paragonLevel;
        this.seasonal = seasonal;
        this.name = name;
        this.id = id;
        this.level = level;
        this.hardcore = hardcore;
        this.gender = gender;
        this.dead = dead;
        this.clas = clas;
        this.last_updated = last_updated;
    }

    public int getParagonLevel() {
        return paragonLevel;
    }

    public void setParagonLevel(int paragonLevel) {
        this.paragonLevel = paragonLevel;
    }

    public boolean isSeasonal() {
        return seasonal;
    }

    public void setSeasonal(boolean seasonal) {
        this.seasonal = seasonal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isHardcore() {
        return hardcore;
    }

    public void setHardcore(boolean hardcore) {
        this.hardcore = hardcore;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }
}
