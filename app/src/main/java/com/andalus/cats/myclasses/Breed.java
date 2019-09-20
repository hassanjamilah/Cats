package com.andalus.cats.myclasses;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * This the breed class which contains all the fields in the api
 */
@Entity
public class Breed implements Parcelable {

    @PrimaryKey
    @NonNull
    private String id ;

    private String imperial ;
    private String metric ;

    @Ignore
    private Object weight ;

    private String name ;
    private String      vetstreet_url   ;
    private String      cfa_url   ;
    private String      vcahospitals_url   ;


    private String temperament ;
    private String origin ;
    private String country_codes ;
    private String  country_code;
    private String  description;
    private String  life_span;
    private int indoor ;
    private String alt_names ;
    private int adaptability ;
    private int affection_level ;
    private int  child_friendly;
    private int dog_friendly ;
    private int energy_level ;
    private int grooming ;
    private int  health_issues;
    private int  intelligence;
    private int shedding_level ;
    private int  social_needs;
    private int stranger_friendly ;
    private int  vocalisation;
    private int experimental ;
    private int  hairless;
    private int natural ;
    private int rare ;
    private int  rex;
    private int suppressed_tail ;
    private int short_legs ;
    private String  wikipedia_url;
    private int hypoallergenic ;

    @Ignore
    private String ImageURL ;



    public Breed() {
    }

    @NonNull
    public String getId() {
        return id;
    }


    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getImperial() {
        return imperial;
    }

