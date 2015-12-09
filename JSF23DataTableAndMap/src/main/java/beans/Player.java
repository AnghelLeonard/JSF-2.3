package beans;

import java.util.Date;

/**
 *
 * @author Anghel Leonard
 */
public class Player  implements Comparable<Player>{
    
    private String name;
    private byte age;
    private String birthplace;
    private String residence;
    private short height;
    private byte weight;
    private String coach;
    private Date born;
    private int ranking;

    public Player() {
    }
    
    public Player(int ranking, String name, byte age, String birthplace, String residence, short height, byte weight, String coach, Date born) {
        this.ranking = ranking;
        this.name = name;
        this.age = age;
        this.birthplace = birthplace;
        this.residence = residence;
        this.height = height;
        this.weight = weight;
        this.coach = coach;
        this.born = born;
    }        

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }      

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public short getHeight() {
        return height;
    }

    public void setHeight(short height) {
        this.height = height;
    }   

    public byte getWeight() {
        return weight;
    }

    public void setWeight(byte weight) {
        this.weight = weight;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }      

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }        

    @Override
    public int compareTo(Player o) {
        return 1;
    }
}