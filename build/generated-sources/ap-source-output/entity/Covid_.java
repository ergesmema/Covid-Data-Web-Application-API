package entity;

import entity.Country;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-02-12T17:14:45")
@StaticMetamodel(Covid.class)
public class Covid_ { 

    public static volatile SingularAttribute<Covid, Date> date;
    public static volatile SingularAttribute<Covid, Double> newDeathsSmoothed;
    public static volatile SingularAttribute<Covid, Country> country;
    public static volatile SingularAttribute<Covid, Long> newCases;
    public static volatile SingularAttribute<Covid, Double> reproductionRate;
    public static volatile SingularAttribute<Covid, Long> totalTests;
    public static volatile SingularAttribute<Covid, Double> stringencyIndex;
    public static volatile SingularAttribute<Covid, String> isoCode;
    public static volatile SingularAttribute<Covid, Long> newDeaths;
    public static volatile SingularAttribute<Covid, Long> totalDeaths;
    public static volatile SingularAttribute<Covid, Long> newTests;
    public static volatile SingularAttribute<Covid, Double> newCasesSmoothed;
    public static volatile SingularAttribute<Covid, Long> totalCases;
    public static volatile SingularAttribute<Covid, Double> newDeathsPerCase;

}