    public void setImperial(String imperial) {
        this.imperial = imperial;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public Object getWeight() {
        return weight;
    }

    public void setWeight(Object weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVetstreet_url() {
        return vetstreet_url;
    }

    public void setVetstreet_url(String vetstreet_url) {
        this.vetstreet_url = vetstreet_url;
    }

    public String getCfa_url() {
        return cfa_url;
    }

    public void setCfa_url(String cfa_url) {
        this.cfa_url = cfa_url;
    }

    public String getVcahospitals_url() {
        return vcahospitals_url;
    }

    public void setVcahospitals_url(String vcahospitals_url) {
        this.vcahospitals_url = vcahospitals_url;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCountry_codes() {
        return country_codes;
    }

    public void setCountry_codes(String country_codes) {
        this.country_codes = country_codes;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public int getIndoor() {
        return indoor;
    }

    public void setIndoor(int indoor) {
        this.indoor = indoor;
    }

    public String getAlt_names() {
        return alt_names;
    }

    public void setAlt_names(String alt_names) {
        this.alt_names = alt_names;
    }

    public int getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(int adaptability) {
        this.adaptability = adaptability;
    }

    public int getAffection_level() {
        return affection_level;
    }

    public void setAffection_level(int affection_level) {
        this.affection_level = affection_level;
    }

    public int getChild_friendly() {
        return child_friendly;
    }

    public void setChild_friendly(int child_friendly) {
        this.child_friendly = child_friendly;
    }

    public int getDog_friendly() {
        return dog_friendly;
    }

    public void setDog_friendly(int dog_friendly) {
        this.dog_friendly = dog_friendly;
    }

    public int getEnergy_level() {
        return energy_level;
    }

    public void setEnergy_level(int energy_level) {
        this.energy_level = energy_level;
    }

    public int getGrooming() {
        return grooming;
    }

    public void setGrooming(int grooming) {
        this.grooming = grooming;
    }

    public int getHealth_issues() {
        return health_issues;
    }

    public void setHealth_issues(int health_issues) {
        this.health_issues = health_issues;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getShedding_level() {
        return shedding_level;
    }

    public void setShedding_level(int shedding_level) {
        this.shedding_level = shedding_level;
    }

    public int getSocial_needs() {
        return social_needs;
    }

    public void setSocial_needs(int social_needs) {
        this.social_needs = social_needs;
    }

    public int getStranger_friendly() {
        return stranger_friendly;
    }

    public void setStranger_friendly(int stranger_friendly) {
        this.stranger_friendly = stranger_friendly;
    }

    public int getVocalisation() {
        return vocalisation;
    }

    public void setVocalisation(int vocalisation) {
        this.vocalisation = vocalisation;
    }

    public int getExperimental() {
        return experimental;
    }

    public void setExperimental(int experimental) {
        this.experimental = experimental;
    }

    public int getHairless() {
        return hairless;
    }

    public void setHairless(int hairless) {
        this.hairless = hairless;
    }

    public int getNatural() {
        return natural;
    }

    public void setNatural(int natural) {
        this.natural = natural;
    }

    public int getRare() {
        return rare;
    }

    public void setRare(int rare) {
        this.rare = rare;
    }

    public int getRex() {
        return rex;
    }

    public void setRex(int rex) {
        this.rex = rex;
    }

    public int getSuppressed_tail() {
        return suppressed_tail;
    }

    public void setSuppressed_tail(int suppressed_tail) {
        this.suppressed_tail = suppressed_tail;
    }

    public int getShort_legs() {
        return short_legs;
    }

    public void setShort_legs(int short_legs) {
        this.short_legs = short_legs;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public void setWikipedia_url(String wikipedia_url) {
        this.wikipedia_url = wikipedia_url;
    }

    public int getHypoallergenic() {
        return hypoallergenic;
    }

    public void setHypoallergenic(int hypoallergenic) {
        this.hypoallergenic = hypoallergenic;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public static Creator<Breed> getCREATOR() {
        return CREATOR;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "id='" + id + '\'' +
                ", imperial='" + imperial + '\'' +
                ", metric='" + metric + '\'' +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", vetstreet_url='" + vetstreet_url + '\'' +
                ", temperament='" + temperament + '\'' +
                ", origin='" + origin + '\'' +
                ", country_codes='" + country_codes + '\'' +
                ", country_code='" + country_code + '\'' +
                ", description='" + description + '\'' +
                ", life_span='" + life_span + '\'' +
                ", indoor=" + indoor +
                ", alt_names='" + alt_names + '\'' +
                ", adaptability=" + adaptability +
                ", affection_level=" + affection_level +
                ", child_friendly=" + child_friendly +
                ", dog_friendly=" + dog_friendly +
                ", energy_level=" + energy_level +
                ", grooming=" + grooming +
                ", health_issues=" + health_issues +
                ", intelligence=" + intelligence +
                ", shedding_level=" + shedding_level +
                ", social_needs=" + social_needs +
                ", stranger_friendly=" + stranger_friendly +
                ", vocalisation=" + vocalisation +
                ", experimental=" + experimental +
                ", hairless=" + hairless +
                ", natural=" + natural +
                ", rare=" + rare +
                ", rex=" + rex +
                ", suppressed_tail=" + suppressed_tail +
                ", short_legs=" + short_legs +
                ", wikipedia_url='" + wikipedia_url + '\'' +
                ", hypoallergenic=" + hypoallergenic +
                '}';
    }







    public String getHTML(){
        StringBuilder builder =new StringBuilder();

        builder.append("<p><strong><font color=\"white\">" + "Name :" + "</strong></p>") ;
        builder.append("<p><font color=\"white\">").append(this.getName()).append("</p>");

        builder.append("<p><strong><font color=\"white\">" + "Imperial Weight :" + "</strong></p>") ;
        builder.append("<p><font color=\"white\">").append(this.getImperial()).append("</p>");

        builder.append("<p><strong><font color=\"white\">" + "Metrics :" + "</strong></p>") ;
        builder.append("<p><font color=\"white\">").append(this.getMetric()).append("</p>");

        //builder.append("<p><strong>" + "CFA URL :" + "</strong></p>") ;
        builder.append("<p><a href=" + "\"").append(this.getCfa_url()).append("\">CFA Information</a></p>");


        builder.append("<p><a href=" + "\"").append(this.getVetstreet_url()).append("\">Vetstreet Information</a></p>");

        builder.append("<p><a href=" + "\"").append(this.getVcahospitals_url()).append("\">Vcahospitals Information</a></p>");

        builder.append("<p><strong><font color=\"white\">" + "Temperament :" + "</strong></p>") ;
        builder.append("<p><font color=\"white\">").append(this.getTemperament()).append("</p>");

        builder.append("<p><strong><font color=\"white\">" + "Origin :" + "</strong></p>") ;
        builder.append("<p><font color=\"white\">").append(this.getOrigin()).append("</p>");

        builder.append("<p><strong><font color=\"white\">" + "Description :" + "</strong></p>") ;
        builder.append("<p><font color=\"white\">").append(this.getDescription()).append("</p>");


        builder.append("<p><strong><font color=\"white\">" + "Life span :" + "</strong></p>") ;
        builder.append("<p><font color=\"white\">").append(this.getLife_span()).append("</p>");

        String otherInfo = getBooleanSytax("Vocalisation", getVocalisation())  ;
        otherInfo = otherInfo + ", " + getBooleanSytax("Experimental" , getExperimental()) ;
        otherInfo = otherInfo + ", " + getBooleanSytax("Hairless" , getHairless()) ;
        otherInfo = otherInfo + ", " + getBooleanSytax("Natural" , getNatural()) ;

        otherInfo = otherInfo + ", " + getBooleanSytax("Rare" , getRare()) ;
        otherInfo = otherInfo + ", " + getBooleanSytax("Rex" , getRex()) ;
        otherInfo = otherInfo + ", " + getBooleanSytax("Suppressed Tail" ,getSuppressed_tail()) ;

        otherInfo = otherInfo + ", " + getBooleanSytax("Short Legs" ,getShort_legs()) ;
        otherInfo = otherInfo + ", " + getBooleanSytax("Hypoallergenic" ,getHypoallergenic()) ;
        builder.append("<p><strong><font color=\"white\">" + "Other Information :" + "</strong></p>") ;
        builder.append("<p><font color=\"white\">").append(otherInfo).append("</p>");





        return builder.toString() ;

    }


    public String getBooleanSytax(String base , int value){
        return value == 1 ? base :  "Not " + base ;


    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.imperial);
        dest.writeString(this.metric);

        dest.writeString(this.name);
        dest.writeString(this.vetstreet_url);
        dest.writeString(this.cfa_url);
        dest.writeString(this.vcahospitals_url);
        dest.writeString(this.temperament);
        dest.writeString(this.origin);
        dest.writeString(this.country_codes);
        dest.writeString(this.country_code);
        dest.writeString(this.description);
        dest.writeString(this.life_span);
        dest.writeInt(this.indoor);
        dest.writeString(this.alt_names);
        dest.writeInt(this.adaptability);
        dest.writeInt(this.affection_level);
        dest.writeInt(this.child_friendly);
        dest.writeInt(this.dog_friendly);
        dest.writeInt(this.energy_level);
        dest.writeInt(this.grooming);
        dest.writeInt(this.health_issues);
        dest.writeInt(this.intelligence);
        dest.writeInt(this.shedding_level);
        dest.writeInt(this.social_needs);
        dest.writeInt(this.stranger_friendly);
        dest.writeInt(this.vocalisation);
        dest.writeInt(this.experimental);
        dest.writeInt(this.hairless);
        dest.writeInt(this.natural);
        dest.writeInt(this.rare);
        dest.writeInt(this.rex);
        dest.writeInt(this.suppressed_tail);
        dest.writeInt(this.short_legs);
        dest.writeString(this.wikipedia_url);
        dest.writeInt(this.hypoallergenic);
        dest.writeString(this.ImageURL);
    }

    protected Breed(Parcel in) {
        this.id = in.readString();
        this.imperial = in.readString();
        this.metric = in.readString();

        this.name = in.readString();
        this.vetstreet_url = in.readString();
        this.cfa_url = in.readString();
        this.vcahospitals_url = in.readString();
        this.temperament = in.readString();
        this.origin = in.readString();
        this.country_codes = in.readString();
        this.country_code = in.readString();
        this.description = in.readString();
        this.life_span = in.readString();
        this.indoor = in.readInt();
        this.alt_names = in.readString();
        this.adaptability = in.readInt();
        this.affection_level = in.readInt();
        this.child_friendly = in.readInt();
        this.dog_friendly = in.readInt();
        this.energy_level = in.readInt();
        this.grooming = in.readInt();
        this.health_issues = in.readInt();
        this.intelligence = in.readInt();
        this.shedding_level = in.readInt();
        this.social_needs = in.readInt();
        this.stranger_friendly = in.readInt();
        this.vocalisation = in.readInt();
        this.experimental = in.readInt();
        this.hairless = in.readInt();
        this.natural = in.readInt();
        this.rare = in.readInt();
        this.rex = in.readInt();
        this.suppressed_tail = in.readInt();
        this.short_legs = in.readInt();
        this.wikipedia_url = in.readString();
        this.hypoallergenic = in.readInt();
        this.ImageURL = in.readString();
    }

    public static final Creator<Breed> CREATOR = new Creator<Breed>() {
        @Override
        public Breed createFromParcel(Parcel source) {
            return new Breed(source);
        }

        @Override
        public Breed[] newArray(int size) {
            return new Breed[size];
        }
    };
}
