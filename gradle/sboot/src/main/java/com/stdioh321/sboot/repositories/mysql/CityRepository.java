package com.stdioh321.sboot.repositories.mysql;

import com.stdioh321.sboot.annotations.CustomAnn;
import com.stdioh321.sboot.entities.mysql.City;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedQuery;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/*@Repository*/

public interface CityRepository extends JpaRepository<City, String> {
    /*@Query("SELECT c FROM City c WHERE c.name LIKE %?1%")*/
    default public List<Object> findByCityName(String name) {
        return this.findAll().stream().filter(city -> {
            return (city.getName() != null && name != null && city.getName().toLowerCase().trim().contains(name.toLowerCase().trim()));

        }).collect(Collectors.toList());
    }

    default public List findByFields(String fields, String q) {
        List<?> all = findAll();
        fields = Objects.isNull(fields) ? "" : fields.toLowerCase().trim();
        q = Objects.isNull(q) ? "" : q.toLowerCase().trim();
        if (fields.isEmpty() && q.isEmpty()) return all;

        if (!q.isEmpty()) {
            String[] qItems = q.split(",");
            String qStr = qItems[0];
            String[] qFields = qItems.length > 0 ? Arrays.copyOfRange(qItems, 1, qItems.length) : new String[]{};

            all = all.stream().filter(city -> {
                return Arrays.stream(city.getClass().getDeclaredFields()).anyMatch(field -> {
                    field.setAccessible(true);
                    boolean hasMatch = false;
                    try {
                        if (qFields.length > 0) {
                            if (Arrays.stream(qFields).anyMatch(s -> {
                                return s.equals(field.getName().toLowerCase().trim());
                            })) {
                                hasMatch = field.get(city).toString().toLowerCase().trim().contains(qStr);
                            }
                        } else
                            hasMatch = field.get(city).toString().toLowerCase().trim().contains(qStr);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }


                    return hasMatch;
                });
            }).collect(Collectors.toList());
        }
        if (!fields.isEmpty()) {
            List<Map<String, Object>> tmpAll = new ArrayList<>();
            String[] fieldItems = fields.split(",");
            System.out.println(fieldItems);
            tmpAll = all.stream().map(o -> {
                Map<String, Object> currItem = new HashMap<>();
                for (Field f : o.getClass().getDeclaredFields()) {
                    f.setAccessible(true);
                    boolean isPresent = Arrays.stream(fieldItems).anyMatch(s -> {
                        return s.equals(f.getName().toLowerCase());
                    });
                    if (isPresent) {
                        try {
                            System.out.println(f.getName());
                            currItem.put(f.getName(), f.get(o));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return currItem;
            }).collect(Collectors.toList());

            all = tmpAll;
        }
        return all;
    }

    /*default public List<City> findByCityName(String name) {
        return this.findAll().stream().filter(city -> {
            if (city.getName().toLowerCase().contains(name.toLowerCase())) return true;
            return false;
        }).collect(Collectors.toList());
    }*/
}
