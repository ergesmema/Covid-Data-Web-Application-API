package entity;

import entity.Continent;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-02-12T17:14:45")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile SingularAttribute<Country, Integer> continentId;
    public static volatile SingularAttribute<Country, Continent> continent;
    public static volatile SingularAttribute<Country, String> countryIsoCode;
    public static volatile SingularAttribute<Country, String> location;
    public static volatile SingularAttribute<Country, Double> medianAge;
    public static volatile SingularAttribute<Country, Long> population;

}